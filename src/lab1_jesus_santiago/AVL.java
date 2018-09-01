package lab1_jesus_santiago;

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

        Arbol.Preorden(root);
        System.out.println("");
        System.out.println(GetPadre(root, 28).getDato());
        
        
        System.out.println("");
    }

    static int h(Nodo raiz) {
        if (raiz == null) {
            return -1;
        } else {
            return 1 + Math.max(h(raiz.izquierdo), h(raiz.derecho));
        }
    }
    
//    static boolean Primos(Nodo root,Nodo a, Nodo b){
//        if () {
//            
//        }
//    }

    static Nodo GetPadre(Nodo root, int dat) {//Obtener Padre

        if (root != null) {
            if (root.getDerecho() != null) {
                if (root.getDerecho().getDato() == dat) {
                    return root;
                    
                }
            }
            if (root.getIzquierdo() != null) {
                if (root.getIzquierdo().getDato() == dat) {
                    return root;
                }
            }
            GetPadre(root.getIzquierdo(), dat);
            GetPadre(root.getDerecho(), dat);
        }
        return root;

    }

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
}
