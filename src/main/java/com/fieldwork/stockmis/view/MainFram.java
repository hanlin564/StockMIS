package com.fieldwork.stockmis.view;

import com.fieldwork.stockmis.entity.Operation;
import com.fieldwork.stockmis.service.ComponentService;
import com.fieldwork.stockmis.utils.DateChooser;
import com.fieldwork.stockmis.utils.StockConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

/**
 * @author whl
 * @date 2021/6/5 14:48
 */
@Component
@Slf4j
public class MainFram extends JFrame {

    @Autowired
    ComponentService componentService;

    //配件的大类
    String[] componentClasses = new String[] {"--请选择要盘点的配件大类--", "显卡", "处理器", "内存", "显示器", "硬盘", "键盘", "鼠标", "机箱", "主板", "风扇"};

    String userId;

    private JTextField componentIdField;
    private JTextField stockNoField;
    private JTextField partNoField;
    private JTextField shelfNoField;
    private JTextField tierNoField;
    private JTextField countField;


    public MainFram() {
        setTitle("管理菜单");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 700);
        setLocationRelativeTo(null);



        JPanel panel = new JPanel(null);

        //盘点下拉框
        JComboBox checkComboBox = new JComboBox(componentClasses);
        checkComboBox.setLocation(10, 20);
        checkComboBox.setSize(260, 60);
        panel.add(checkComboBox);

        JButton checkButton = new JButton("盘点");
        checkButton.setLocation(280, 33);
        checkButton.setSize(80, 30);
        panel.add(checkButton);

        JLabel componentIdLable = new JLabel("配件号:");
        componentIdLable.setBounds(370, 33, 50, 30);
        panel.add(componentIdLable);

        componentIdField = new JTextField();
        componentIdField.setBounds(420, 33, 130, 30);
        panel.add(componentIdField);

        JLabel stockNoLable = new JLabel("仓库号:");
        stockNoLable.setBounds(370, 60, 50, 30);
        panel.add(stockNoLable);

        stockNoField = new JTextField();
        stockNoField.setBounds(420, 60, 130, 30);
        panel.add(stockNoField);

        JLabel partNoLable = new JLabel("分区号:");
        partNoLable.setBounds(370, 87, 50, 30);
        panel.add(partNoLable);

        partNoField = new JTextField();
        partNoField.setBounds(420, 87, 130, 30);
        panel.add(partNoField);

        JLabel shelfNoLable = new JLabel("货架号:");
        shelfNoLable.setBounds(370, 114, 50, 30);
        panel.add(shelfNoLable);

        shelfNoField = new JTextField();
        shelfNoField.setBounds(420, 114, 130, 30);
        panel.add(shelfNoField);

        JLabel tierNoLable = new JLabel("层数:");
        tierNoLable.setBounds(370, 141, 50, 30);
        panel.add(tierNoLable);

        tierNoField = new JTextField();
        tierNoField.setBounds(420, 141, 130, 30);
        panel.add(tierNoField);

        JLabel countLable = new JLabel("数量:");
        countLable.setBounds(370, 168, 50, 30);
        panel.add(countLable);

        countField = new JTextField();
        countField.setBounds(420, 168, 130, 30);
        panel.add(countField);

        //入库按钮
        JButton inputButton = new JButton("入库");
        inputButton.setBounds(580, 33, 80, 80);
        inputButton.addActionListener((event) -> {
            Operation inputOperation = generateAnOperationObject(0);
            if (componentService.putInStorage(inputOperation)) {
                log.info("入库成功");
                //todo:成功和失败都弹出相应的窗口进行提示
            } else {
                log.error("入库失败");

            }

        });
        panel.add(inputButton);

        //出库按钮
        JButton outputButton = new JButton("出库");
        outputButton.setBounds(580, 120, 80, 80);
        panel.add(outputButton);

        JLabel IDsearchLable = new JLabel("配件号:");
        IDsearchLable.setBounds(670, 33, 50, 30);
        panel.add(IDsearchLable);

        JTextField IDsearchField = new JTextField();
        IDsearchField.setBounds(720, 33, 130, 30);
        panel.add(IDsearchField);

