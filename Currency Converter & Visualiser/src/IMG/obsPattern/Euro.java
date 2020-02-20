/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IMG.obsPattern;

/*This is the observable class*/
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author marjo
 */
public class Euro{
    
    
    private List<Observer> observers = new ArrayList<>();
    private double euroToUSD;
    
 
public double geteuroToUSD() {
      return euroToUSD;
   }

   public void seteuroToUSD(double euroToUSD) {
      this.euroToUSD = euroToUSD;
      notifyAllObservers();
   }

   public void attach(Observer observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
   } 	
}
