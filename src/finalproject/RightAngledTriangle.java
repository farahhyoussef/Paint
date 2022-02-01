/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;


public class RightAngledTriangle extends Triangle {
    
    public RightAngledTriangle(Color color, boolean isFilled, int x1, int x2, int y1, int y2) {
        super(color, isFilled, x1, x2, y1, y2);
    }
    @Override
    public void draw(Graphics g) {
         g.setColor(getColor());
         if (isIsFilled()) {
             g.fillPolygon(new int[] {getX1(), getX2(),getX3()}, new int[] {getY1(), getY2(), getY3()}, 3);
        } else {
           g.drawPolygon(new int[] {getX1(), getX2(),getX3()}, new int[] {getY1(), getY2(), getY3()}, 3);
           
        }
         
    }
}
