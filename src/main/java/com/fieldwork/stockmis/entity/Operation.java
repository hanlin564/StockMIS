package com.fieldwork.stockmis.entity;

import lombok.Data;

import java.util.Date;

/**
 * 此类封装入/出库操作的详细信息
 * @author whl
 * @date 2021/6/6 22:03
 */
@Data
public class Operation {
    Integer operationId;
    Integer type;
    String userId;
    Date time;
    Integer componentId;
    Integer count;
    Integer stockNo;
    Integer partNo;
    Integer shelfNo;
    Integer tierNo;
}
