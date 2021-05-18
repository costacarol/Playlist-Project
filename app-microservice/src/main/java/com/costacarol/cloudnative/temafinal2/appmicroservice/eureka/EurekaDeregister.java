package com.costacarol.cloudnative.temafinal2.appmicroservice.eureka;

import feign.Feign;
import org.springframework.beans.factory.DisposableBean;

public class EurekaDeregister implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        EurekaConfig deRegister = Feign.builder()
                .target(EurekaConfig.class, "http://localhost:8080");
        deRegister.deRegister();
    }
}
