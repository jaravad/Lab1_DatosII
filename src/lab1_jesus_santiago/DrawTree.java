/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_jesus_santiago;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Jesus David
 */
public class DrawTree extends JPanel {

    private Nodo Tree;
    private HashMap posicNodos = null;
    private HashMap subtSizes = null;
    private boolean sw = true;
    private int parent2child = 20, child2child = 30;
    private Dimension empty = new Dimension(0, 0);
    private FontMetrics fm = null;

    public DrawTree(Nodo myTree) {
        this.Tree = myTree;
        this.setBackground(Color.WHITE);
        posicNodos = new HashMap();
        subtSizes = new HashMap();
        sw = true;
        repaint();
    }

    private void calculatePositions() {
        posicNodos.clear();
        subtSizes.clear();
        Nodo root = this.Tree;
        if (root != null) {
            calcularTamañoSubarbol(root);
            calculatePosition(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
        }
    }

    private Dimension calcularTamañoSubarbol(Nodo n) {
        if (n == null) {
            return new Dimension(0, 0);
        }

        Dimension ld = calcularTamañoSubarbol(n.getIzquierdo());
        Dimension rd = calcularTamañoSubarbol(n.getDerecho());

        int h = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
        int w = ld.width + child2child + rd.width;

        Dimension d = new Dimension(w, h);
        subtSizes.put(n, d);

        return d;
        
        
    }

    private void calculatePosition(Nodo n, int left, int right, int top) {
        if (n == null) {
            return;
        }

        Dimension ld = (Dimension) subtSizes.get(n.getIzquierdo());
        if (ld == null) {
            ld = empty;
        }

        Dimension rd = (Dimension) subtSizes.get(n.getDerecho());
        if (rd == null) {
            rd = empty;
        }

        int center = 0;

        if (right != Integer.MAX_VALUE) {
            center = right - rd.width - child2child / 2;
        } else if (left != Integer.MAX_VALUE) {
            center = left + ld.width + child2child / 2;
        }
        int width = fm.stringWidth(n.getDato());

        posicNodos.put(n, new Rectangle(center - width / 2 - 3, top, width + 6, fm.getHeight()));

        calculatePosition(n.getIzquierdo(), Integer.MAX_VALUE, center - child2child / 2, top + fm.getHeight() + parent2child);
        calculatePosition(n.getDerecho(), center + child2child / 2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child);
    }

    private void dibujarArbol(Graphics2D g, Nodo n, int puntox, int puntoy, int yoffs) {
        if (n == null) {
            return;
        }

        Rectangle r = (Rectangle) posicNodos.get(n);
        g.draw(r);
        g.drawString(n.getDato(), r.x + 3, r.y + yoffs);

        if (puntox != Integer.MAX_VALUE) {
            g.drawLine(puntox, puntoy, (int) (r.x + r.width / 2), r.y);
        }

        dibujarArbol(g, n.getIzquierdo(), (int) (r.x + r.width / 2), r.y + r.height, yoffs);
        dibujarArbol(g, n.getDerecho(), (int) (r.x + r.width / 2), r.y + r.height, yoffs);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        fm = g.getFontMetrics();

        if (sw) {
            calculatePositions();
            sw = false;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(getWidth() / 2, parent2child);
        dibujarArbol(g2d, this.Tree, Integer.MAX_VALUE, Integer.MAX_VALUE,
                fm.getLeading() + fm.getAscent());
        fm = null;
    }
}
