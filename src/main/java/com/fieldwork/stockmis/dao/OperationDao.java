package com.fieldwork.stockmis.dao;

import com.fieldwork.stockmis.entity.Operation;
import com.fieldwork.stockmis.entity.OperationSearchResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author whl
 * @date 2021/6/7 13:10
 */
@Mapper
public interface OperationDao {
    /**
     * 插入一条操作记录，并指定为入库操作还是出库操作
     * @param operation
     * @return
     * 成功，返回true；失败，返回false
     */
    Boolean insertAnOperationRecord(Operation operation);

    /**
     * 查询指定时间内的入/出库操作记录
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    List<OperationSearchResult> searchOperationByDateTime(@Param("startDateTime") Date startDateTime, @Param("endDateTime") Date endDateTime);
}
