package com.ouss.saleservice;

import com.ouss.saleservice.config.GlobalConfig;
import com.ouss.saleservice.config.SaleConfig;
import com.ouss.saleservice.entites.Sale;
import com.ouss.saleservice.repository.SaleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({GlobalConfig.class, SaleConfig.class})
public class SaleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(SaleRepository saleRepository){
        return args -> {
            for (int i=1;i<11;i++){
                Sale c = Sale.builder().idClient(i).idProduct(i).date(new Date(
                        System.currentTimeMillis()
                )).build();
                saleRepository.save(c);
            }
        };
    }
}
