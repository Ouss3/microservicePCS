package com.ouss.clientservice;

import com.ouss.clientservice.config.ClientConfig;
import com.ouss.clientservice.config.GlobalConfig;
import com.ouss.clientservice.entites.Client;
import com.ouss.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class, ClientConfig.class})
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientRepository clientRepository ){
        return args -> {
            for(int i=0;i<10;i++){
                Client c = Client.builder().nom("name"+i).prenom("prenom"+i).email("email"+i).build();
                clientRepository.save(c);
            }

        };


    }
}
