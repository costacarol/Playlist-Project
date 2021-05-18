package com.costacarol.cloudnative.temafinal2.songmicroservice.eureka;

import feign.Body;
import feign.Headers;
import feign.RequestLine;


public interface EurekaConfig {


    String appname = "song-microservice";
    String hostnameInstanceOne = "song1";
    String hostnameInstanceTwo = "song2";
    String portOne = "8086";
    String portTwo = "8084";


    @RequestLine("POST /eureka/v2/apps/song-microservice")
    @Headers("Content-Type: application/json")
    @Body("%7B\"instance\": \n{\n\"hostName\": \""+hostnameInstanceOne+"\",\n\"app\": \""+appname+"\",\n\"vipAddress\": \""+hostnameInstanceOne+"\",\n\"secureVipAddress\": \""+hostnameInstanceOne+"\",\n\"ipAddr\": \"127.0.1.1\", \n\"status\": \"UP\", \n\"port\": {\"$\": \""+portOne+"\", \"@enabled\": \"true\"}, \n\"securePort\": {\"$\": \"8443\", \"@enabled\": \"false\"}, \n\"healthCheckUrl\": \"http://"+hostnameInstanceOne+":"+portOne+"/healthcheck\", \n\"statusPageUrl\": \"http://"+hostnameInstanceOne+":"+portOne+"/Status\", \n\"homePageUrl\": \"http://"+hostnameInstanceOne+":"+portOne+"\", \n\"dataCenterInfo\":{ \n\"@class\": \"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\", \n\"name\": \"MyOwn\" \n}\n}%7D")
    void registerFirstInstance();

    @RequestLine("POST /eureka/v2/apps/song-microservice")
    @Headers("Content-Type: application/json")
    @Body("%7B\"instance\": \n{\n\"hostName\": \""+hostnameInstanceTwo+"\",\n\"app\": \""+appname+"\",\n\"vipAddress\": \""+hostnameInstanceTwo+"\",\n\"secureVipAddress\": \""+hostnameInstanceTwo+"\",\n\"ipAddr\": \"127.0.1.1\", \n\"status\": \"UP\", \n\"port\": {\"$\": \""+portTwo+"\", \"@enabled\": \"true\"}, \n\"securePort\": {\"$\": \"8443\", \"@enabled\": \"false\"}, \n\"healthCheckUrl\": \"http://"+hostnameInstanceTwo+":"+portTwo+"/healthcheck\", \n\"statusPageUrl\": \"http://"+hostnameInstanceTwo+":"+portTwo+"/Status\", \n\"homePageUrl\": \"http://"+hostnameInstanceTwo+":"+portTwo+"\", \n\"dataCenterInfo\":{\n\"@class\": \"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\", \n\"name\": \"MyOwn\" \n}\n}%7D")
    void registerSecondInstance();


    @RequestLine("PUT /eureka/v2/apps/song-microservice/"+hostnameInstanceOne)
    void sendHeartBeatSongOne();

    @RequestLine("PUT /eureka/v2/apps/song-microservice/"+hostnameInstanceTwo)
    void sendHeartBeatSongTwo();

    @RequestLine("DELETE /eureka/v2/apps/song-microservice/"+hostnameInstanceOne)
    void deRegisterInstanceOne();

    @RequestLine("DELETE /eureka/v2/apps/song-microservice/"+hostnameInstanceTwo)
    void deRegisterInstanceTwo();



}
