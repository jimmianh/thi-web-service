package com.example.thiwedservice.controller;

import com.example.thiwedservice.model.Product;
import com.example.thiwedservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity findAll() {
        List<Product> list = productService.findAll();
        if (list == null || list.size() == 0){
            return new ResponseEntity(list, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable(name = "id") int id) {
        return new ResponseEntity(productService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public ResponseEntity sellProduct(@PathVariable(name = "id") int id, @RequestParam Integer quantity) {
        return new ResponseEntity(productService.sellProduct(id, quantity), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity save( @RequestBody Product product) {
        return new ResponseEntity(productService.save(product), HttpStatus.CREATED);
    }
}
