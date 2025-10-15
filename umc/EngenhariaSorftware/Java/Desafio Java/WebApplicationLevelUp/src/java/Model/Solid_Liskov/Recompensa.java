/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Solid_Liskov;

/**
 *
 * @author higor
 */
public abstract class Recompensa {
    protected String nivel;
    protected String mensagem;

    public String getNivel() { return nivel; }
    public String getMensagem() { return mensagem; }

    // Método abstrato que subclasses devem implementar
    public abstract Recompensa calcular();
}
