/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_jesus_santiago;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jesus David
 */
public class Tree {
    Nodo myTree=new Nodo();
    
    public JPanel getDibujo() {
        return this.myTree.getdibujo();
    }
    
    static void add(Nodo raiz, String father, String dat, int side) {//Recorrido por niveles adaptado para insertar
        LinkedList<Nodo> cola = new LinkedList();
        cola.addFirst(raiz);

        while (!cola.isEmpty()) {
            Nodo nodo = cola.removeLast();
            if (father == null) {
                nodo.setDato(dat);
            } else if (nodo.getDato().equals(father)) {
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

            if (nodo.getIzquierdo() != null) {
                cola.addFirst(nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                cola.addFirst(nodo.getDerecho());
            }

        }

    }
}
