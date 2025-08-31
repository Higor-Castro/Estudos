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
public class Gerente extends Funcionario {
    
    private String setor;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    @Override
    public double calcularBonificacao(){
        return salario*0.15;
    }
}
