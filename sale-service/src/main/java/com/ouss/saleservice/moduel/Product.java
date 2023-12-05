package com.ouss.saleservice.moduel;

import lombok.*;

@Data@AllArgsConstructor@NoArgsConstructor@ToString@Builder
public class Product {
    private Integer idProduct;
    private String name;
    private String description;
    private Float price;
    private Integer quantity;


}
