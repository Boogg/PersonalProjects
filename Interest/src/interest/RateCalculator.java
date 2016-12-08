/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interest;


public class RateCalculator {
    
    //variables
    private int years = 0;
    private float rate = 0;
//    private float payment = 0;
    private float principal = 0;
    
     //constructor
    RateCalculator(int principal, float rate){
        this.rate = rate;
        this.principal = principal;
    }
    
    
    //setters and getters
    public int getYears(){
        return this.years;
    }
    public void setYears(int years){
        this.years = years;
    }
    public float getRate(){
        return this.rate;
    }
    public void setRate(float rate){
        this.rate = rate;
    }
//    public float getPayment(){
//        return this.payment;
//    }
    public float getPricipal(){
        return this.principal;
    }
    public void setPrincipal(float principal){
        this.principal = principal;
    }
    
    
    //methods
    public float calculatePayment(){
        float holder = 1;
        for(int i=0;i<(12*this.years);i++){
            holder *= (1 + rate/12);
        }
        return this.principal*(this.rate / 12)*(holder / (holder-1));  
    }
       
    
}
