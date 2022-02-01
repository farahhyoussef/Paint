/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;


public class RightAngledFourSided extends Shape {

    public RightAngledFourSided(Color color, boolean isFilled, int x1, int x2, int y1, int y2) {
        super(color, isFilled, x1, x2, y1, y2);
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public boolean isSelected(int xMouse, int yMouse) {
        int x = Math.min(getX1(), getX2());
        int side1 = (Math.abs(getX2() - getX1()));
        int y = Math.min(getY1(), getY2());
        int side2 = (Math.abs(getY2() - getY1()) );
        if (xMouse <= (x + side1) && xMouse >= x && yMouse <= (y + side2) && yMouse >= y) {
            BooleanObserver b = new BooleanObserver(e);
             e.attach(b);
        e.setCondition(true);
         System.out.println("rectangle");
            return true;
           
        }
        return false;
    }

}
