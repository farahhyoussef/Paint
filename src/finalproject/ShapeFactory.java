/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;


public class ShapeFactory {

    public Shape createShape(char choice, Color colorPicked, boolean ifFilled, int firstX, int secondX, int firstY, int secondY) {
        switch (choice) {
            case 'L': {
                return new Line(colorPicked, ifFilled, firstX, secondX, firstY, secondY);
            }
            case 'R': {
                return new Rectangle(colorPicked, ifFilled, firstX, secondX, firstY, secondY);
            }
            case 'S': {
                return new Square(colorPicked, ifFilled, firstX, secondX, firstY, secondY);
            }
            case 'C': {
                return new Circle(colorPicked, ifFilled, firstX, secondX, firstY, secondY);
            }
            case 'T': {
                return new Triangle(colorPicked, ifFilled, firstX, secondX, firstY, secondY);
            }
            case 'A': {
                return new RightAngledTriangle(colorPicked, ifFilled, firstX, secondX, firstY, secondY);
            }
            case 'O': {
                return new Oval(colorPicked, ifFilled, firstX, secondX, firstY, secondY);

            }
        }
        return null;
    }

}
