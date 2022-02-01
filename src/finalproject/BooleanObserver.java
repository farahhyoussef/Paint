/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;


public class BooleanObserver extends Observer {
private Isselected e;
 public BooleanObserver(Isselected e) {
        this.e = e;
    }
    
    @Override
    public void update() {
         System.out.println("Boolean Observer "+ e.isCondition());
         
    }
    
}
