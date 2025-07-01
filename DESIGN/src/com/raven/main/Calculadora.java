package com.raven.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.miginfocom.swing.MigLayout;

public class Calculadora extends JFrame {
    
    private JTextField display;
    private double resultado = 0;
    private String operadorAnterior = "=";
    private boolean iniciarNumero = true;
    private Color corPrimaria = new Color(124, 58, 237);
    private Color corSecundaria = new Color(91, 33, 182);
    private Color corTexto = new Color(245, 245, 245);
    private Color corBotaoNumero = new Color(124, 58, 237, 30);
    private Color corBotaoOperador = new Color(91, 33, 182, 50);
    private Color corBotaoIgual = new Color(168, 85, 247, 100);
    
    public Calculadora() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        
        // Painel principal com gradiente
        JPanel painelPrincipal = new JPanel(new MigLayout("wrap, fill", "[grow]", "[]10[]")) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gra = new GradientPaint(0, 0, corPrimaria, 0, getHeight(), corSecundaria);
                g2.setPaint(gra);
                g2.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        painelPrincipal.setOpaque(false);
        
        
        JPanel painelDisplay = new JPanel(new MigLayout("wrap", "[right]", "[][]"));
        painelDisplay.setOpaque(false);
        
        display = new JTextField("0");
        display.setFont(new Font("sansserif", Font.BOLD, 48));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(0, 0, 0, 0));
        display.setForeground(corTexto);
        display.setBorder(null);
        
        painelDisplay.add(display, "width 100%, height 100!");
        painelPrincipal.add(painelDisplay, "grow");
        
        
        JPanel painelBotoes = new JPanel(new MigLayout("wrap 4, gap 10", "[grow,fill][grow,fill][grow,fill][grow,fill]", "[grow,fill][grow,fill][grow,fill][grow,fill][grow,fill]"));
        painelBotoes.setOpaque(false);
        
        
        String[] botoes = {
            "C", "←", "±", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "%", "="
        };
        
        for (String botao : botoes) {
            JButton btn = criarBotaoCalculadora(botao);
            painelBotoes.add(btn);
        }
        
        painelPrincipal.add(painelBotoes, "grow");
        
        
        JPanel painelNavegacao = new JPanel(new MigLayout("", "[]10[]", ""));
        painelNavegacao.setOpaque(false);
        
        JButton btnVoltar = criarBotaoNavegacao("VOLTAR");
        JButton btnSair = criarBotaoNavegacao("SAIR");
        
        btnVoltar.addActionListener(e -> voltarParaAplicativos());
        btnSair.addActionListener(e -> voltarParaLogin());
        
        painelNavegacao.add(btnVoltar);
        painelNavegacao.add(btnSair);
        
        painelPrincipal.add(painelNavegacao, "center");
        
        
        add(painelPrincipal);
        
        // Margem
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
    
    private JButton criarBotaoCalculadora(String texto) {
        JButton botao = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
              
                Color corFundo;
                if (texto.matches("[0-9.]")) {
                    corFundo = corBotaoNumero;
                } else if (texto.equals("=")) {
                    corFundo = corBotaoIgual;
                } else {
                    corFundo = corBotaoOperador;
                }
                
                
                g2.setColor(corFundo);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                
               
                g2.setColor(new Color(255, 255, 255, 50));
                g2.setStroke(new BasicStroke(1));
                g2.drawRoundRect(1, 1, getWidth()-3, getHeight()-3, 20, 20);
                
                
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                g2.setColor(corTexto);
                g2.drawString(texto, 
                    (getWidth() - fm.stringWidth(texto)) / 2,
                    ((getHeight() - fm.getHeight()) / 2) + fm.getAscent());
            }
        };
        
        botao.setFont(new Font("sansserif", Font.BOLD, 24));
        botao.setForeground(corTexto);
        botao.setBorder(null);
        botao.setContentAreaFilled(false);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(80, 80));
        
        
        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                botao.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        
        botao.addActionListener(e -> processarBotao(texto));
        
        return botao;
    }
    
    private JButton criarBotaoNavegacao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("sansserif", Font.BOLD, 14));
        botao.setForeground(corTexto);
        botao.setBackground(new Color(0, 0, 0, 0));
        botao.setBorder(BorderFactory.createLineBorder(corTexto, 1));
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
        
        return botao;
    }
    
    private void voltarParaAplicativos() {
        this.dispose();
        new TelaAplicativos().setVisible(true);
    }
    
    private void voltarParaLogin() {
        this.dispose();
        new Main().setVisible(true);
    }
    
    private void processarBotao(String comando) {
        if (comando.matches("[0-9.]")) {
            if (iniciarNumero) {
                display.setText(comando);
                iniciarNumero = false;
            } else {
                display.setText(display.getText() + comando);
            }
        } else {
            processarComando(comando);
        }
    }
    
    private void processarComando(String comando) {
        if (comando.equals("C")) {
            resultado = 0;
            display.setText("0");
            iniciarNumero = true;
            operadorAnterior = "=";
        } else if (comando.equals("←")) {
            String texto = display.getText();
            if (texto.length() > 0) {
                texto = texto.substring(0, texto.length() - 1);
                if (texto.length() == 0) {
                    texto = "0";
                    iniciarNumero = true;
                }
                display.setText(texto);
            }
        } else if (comando.equals("±")) {
            double valor = Double.parseDouble(display.getText());
            valor = -valor;
            display.setText(String.valueOf(valor));
        } else if (comando.equals("%")) {
            double valor = Double.parseDouble(display.getText());
            valor = valor / 100;
            display.setText(String.valueOf(valor));
            iniciarNumero = true;
        } else if ("=+-*/".contains(comando)) {
            calcular(Double.parseDouble(display.getText()));
            operadorAnterior = comando;
            iniciarNumero = true;
        }
    }
    
    private void calcular(double numero) {
        if (operadorAnterior.equals("+")) {
            resultado += numero;
        } else if (operadorAnterior.equals("-")) {
            resultado -= numero;
        } else if (operadorAnterior.equals("*")) {
            resultado *= numero;
        } else if (operadorAnterior.equals("/")) {
            if (numero != 0) {
                resultado /= numero;
            } else {
                JOptionPane.showMessageDialog(this, "Não é possível dividir por zero!");
                return;
            }
        } else if (operadorAnterior.equals("=")) {
            resultado = numero;
        }
        display.setText(String.valueOf(resultado));
    }
} 