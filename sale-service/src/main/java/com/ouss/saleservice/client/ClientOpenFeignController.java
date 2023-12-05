package com.ouss.saleservice.client;

import com.ouss.saleservice.moduel.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("CLIENT-SERVICE")
public interface ClientOpenFeignController {
    @GetMapping("/clients")
    List<Client> getAll();
    @GetMapping("/clients/{id}")
    Client clientbyid(@PathVariable Integer id);


}
