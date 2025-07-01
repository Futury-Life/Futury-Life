/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.calculadora.calculadoraa;

import br.com.calculadoraa.controle.CalculadoraaController;
import br.com.calculadoraa.enums.EnumOperacao;
public class TelaPrincipal extends javax.swing.JFrame {
    private CalculadoraaController calculadoraaController;
    private EnumOperacao ultimaOperacao;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());
    public TelaPrincipal() {
        initComponents();
        calculadoraaController = new CalculadoraaController();
        tfValor.setEditable(false);
        tfA.setEditable (false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        tfValor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        bt7 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt0 = new javax.swing.JButton();
        btSoma = new javax.swing.JButton();
        btSubtracao = new javax.swing.JButton();
        btMultipllicar = new javax.swing.JButton();
        btDivisao = new javax.swing.JButton();
        btVirgula = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btIgualdade = new javax.swing.JButton();
        tfA = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        tfValor.setBackground(new java.awt.Color(153, 51, 255));
        tfValor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tfValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValor.setText("0,00");
        tfValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        tfValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel1.setLayout(new java.awt.GridLayout(6, 1));

        bt7.setBackground(new java.awt.Color(153, 51, 255));
        bt7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bt7.setText("7");
        bt7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });
        jPanel1.add(bt7);

        bt8.setBackground(new java.awt.Color(153, 51, 255));
        bt8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bt8.setText("8");
        bt8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt8ActionPerformed(evt);
            }
        });
        jPanel1.add(bt8);

        bt9.setBackground(new java.awt.Color(153, 51, 255));
        bt9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bt9.setText("9");
        bt9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt9ActionPerformed(evt);
            }
        });
        jPanel1.add(bt9);

        bt4.setBackground(new java.awt.Color(153, 51, 255));
        bt4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bt4.setText("4");
        bt4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        jPanel1.add(bt4);

        bt5.setBackground(new java.awt.Color(153, 51, 255));
        bt5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bt5.setText("5");
        bt5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });
        jPanel1.add(bt5);

        bt6.setBackground(new java.awt.Color(153, 51, 255));
        bt6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bt6.setText("6");
        bt6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });
        jPanel1.add(bt6);

        bt1.setBackground(new java.awt.Color(153, 51, 255));
        bt1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bt1.setText("1");
        bt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        jPanel1.add(bt1);

        bt2.setBackground(new java.awt.Color(153, 51, 255));
        bt2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bt2.setText("2");
        bt2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        jPanel1.add(bt2);

        bt3.setBackground(new java.awt.Color(153, 51, 255));
        bt3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bt3.setText("3");
        bt3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        jPanel1.add(bt3);

        bt0.setBackground(new java.awt.Color(153, 51, 255));
        bt0.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bt0.setText("0");
        bt0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bt0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt0ActionPerformed(evt);
            }
        });
        jPanel1.add(bt0);

        btSoma.setBackground(new java.awt.Color(153, 51, 255));
        btSoma.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btSoma.setText("+");
        btSoma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btSoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSomaActionPerformed(evt);
            }
        });
        jPanel1.add(btSoma);

        btSubtracao.setBackground(new java.awt.Color(153, 51, 255));
        btSubtracao.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btSubtracao.setText("-");
        btSubtracao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btSubtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubtracaoActionPerformed(evt);
            }
        });
        jPanel1.add(btSubtracao);

        btMultipllicar.setBackground(new java.awt.Color(153, 51, 255));
        btMultipllicar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btMultipllicar.setText("x");
        btMultipllicar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btMultipllicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMultipllicarActionPerformed(evt);
            }
        });
        jPanel1.add(btMultipllicar);

        btDivisao.setBackground(new java.awt.Color(153, 51, 255));
        btDivisao.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btDivisao.setText("/");
        btDivisao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btDivisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDivisaoActionPerformed(evt);
            }
        });
        jPanel1.add(btDivisao);

        btVirgula.setBackground(new java.awt.Color(153, 0, 255));
        btVirgula.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btVirgula.setText(",");
        btVirgula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btVirgula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVirgulaActionPerformed(evt);
            }
        });
        jPanel1.add(btVirgula);

        jButton1.setBackground(new java.awt.Color(153, 51, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setText("AC");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        btIgualdade.setBackground(new java.awt.Color(153, 0, 255));
        btIgualdade.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btIgualdade.setText("=");
        btIgualdade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btIgualdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIgualdadeActionPerformed(evt);
            }
        });
        jPanel1.add(btIgualdade);

        tfA.setBackground(new java.awt.Color(153, 51, 255));
        tfA.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        tfA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfA.setText("FUturylifE");
        tfA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        tfA.setSelectedTextColor(new java.awt.Color(255, 58, 96));
        tfA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
            .addComponent(tfValor, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(tfA, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorActionPerformed
        
    }//GEN-LAST:event_tfValorActionPerformed

    private void bt0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt0ActionPerformed
        Digita("0");
    }//GEN-LAST:event_bt0ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        Digita("1");
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        
        Digita("2");
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed

        Digita("3");
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        
        Digita("4");
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
        
        Digita("5");
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed
        
        Digita("6");
    }//GEN-LAST:event_bt6ActionPerformed

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt7ActionPerformed
        
        Digita("7");
    }//GEN-LAST:event_bt7ActionPerformed

    private void bt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt8ActionPerformed
        
        Digita("8");
    }//GEN-LAST:event_bt8ActionPerformed

    private void btSomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSomaActionPerformed
        calculadoraaController.realizaOperacao(EnumOperacao.SOMA, stringToDouble(tfValor.getText()));
        Limpa();
        
    }//GEN-LAST:event_btSomaActionPerformed

    private void btSubtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubtracaoActionPerformed
        calculadoraaController.realizaOperacao(EnumOperacao.SUBTRACAO, stringToDouble(tfValor.getText()));
        Limpa();
    }//GEN-LAST:event_btSubtracaoActionPerformed
    private Double stringToDouble(String numero) {
    if (numero == null || numero.isEmpty()) return 0.0;

    try {
        return Double.parseDouble(numero.replace(",", "."));
    } catch (NumberFormatException ex) {
        logger.severe("Erro ao converter número: " + numero);
        return 0.0;
    }
}
    private void btMultipllicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMultipllicarActionPerformed
        calculadoraaController.realizaOperacao(EnumOperacao.MULTIPLICACAO, stringToDouble(tfValor.getText()));
        Limpa();
    }//GEN-LAST:event_btMultipllicarActionPerformed

    private void btDivisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDivisaoActionPerformed
        calculadoraaController.realizaOperacao(EnumOperacao.DIVISAO, stringToDouble(tfValor.getText()));
        Limpa();
    }//GEN-LAST:event_btDivisaoActionPerformed

    private void btIgualdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIgualdadeActionPerformed
    try {
        String texto = tfValor.getText();

        if (texto == null || texto.trim().isEmpty()) {
            tfValor.setText("Erro: campo vazio");
            return;
        }

        double valorAtual = stringToDouble(texto);
        
        if (ultimaOperacao == EnumOperacao.DIVISAO && valorAtual == 0) {
            tfValor.setText("Erro: divisão por zero");
            return;
        }

        double resultado = calculadoraaController.finalizaOperacao(valorAtual);

        if (Double.isNaN(resultado) || Double.isInfinite(resultado)) {
            tfValor.setText("Erro: resultado indefinido");
            return;
        }

        tfValor.setText(String.format("%.2f", resultado).replace(".", ","));

    } catch (NumberFormatException e) {
        tfValor.setText("Erro: número inválido");
    } catch (NullPointerException e) {
        tfValor.setText("Erro: valor nulo");
    } catch (Exception e) {
        tfValor.setText("Erro inesperado");
        logger.severe("Erro inesperado: " + e.getMessage());
    }//GEN-LAST:event_btIgualdadeActionPerformed
    }
    private void btVirgulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVirgulaActionPerformed

        Digita(",");
    }//GEN-LAST:event_btVirgulaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Limpa();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt9ActionPerformed

        Digita("9");
    }//GEN-LAST:event_bt9ActionPerformed

    private void tfAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAActionPerformed
    private void Digita(String caractere) {
        if (tfValor.getText().equals("0,00")) {
            tfValor.setText(caractere);
        } else{
            if (caractere.equals(",") && tfValor.getText().contains(",")) {    
            } else {
                tfValor.setText(tfValor.getText().concat(caractere));
            }
        }
    }
    private void Limpa() {
        tfValor.setText("0,00");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt0;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JButton btDivisao;
    private javax.swing.JButton btIgualdade;
    private javax.swing.JButton btMultipllicar;
    private javax.swing.JButton btSoma;
    private javax.swing.JButton btSubtracao;
    private javax.swing.JButton btVirgula;
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField tfA;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
