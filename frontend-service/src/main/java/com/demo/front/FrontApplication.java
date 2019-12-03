package com.demo.front;

import feign.Logger;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(FrontendConfiguration.class)
public class FrontApplication {

    @Autowired
    private FrontendConfiguration frontendConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class, args);
    }

    public static final String API_PATH = "/api";

    @PostConstruct
    public void init()
    {
        log.info("========================== Frontend configuration ==========================");
        log.info("{}", frontendConfiguration);
        log.info("============================================================================");
    }

    @Slf4j
    @RestController
    @RequestMapping(API_PATH)
    static public class FrontEndController {

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

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
