package com.example.Komponent.Komponent.services;


import com.example.Komponent.Komponent.model.Product;
import com.example.Komponent.Komponent.repository.ProductRepo;
import com.example.Komponent.Komponent.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepo repository;

    @Override
    public Product saveProduct(Product Product) {
        return repository.save(Product);
    }

    @Override
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(int id) {
        Product Product = repository.findById(id).orElse(null);
        repository.delete(Product);
    }
    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
