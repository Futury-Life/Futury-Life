package com.raven.component;

import com.raven.swing.ButtonOutLine;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelCover extends javax.swing.JPanel {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private ActionListener event;
    private GridBagLayout layout;
    private JLabel title;
    private JLabel description;
    private JLabel description1;
    private ButtonOutLine button;
    private boolean isLogin;

    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new GridBagLayout();
        setLayout(layout);
        init();

    }

    private void init() {
        title = new JLabel("Bem-vindo de volta!");
        title.setFont(new Font("sansserif", 1, 30));
        title.setForeground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(40, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(title, gbc);
        description = new JLabel("Para manter-se conectado conosco,");
        description.setForeground(new Color(245, 245, 245));
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 5, 0);
        add(description, gbc);
        description1 = new JLabel("faça login com suas informações");
        description1.setForeground(new Color(245, 245, 245));
        gbc.gridy++;
        gbc.insets = new Insets(5, 0, 25, 0);
        add(description1, gbc);
        button = new ButtonOutLine();
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(255, 255, 255));
        button.setText("ENTRAR");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }
        });
        gbc.gridy++;
        gbc.insets = new Insets(25, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 60;
        gbc.ipady = 10;
        add(button, gbc);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gra = new GradientPaint(0, 0, new Color(124, 58, 237), 0, getHeight(), new Color(91, 33, 182));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    public void addEvent(ActionListener event) {
        this.event = event;
    }

    public void login(boolean login) {
        if (this.isLogin != login) {
            if (login) {
                title.setText("Olá, Amigo!");
                description.setText("Digite seus dados pessoais");
                description1.setText("e comece sua jornada conosco");
                button.setText("CADASTRAR");
            } else {
                title.setText("Bem-vindo de volta!");
                description.setText("Para manter-se conectado conosco,");
                description1.setText("faça login com suas informações");
                button.setText("ENTRAR");
            }
            this.isLogin = login;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
