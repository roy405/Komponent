package com.example.Komponent.Komponent;

import com.example.Komponent.Komponent.model.Orders;
import com.example.Komponent.Komponent.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class PaymentDTO {

    private
    Integer id;

    private String payment_method;
    private String card_type;
    private String card_number;
    private String card_expiery;
    private String card_cvv;


    private User user;


    private List<Orders> orders;

    public PaymentDTO() {
    }

}
