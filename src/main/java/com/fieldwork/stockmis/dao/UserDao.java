package com.fieldwork.stockmis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author whl
 * @date 2021/6/4 18:58
 */
@Mapper
public interface UserDao {

    /**
     * 查询user表中密码和用户名都匹配的记录条数
     * @param userId
     * 用户名
     * @param password
     * 用户密码
     * @return
     * 返回user表中密码和用户名都匹配的记录条数，用户名密码正确时应返回1；返回0
     */
    Integer getUserCountByIdAndPassword(@Param("userId") String userId, @Param("password") String password);
}
