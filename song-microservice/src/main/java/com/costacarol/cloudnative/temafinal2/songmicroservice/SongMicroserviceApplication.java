package com.costacarol.cloudnative.temafinal2.songmicroservice;

import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.sources.URLConfigurationSource;
import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.URL;

@SpringBootApplication
public class SongMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongMicroserviceApplication.class, args);
	}

}