        JButton IDSearchButton = new JButton("查询配件号");
        IDSearchButton.setBounds(715, 70, 120, 30);
        panel.add(IDSearchButton);

        JLabel stockSearchLable = new JLabel("仓库号:");
        stockSearchLable.setBounds(860, 33, 50, 30);
        panel.add(stockSearchLable);

        JTextField stockSearchField = new JTextField();
        stockSearchField.setBounds(910, 33, 130, 30);
        panel.add(stockSearchField);

        JLabel partSearchLable = new JLabel("分区号:");
        partSearchLable.setBounds(860, 60, 50, 30);
        panel.add(partSearchLable);

        JTextField partSearchField = new JTextField();
        partSearchField.setBounds(910, 60, 130, 30);
        panel.add(partSearchField);

        JLabel shelfSearchLable = new JLabel("货架号:");
        shelfSearchLable.setBounds(860, 87, 50, 30);
        panel.add(shelfSearchLable);

        JTextField shelfSearchField = new JTextField();
        shelfSearchField.setBounds(910, 87, 130, 30);
        panel.add(shelfSearchField);

        JLabel tierSearchLable = new JLabel("层数:");
        tierSearchLable.setBounds(860, 114, 50, 30);
        panel.add(tierSearchLable);

        JTextField tierSearchField = new JTextField();
        tierSearchField.setBounds(910, 114, 130, 30);
        panel.add(tierSearchField);

        JButton locationSearchButton = new JButton("查询指定位置");
        locationSearchButton.setBounds(905, 145, 120, 30);
        panel.add(locationSearchButton);

        DateChooser startDate = DateChooser.getInstance("yyyy-MM-dd");
        DateChooser endDate = DateChooser.getInstance("yyyy-MM-dd");
        JTextField startDateField = new JTextField("单击选择日期");
        JTextField endDateField = new JTextField("单击选择日期");
        startDate.register(startDateField);
        endDate.register(endDateField);
        startDateField.setBounds(670, 200, 150, 30);
        endDateField.setBounds(850, 200, 150, 30);
        add(startDateField);
        add(endDateField);

        JLabel startToEnd = new JLabel("至");
        startToEnd.setBounds(828, 205, 20, 20);
        panel.add(startToEnd);

        JButton dateSearchButton = new JButton("查询入/出库时间");
        dateSearchButton.setBounds(665, 230, 150, 30);
        panel.add(dateSearchButton);

        JLabel noteLable = new JLabel("备忘录");
        noteLable.setBounds(295, 275, 40, 30);
        panel.add(noteLable);

        JTextArea noteArea = new JTextArea();
        noteArea.setBounds(10, 300, 600, 300);
        noteArea.setBackground(Color.LIGHT_GRAY);
        panel.add(noteArea);

        JLabel welcomeLable = new JLabel();
        welcomeLable.setBounds(665, 400, 350, 40);
        panel.add(welcomeLable);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                userId = (String) StockConstant.constantMap.get("userId");
                welcomeLable.setText(userId + ",欢迎使用电脑配件库存管理系统！");
                welcomeLable.setFont(new Font(null, 0, 20));
                welcomeLable.setForeground(Color.RED);
            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        add(panel);

    }

    /**
     * 生成一个Operation实例
     * @param type
     * 传入0，表示该操作为入库<br>
     * 传入1，表示该操作为出库
     * @return
     * 返回一个Operation实例
     */
    private Operation generateAnOperationObject(Integer type) {
        Operation operation = new Operation();
        operation.setType(0);
        operation.setUserId(userId);
        operation.setTime(new Date());
        operation.setComponentId(Integer.valueOf(componentIdField.getText()));
        operation.setCount(Integer.valueOf((countField.getText())));
        operation.setStockNo(Integer.valueOf(stockNoField.getText()));
        operation.setPartNo(Integer.valueOf(partNoField.getText()));
        operation.setShelfNo(Integer.valueOf(shelfNoField.getText()));
        operation.setTierNo(Integer.valueOf(tierNoField.getText()));

        log.info(operation.toString());

        return operation;
    }

}
