package com.example.eureka.server;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/discovery")
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/apps")
    public String discovery() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("STORES");
        if (serviceInstances != null && serviceInstances.size() > 0) {
            return serviceInstances.get(0).getUri().toString();
        }
        return null;
    }
}
