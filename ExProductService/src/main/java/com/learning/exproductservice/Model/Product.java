package com.learning.exproductservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
public class Product {

    @Id()
    @GeneratedValue()
    private int prdid;
    @NotEmpty(message="Product name is required")
    private String prdname;
    @Positive(message = "Invalid product price")
    private double prdprice;
    private String prddesc;

    public Product(){

    }
    public Product(String prdname, double prdprice, String prddesc) {
        this.prdname = prdname;
        this.prdprice = prdprice;
        this.prddesc = prddesc;
    }

    public int getPrdid() {
        return prdid;
    }

    public void setPrdid(int prdid) {
        this.prdid = prdid;
    }

    public String getPrdname() {
        return prdname;
    }

    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    public double getPrdprice() {
        return prdprice;
    }

    public void setPrdprice(double prdprice) {
        this.prdprice = prdprice;
    }

    public String getPrddesc() {
        return prddesc;
    }

    public void setPrddesc(String prddesc) {
        this.prddesc = prddesc;
    }
}
