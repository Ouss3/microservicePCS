package com.ouss.clientservice.entites;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Date;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString@Builder
public class Client {
    @Id@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer idClient;
    private String nom;

    private String prenom;
    private String email;
}
