package lab1_jesus_santiago;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Jesus David
 */
public class AVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Nodo root = null;
        root = insertar(root, 19);
        root = insertar(root, 7);
        root = insertar(root, 8);
        root = insertar(root, 30);
        root = insertar(root, 60);
        root = insertar(root, 28);
        root = insertar(root, 6);
        root = insertar(root, 2);
        root = insertar(root, 9);
        root = insertar(root, 70);
        System.out.println("Pre-orden:");
        Arbol.Preorden(root);
        System.out.println("");
        System.out.println("--------------------------------");
        System.out.println("Padre de 28:");
        System.out.println(getPadre(root, 28).getDato());
        System.out.println("Padre de 19:");
        if (getPadre(root, 19) != null) {
            System.out.println(getPadre(root, 19).getDato());
        } else {
            System.out.println("No tiene padre");
        }

        System.out.println("Padre de 7:");
        if (getPadre(root, 7) != null) {
            System.out.println(getPadre(root, 7).getDato());
        } else {
            System.out.println("No tiene padre");
        }

        if (Primos(root, 2, 70)) {
            System.out.println("Son primos");
        } else {
            System.out.println("No son primos");
        }
    }

    static int h(Nodo raiz) {
        if (raiz == null) {
            return -1;
        } else {
            return 1 + Math.max(h(raiz.izquierdo), h(raiz.derecho));
        }
    }

    static boolean Primos(Nodo root, int a, int b) {
        boolean sw = false;
        try {
            Nodo padrea = getPadre(root, a);
            Nodo granpa = getPadre(root, padrea.getDato());
            Nodo padreb = getPadre(root, b);
            Nodo granpb = getPadre(root, padreb.getDato());

            if (granpa == granpb) {
                if (padreb != padrea) {

                    sw = true;
                }

            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return sw;

    }
//    static void GetPadre(Nodo root, int dat) {//Obtener Padre
//
//        if (root != null) {
//            if (root.getDerecho() != null) {
//                if (root.getDerecho().getDato() == dat) {
//                    System.out.println(root.getDato());
//                    
//                }
//            }
//            if (root.getIzquierdo() != null) {
//                if (root.getIzquierdo().getDato() == dat) {
//                    System.out.println(root.getDato());
//                }
//            }
//            
//            GetPadre(root.getIzquierdo(), dat);
//            GetPadre(root.getDerecho(), dat);
//        }
//        
//    }

    static Nodo insertar(Nodo nodo, int dato) {
        if (nodo == null) {
            return (new Nodo(dato));
        }

        if (dato < nodo.getDato()) {
            nodo.izquierdo = insertar(nodo.izquierdo, dato);
        } else if (dato > nodo.getDato()) {
            nodo.derecho = insertar(nodo.derecho, dato);
        } else {
            return nodo;
        }
        return nodo;
    }

    static Nodo getPadre(Nodo raiz, int dat) {
        LinkedList<Nodo> cola = new LinkedList();
        cola.addFirst(raiz);
        while (!cola.isEmpty()) {
            Nodo nodo = cola.removeLast();

            if (nodo.getIzquierdo() != null) {
                if (nodo.getIzquierdo().getDato() == dat) {
                    return nodo;
                }
            }
            if (nodo.getDerecho() != null) {
                if (nodo.getDerecho().getDato() == dat) {
                    return nodo;
                }
            }
            if (nodo.izquierdo != null) {
                cola.addFirst(nodo.izquierdo);
            }
            if (nodo.derecho != null) {
                cola.addFirst(nodo.derecho);
            }

        }
        return null;
    }
}
