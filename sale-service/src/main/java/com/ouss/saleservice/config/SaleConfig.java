package com.ouss.saleservice.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "sale.params")
@Data
public class SaleConfig {
    private int a, b;
}
