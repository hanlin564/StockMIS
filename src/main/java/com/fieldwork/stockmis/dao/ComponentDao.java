package com.fieldwork.stockmis.dao;

import com.fieldwork.stockmis.entity.Component;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author whl
 * @date 2021/6/7 12:52
 */
@Mapper
public interface ComponentDao {
    /**
     * 更新指定配件的数量
     * @param componentId
     * 配件号
     * @param addOrMinusCount
     * 当要对数量进行增加时，为正数；要减少时为负数
     * @return
     * 成功，返回true；失败，返回false
     */
    Boolean updateCompenentCount(@Param("componentId") Integer componentId, @Param("addOrMinusCount") Integer addOrMinusCount);

    /**
     * 插入一条配件记录
     * @param component
     * @return
     * 成功，返回true；失败，返回false
     */
    Boolean insertAnCompoent(Component component);
}
