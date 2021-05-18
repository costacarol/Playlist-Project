package com.costacarol.cloudnative.temafinal2.appmicroservice.eureka;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


public interface EurekaConfig {

    String nameMicroservice = "app-microservice";
    String hostName = "app";
    String port = "8083";

    @RequestLine("POST /eureka/v2/apps/app-microservice")
    @Headers("Content-Type: application/json")
    @Body("%7B\"instance\": \n{\n\"hostName\": \""+hostName+"\",\n\"app\": \""+nameMicroservice+"\",\n\"vipAddress\": \""+nameMicroservice+"\",\n\"secureVipAddress\": \""+nameMicroservice+"\",\n\"ipAddr\": \"127.0.1.1\", \n\"status\": \"UP\", \n\"port\": {\"$\": \""+port+"\", \"@enabled\": \"true\"}, \n\"securePort\": {\"$\": \"8443\", \"@enabled\": \"true\"}, \n\"healthCheckUrl\": \"http://localhost:"+port+"/healthcheck\", \n\"statusPageUrl\": \"http://localhost:"+port+"/healthcheck\", \n\"homePageUrl\": \"http://localhost:"+port+"\", \n\"dataCenterInfo\": { \n\"@class\": \"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\", \n\"name\": \"MyOwn\" \n}\n}%7D"
    )
    void register();

    @RequestLine("PUT /eureka/v2/apps/"+nameMicroservice+"/"+hostName)
    void sendHeartBeat();

    @RequestLine("DELETE /eureka/v2/apps/"+nameMicroservice+"/"+hostName)
    void deRegister();

    @RequestLine("GET /eureka/v2/apps/{microserviceName}")
    @Headers("Accept: application/json")
    String getInstance(@Param("microserviceName") String microserviceName);
}

