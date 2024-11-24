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
    //Atrib.
    
    //Métodos
    public Usuario consultar(Usuario p_usuario) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //              
            String sql = "SELECT * FROM usuarios where usuario = '" + p_usuario.getUsuario() + "' and senha = '" + p_usuario.getSenha() + "'";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar
            
            int n_req = 0;
            while (rs.next()) {                
                n_req++;
            }
            conexao.close();
           
            if (n_req==0){
                return null;
            }else{
                return p_usuario;
            }                          
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
        }
        
        return p_usuario;
    }
}
