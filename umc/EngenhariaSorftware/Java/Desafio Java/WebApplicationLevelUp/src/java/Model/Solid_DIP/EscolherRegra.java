/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Solid_DIP;

import Model.Solid_DIP.CalculoDiaria;
import Model.Solid_DIP.CalculoSemanal;
import Model.Solid_DIP.RegraDeCalculo;
import Model.Solid_DIP.CalculoMensal;

/**
 *
 * @author higor
 */
public class EscolherRegra {
    
    
    public static RegraDeCalculo escolher(String frequencia) {
        return switch (frequencia.toLowerCase()) {
            case "diaria" -> new CalculoDiaria();
            case "semanal" -> new CalculoSemanal();
            default -> new CalculoMensal();
        };
    }
}
