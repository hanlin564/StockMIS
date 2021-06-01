package com.fieldwork.stockmis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.fieldwork.stockmis.dao")
@SpringBootApplication
public class StockMisApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockMisApplication.class, args);
    }

}
