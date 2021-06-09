package com.fieldwork.stockmis.entity;

import lombok.Data;

/**
 * @author whl
 * @date 2021/6/8 16:58
 */
@Data
public class Position {
    Integer stockNo;
    Integer partNo;
    Integer shelfNo;
    Integer tierNo;
    Integer componentId;
}
