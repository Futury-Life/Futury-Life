package com.raven.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class TelaAplicativos extends JFrame {
    
    private Color corPrimaria = new Color(124, 58, 237);
    private Color corSecundaria = new Color(91, 33, 182);
    private Color corTexto = new Color(245, 245, 245);
    private Color corCard = new Color(124, 58, 237, 30);
    private Color corCardHover = new Color(124, 58, 237, 60);
    
    public TelaAplicativos() {
        setTitle("Menu de Aplicativos");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Painel principal com gradiente
        JPanel painelPrincipal = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gra = new GradientPaint(0, 0, corPrimaria, 0, getHeight(), corSecundaria);
                g2.setPaint(gra);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        painelPrincipal.setOpaque(false);
        
    
        JLabel lblTitulo = new JLabel("Meus Aplicativos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("sansserif", Font.BOLD, 28));
        lblTitulo.setForeground(corTexto);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        painelPrincipal.add(lblTitulo, BorderLayout.NORTH);
        
        
        JPanel painelBotoes = new JPanel(new GridBagLayout());
        painelBotoes.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        painelBotoes.add(criarBotao("CALCULADORA", e -> abrirCalculadora()), gbc);
        painelBotoes.add(criarBotao("SNAKE GAME", e -> abrirJogo()), gbc);
        painelBotoes.add(criarBotao("VOLTAR", e -> {
            dispose();
            new Main().setVisible(true);
        }), gbc);

        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        add(painelPrincipal);
    }
    
    private JButton criarBotao(String texto, ActionListener acao) {
        JButton botao = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Fundo transparente
                g2.setColor(new Color(0, 0, 0, 0));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                
                // Texto
                g2.setColor(corTexto);
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(getText(), 
                    (getWidth() - fm.stringWidth(getText())) / 2,
                    ((getHeight() - fm.getHeight()) / 2) + fm.getAscent());
            }
        };
        
        botao.setPreferredSize(new Dimension(200, 45));
        botao.setFont(new Font("sansserif", Font.BOLD, 14));
        botao.setForeground(corTexto);
        botao.setBackground(new Color(0, 0, 0, 0));
        botao.setBorder(BorderFactory.createLineBorder(corTexto, 2));
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        
        
        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setBackground(new Color(255, 255, 255, 30));
                botao.setContentAreaFilled(true);
                botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                botao.setBackground(new Color(0, 0, 0, 0));
                botao.setContentAreaFilled(false);
                botao.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        
        botao.addActionListener(acao);
        return botao;
    }
    
    private void abrirJogo() {
        SnakeGame jogo = new SnakeGame();
        jogo.setVisible(true);
        this.setVisible(false);
    }
    
    private void abrirCalculadora() {
        Calculadora calc = new Calculadora();
        calc.setVisible(true);
        this.setVisible(false);
    }
} 