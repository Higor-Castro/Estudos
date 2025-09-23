/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.Usuario;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author higor
 */
public class UsuarioDao {
    
    public boolean cadastrar(Usuario usuario) throws ClassNotFoundException {
        String sql = "INSERT INTO usuarios (registro, nome, email, cargo, departamento) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexao.conectar();
             PreparedStatement comando = con.prepareStatement(sql)) {

            comando.setString(1, usuario.getRegistro());
            comando.setString(2, usuario.getNome());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getCargo());
            comando.setString(5, usuario.getDepartamento());
            

            comando.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar usuário: " + ex.getMessage());
            return false;
        }
    }



    public Usuario consultarByRegistro(String registro) throws ClassNotFoundException, SQLException {

       String sql = "SELECT * FROM usuarios WHERE registro = ?";

       try (Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

           ps.setString(1, registro);

           try (ResultSet rs = ps.executeQuery()) {
               if (rs.next()) {
                   return Usuario.builder()
                           .comRegistro(rs.getString("registro"))
                           .comNome(rs.getString("nome"))
                           .comCargo(rs.getString("cargo"))
                           .comDepartamento(rs.getString("departamento"))
                           .comEmail(rs.getString("email"))
                           .constroi();
               }
           }
       }

       return null; // retorna null se não encontrar
   }
    public void deletar(Connection con, String registro) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE registro = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, registro);
            ps.executeUpdate();
        }
    }





}


    



