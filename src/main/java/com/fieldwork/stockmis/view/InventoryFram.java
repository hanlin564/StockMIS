package com.fieldwork.stockmis.view;

import com.fieldwork.stockmis.service.ComponentService;
import com.fieldwork.stockmis.utils.StockConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

/**
 * 盘点结果UI
 * @author siqi
 * @date 2021/6/6 14:36
 */
@Component
public class InventoryFram extends JFrame {

    @Autowired
    ComponentService componentService;

    Object[][] tabData;

    public InventoryFram(){
        //盘点结果页面窗口
        setTitle("盘点结果");
        setLocationRelativeTo(null);
        setSize(800,500);
        setLayout(new BorderLayout());





        //表格的各列列名
        String[] name = {"配件号","数量"};
        //表格部分行列数
        tabData = new Object[1000][2];
        //表格部分
        JTable jTab = new JTable(tabData,name);
        //表格部分所在面板
        JScrollPane jScrollPane = new JScrollPane(jTab);
        //底部部分的面板
        JPanel jPanelBot = new JPanel(new BorderLayout());
        //底部部分的返回按钮
        JButton backButton = new JButton("back to main menu");
        backButton.addActionListener(event -> dispose());
        //底部部分显示的查询时间文本
        JLabel jLabel = new JLabel();
        jPanelBot.add(backButton,BorderLayout.WEST);
        jPanelBot.add(jLabel,BorderLayout.CENTER);

        setSize(800,500);
        setLayout(new BorderLayout());


        add(jScrollPane, BorderLayout.CENTER);

        add(jPanelBot,BorderLayout.SOUTH);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

                Date date = new Date();
                jLabel.setText("盘点截止日期" + date);

                String checkClass = StockConstant.constantMap.get("checkClass").toString();
//                Object[][] results = componentService.checkComponentIdAndCount(checkClass);
                jTab.setModel(new TableModel() {
                    String[] name = {"配件号","数量"};
                    Object[][] data = componentService.checkComponentIdAndCount(checkClass);

                    @Override
                    public int getRowCount() {
                        return data.length;
                    }

                    @Override
                    public int getColumnCount() {
                        return data[0].length;
                    }

                    @Override
                    public String getColumnName(int columnIndex) {
                        return name[columnIndex];
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return Object.class;
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }

                    @Override
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        return data[rowIndex][columnIndex];
                    }

                    @Override
                    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                        data[rowIndex][columnIndex] = aValue;
                    }

                    @Override
                    public void addTableModelListener(TableModelListener l) {

                    }

                    @Override
                    public void removeTableModelListener(TableModelListener l) {

                    }
                });

//                int index = 0;
//                int cols = results[0].length;
//                for (Object[] result : results) {
//                    System.arraycopy(result, 0, tabData[index], 0, cols);
//                    index++;
//                }


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

    }


}
