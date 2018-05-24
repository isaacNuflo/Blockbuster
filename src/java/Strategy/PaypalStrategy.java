/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import entidades.Payment;
import entidades.Rental;
import java.sql.Timestamp;
import modeloControl.AccesoDatos;

/**
 *
 * @author LABO08
 */
public class PaypalStrategy implements PaymentStrategy {

    private Payment payment;
    private String emailId;
    private String password;

    public PaypalStrategy(Payment payment) {
        this.payment = payment;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void pay(Double amount) {
        payment.setAmount(amount);
        AccesoDatos ad = new AccesoDatos();
        ad.insertRental(payment.getRental());
        ad.insertPayment(payment);
    }

}
