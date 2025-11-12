/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Decorator;

import Model.Usuario;
/**
 *
 * @author higor
 */
public class Notifier implements INotifier {
    private Usuario usuario ;

    public Notifier(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void send(String msg) {
        System.out.println(msg + usuario.getNome());
    }


}
