package com.ouss.saleservice.entites;

import com.ouss.saleservice.moduel.Client;
import com.ouss.saleservice.moduel.Product;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity@Data@AllArgsConstructor@NoArgsConstructor@ToString@Builder
public class Sale {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSale;
    private Integer idProduct;
    private Date date;

    private Integer idClient;
    @Transient
    private Product product;
    @Transient
    private Client client;



}
