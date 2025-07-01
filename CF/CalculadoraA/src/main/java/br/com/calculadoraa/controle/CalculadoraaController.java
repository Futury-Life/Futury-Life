/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.calculadoraa.controle;
import br.com.calculadoraa.enums.EnumOperacao;
/**
 *
 * @author josel
 */
public class CalculadoraaController {
    private double valorAnterior;
    private EnumOperacao operacao;

    public void realizaOperacao(EnumOperacao op, double valor) {
        this.valorAnterior = valor;
        this.operacao = op;
    }

    public double finalizaOperacao(double valorAtual) {
        if (operacao == null) return valorAtual;

        switch (operacao) {
            case SOMA:
                return valorAnterior + valorAtual;
            case SUBTRACAO:
                return valorAnterior - valorAtual;
            case MULTIPLICACAO:
                return valorAnterior * valorAtual;
            case DIVISAO:
                if (valorAtual == 0) throw new ArithmeticException("Divisão por zero!");
                return valorAnterior / valorAtual;
            default:
                return valorAtual;
        }
    }
}