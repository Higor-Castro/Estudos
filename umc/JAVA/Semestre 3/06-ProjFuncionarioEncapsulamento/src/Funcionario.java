/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alunos
 */
public class Funcionario {
    public String nome;
    public int registro;
    private String setor;
    private String cargo;
    private double salario;
    private int telefone;
    private String filial;
    private int filhos;
    private String cidade;  
    
     public String getSetor(){
        return this.setor;
    }
     public void setSetor(String setor){
         this.setor=setor;
     }
     
     public String getCargo(){
         return this.cargo;
     }
     public void setCargo(String cargo){
         this.cargo=cargo;
     }
     
     public double getSalario(){
         return this.salario;
     }
     public void setSalario(double salario){
         this.salario=salario;
     }
     
     public int getTelefone(){
         return this.telefone;
     }
     public void setTelefone(int telefone){
         this.telefone=telefone;
     }
     
     public String getFilial(){
         return this.filial;
     }
     public void setFilial(String filial){
         this.filial=filial;
     }
     
     public int getFilhos(){
         return this.filhos;
     }
     public void setFilhos(int filhos ){
         this.filhos=filhos;
     }
     
     public String getCidade(){
         return this.cidade;
     }
     public void setCidade(String cidade){
         this.cidade=cidade;
     }
}


