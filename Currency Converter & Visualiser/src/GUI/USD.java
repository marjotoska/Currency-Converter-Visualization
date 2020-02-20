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
public class USD {
    
    private final double exchangeRateToEUR;
    private final double exchangeRateToALL;
    private final double exchangeRateToGBP;


    public USD() {
        this.exchangeRateToEUR = 0.92302;
        this.exchangeRateToALL = 112.703;
        this.exchangeRateToGBP = 0.76640;
    }

    public double getRateToALL() {
        return this.exchangeRateToALL;
    }

    public double getRateToGBP() {
        return this.exchangeRateToGBP;
    }
    
    public double getRateToEUR(){
        return this.exchangeRateToEUR;
    }

}

