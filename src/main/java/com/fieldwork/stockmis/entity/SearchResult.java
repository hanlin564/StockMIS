package com.fieldwork.stockmis.entity;

import lombok.Data;

/**
 * @author whl
 * @date 2021/6/8 15:55
 */
@Data
public class SearchResult {
    Integer componentId;
    String componentClass;
    String componentSpecies;
    String componentType;
    Integer stockNo;
    Integer partNo;
    Integer shelfNo;
    Integer tierNo;
}
