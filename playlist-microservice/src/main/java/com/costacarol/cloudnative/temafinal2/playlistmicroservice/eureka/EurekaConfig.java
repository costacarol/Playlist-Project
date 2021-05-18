package com.costacarol.cloudnative.temafinal2.playlistmicroservice.eureka;

import feign.Body;
import feign.Headers;
import feign.RequestLine;

public interface EurekaConfig {


    String nameMicroservice = "playlist-microservice";
    String hostName = "playlist";
    String port = "8082";


    @RequestLine("POST /eureka/v2/apps/"+nameMicroservice)
    @Body("%7B\"instance\": \n{\n\"hostName\": \"" + hostName + "\",\n\"app\": \"" + nameMicroservice + "\",\n\"vipAddress\": \"" + nameMicroservice + "\",\n\"secureVipAddress\": \"" + nameMicroservice + "\",\n\"ipAddr\": \"127.0.1.1\", \n\"status\": \"UP\", \n\"port\": {\"$\": \""+port+"\", \"@enabled\": \"true\"}, \n\"securePort\": {\"$\": \"8443\", \"@enabled\": \"false\"}, \n\"healthCheckUrl\": \"http://"+hostName+":"+port+"/healthcheck\", \n\"statusPageUrl\": \"http://"+hostName+":"+port+"/healthcheck\", \n\"homePageUrl\": \"http://"+hostName+":"+port+"\", \n\"dataCenterInfo\": { \n\"@class\": \"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\", \n\"name\": \"MyOwn\" \n}\n}%7D")
    @Headers("Content-Type: application/json")
    void register();

    @RequestLine("PUT /eureka/v2/apps/"+ nameMicroservice +"/"+hostName)
    void sendHeartBeat();

    @RequestLine("DELETE /eureka/v2/apps/"+ nameMicroservice +"/"+hostName)
    void deRegister();

}

