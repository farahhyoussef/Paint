/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;


public abstract class Shape extends Coordinates implements Cloneable, RepaintDecorator {

    private Color color;
    private boolean isFilled;
    Isselected e = new Isselected(false);

    public Shape(Color color, boolean isFilled, int x1, int x2, int y1, int y2) {
        super(x1, x2, y1, y2);
        this.color = color;
        this.isFilled = isFilled;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Shape s = (Shape) super.clone();
        return s;
    }

    public abstract void draw(Graphics g);

    public abstract boolean isSelected(int xMouse, int yMouse);

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the isFilled
     */
    public boolean isIsFilled() {
        return isFilled;
    }

    /**
     * @param isFilled the isFilled to set
     */
    public void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    @Override
    public void changeFill() {
        if (!isIsFilled()) {
            setIsFilled(true);
        }
    }
    

}
