package com.fieldwork.stockmis.dao;

import com.fieldwork.stockmis.entity.Component;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 通过id查询对应的配件信息
     * @param componentId
     * @return
     * 返回配件信息；若没查到则返回null
     */
    Component getComponentById(@Param("componentId") Integer componentId);

    /**
     * 根据id删除对应的配件信息
     * @param componentId
     * @return
     * 成功，返回true；失败，返回false
     */
    Boolean deleteComponentById(@Param("componentId") Integer componentId);

    /**
     * 通过配件号查询配件记录的条数
     * @param componentId
     * @return
     * 返回0，说明这配件不在仓库中<br>
     * 返回1，说明这配件在仓库中
     */
    Integer getComponentCountById(@Param("componentId") Integer componentId);

    List<Component> getComponentsByClass(@Param("componentClass") String componentClass);
}
