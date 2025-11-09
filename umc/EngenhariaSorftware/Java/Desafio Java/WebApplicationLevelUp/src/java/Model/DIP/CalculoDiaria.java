/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DIP;
import Model.Meta;

/**
 *
 * @author higor
 */
// Implementação concreta da regra — cálculo para metas diárias
public class CalculoDiaria implements RegraDeCalculo {

    @Override
    public int condicao(Tempo tempo) {
        int total = 0;

        // Cada meta tem um número de etapas, e cada etapa é 1 dia
        for (Meta meta : tempo.getMetas()) {
            total += meta.getEtapas(); 
        }
        return total; // Retorna o total de dias
    }
}
