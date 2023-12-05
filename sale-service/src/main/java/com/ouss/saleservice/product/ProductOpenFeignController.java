package com.ouss.saleservice.product;

import com.ouss.saleservice.moduel.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("PRODUCT-SERVICE")
public interface ProductOpenFeignController {

    @GetMapping("/products")
    List<Product> getAll();

    @GetMapping("/products/{id}")
    Product productbyid(@PathVariable Integer id);


}
