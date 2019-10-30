package com.demo.front;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class FrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class, args);
    }

    @Slf4j
    @RestController
    @RequestMapping("api")
    static public class FrontEndController {
        private List rockets = new ArrayList();

        @GetMapping
        @ResponseBody
        public List<Rocket> get() throws UnknownHostException {
            log.info("Getting all rockets");
            Rocket rocket = Rocket.builder()
                    .id(UUID.randomUUID().toString())
                    .host(InetAddress.getLocalHost().getHostName())
                    .timestamp(LocalDateTime.now())
                    .build();
            rockets.add(rocket);
            return rockets;
        }

        @PostMapping
        @ResponseBody
        public Rocket put() throws UnknownHostException {
            log.info("Building new rocket");
            Rocket rocket = Rocket.builder()
                    .id(UUID.randomUUID().toString())
                    .host(InetAddress.getLocalHost().getHostName())
                    .timestamp(LocalDateTime.now())
                    .build();
            return rocket;
        }
    }

    @Data
    @Builder
    public static class Rocket {
        private String id;
        private String host;
        private LocalDateTime timestamp;
    }
}
