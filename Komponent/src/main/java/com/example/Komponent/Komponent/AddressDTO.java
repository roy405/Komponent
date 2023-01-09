package com.example.Komponent.Komponent;

import com.example.Komponent.Komponent.model.ExteriorSupplier;
import com.example.Komponent.Komponent.model.Orders;
import com.example.Komponent.Komponent.model.Product;
import com.example.Komponent.Komponent.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class AddressDTO {

    private
    Integer id;

    private String street1;
    private String street2;
    private String state;
    private String city;
    private String zip_code;
    private String country;
    private String address_type;

    private List<User> user;

    private ExteriorSupplier exteriorSupplier;

    private List<Orders> orders;

    private List<Product> product ;

    public AddressDTO() {
    }


}
