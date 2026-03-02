package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private double priceAtOrder;

    @ManyToOne
    private Order order;

    @ManyToOne
    private SellerProduce sellerProduce;

    public OrderItem() {}

    public OrderItem(Order order, SellerProduce sellerProduce, int quantity, double priceAtOrder) {
        this.order = order;
        this.sellerProduce = sellerProduce;
        this.quantity = quantity;
        this.priceAtOrder = priceAtOrder;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPriceAtOrder() {
        return priceAtOrder;
    }
}