/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import entidades.Payment;
import modeloControl.AccesoDatos;

/**
 *
 * @author LABO08
 */
public class CashStrategy implements PaymentStrategy {
    private Payment payment;
    
    public CashStrategy(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void pay(Double amount) {
        payment.setAmount(amount);
        AccesoDatos ad = new AccesoDatos();
        ad.insertRental(payment.getRental());
        ad.insertPayment(payment);
    }

}
