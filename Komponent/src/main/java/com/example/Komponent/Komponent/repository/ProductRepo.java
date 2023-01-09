package com.example.Komponent.Komponent.repository;


import com.example.Komponent.Komponent.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product, Integer> {

}