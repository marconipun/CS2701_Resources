package com.example.demo.Models;
import jakarta.persistence.*;

@Entity
public class SellerProduce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;
    private int stock;

    @ManyToOne
    private User seller;

    @ManyToOne
    private Produce produce;

    public SellerProduce() {}

    public SellerProduce(User seller, Produce produce, double price, int stock) {
        this.seller = seller;
        this.produce = produce;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public User getSeller() {
        return seller;
    }

    public Produce getProduce() {
        return produce;
    }
}