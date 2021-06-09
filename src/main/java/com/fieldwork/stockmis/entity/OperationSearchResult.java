package com.fieldwork.stockmis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author whl
 * @date 2021/6/9 12:17
 */
@Data
public class OperationSearchResult {
    Integer operationId;
    Integer type;
    Integer componentId;
    String userId;
    Date time;
    Integer count;
    Integer stockNo;
    Integer partNo;
    Integer shelfNo;
    Integer tierNo;
}
