package com.ecommerce.site.monitoring;

import com.ecommerce.site.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DataBaseService implements HealthIndicator {

    @Autowired
    private EmailSenderService emailSenderService;
    private final String DATABASE_SERVICE = "dataBaseService";
    @Override
    public Health health() {
        if (isDatabaseHealthGood())
            return Health.up().withDetail(DATABASE_SERVICE, "Service is running").build();

        return Health.down().withDetail(DATABASE_SERVICE, "Service not available").build();
    }

    private boolean isDatabaseHealthGood(){
        //logic
        return true;
    }
}
