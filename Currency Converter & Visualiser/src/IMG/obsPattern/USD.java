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
public class USD extends Observer{
double amt;
    
    public USD(Euro euro, double amt) {
        this.euro = euro;
        this.euro.attach(this);
        this.amt = amt;
   }

   public USD() {
       
    }
//      public String toString(){
//        return "Amount is : " + amt;
//    }
//    
 @Override
   public void update() {
      System.out.println(amt*(euro.geteuroToUSD())); 
   }
}
    
  

