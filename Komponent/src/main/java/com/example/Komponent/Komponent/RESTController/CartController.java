package com.example.Komponent.Komponent.RESTController;



import com.example.Komponent.Komponent.model.Cart;
import com.example.Komponent.Komponent.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private com.example.Komponent.Komponent.services.CartService CartService;

    @GetMapping
    public List<Cart> getCarts() {
        return CartService.getAllCart();
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable("id") int id) {
        return CartService.getCartById(id);
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return CartService.saveCart(cart);
    }

    @PutMapping
    public Cart updateCart(@RequestBody Cart cart) {
        return CartService.saveCart(cart);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") int id) {
        CartService.deleteCart(id);
    }


}
