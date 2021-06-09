package com.fieldwork.stockmis.view;

import com.fieldwork.stockmis.service.ComponentService;
import com.fieldwork.stockmis.utils.StockConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

/**
 * @author hy
 * @date 2021/6/9 11:49
 */
@Component
public class OperationSearchFram extends JFrame {

    @Autowired
    ComponentService componentService;

    public OperationSearchFram() {
        setTitle("查询结果");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JButton back=new JButton("返回");
        back.setSize(60,30);
        back.addActionListener((event) -> dispose());
        Container contentPane=getContentPane();
        JTable table=table();
        add(table,BorderLayout.NORTH);
        contentPane.add(new JScrollPane(table));
        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(back,BorderLayout.WEST);
        //JLabel
        add(p1,BorderLayout.SOUTH);

    }
    public JTable table(){
        Object[][] obj=new Object[20][10];
        String[] name={"操作号","操作方式","配件号","操作者id","操作时间","操作数量","仓库号","分区号","货架号","层数"};
        JTable table=new JTable(obj,name);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                Date startDateTime = (Date) StockConstant.constantMap.get("startDateTime");
                Date endDateTime = (Date) StockConstant.constantMap.get("endDateTime");

                Object[][] results;
                results = componentService.searchOperationByTime(startDateTime, endDateTime);

                int index = 0;
                int cols = results[0].length;
                for (Object[] result : results) {
                    System.arraycopy(result, 0, obj[index], 0, cols);
                    index++;
                }
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
        return table;
    }
}
