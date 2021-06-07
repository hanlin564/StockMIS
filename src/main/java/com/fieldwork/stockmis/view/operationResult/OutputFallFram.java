package com.fieldwork.stockmis.view.operationResult;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author whl
 * @date 2021/6/7 16:18
 */
@Component
public class OutputFallFram extends JFrame {
    public OutputFallFram() {
        setSize(200, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        add(panel);
        JLabel loginFall = new JLabel("出库失败！", JLabel.CENTER);
        loginFall.setForeground(Color.RED);
        panel.add(loginFall, BorderLayout.CENTER);
    }
}
