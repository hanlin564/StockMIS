package com.fieldwork.stockmis;

import com.fieldwork.stockmis.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class StockMisApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testDB() {
        System.out.println(userDao.getUserCountByIdAndPassword("whl", "123"));
    }

}
