/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Strategy.CashStrategy;
import Strategy.CreditCardStrategy;
import Strategy.CriptoStrategy;
import Strategy.DebtCardStrategy;
import Strategy.NullStrategy;
import Strategy.PaymentStrategy;
import Strategy.PaypalStrategy;
import entidades.Payment;

/**
 *
 * @author LABO08
 */
public class StrategyFactory {
    Payment payment;
    
    public StrategyFactory(Payment payment){
        this.payment = payment;
    }
    
    public PaymentStrategy getStrategy(String strategyType){
        if(strategyType == null){
            return new NullStrategy();
        }
        else if(strategyType.equalsIgnoreCase("CASH")){
            return new CashStrategy(payment);
        }
        else if(strategyType.equalsIgnoreCase("CREDIT")){
            return new CreditCardStrategy(payment);
        }
        else if(strategyType.equalsIgnoreCase("DEBT")){
            return new DebtCardStrategy(payment);
        }
        else if(strategyType.equalsIgnoreCase("CRIPTO")){
            return new CriptoStrategy(payment);
        }
        else if(strategyType.equalsIgnoreCase("PAYPAL")){
            return new PaypalStrategy(payment);
        }
        else{
            return new NullStrategy();
        }
    }
}
