package com.fieldwork.stockmis.view.operationResult;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author whl
 * @date 2021/6/5 17:08
 */
@Component
public class LoginFallFram extends JFrame {
    public LoginFallFram() {
        setSize(200, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        add(panel);
        JLabel loginFall = new JLabel("账号或密码错误！", JLabel.CENTER);
        loginFall.setForeground(Color.RED);
        panel.add(loginFall, BorderLayout.CENTER);

    }
}
