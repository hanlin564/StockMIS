package com.fieldwork.stockmis.view.operationResult;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author whl
 * @date 2021/6/7 10:58
 */
@Component
public class InputSuccessFram extends JFrame {
    public InputSuccessFram() {
        setSize(200, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        add(panel);
        JLabel loginFall = new JLabel("入库成功！", JLabel.CENTER);
        loginFall.setForeground(Color.RED);
        panel.add(loginFall, BorderLayout.CENTER);
    }
}
