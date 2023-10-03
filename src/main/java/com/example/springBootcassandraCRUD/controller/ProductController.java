package com.example.springBootcassandraCRUD.controller;

import com.example.springBootcassandraCRUD.entity.Product;
import com.example.springBootcassandraCRUD.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;


    @PostMapping("products")
    public Product addProduct(@RequestBody Product product){
        productRepo.save(product);
        return product;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){

        return productRepo.findAll();
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
                                                 @RequestBody Product productDetails){
        try{
            Product product = productRepo.findById(productId).get();
            product.setName(productDetails.getName());
            final Product updatedProduct = productRepo.save(product);
            return ResponseEntity.ok(updatedProduct);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       return null;
    }

    @GetMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Integer productId){
        try{
            return productRepo.findById(productId).get();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    @DeleteMapping("products/{id}")
    public String deleteProduct(@PathVariable(value = "id") Integer productId) {
        if(productRepo.findById(productId).isEmpty()){
            return "id is not present";
        }
        productRepo.deleteById(productId);
        return "successfully deleted";
    }


}
