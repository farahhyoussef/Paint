/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrawingArea;

import java.awt.Color;


public class Undo {

    private char actionUndo, shape;
    private Color color,clearedColor;
    private int x1, x2, x3, y1, y2, y3, index,increaseSide;
    private boolean isFilled;
  Undo(char action,Color color, boolean isFilled, int x1, int x2, int y1, int y2) {
        actionUndo=action;
        this.color=color;
        this.isFilled=isFilled;
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        
    }
    public Undo(char action,int index,int x1, int x2, int y1, int y2,int increaseSide) {
        this.index = index;
        this.actionUndo = action;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.increaseSide=increaseSide;

    }

    public Undo(char action, int index) {
        actionUndo = action;
        this.index = index;
    }

    Undo(int index,char action, Color color, boolean isFilled, int x1, int x2, int y1, int y2) {
        actionUndo = action;
        this.index=index;
        this.color = color;
        this.isFilled = isFilled;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }
    

    /**
     * @return the actionUndo
     */
    public char getActionUndo() {
        return actionUndo;
    }

    /**
     * @param movement the actionUndo to set
     */
    public void setActionUndo(char movement) {
        this.actionUndo = movement;
    }

    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @return the x3
     */
    public int getX3() {
        return x3;
    }

    /**
     * @param x3 the x3 to set
     */
    public void setX3(int x3) {
        this.x3 = x3;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * @return the y3
     */
    public int getY3() {
        return y3;
    }

    /**
     * @param y3 the y3 to set
     */
    public void setY3(int y3) {
        this.y3 = y3;
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

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the shape
     */
    public char getShape() {
        return shape;
    }

    /**
     * @param shape the shape to set
     */
    public void setShape(char shape) {
        this.shape = shape;
    }

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
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the increaseSide
     */
    public int getIncreaseSide() {
        return increaseSide;
    }

    /**
     * @return the clearedColor
     */
    public Color getClearedColor() {
        return clearedColor;
    }

    /**
     * @param prevColor the clearedColor to set
     */
    public void setClearedColor(Color clearedColor) {
        this.clearedColor = clearedColor;
    }

}
