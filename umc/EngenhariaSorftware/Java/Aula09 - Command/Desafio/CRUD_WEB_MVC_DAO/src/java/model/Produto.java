/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;

/**
 *
 * @author PTOLEDO
 */
public class Produto {

    private int id;
    private String descricao;
    private double preco;
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    public Produto(){
        super();
    }
    
    public static ProdutoBuilder getBuilder() {
        return new ProdutoBuilder();
    }

    public static class ProdutoBuilder {

        Produto prod;

        public ProdutoBuilder comId(int id) {
            prod.id = id;
            return this;
        }

        public ProdutoBuilder comDescricao(String descricao) {
            prod.descricao = descricao;
            return this;
        }

        public ProdutoBuilder comPreco(double preco) {
            prod.preco = preco;
            return this;
        }
        
        public ProdutoBuilder comQuantidade(int quantidade){
            prod.quantidade = quantidade;
            return this;
        }

        public Produto constroi() {
            return prod;
        }
    }

}
