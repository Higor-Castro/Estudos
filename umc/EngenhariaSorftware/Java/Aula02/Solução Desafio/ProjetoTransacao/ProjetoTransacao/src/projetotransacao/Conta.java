/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetotransacao;

import java.util.ArrayList;

/**
 *
 * @author ptoledo
 */
public class Conta {
    
    private long numero;
    private double saldo;
    private ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
    
    public Conta(long numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
        System.out.println("Conta: " + numero + ", saldo R$ " + saldo);
    }
    
    public void novaTransacao(Transacao transacao){
        transacoes.add(transacao);
        transacao.realizarTransacao();
    }
}
