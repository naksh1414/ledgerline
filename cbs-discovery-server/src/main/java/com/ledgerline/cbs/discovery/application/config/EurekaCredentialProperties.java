package com.ledgerline.cbs.discovery.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties (prefix = "ledgerline.cbs.eureka.credentials")
public record EurekaCredentialProperties(
    String username,
    String password) {

}
