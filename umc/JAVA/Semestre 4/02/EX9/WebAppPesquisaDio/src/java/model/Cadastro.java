/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alunocmc
 */
public class Cadastro {   

    // Atributos privados que armazenam as informações do usuário
    
    private int satisfeito;
    private int recomendaria;
    private int informacoes;
    private int seguro;
    private int novos_recursos;
    
    //Metodos Getters
    public int getSatisfeito() {
        return satisfeito;
    }

    public int getRecomendaria() {
        return recomendaria;
    }

    public int getInformacoes() {
        return informacoes;
    }

    public int getSeguro() {
        return seguro;
    }

    public int getNovos_recursos() {
        return novos_recursos;
    }
   //Metodos Setters

    public void setSatisfeito(int satisfeito) {
        this.satisfeito = satisfeito;
    }

    public void setRecomendaria(int recomendaria) {
        this.recomendaria = recomendaria;
    }

    public void setInformacoes(int informacoes) {
        this.informacoes = informacoes;
    }

    public void setSeguro(int seguro) {
        this.seguro = seguro;
    }

    public void setNovos_recursos(int novos_recursos) {
        this.novos_recursos = novos_recursos;
    }
    
    
    
}
