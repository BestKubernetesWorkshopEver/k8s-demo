package com.demo.backend;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Slf4j
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class BackendConfiguration {
    @JsonProperty("spring.data.mongodb.host")
    private String host;
    @JsonProperty("spring.data.mongodb.port")
    private int port;

    @Override
    public String toString() {
        return "BackendConfiguration{" +
                "spring.data.mongodb.host='" + host + '\'' +
                ", spring.data.mongodb.port=" + port +
                '}';
    }
}
