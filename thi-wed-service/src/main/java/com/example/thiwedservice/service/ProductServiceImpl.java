package com.example.thiwedservice.service;
import com.example.thiwedservice.model.Product;
import com.example.thiwedservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product sellProduct(int id, Integer quantity) {
        Optional<Product> existProduct = productRepository.findById(id);
        if (!existProduct.isPresent()){
            throw new RuntimeException("Product not found!");
        }
        Product updateProduct = existProduct.get();
        if (updateProduct.getQuantity() < quantity){
            throw new RuntimeException("Product quantity not enough!");
        }
        updateProduct.setQuantity(updateProduct.getQuantity() - quantity);
        return productRepository.save(updateProduct);
    }
}
