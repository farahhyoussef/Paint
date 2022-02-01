/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends RightAngledFourSided {

    public Rectangle(Color color, boolean isFilled, int x1, int x2, int y1, int y2) {
        super(color, isFilled, x1, x2, y1, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (isIsFilled()) {

            g.fillRect(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), Math.abs(getX2() - getX1()), Math.abs(getY2() - getY1()));
        } else {
            g.drawRect(Math.min(getX1(), getX2()), Math.min(getY1(), getY2()), Math.abs(getX2() - getX1()), Math.abs(getY2() - getY1()));
        }
    }

}
