package com.fieldwork.stockmis.service;

import com.fieldwork.stockmis.entity.Component;
import com.fieldwork.stockmis.entity.Operation;

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
}
