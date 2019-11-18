package com.demo.backend;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Slf4j
    @RestController
    @RequestMapping("api")
    public static class RocketController {

        @Autowired
        private MongoTemplate mongoTemplate;

        @GetMapping
        @ResponseBody
        public List<Rocket> get() {
            log.info("Getting all rockets");
            return mongoTemplate.findAll(Rocket.class);
        }

        @PostMapping
        @ResponseBody
        public Rocket post() throws UnknownHostException {
            Rocket rocket = Rocket.builder()
                    .id(UUID.randomUUID().toString())
                    .host(InetAddress.getLocalHost().getHostName())
                    .timestamp(LocalDateTime.now())
                    .build();
            log.info("Building new rocket {}", rocket);
            return mongoTemplate.save(rocket);
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
