package com.costacarol.cloudnative.temafinal2.songmicroservice.eureka;

import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EurekaSendHeartBeat implements Runnable {

    public EurekaSendHeartBeat() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        EurekaConfig send = Feign.builder()
                .decoder(new GsonDecoder())
                .target(EurekaConfig.class, "http://localhost:8080");

        while (true) {
            try {
//                send.sendHeartBeatSongOne();
//                send.sendHeartBeatSongTwo();
                Thread.sleep(30000);
                log.info("Send HeartBeat: service is UP!");
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Something was wrong. The request is not responding or is not available.");
            }
        }
    }
}
