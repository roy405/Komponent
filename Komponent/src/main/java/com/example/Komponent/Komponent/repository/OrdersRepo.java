package com.example.Komponent.Komponent.repository;

import com.example.Komponent.Komponent.model.Cart;
import com.example.Komponent.Komponent.model.Orders;
import com.example.Komponent.Komponent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrdersRepo extends JpaRepository<Orders, Integer> {

    List<Orders> findOrdersByUser(User user);

}
