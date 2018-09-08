/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_jesus_santiago;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Jesus David
 */
public class Test extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graph2=(Graphics2D) g;
        graph2.setColor(Color.red);
        Rectangle rectangle=new Rectangle(this.getWidth()/2-50,this.getHeight()/2-50,100,100);
        graph2.draw(rectangle);
    }
}
