package com.fieldwork.stockmis.view;

import com.fieldwork.stockmis.dao.PositionDao;
import com.fieldwork.stockmis.entity.Position;
import com.fieldwork.stockmis.service.ComponentService;
import com.fieldwork.stockmis.utils.StockConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author hy
 * @date 2021/6/8 15:42
 */
@Component
public class ConsequenceFram extends JFrame{

    @Autowired
    ComponentService componentService;

    @Autowired
    PositionDao positionDao;

    public ConsequenceFram() {
        setTitle("查询结果");
        setSize(800, 400);
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
        setLocation(600,300);
    }

    public JTable table(){
        Object[][] obj=new Object[5][8];
        String[] name={"配件号","大类","种","型号","仓库号","分区号","货架号","层"};
        JTable table=new JTable(obj,name);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                String IDSearchText = (String) StockConstant.constantMap.get("IDSearchText");

                Object[][] results;

                if (IDSearchText != null) {
                     results = componentService.searchComponentById(IDSearchText);
                } else {
                    Position positionInfo = (Position) StockConstant.constantMap.get("positionInfo");
                    results = componentService.searchComponentByPosition(positionInfo);
                }


                int index = 0;
                for (Object[] result : results) {
                    obj[index][0] = result[0];
                    obj[index][1] = result[1];
                    obj[index][2] = result[2];
                    obj[index][3] = result[3];
                    obj[index][4] = result[4];
                    obj[index][5] = result[5];
                    obj[index][6] = result[6];
                    obj[index][7] = result[7];
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
