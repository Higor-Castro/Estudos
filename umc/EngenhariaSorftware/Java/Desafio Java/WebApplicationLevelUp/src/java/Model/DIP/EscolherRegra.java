/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DIP;

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
