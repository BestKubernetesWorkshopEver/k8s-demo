package com.demo.front;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class FrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class, args);
    }

    public static final String API_PATH = "/api";

    @Slf4j
    @RestController
    @RequestMapping(API_PATH)
    static public class FrontEndController {
        private List rockets = new ArrayList();

        @Autowired
        private BackendService service;


        @GetMapping
        @ResponseBody
        public List<Rocket> get() {
            log.info("Getting all rockets");
            return service.get();
        }

        @PostMapping
        @ResponseBody
        public Rocket post() {
            log.info("Building new rocket");
            return service.post();
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
