package com.costacarol.cloudnative.temafinal2.appmicroservice.eureka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EurekaInstanceResponse {

    private String ipAddr;
    private EurekaPort port;
}
