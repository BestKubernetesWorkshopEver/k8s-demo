package com.demo.front;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "workshop")
public class FrontendConfiguration {

    @JsonProperty("workshop.username")
    private String username;
    @JsonProperty("workshop.password")
    private String password;
    private Backend backend;

    @Data
    public static class Backend {
        @JsonProperty("workshop.backend.host")
        private String host;
        @JsonProperty("workshop.backend.port")
        private int port;

        @Override
        public String toString() {
            return
                    " workshop.backend.host='" + host + '\'' +
                            ", workshop.backend.port=" + port;
        }
    }

    @Override
    public String toString() {
        return "FrontendConfiguration{" +
                "workshop.username='" + username + '\'' +
                ", workshop.password='" + password + '\''
                + backend +
                '}';
    }
}
