/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IMG.obsPattern;

/**
 *
 * @author marjo
 */
public class ObserverTest {

   public static void main(String[] args) {
      Euro euro = new Euro();

       new USD(euro, 7);
      
      System.out.println("First state change: 1.083317");	
      euro.seteuroToUSD(1.083317);
       
      System.out.println("\nSecond state change: 3");	
      euro.seteuroToUSD(3);
   }
}
    
