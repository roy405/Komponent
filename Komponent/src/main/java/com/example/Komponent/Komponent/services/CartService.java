package com.example.Komponent.Komponent.services;


import com.example.Komponent.Komponent.model.Cart;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

public interface CartService {

    Cart saveCart(Cart Cart);

    Cart getCartById(int id);

    void deleteCart(int id);

    List<Cart> getAllCart();

    /* Integer getCartPriceTotalByUser(User user); */
}
