package com.fieldwork.stockmis;

import com.fieldwork.stockmis.dao.UserDao;
import com.fieldwork.stockmis.utils.SpringUtil;
import com.fieldwork.stockmis.view.LoginFram;
import com.fieldwork.stockmis.view.MainFram;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootTest
class StockMisApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
    }


}
