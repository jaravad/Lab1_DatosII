
package lab1_jesus_santiago;

import javax.swing.JPanel;

/**
 *
 * @author Jesus David
 */
public class Nodo {
    private Nodo p;
    private String dato;
    private Nodo izquierdo;
    private Nodo derecho;
    
    public Nodo(){
        this.dato="";
        this.setDerecho(null);
        this.setIzquierdo(null);
    }

    public Nodo(Nodo padre,String dato) {
        this.dato = dato;
        this.p=padre;
        this.izquierdo = null;
        this.derecho = null;
    }

    public String getDato() {
        return dato;
    }
    
    public void setDato(String s){
        this.dato=s;
    }
    
    public Nodo getPadre(){
        return this.p;
    }
    public void setPadre(Nodo n){
        this.p=n;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
    
    public JPanel getdibujo() {
        return new DTree(this);
    }
    
}
