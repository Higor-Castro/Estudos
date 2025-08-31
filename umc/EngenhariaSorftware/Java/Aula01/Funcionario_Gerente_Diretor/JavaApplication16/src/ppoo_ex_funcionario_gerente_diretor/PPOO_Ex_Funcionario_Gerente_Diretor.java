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
public class PPOO_Ex_Funcionario_Gerente_Diretor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Funcionario funcionario = new Funcionario();
        Funcionario gerente = new Gerente();
        Funcionario diretor = new Diretor();

        Funcionario[] arrayFuncionarios = new Funcionario[3];

        arrayFuncionarios[0] = funcionario;
        arrayFuncionarios[1] = gerente;
        arrayFuncionarios[2] = diretor;
        
        for(Funcionario func : arrayFuncionarios){
            func.setSalario(1000);
            System.out.println(func.calcularBonificacao());
        }

    }

}
