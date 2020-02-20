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
public class GBP {
    
    private final double exchangeRateToEUR;
    private final double exchangeRateToUSD;
    private final double exchangeRateToALL;


    public GBP() {
        this.exchangeRateToEUR = 1.20448;
        this.exchangeRateToUSD = 1.30480;
        this.exchangeRateToALL = 147.055;
    }

    public double getRateToUSD() {
        return this.exchangeRateToUSD;
    }

    public double getRateToALL() {
        return this.exchangeRateToALL;
    }
    
    public double getRateToEUR(){
        return this.exchangeRateToEUR;
    }


    
}
