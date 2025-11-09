/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DIP;

import Model.Meta;
import java.util.List;

/**
 *
 * @author higor
 */
public class Tempo {
    private List<Meta> metas;           // lista de metas do usuário
    private RegraDeCalculo regraTempo;  // abstração da regra de cálculo

    // Define qual regra será usada (por exemplo, diária)
    public void setRegraDeCalculo(RegraDeCalculo regraTempo) {
        this.regraTempo = regraTempo;
    }

    // Faz o cálculo de tempo total usando a regra definida
    public int calcularTempo() {
        return regraTempo.condicao(this);
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }
}
