package com.fieldwork.stockmis.service.impl;

import com.fieldwork.stockmis.dao.UserDao;
import com.fieldwork.stockmis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author whl
 * @date 2021/6/5 14:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    /**
     * 用户点击"登录"按钮时调用该接口
     *
     * @param userId   用户名
     * @param password 密码
     * @return 登录成功，返回true；用户名或密码错误，返回false
     */
    @Override
    public boolean login(String userId, String password) {
        return userDao.getUserCountByIdAndPassword(userId, password) == 1;
    }
}
