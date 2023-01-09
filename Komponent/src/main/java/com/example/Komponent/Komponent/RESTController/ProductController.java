package com.example.Komponent.Komponent.RESTController;

import com.example.Komponent.Komponent.model.Product;
import com.example.Komponent.Komponent.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @GetMapping
    public List<Product> getProducts() {
        return ProductService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return ProductService.getProductById(id);
    }

    @CrossOrigin(origins = "http://localhost:3005")
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return ProductService.saveProduct(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return ProductService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        ProductService.deleteProduct(id);
    }
}