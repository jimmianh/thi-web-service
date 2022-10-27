package com.example.thiwedservice.service;

import com.example.thiwedservice.model.Product;


import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product sellProduct(Long id, Integer quantity);
    List<Product> findAll();
}

