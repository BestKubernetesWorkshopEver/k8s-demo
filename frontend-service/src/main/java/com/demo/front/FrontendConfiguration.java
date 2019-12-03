package com.demo.front;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "workshop")
public class FrontendConfiguration {

    private String username;
    private String password;
    private Backend backend;

    @Data
    public static class Backend {
        private String url;
        private int port;

        @Override
        public String toString() {
            return
                    " workshop.backend.url='" + url + '\'' +
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
