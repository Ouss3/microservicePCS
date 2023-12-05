package com.ouss.clientservice.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "client.params")
@Data
public class ClientConfig {
    private int x, y;

}
