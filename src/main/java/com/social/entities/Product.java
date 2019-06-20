package com.social.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name="Product")
@Scope("session")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long productid ;


    @Column(unique = true)
    private String designation;


    private double price;

    private double qty;

    public Long getProductId() {
        return productid;
    }

    public void setProductId(Long productId) {
        this.productid = productId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }




    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

}

