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
public class ALL {
 
    private final double exchangeRateToEUR;
    private final double exchangeRateToUSD;
    private final double exchangeRateToGBP;


    public ALL() {
        this.exchangeRateToEUR = 0.00819;
        this.exchangeRateToUSD = 0.00887;
        this.exchangeRateToGBP = 0.00680;
    }

    public double getRateToUSD() {
        return this.exchangeRateToUSD;
    }

    public double getRateToGBP() {
        return this.exchangeRateToGBP;
    }
    
    public double getRateToEUR(){
        return this.exchangeRateToEUR;
    }

    
}
