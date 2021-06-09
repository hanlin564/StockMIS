package com.fieldwork.stockmis.dao;

import com.fieldwork.stockmis.entity.ComponentSearchResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author whl
 * @date 2021/6/7 12:21
 */
@Mapper
public interface PositionDao {
    /**
     * 根据给定的位置信息，返回存放在该位置的配件号
     * @param stockNo
     * @param partNo
     * @param shelfNo
     * @param tierNo
     * @return
     * 当该位置没有存放配件时，返回null<br>
     * 否则返回存放在该位置的配件号
     */
    Integer getComponentIdByPosition(@Param("stockNo") Integer stockNo, @Param("partNo") Integer partNo, @Param("shelfNo") Integer shelfNo, @Param("tierNo") Integer tierNo);

    /**
     * 向position表中插入一条位置信息的记录
     * @param stockNo
     * @param partNo
     * @param shelfNo
     * @param tierNo
     * @param componentId
     * @return
     * 成功，返回true；失败，返回false
     */
    Boolean insertAPositionRecord(@Param("stockNo") Integer stockNo, @Param("partNo") Integer partNo, @Param("shelfNo") Integer shelfNo, @Param("tierNo") Integer tierNo, @Param("componentId") Integer componentId);

    /**
     * 根据配件号删除一条位置信息
     * @param componentId
     * @return
     * 成功，返回true；失败，返回false
     */
    Boolean deletePositionByComponentId(@Param("componentId") Integer componentId);

    /**
     * 根据给定位置查询配件详细信息
     * @param stockNo
     * @param partNo
     * @param shelfNo
     * @param tierNo
     * @return
     */
    List<ComponentSearchResult> searchComponentByPosition(@Param("stockNo") Integer stockNo, @Param("partNo") Integer partNo, @Param("shelfNo") Integer shelfNo, @Param("tierNo") Integer tierNo);


}
