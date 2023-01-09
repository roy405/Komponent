package com.example.Komponent.Komponent;

import com.example.Komponent.Komponent.model.Orders;
import com.example.Komponent.Komponent.model.Product;
import com.example.Komponent.Komponent.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class CartDTO {
    private
    Integer id;

    private double cart_total;
    private double shipping_cost;
    private double taxes;


    private User user;

    private Orders orders;

    private List<Product> product;

    public CartDTO() {
    }
}
