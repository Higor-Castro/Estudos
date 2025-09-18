/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dados;

/**
 *
 * @author alunocmc
 */
public class Produtos {
    //Atributos
    private int id;
    private String nome;
    private float valor;
    //Metodos - Construtores
    public Produtos(){}
    public Produtos (int p_id, String p_nome, float p_valor){
        this.id = p_id;
        this.nome = p_nome;
        this.valor = p_valor;
    }
        //M. seters '
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    //M. Getters
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public float getValor() {
        return this.valor;
    }
    
    //M. Bidirecional 
    public float calcDesc(float p_valor){
        return this.getValor()*10/100;
    }
    
      public float calcJuros(float p_valor){
        return this.getValor()*5/100;
    }
}
    

    

    
    

