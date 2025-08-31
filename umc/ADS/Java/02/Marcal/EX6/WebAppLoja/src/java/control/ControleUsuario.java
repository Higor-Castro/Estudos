/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author alunocmc
 */
public class ControleUsuario {
    //Atrib.
    
    //Métodos
    public boolean logar(String p_usuario, String p_senha) throws ClassNotFoundException{
        Usuario usu = new Usuario();
        usu.setUsuario(p_usuario);
        usu.setSenha(p_senha);
        
        UsuarioDAO usuDAO = new UsuarioDAO();
        if (usuDAO.consultar(usu) == null){
            return false;
        }else{
            return true;
        }
    }
}
