package com.example.mobilekomponent.models;


import java.util.List;

public class Cart {


    private Integer id;
    private double cart_total;
    private double shipping_cost;
    private double taxes;

    public Cart(int id, double cart_total, double shipping_cost, double taxes) {
        this.id = id;
        this.cart_total = cart_total;
        this.shipping_cost = shipping_cost;
        this.taxes = taxes;
    }


    private User user;


    private Orders orders;


    private List<Product> product;

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCart_total() {
        return cart_total;
    }

    public void setCart_total(double cart_total) {
        this.cart_total = cart_total;
    }

    public double getShipping_cost() {
        return shipping_cost;
    }

    public void setShipping_cost(double shipping_cost) {
        this.shipping_cost = shipping_cost;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}

