package com.costacarol.cloudnative.temafinal2.appmicroservice.ribbon;

import com.costacarol.cloudnative.temafinal2.appmicroservice.eureka.EurekaConfig;
import com.costacarol.cloudnative.temafinal2.appmicroservice.eureka.EurekaInstanceResponse;
import com.costacarol.cloudnative.temafinal2.appmicroservice.eureka.EurekaResponse;
import com.costacarol.cloudnative.temafinal2.appmicroservice.model.Song;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.ribbon.ClientOptions;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.http.HttpRequestTemplate;
import com.netflix.ribbon.http.HttpResourceGroup;
import feign.Feign;
import feign.okhttp.OkHttpClient;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class RibbonClass {

    private final String EUREKA_PORT = "8080";
    private final String SONG_MICROSERVICE_NAME = "song-microservice";

    public String getInstances(String microserviceName) {

        EurekaConfig eurekaConfig = Feign.builder()
                .client(new OkHttpClient())
                .target(EurekaConfig.class, "http://localhost:" + EUREKA_PORT);
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> instanceAddress = new ArrayList<>();
        try {
            EurekaResponse eurekaResponse = objectMapper
                    .readValue(eurekaConfig.getInstance(microserviceName), EurekaResponse.class);
            List<EurekaInstanceResponse> instances = eurekaResponse.getApplication().getInstance();
            for (EurekaInstanceResponse instance : instances) {
                instanceAddress.add(instance.getIpAddr() + ":" + instance.getPort().getPort());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.info("Exception JsonProcessingException occurred.");
        }

        return StringUtils.join(instanceAddress, ",");
    }

    public Song callService(Integer idSong) {
        HttpResourceGroup httpResourceGroup = Ribbon.createHttpResourceGroup("appServiceClient",
                ClientOptions.create()
                        .withMaxAutoRetriesNextServer(3)
                        .withConfigurationBasedServerList(getInstances(SONG_MICROSERVICE_NAME)));
        HttpRequestTemplate<ByteBuf> apiTemplate = httpResourceGroup.newTemplateBuilder("apiTemplate", ByteBuf.class)
                .withMethod("GET")
                .withUriTemplate("/song/detail/{idSong}")
                .build();

        ByteBuf result = apiTemplate.requestBuilder()
                .withRequestProperty("idSong", idSong)
                .build().execute();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(result.toString(Charset.defaultCharset()), Song.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.info("Exception JsonProcessingException occurred.");
        }
        return null;
    }
}

