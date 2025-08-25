package com.learning.exproductservice.Controller;

import com.learning.exproductservice.Model.Product;
import com.learning.exproductservice.Repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    //@CacheEvict(value="allproducts", allEntries=true)
    public ResponseEntity<String> addNewProduct(){
        Product product=new Product();
        product.setPrdname("Apple 16");
        product.setPrdprice(1500.0);
        product.setPrddesc("Apple smart mobile device");
        productRepository.save(product);
        return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
    }

    @PostMapping("/new/v2")
    @CacheEvict(value="allproducts", allEntries=true)
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

    //Caching
    @GetMapping("/products")
    @Cacheable(value="allproducts")
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
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product1){
        Product product2=productRepository.findById(id).orElseThrow();
        product2.setPrdname(product1.getPrdname());
        product2.setPrdprice(product1.getPrdprice());
        product2.setPrddesc(product1.getPrddesc());
        productRepository.save(product2);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }
    //Delete Methods
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        productRepository.deleteById(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAllProduct(){
        productRepository.deleteAll();
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    //Pagination
    @GetMapping("/products/v2")
    public Page<Product> getProducts2(@PageableDefault(size=2) Pageable pageable){
        return productRepository.findAll(pageable);
    }

    //Filtering
    @GetMapping("/search")
    public ResponseEntity<Page<Product>> getProducts(@RequestParam String name,@PageableDefault(size=2) Pageable pageable){
        return ResponseEntity.ok(productRepository.findByPrdnameContainingIgnoreCase(name, pageable));
    }

    //Validation [add new dependencies for validation in pom.xml]
    @PostMapping("/new/v3")
    public ResponseEntity<String> addNewProduct3(@Valid @RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>("Valid Product added successfully", HttpStatus.OK);
    }
}
