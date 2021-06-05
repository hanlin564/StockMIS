package com.fieldwork.stockmis.service;

/**
 * @author whl
 * @date 2021/6/5 14:55
 */
public interface UserService {

    /**
     * 用户点击"登录"按钮时调用该接口
     * @param userId
     * 用户名
     * @param password
     * 密码
     * @return
     * 登录成功，返回true；用户名或密码错误，返回false
     */
    boolean login(String userId, String password);
}
