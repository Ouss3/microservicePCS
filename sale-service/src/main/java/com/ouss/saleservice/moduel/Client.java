package com.ouss.saleservice.moduel;

import lombok.*;

@Data@AllArgsConstructor@NoArgsConstructor@ToString@Builder
public class Client {
    private Integer idClient;
    private String nom;
    private String prenom;
    private String email;
}
