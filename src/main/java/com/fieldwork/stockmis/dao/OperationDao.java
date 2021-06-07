package com.fieldwork.stockmis.dao;

import com.fieldwork.stockmis.entity.Operation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author whl
 * @date 2021/6/7 13:10
 */
@Mapper
public interface OperationDao {
    /**
     * 插入一条操作记录
     * @param operation
     * @return
     * 成功，返回true；失败，返回false
     */
    Boolean insertAnOperationRecord(Operation operation);
}
