package com.example.Komponent.Komponent.services;

import com.example.Komponent.Komponent.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    Product saveProduct(Product Product);

    Product getProductById(int id);

    void deleteProduct(int id);

    List<Product> getAllProducts();
}
