package com.example.Komponent.Komponent.services;


import com.example.Komponent.Komponent.model.Cart;
import com.example.Komponent.Komponent.model.Orders;
import com.example.Komponent.Komponent.model.User;
import com.example.Komponent.Komponent.repository.*;
import com.example.Komponent.Komponent.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImplementation implements OrdersService {

    @Autowired
    private OrdersRepo repository;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CartRepo cartRepo;

    @Override
    public Orders saveOrder(Orders Orders) {

        return repository.save(Orders);
    }

    @Override
    public List<Orders> getOrdersById(User user) {
        return repository.findOrdersByUser(user);
    }



    @Override
    public void deleteOrder(int id) {
        Orders Orders = repository.findById(id).orElse(null);
        repository.delete(Orders);
    }
    @Override
    public List<Orders> getAllOrders() {
        return repository.findAll();
    }
}
