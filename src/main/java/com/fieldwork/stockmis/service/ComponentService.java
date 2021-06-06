package com.fieldwork.stockmis.service;

import com.fieldwork.stockmis.entity.Operation;

/**
 * @author whl
 * @date 2021/6/6 21:54
 */
public interface ComponentService {

    /**
     * 根据inputOperation的描述，对配件进行入库操作
     * @param inputOperation
     * inputOperation为入库操作的详细信息
     * @return
     * 入库成功，返回true<br>
     * 入库失败，返回false
     */
    Boolean putInStorage(Operation inputOperation);
}
