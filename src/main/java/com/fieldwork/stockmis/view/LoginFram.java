package com.fieldwork.stockmis.view;

import com.fieldwork.stockmis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * @author whl
 * @date 2021/6/2 20:02
 */
@Component
@Slf4j
public class LoginFram extends JFrame {

    @Autowired
    UserService userService;

    public LoginFram() {
        setTitle("欢迎使用库存管理系统");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel);

        panel.setLayout(null);
        JLabel userLabel = new JLabel("账号:");
        userLabel.setBounds(60,20,80,25);
        panel.add(userLabel);

        JTextField idFiled = new JTextField(20);
        idFiled.setBounds(100,20,165,25);
        panel.add(idFiled);

        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(60,50,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(100,50,165,25);
        panel.add(passwordField);

        JButton loginButton = new JButton("登录");
        loginButton.setBounds(135, 80, 80, 25);
        loginButton.addActionListener((event) -> {

            //获取用户输入的用户名、密码
            String userId = idFiled.getText();
            String password = String.valueOf(passwordField.getPassword());

            //校验用户名密码
            if (userService.login(userId, password)) {
                log.info("登录成功");
            } else {
                log.info("用户名或密码错误");
            }
        });
        panel.add(loginButton);

        setVisible(true);
    }
}
