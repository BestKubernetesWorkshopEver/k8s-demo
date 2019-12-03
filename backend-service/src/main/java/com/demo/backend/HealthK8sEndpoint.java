package com.demo.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "help")
public class HealthK8sEndpoint {

    @Autowired
    private BackendConfiguration backendConfiguration;

    @ReadOperation
    public BackendConfiguration health() {
        return backendConfiguration;
    }
}
