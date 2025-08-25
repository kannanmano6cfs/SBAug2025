package com.learning.exproductservice.Controller;

import com.learning.exproductservice.Model.Product;
import com.learning.exproductservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String Welcome(){
        return "Welcome to the Product Service";
    }

    //Post Methods (Versioning)
    @PostMapping("/new/v1")
    public ResponseEntity<String> addNewProduct(){
        Product product=new Product();
        product.setPrdname("Apple 16");
        product.setPrdprice(1500.0);
        product.setPrddesc("Apple smart mobile device");
        productRepository.save(product);
        return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
    }

    @PostMapping("/new/v2")
    public ResponseEntity<String> addNewProduct2(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
    }


    //Get Methods
    @GetMapping("/count")
    public ResponseEntity<String> getProductCount(){
        long count = productRepository.count();
        return new ResponseEntity<>("Number of Products is " + count, HttpStatus.OK);
    }

    @GetMapping("/products")
    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/product/v1/{id}")
    public Product getProductById(@PathVariable int id){
        Optional<Product> product=productRepository.findById(id);
        return product.orElse(null);
    }

    @GetMapping("/product/v2")
    public Product getProduct2ById(@RequestParam int id){
        Optional<Product> product=productRepository.findById(id);
        return product.orElse(null);
    }

    @GetMapping("/product/v3")
    public Iterable<Product> getProduct3ById(@RequestParam String name){
        Iterable<Product> product=productRepository.findByPrdname(name);
        return product;
    }
    //Put Methods


    //Delete Methods


    //Pagination


    //Filtering


    //Caching


    //Validation
}
