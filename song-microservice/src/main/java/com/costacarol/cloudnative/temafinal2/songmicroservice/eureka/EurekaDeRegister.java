package com.costacarol.cloudnative.temafinal2.songmicroservice.eureka;

import feign.Feign;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class EurekaDeRegister implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        EurekaConfig deRegister = Feign.builder()
                .target(EurekaConfig.class, "http://localhost:8080");
        deRegister.deRegisterInstanceOne();
        deRegister.deRegisterInstanceTwo();
    }
}
