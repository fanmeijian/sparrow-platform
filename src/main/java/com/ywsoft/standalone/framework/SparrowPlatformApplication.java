package com.ywsoft.standalone.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class SparrowPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparrowPlatformApplication.class, args);
    }
}
