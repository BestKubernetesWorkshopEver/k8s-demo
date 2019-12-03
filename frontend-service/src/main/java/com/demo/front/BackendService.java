package com.demo.front;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "backendService", url = "${workshop.backend.url}:${workshop.backend.port}")
public interface BackendService {
    @GetMapping(value = "api")
    @ResponseBody
    public List<FrontApplication.Rocket> get();

    @PostMapping(value = "api")
    @ResponseBody
    public FrontApplication.Rocket post();
}
