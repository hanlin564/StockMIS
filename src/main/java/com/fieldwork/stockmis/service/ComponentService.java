package com.fieldwork.stockmis.service;

import com.fieldwork.stockmis.entity.Component;
import com.fieldwork.stockmis.entity.Operation;
import com.fieldwork.stockmis.entity.Position;

import java.util.Date;

/**
 * @author whl
 * @date 2021/6/6 21:54
 */
public interface ComponentService {

    /**
     * 对配件进行入库操作
     * @param inputOperation
     * inputOperation为入库操作的详细信息
     * @param component
     * component为配件的详细信息
     * @return
     * 入库成功，返回true<br>
     * 入库失败，返回false
     */
    Boolean putInStorage(Operation inputOperation, Component component);

    /**
     * 对指定配件进行出库操作
     * @param outputOperation
     * outputOperation为出库操作的详细信息
     * @param component
     * component为配件的详细信息
     * @return
     * 出库成功，返回true<br>
     * 出库失败，返回false
     */
    Boolean takeFromStorage(Operation outputOperation, Component component);

    /**
     * 对指定大类进行盘点
     * @param checkClass
     * @return
     * 返回一个有两列的矩阵，第一列为配件号，第二列为配件数量
     */
    String[][] checkComponentIdAndCount(String checkClass);

    /**
     * 根据配件号搜索配件
     * @param idSearchText
     * @return
     * 返回一个8列矩阵
     */
    Object[][] searchComponentById(String idSearchText);

    /**
     * 根据位置搜索配件
     * @param position
     * @return
     * 返回一个8列矩阵
     */
    Object[][] searchComponentByPosition(Position position);

    /**
     * 根据给定的开始与截止时间，查询这个区间内的所有入/出库记录
     * @param startDateTime
     * @param endDateTime
     * @return
     * 返回一个10列的矩阵
     */
    String[][] searchOperationByTime(Date startDateTime, Date endDateTime);

    /**
     * 在出库时检查用户输入的位置信息是否存放着用户想要出库的对应配件
     * @param outputOperation
     * @param component
     * 封装的配件信息中的count属性不是此配件的现存数量，而是用户想出库的配件数量
     * @return
     * 若有，返回true；若无，返回false
     */
    Boolean checkComponentAndPosition(Operation outputOperation, Component component);
}
