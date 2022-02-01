/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;


public class Triangle extends Shape {

    private int x3, y3;

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public Triangle(Color color, boolean isFilled, int x1, int x2, int y1, int y2) {
        super(color, isFilled, x1, x2, y1, y2);
        //this.x3 = x3;
        //this.y3 = y3;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (isIsFilled()) {
            g.fillPolygon(new int[]{getX1(), getX2(), getX3()}, new int[]{getY1(), getY2(), getY3()}, 3);
        } else {
            g.drawPolygon(new int[]{getX1(), getX2(), getX3()}, new int[]{getY1(), getY2(), getY3()}, 3);

        }

    }

    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    public boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
        /* Calculate area of triangle ABC */
        double A = area(x1, y1, x2, y2, x3, y3);

        /* Calculate area of triangle PBC */
        double A1 = area(x, y, x2, y2, x3, y3);

        /* Calculate area of triangle PAC */
        double A2 = area(x1, y1, x, y, x3, y3);

        /* Calculate area of triangle PAB */
        double A3 = area(x1, y1, x2, y2, x, y);

        /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
    }

    @Override
    public boolean isSelected(int xMouse, int yMouse) {
        

            if (isInside(getX1(), getY1(), getX2(), getY2(), getX3(), getY3(), xMouse, yMouse)) {
               BooleanObserver b = new BooleanObserver(e);
             e.attach(b);
        e.setCondition(true);
         System.out.println("triangle");
                return true;
            }


        return false;
    }

}
