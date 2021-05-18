package com.costacarol.cloudnative.temafinal2.appmicroservice.eureka;

import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class EurekaRegister implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        EurekaConfig register = Feign.builder()
                .decoder(new GsonDecoder())
                .target(EurekaConfig.class, "http://localhost:8080");
        register.register();
        log.info("Register on Eureka process: done.");
    }
}

