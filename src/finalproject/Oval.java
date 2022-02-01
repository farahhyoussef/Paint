/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;


public class Oval extends Shape {
    
    public Oval(Color color, boolean isFilled, int x1, int x2, int y1, int y2) {
        super(color, isFilled, x1, x2, y1, y2);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (isIsFilled()) {

            g.fillOval(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), Math.abs(getX2() - getX1()), Math.abs(getY2() - getY1()));
        } else {
            g.drawOval(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), Math.abs(getX2() - getX1()), Math.abs(getY2() - getY1()));
        }
    }

    @Override
    public boolean isSelected(int xMouse, int yMouse) {
        
        int x = Math.min(getX1(), getX2());
        int radius1 = (Math.abs(getX2() - getX1()));
        int y = Math.min(getY1(), getY2());
        int radius2 = (Math.abs(getY2() - getY1()));
        if (xMouse <= (x + radius1) && xMouse >= x && yMouse <= (y + radius2) && yMouse >= y) {
            BooleanObserver b = new BooleanObserver(e);
             e.attach(b);
        e.setCondition(true);
        System.out.println("oval");
            return true;
        }

      return false;
    }

    

}
