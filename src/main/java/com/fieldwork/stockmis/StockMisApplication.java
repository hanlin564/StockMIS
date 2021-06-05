package com.fieldwork.stockmis;

import com.fieldwork.stockmis.view.LoginFram;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

/**
 * @author wanghanlin
 */
@MapperScan("com.fieldwork.stockmis.dao")
@SpringBootApplication
public class StockMisApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(StockMisApplication.class);
        ApplicationContext context = builder.headless(false).run(args);
        LoginFram loginFram = context.getBean(LoginFram.class);
        loginFram.setVisible(true);
    }

}
