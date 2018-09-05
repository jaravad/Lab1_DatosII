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

    

}
