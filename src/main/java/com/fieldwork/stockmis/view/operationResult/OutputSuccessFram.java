package com.fieldwork.stockmis.view.operationResult;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author whl & tyl
 * @date 2021/6/7 16:08
 */
@Component
public class OutputSuccessFram extends JFrame{
    public OutputSuccessFram() {
        setSize(200, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        add(panel);
        JLabel loginFall = new JLabel("出库成功！", JLabel.CENTER);
        loginFall.setForeground(Color.RED);
        panel.add(loginFall, BorderLayout.CENTER);
    }
}
