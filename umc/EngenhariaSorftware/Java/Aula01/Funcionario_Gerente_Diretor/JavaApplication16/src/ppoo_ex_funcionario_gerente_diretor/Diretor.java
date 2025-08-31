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
public class Diretor extends Funcionario{
    private String unidade;

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    @Override
    public double calcularBonificacao(){
        return salario*0.20;
    }
}
