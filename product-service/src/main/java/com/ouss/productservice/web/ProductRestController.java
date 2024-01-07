package com.ouss.productservice.web;

import com.ouss.productservice.config.GlobalConfig;
import com.ouss.productservice.config.ProductConfig;
import com.ouss.productservice.entites.Product;
import com.ouss.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
     private GlobalConfig globalConfig;
    @Autowired
    private ProductConfig productConfig;

    @GetMapping("/config")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
    @GetMapping("/config2")
    public ProductConfig productConfig(){
        return productConfig;
    }

    @GetMapping("/products")
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product productbyid(@PathVariable Integer id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product){
        Product p = new Product();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setQuantity(product.getQuantity());
        p.setDescription(product.getDescription());
        return productRepository.save(p);

    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Integer id,@RequestBody Product product){
        Product p = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setQuantity(product.getQuantity());
        p.setDescription(product.getDescription());
        return productRepository.save(p);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productRepository.deleteById(id);
    }


}
