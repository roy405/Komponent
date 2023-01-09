package com.example.Komponent.Komponent.services;


import com.example.Komponent.Komponent.model.Orders;
import com.example.Komponent.Komponent.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrdersService {

    Orders saveOrder(Orders Orders);

    List<Orders> getOrdersById(User user);

    void deleteOrder(int id);

    List<Orders> getAllOrders();

}
