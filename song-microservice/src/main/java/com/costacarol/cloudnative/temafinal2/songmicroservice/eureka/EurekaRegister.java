package com.costacarol.cloudnative.temafinal2.songmicroservice.eureka;

import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class EurekaRegister implements CommandLineRunner {

    @Value("${server.port}")
    private String port;

    @Override
    public void run(String... args) throws Exception {
        EurekaConfig register = Feign.builder()
                .decoder(new GsonDecoder())
                .target(EurekaConfig.class, "http://localhost:8080");
        register.registerFirstInstance();
        log.info("Register instance on Eureka process: done.");
        register.registerSecondInstance();
        log.info("Register second instance on Eureka process: done.");
    }
}
