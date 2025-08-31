/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetotransacao;

import java.util.Date;

/**
 *
 * @author ptoledo
 */
public abstract class Transacao {

    private Date data;
    private double valor;
    private String descricao;

    public void setData(Date data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }    
    
    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void realizarTransacao();

    @Override
    public String toString() {
        return "Transacao [data= " + data + ", valor= " + valor + ", descricao= " + descricao + "]";
    }
}
