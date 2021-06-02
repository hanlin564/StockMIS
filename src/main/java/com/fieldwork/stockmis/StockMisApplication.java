package com.fieldwork.stockmis;

import com.fieldwork.stockmis.view.LoginView;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import javax.swing.*;

@MapperScan("com.fieldwork.stockmis.dao")
@SpringBootApplication
public class StockMisApplication {

    public static void main(String[] args) {
//        SpringApplication.run(StockMisApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(StockMisApplication.class);
        ApplicationContext context = builder.headless(false).run(args);
        LoginView loginView = context.getBean(LoginView.class);
        loginView.setVisible(true);
//        JFrame login = new JFrame("Login");
//        login.setSize(350, 200);
//        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JPanel panel = new JPanel();
//        login.add(panel);
//
//        panel.setLayout(null);
//        JLabel userLabel = new JLabel("User:");
//        userLabel.setBounds(10,20,80,25);
//        panel.add(userLabel);
//
//        JTextField userText = new JTextField(20);
//        userText.setBounds(100,20,165,25);
//        panel.add(userText);
//
//        JLabel passwordLabel = new JLabel("Password:");
//        passwordLabel.setBounds(10,50,80,25);
//        panel.add(passwordLabel);
//
//        JPasswordField passwordText = new JPasswordField(20);
//        passwordText.setBounds(100,50,165,25);
//        panel.add(passwordText);
//
//        JButton loginButton = new JButton("login");
//        loginButton.setBounds(10, 80, 80, 25);
//        panel.add(loginButton);
//
//        login.setVisible(true);
    }

}
