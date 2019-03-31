package org.yejh.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        String serviceId = System.getProperty("spring.application.name", "eureka-client-1");
        List<ServiceInstance> instances = client.getInstances(serviceId);
        for (ServiceInstance instance : instances) {
            logger.info("/hello, host: {}, service id: {}", instance.getHost(), instance.getServiceId());
        }
        return "Hello " + serviceId;
    }
}
