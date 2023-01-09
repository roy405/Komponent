package com.example.Komponent.Komponent.repository;

import com.example.Komponent.Komponent.model.Cart;
import com.example.Komponent.Komponent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CartRepo extends JpaRepository<Cart, Integer> {

    Cart findCartByUser(User user);

}
