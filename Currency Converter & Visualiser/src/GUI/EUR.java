/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author marjo
 */
public class EUR {
    
    private final double exchangeRateToUSD;
    private final double exchangeRateToALL;
    private final double exchangeRateToGBP;


    public EUR() {
        this.exchangeRateToUSD = 1.083317;
        this.exchangeRateToALL = 122.094;
        this.exchangeRateToGBP = 0.83026;
    }

    public double getRateToALL() {
        return this.exchangeRateToALL;
    }

    public double getRateToGBP() {
        return this.exchangeRateToGBP;
    }
    
    public double getRateToUSD(){
        return this.exchangeRateToUSD;
    }

}
