package com.project.bank.customer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Getter
@Setter
@Lazy
@Configuration
@ConfigurationProperties(prefix = "application.http-client")
public class ExternalApiProperties {
    private String productUrl;
}
