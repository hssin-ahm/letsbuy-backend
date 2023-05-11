package com.ecommerce.site.monitoring;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Endpoint(id = "custom")
@Component
public class CustomActuatorEndPoint {

    @ReadOperation
    public Map<String, String> customEndPoint(){
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("name", "username" );
        return map;
    }
}
