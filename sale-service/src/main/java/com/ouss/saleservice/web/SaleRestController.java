package com.ouss.saleservice.web;


import com.ouss.saleservice.client.ClientOpenFeignController;
import com.ouss.saleservice.config.GlobalConfig;
import com.ouss.saleservice.config.SaleConfig;
import com.ouss.saleservice.entites.Sale;
import com.ouss.saleservice.moduel.Client;
import com.ouss.saleservice.moduel.Product;
import com.ouss.saleservice.product.ProductOpenFeignController;
import com.ouss.saleservice.repository.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleRestController {

    @Autowired
    SaleRepository saleRepository;
    @Autowired
    ProductOpenFeignController productOpenFeignController;
    @Autowired
    ClientOpenFeignController clientOpenFeignController;
    @Autowired
    GlobalConfig globalConfig;
    @Autowired
    SaleConfig saleConfig;

    @GetMapping("/config")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
    @GetMapping("/config2")
    public SaleConfig saleConfig(){
        return saleConfig;
    }

    @GetMapping("/sales")
    public List<Sale> getAll() {
        List<Product> products = productOpenFeignController.getAll();
        List<Client> clients = clientOpenFeignController.getAll();
        List<Sale> sales = saleRepository.findAll();
        for (Sale s : sales) {
            for (Product p : products) {
                if (s.getIdProduct() == p.getIdProduct()) {
                    s.setProduct(p);
                }
            }
            for (Client c : clients) {
                if (s.getIdClient() == c.getIdClient()) {
                    s.setClient(c);
                }
            }
        }
        return sales;
    }

    @GetMapping("/sales/{id}")
    public Sale getId(Integer id) {
        Sale s = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        Product p = productOpenFeignController.productbyid(s.getIdProduct());
        Client c = clientOpenFeignController.clientbyid(s.getIdClient());
        s.setProduct(p);
        s.setClient(c);
        return s;
    }

    @PutMapping("/sales/{id}")
    public void update(@PathVariable Integer id, @RequestBody Sale s) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        if (s.getIdClient() != null) sale.setIdClient(s.getIdClient());
        if (s.getIdProduct() != null) sale.setIdProduct(s.getIdProduct());
        if (s.getDate() != null) sale.setDate(s.getDate());

        saleRepository.save(sale);
    }
    @PostMapping("/sales")
    public void save(@RequestBody Sale s){
        Sale sale = new Sale();
        sale.setIdClient(s.getIdClient());
        sale.setIdProduct(s.getIdProduct());
        sale.setDate(s.getDate());
        saleRepository.save(sale);
    }
    @DeleteMapping("/sales/{id}")
    public void delete(@PathVariable Integer id){
        saleRepository.deleteById(id);
    }

}
