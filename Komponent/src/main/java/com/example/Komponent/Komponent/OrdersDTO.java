package com.example.Komponent.Komponent;

import com.example.Komponent.Komponent.model.Address;
import com.example.Komponent.Komponent.model.Cart;
import com.example.Komponent.Komponent.model.Payment;
import com.example.Komponent.Komponent.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
public class OrdersDTO {

    Integer id;

    private double order_total;

    private String order_date;

    private CartDTO cart;

    private User user;

    private PaymentDTO payment;

    private AddressDTO address;

    public OrdersDTO(){}


}
