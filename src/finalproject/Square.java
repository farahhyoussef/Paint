/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;


public class Square extends RightAngledFourSided {
     
    public Square(Color color, boolean isFilled, int x1, int x2, int y1, int y2) {
        super(color, isFilled, x1, x2, y1, y2);
        
    }

    
    
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (isIsFilled()) {
            if (getX2() > getY2()) {
                g.fillRect(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), Math.abs(getX2() - getX1()), Math.abs(getX2() - getX1()));
            } else {
                g.fillRect(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), Math.abs(getY2() - getY1()), Math.abs(getY2() - getY1()));
            }
        } else {
            if (getX2() > getY2()) {
                g.drawRect(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), Math.abs(getX2() - getX1()), Math.abs(getX2() - getX1()));
            } else {
                g.drawRect(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), Math.abs(getY2() - getY1()), Math.abs(getY2() - getY1()));
            }
        }
    }

    public boolean isSelected(int xMouse, int yMouse) {
        int x = Math.min(getX1(), getX2());
        int y = Math.min(getY1(), getY2());
        int side;
        if (getX2() > getY2()) {

            side = (Math.abs(getX2() - getX1()));

        } else {

            side = (Math.abs(getY2() - getY1()));

        }
        if (xMouse <= (x + side) && xMouse >= x && yMouse <= (y + side) && yMouse >= y) {
            BooleanObserver b = new BooleanObserver(e);
             e.attach(b);
        e.setCondition(true);
         System.out.println("squuare");
            return true;
        }
    
        return false;

    }

    

    
}
