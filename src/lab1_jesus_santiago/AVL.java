package lab1_jesus_santiago;

import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus David
 */
public class AVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI ven = new GUI();
        ven.setVisible(true);

//        add(root, null, "Juan", 1);
//        add(root,"Juan","Pedro",1);
//        add(root,"Juan","Alexa",3);
    }

    static int h(Nodo raiz) {
        if (raiz == null) {
            return -1;
        } else {
            return 1 + Math.max(h(raiz.izquierdo), h(raiz.derecho));
        }
    }

    static void add(Nodo raiz, String father, String dat, int side) {
        LinkedList<Nodo> cola = new LinkedList();
        cola.addFirst(raiz);

        while (!cola.isEmpty()) {
            Nodo nodo = cola.removeLast();
            if (father == null) {
                nodo.dato = dat;
            } else if (nodo.dato.equals(father)) {
                if (side == 1) {
                    if (nodo.getIzquierdo() == null) {
                        nodo.setIzquierdo(new Nodo(nodo, dat));
                    } else {
                        JOptionPane.showMessageDialog(null, "Lado izquierdo lleno", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (side == 2) {

                    if (nodo.getDerecho() == null) {
                        nodo.setDerecho(new Nodo(nodo, dat));
                    } else {
                        JOptionPane.showMessageDialog(null, "Lado derecho lleno", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Argumento lado invalido (1 o 2)", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if (nodo.izquierdo != null) {
                cola.addFirst(nodo.izquierdo);
            }
            if (nodo.derecho != null) {
                cola.addFirst(nodo.derecho);
            }

        }

    }

}
