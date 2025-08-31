/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppoo_ex_funcionario_gerente_diretor;

/**
 *
 * @author proft
 */
public class Teste {
    public static void main(String[] args){
        Funcionario obj;
        
        obj = new Funcionario();
        obj.setSalario(2000);
        System.out.println(obj.calcularBonificacao());
        
        
        obj = new Gerente();
        obj.setSalario(2000);
        System.out.println(obj.calcularBonificacao());
        
        
        obj = new Diretor();
        obj.setSalario(2000);
        System.out.println(obj.calcularBonificacao());
        
        
        
        
    }
}
