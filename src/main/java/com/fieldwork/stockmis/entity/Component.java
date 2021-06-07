package com.fieldwork.stockmis.entity;

import lombok.Data;

/**
 * @author whl
 * @date 2021/6/7 13:48
 */
@Data
public class Component {
    Integer componentId;
    String componentClass;
    String componentSpecies;
    String componentType;
    Integer count;

}
