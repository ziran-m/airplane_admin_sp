package com.airplane.airplane_admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.airplane.airplane_admin.mapper")
public class AirplaneAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirplaneAdminApplication.class, args);
    }

}
