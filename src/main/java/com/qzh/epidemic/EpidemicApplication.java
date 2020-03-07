package com.qzh.epidemic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.qzh.epidemic.mapper"})
public class EpidemicApplication {
    public static void main(String[] args) {
        SpringApplication.run(EpidemicApplication.class, args);
    }

}
