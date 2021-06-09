package com.fieldwork.stockmis.service.impl;

import com.fieldwork.stockmis.dao.ComponentDao;
import com.fieldwork.stockmis.dao.OperationDao;
import com.fieldwork.stockmis.dao.PositionDao;
import com.fieldwork.stockmis.entity.Component;
import com.fieldwork.stockmis.entity.Operation;
import com.fieldwork.stockmis.entity.Position;
import com.fieldwork.stockmis.entity.SearchResult;
import com.fieldwork.stockmis.service.ComponentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author whl
 * @date 2021/6/6 22:00
 */
@Service
@Slf4j
public class ComponentServiceImpl implements ComponentService {

    @Autowired
    PositionDao positionDao;

    @Autowired
    ComponentDao componentDao;

    @Autowired
    OperationDao operationDao;

    @Override
    public Boolean putInStorage(Operation inputOperation, Component component) {
        try {
            //获取指定的入库位置的配件id。若相同则说明只需更新配件表的count就行了；若不同则入库失败;若没有就插入一行新的记录
            Integer componentIdInThePosition = positionDao.getComponentIdByPosition(inputOperation.getStockNo(), inputOperation.getPartNo(), inputOperation.getShelfNo(), inputOperation.getTierNo());
            if (componentIdInThePosition.equals(inputOperation.getComponentId())) {
                //更新配件的数量
                componentDao.updateCompenentCount(componentIdInThePosition, inputOperation.getCount());
                //给operation表插入一条操作记录
                operationDao.insertAnOperationRecord(inputOperation);
                return true;
            }

            return false;
        } catch (NullPointerException nullPointerException) {
            try {
                componentDao.insertAnCompoent(component);
                positionDao.insertAPositionRecord(inputOperation.getStockNo(), inputOperation.getPartNo(), inputOperation.getShelfNo(), inputOperation.getTierNo(), component.getComponentId());
                operationDao.insertAnOperationRecord(inputOperation);
                log.info("位置上没有对应的配件: {}", nullPointerException.getMessage());
                return true;
            } catch (Exception e) {
                log.error("此配件不应放置于此: {}", e.getMessage());
                return false;
            }
        } catch (Exception e) {
            log.error("入库失败: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean takeFromStorage(Operation outputOperation, Component component) {
        try {


            if (componentDao.getComponentCountById(component.getComponentId()) == 0) {
                log.error("出库失败，此配件不在数据库中");
                return false;
            }
            Component c = componentDao.getComponentById(component.getComponentId());
            int currCount = c.getCount();
            int afterCount;
            if ((afterCount = currCount - outputOperation.getCount()) < 0) {
                log.error("出库数量多于现存数量");
                return false;
            } else if (afterCount == 0) {
                //删除配件表中的记录
                componentDao.deleteComponentById(c.getComponentId());
                //删除位置表中的记录
                positionDao.deletePositionByComponentId(c.getComponentId());
                //向操作表中新增一条记录
                operationDao.insertAnOperationRecord(outputOperation);
                return true;
            } else {
                componentDao.updateCompenentCount(c.getComponentId(), -outputOperation.getCount());
                //向操作表中新增一条记录
                operationDao.insertAnOperationRecord(outputOperation);
                return true;
            }
        } catch (Exception e) {
            log.error("出库失败: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public String[][] checkComponentIdAndCount(String checkClass) {
        try {
            if ("--请选择要盘点的配件大类--".equals(checkClass)) {
                log.error("请选择一个大类进行盘点");
                return null;
            }

            List<Component> componentList = componentDao.getComponentsByClass(checkClass);
            int len = componentList.size();

            String[][] result = new String[len][2];
            int index = 0;
            for (Component component : componentList) {
                result[index][0] = String.valueOf(component.getComponentId());
                result[index][1] = String.valueOf(component.getCount());
                index++;
            }
            return result;
        } catch (Exception e) {
            log.error("盘点失败: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public String[][] searchComponentById(String idSearchText) {
        try {
            List<SearchResult> resultList = componentDao.searchComponentById(idSearchText);
            int len = resultList.size();

            String[][] result = new String[len][8];
            int index = 0;
            for (SearchResult searchResult : resultList) {
                result[index][0] = String.valueOf(searchResult.getComponentId());
                result[index][1] = searchResult.getComponentClass();
                result[index][2] = searchResult.getComponentSpecies();
                result[index][3] = searchResult.getComponentType();
                result[index][4] = String.valueOf(searchResult.getStockNo());
                result[index][5] = String.valueOf(searchResult.getPartNo());
                result[index][6] = String.valueOf(searchResult.getShelfNo());
                result[index][7] = String.valueOf(searchResult.getTierNo());
                index++;
            }
            return result;
        } catch (Exception e) {
            log.error("查询配件号失败: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Object[][] searchComponentByPosition(Position positionInfo) {
        try {
            List<SearchResult> resultList = positionDao.searchComponentByPosition(positionInfo.getStockNo(), positionInfo.getPartNo(), positionInfo.getShelfNo(), positionInfo.getTierNo());
            int len = resultList.size();

            String[][] result = new String[len][8];
            int index = 0;
            for (SearchResult searchResult : resultList) {
                result[index][0] = String.valueOf(searchResult.getComponentId());
                result[index][1] = searchResult.getComponentClass();
                result[index][2] = searchResult.getComponentSpecies();
                result[index][3] = searchResult.getComponentType();
                result[index][4] = String.valueOf(searchResult.getStockNo());
                result[index][5] = String.valueOf(searchResult.getPartNo());
                result[index][6] = String.valueOf(searchResult.getShelfNo());
                result[index][7] = String.valueOf(searchResult.getTierNo());
                index++;
            }
            return result;
        } catch (Exception e) {
            log.error("查询位置失败: {}", e.getMessage());
            return null;
        }
    }
}
