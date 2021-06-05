package com.fieldwork.stockmis.view;

import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * @author whl
 * @date 2021/6/5 14:48
 */
@Component
public class MainFram extends JFrame {

    public MainFram() {
        setTitle("管理菜单");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 700);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

    }
}
