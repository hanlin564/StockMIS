package com.fieldwork.stockmis.view.operationResult;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author whl & tyl
 * @date 2021/6/7 10:55
 */
@Component
public class InputFallFram extends JFrame {
    public InputFallFram() {
        setSize(200, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        add(panel);
        JLabel loginFall = new JLabel("入库失败！", JLabel.CENTER);
        loginFall.setForeground(Color.RED);
        panel.add(loginFall, BorderLayout.CENTER);
    }
}
