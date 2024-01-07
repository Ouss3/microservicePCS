package com.ouss.clientservice.web;

import com.ouss.clientservice.config.ClientConfig;
import com.ouss.clientservice.config.GlobalConfig;
import com.ouss.clientservice.entites.Client;
import com.ouss.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    GlobalConfig globalConfig;
    @Autowired
    ClientConfig clientConfig;
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/config")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }

    @GetMapping("/config2")
    public ClientConfig clientConfig(){
        return clientConfig;
    }

    @GetMapping("/clients")
    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    @GetMapping("/clients/{id}")
    public Client clientbyid(@PathVariable Integer id){
        return clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Client not found"));
    }
    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable Integer id,@RequestBody Client client){
        Client c = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Client not found"));
        c.setNom(client.getNom());
        c.setPrenom(client.getPrenom());
        c.setEmail(client.getEmail());


        kafkaTemplate.send("client","client"+id +" updated");


        return clientRepository.save(c);
    }
    @PostMapping("/clients")
    public Client saveClient(@RequestBody Client client){
        Client c = new Client();
        c.setNom(client.getNom());
        c.setPrenom(client.getPrenom());
        c.setEmail(client.getEmail());
        return clientRepository.save(c);
    }
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Integer id){
        clientRepository.deleteById(id);
        kafkaTemplate.send("client","client "+id +" deleted");
    }
}
