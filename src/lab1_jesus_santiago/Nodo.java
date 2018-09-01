
package lab1_jesus_santiago;

/**
 *
 * @author Jesus David
 */
public class Nodo {
    Nodo p;
    int dato;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int dato) {
        this.dato = dato;
        this.p=null;
        this.izquierdo = null;
        this.derecho = null;
    }

    public int getDato() {
        return dato;
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
    
}
