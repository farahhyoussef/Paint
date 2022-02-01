/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import finalproject.Observer;
import java.util.ArrayList;

public class Isselected {
    private boolean condition;
    private ArrayList<Observer> observers=new ArrayList<Observer>();

    public Isselected(boolean condition) {
        this.condition = condition;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
        notifyallObservers();
    }
     public void attach(Observer o)
    {
       observers.add(o);
    }
     public void notifyallObservers()
    {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}
