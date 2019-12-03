package com.demo.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "help")
public class HealthK8sEndpoint {

    @Autowired
    private FrontendConfiguration workshopConfiguration;

    @ReadOperation
    public FrontendConfiguration health() {
        return workshopConfiguration;
    }
}
