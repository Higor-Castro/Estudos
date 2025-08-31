/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Marcal;

/**
 *
 * @author alunocmc
 */
public class Pacientes {
  //Atributos
    private int id;
    private String nome;
    private float mens;
    
    //metodo Constutor
    public Pacientes (){
        
    }
    public Pacientes(int p_id, String p_nome, float  p_mens){
        this.id = p_id;
        this.nome = p_nome;
        this.mens = p_mens;
    }
    
    
  //Metodos - steers
    public void setId(int p_id){
        this.id=p_id;
    }
    public void setNome(String p_nome) {
        this.nome = p_nome ;
    }
    public void  setMens (float p_mensalidade){
        this.mens = p_mensalidade;
    }
  //Metodos - getters
    public int getId(){
        return this.id;     
    }
    public String getNome(){
        return this.nome;
    }
    public float getMens(){
        return this.mens;
    }
    
        
    }