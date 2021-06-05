package com.fieldwork.stockmis.view;

import com.fieldwork.stockmis.service.UserService;
import com.fieldwork.stockmis.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author whl
 * @date 2021/6/2 20:02
 */
@Component
@Slf4j
public class LoginFram extends JFrame {

    @Autowired
    UserService userService;

    private JTextField idFiled;
    private JPasswordField passwordField;

    public LoginFram() {
        setTitle("欢迎使用库存管理系统");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);

        panel.setLayout(null);
        JLabel userLabel = new JLabel("账号:");
        userLabel.setBounds(60,20,80,25);
        panel.add(userLabel);

        idFiled = new JTextField(20);
        idFiled.setBounds(100,20,165,25);
        panel.add(idFiled);

        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(60,50,80,25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100,50,165,25);
        panel.add(passwordField);

        JButton loginButton = new JButton("登录");
        loginButton.setBounds(135, 80, 80, 25);
        loginButton.addActionListener((event) -> checkIdAndPassword());

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    checkIdAndPassword();
                }
            }
        });

        idFiled.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    checkIdAndPassword();
                }
            }
        });

        panel.add(loginButton);
    }

    private void checkIdAndPassword() {
        //获取用户输入的用户名、密码
        String userId = idFiled.getText();
        String password = String.valueOf(passwordField.getPassword());

        //校验用户名密码
        if (userService.login(userId, password)) {
            log.info("登录成功");

            //开启主界面
            MainFram mainFram = SpringUtil.getBean(MainFram.class);
            mainFram.setVisible(true);

            //关闭登录界面
            dispose();
        } else {
            log.info("用户名或密码错误");

            //开启登录失败界面
            LoginFallFram loginFallFram = SpringUtil.getBean(LoginFallFram.class);
            loginFallFram.setVisible(true);
        }
    }
}
