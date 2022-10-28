package com.example.thiwedservice.service;

import com.example.thiwedservice.model.Product;


import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    Optional<Product> findById(int id );
    Product sellProduct(int id, Integer quantity);
    List<Product> findAll();

}

