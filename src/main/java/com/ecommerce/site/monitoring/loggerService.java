package com.ecommerce.site.monitoring;

//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.stereotype.Component;
//
//@Component
//public class loggerService implements HealthIndicator {
//    private final String LOGGER_SERVICE = "dataBaseService";
//    @Override
//    public Health health() {
//        if (isLoggerServiceGood())
//            return Health.up().withDetail(LOGGER_SERVICE, "Service is running").build();
//        return Health.down().withDetail(LOGGER_SERVICE, "Service not available").build();
//    }
//
//    private boolean isLoggerServiceGood(){
//        //logic
//        return false;
//    }
//}
