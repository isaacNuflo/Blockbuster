/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Timestamp;

/**
 *
 * @author LABO08
 */
public class Rental {
    private Integer id;
    private Timestamp rental_date;
    private Inventory inventory;
    private Integer customer_id;
    private Integer staff_id;
    private Timestamp return_date;
    private Timestamp last_update;

    public Rental(Integer id, Timestamp rental_date, Inventory inventory,Timestamp last_update) {
        this.id = id;
        this.rental_date = rental_date;
        this.inventory = inventory;
        this.customer_id = 1;
        this.staff_id = 1;
        this.last_update = last_update;
        this.return_date = null;
    }

    public Timestamp getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Timestamp return_date) {
        this.return_date = return_date;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer rental) {
        this.id = rental;
    }

    public Timestamp getRental_date() {
        return rental_date;
    }

    public void setRental_date(Timestamp rental_date) {
        this.rental_date = rental_date;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }
    
    
}
