/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.Usuario;
import util.ConectaDB;
import java.sql.*;

/**
 *
 * @author alunocmc
 */
public class UsuarioDAO {
    // Atrib.
    
    //Método
    public boolean insUsu(Usuario p_usuario) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
                        //Insert INTO usuarios(login, fone, email, senha) VALUES ("ana", "(11)95577-1144", "ana@uol.com","123456");         
            String sql = "Insert INTO usuarios(login, fone, email, senha) VALUES ('" + p_usuario.getLogin() +
                                                                                   "', '" + p_usuario.getFone() +
                                                                                   "', '" + p_usuario.getEmail() + 
                                                                                    "','" + p_usuario.getSenha() + "')";
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return false;
        }
    }
}
