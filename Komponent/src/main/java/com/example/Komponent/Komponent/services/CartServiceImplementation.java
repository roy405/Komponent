package com.example.Komponent.Komponent.services;


import com.example.Komponent.Komponent.model.Cart;
import com.example.Komponent.Komponent.model.Product;
import com.example.Komponent.Komponent.model.User;
import com.example.Komponent.Komponent.repository.CartRepo;
import com.example.Komponent.Komponent.repository.ProductRepo;
import com.example.Komponent.Komponent.repository.UserRepo;
import com.example.Komponent.Komponent.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    private CartRepo repository;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Cart saveCart(Cart Cart) {
        Optional<User> userOptional = userRepo.findById(Cart.getUser().getId());
        Optional<Product> prodOptional = productRepo.findById(Cart.getProduct().get(0).getId());

        if (userOptional.isPresent() && prodOptional.isPresent()) {
            Cart cart = repository.findCartByUser(userOptional.get());
            if (cart == null) {
                cart = new Cart();
            }

            cart.setUser(userOptional.get());
            boolean status = true;
            List<Product> productList = cart.getProduct();
            if (productList != null) {
                for (Product prod : productList) {
                    if (prod.getId().equals(prodOptional.get().getId())) {
                        //prod.setQuantity(prod.getQuantity()+1);
                        status = false;
                        break;
                    }
                }
            }

            if (status) {
                if (productList == null) {
                    productList = new ArrayList<>();
                }
                productList.add(prodOptional.get());
                cart.setCart_total(cart.getCart_total()+prodOptional.get().getPrice());
                cart.setProduct(productList);
            }
            return repository.save(cart);
        }
        return null;
    }

    @Override
    public Cart getCartById(int id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            Cart cart = repository.findCartByUser(userOptional.get());
            return cart;
        }
        return null;
    }

    @Override
    public void deleteCart(int id) {
        Cart Cart = repository.findById(id).orElse(null);
        repository.delete(Cart);
    }

    @Override
    public List<Cart> getAllCart() {
        return repository.findAll();
    }



    /* @Override
    public Integer getCartPriceTotalByUser(User user) {
        List<Cart> list = repository.findCartByUser(user);
        int totPrice = 0;
        for (Cart cart:list) {
            totPrice += cart.getCart_total();
        }
        return totPrice;
    } */
}

