package com.raven.component;

import com.raven.model.ModelLogin;
import com.raven.model.ModelUser;
import com.raven.swing.Button;
import com.raven.swing.MyPasswordField;
import com.raven.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public ModelLogin getDataLogin() {
        return dataLogin;
    }

    public ModelUser getUser() {
        return user;
    }

    private ModelUser user;
    private ModelLogin dataLogin;

    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        login.setVisible(true);
        register.setVisible(false);
    }

    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel label = new JLabel("Criar Conta");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(124, 58, 237));
        label.setHorizontalAlignment(JLabel.CENTER);
        gbc.insets = new Insets(20, 0, 25, 0);
        register.add(label, gbc);

        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/user.png")));
        txtUser.setHint("Nome");
        txtUser.setForeground(new Color(91, 33, 182));
        txtUser.setPreferredSize(new Dimension(220, 36));
        gbc.insets = new Insets(10, 50, 10, 50);
        register.add(txtUser, gbc);

        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
        txtEmail.setHint("Email");
        txtEmail.setForeground(new Color(91, 33, 182));
        txtEmail.setPreferredSize(new Dimension(220, 36));
        gbc.insets = new Insets(10, 50, 10, 50);
        register.add(txtEmail, gbc);

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Senha");
        txtPass.setForeground(new Color(91, 33, 182));
        txtPass.setPreferredSize(new Dimension(220, 36));
        gbc.insets = new Insets(10, 50, 10, 50);
        register.add(txtPass, gbc);

        Button cmd = new Button();
        cmd.setBackground(new Color(124, 58, 237));
        cmd.setForeground(new Color(245, 245, 245));
        cmd.addActionListener(eventRegister);
        cmd.setText("CADASTRAR");
        gbc.insets = new Insets(25, 0, 30, 0);
        register.add(cmd, gbc);

        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userName = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                user = new ModelUser(0, userName, email, password);
            }
        });
    }

    private void initLogin(ActionListener eventLogin) {
        login.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel label = new JLabel("Entrar");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(124, 58, 237));
        label.setHorizontalAlignment(JLabel.CENTER);
        gbc.insets = new Insets(20, 0, 25, 0);
        login.add(label, gbc);

        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
        txtEmail.setHint("Email");
        txtEmail.setForeground(new Color(91, 33, 182));
        txtEmail.setPreferredSize(new Dimension(220, 36));
        gbc.insets = new Insets(10, 50, 10, 50);
        login.add(txtEmail, gbc);

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Senha");
        txtPass.setForeground(new Color(91, 33, 182));
        txtPass.setPreferredSize(new Dimension(220, 36));
        gbc.insets = new Insets(10, 50, 10, 50);
        login.add(txtPass, gbc);

        JButton cmdForget = new JButton("Esqueceu sua senha?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdForget.setBorderPainted(false);
        gbc.insets = new Insets(5, 0, 10, 0);
        login.add(cmdForget, gbc);

        Button cmd = new Button();
        cmd.setBackground(new Color(124, 58, 237));
        cmd.setForeground(new Color(245, 245, 245));
        cmd.setText("ENTRAR");
        gbc.insets = new Insets(25, 0, 30, 0);
        login.add(cmd, gbc);

        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                dataLogin = new ModelLogin(email, password);
                eventLogin.actionPerformed(ae);
            }
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
