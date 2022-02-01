/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class Line extends Shape{

    public Line(Color color, boolean isFilled, int x1, int x2, int y1, int y2) {
        super(color, isFilled, x1,x2,y1, y2);
    }
 
   

    @Override
    public void draw(Graphics g){
         g.setColor(getColor());
        g.drawLine(getX1(),getY1(),getX2(),getY2());
        
    }

    @Override
    public boolean isSelected(int xMouse, int yMouse) {
        
     
       double distance =sqrt(pow((getX2()-getX1()),2)+ pow((getY2()-getY1()),2));
       double distance1 =sqrt(pow((getX2()-xMouse),2)+ pow((getY2()-yMouse),2));
       double distance2 =sqrt(pow((xMouse-getX1()),2)+ pow((yMouse-getY1()),2));
       if(((distance1+distance2)- distance )< 10)
       { 
           BooleanObserver b = new BooleanObserver(e);
             e.attach(b);
        e.setCondition(true);
        System.out.println("line");
           return true;
       }
       return false;
    }

  
    
    
    
    
    
   
 
}
