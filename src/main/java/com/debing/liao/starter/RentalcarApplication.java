package com.debing.liao.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class, scanBasePackages="com.debing.liao")
public class RentalcarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalcarApplication.class, args);
        System.out.println("rental car system start success");
    }

}
