/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_jesus_santiago;

import javax.swing.JTextField;

/**
 *
 * @author Jesus David
 */
public class Arbol {

    

    static void Preorden(Nodo raiz) {
        if (raiz != null) {
            System.out.print("[" + raiz.getX() + "]" + "[" + raiz.getY() + "], ");
            Preorden(raiz.getIzquierdo());
            Preorden(raiz.getDerecho());
        }

    }

    static void InOrden(Nodo raiz) {
        if (raiz != null) {
            InOrden(raiz.getIzquierdo());
            System.out.print("[" + raiz.getDato() + "]");
            InOrden(raiz.getDerecho());
        }
    }

    static void PostOrden(Nodo raiz) {
        if (raiz != null) {
            PostOrden(raiz.getIzquierdo());
            PostOrden(raiz.getDerecho());
            System.out.print("[" + raiz.getDato() + "]");
        }
    }
}
