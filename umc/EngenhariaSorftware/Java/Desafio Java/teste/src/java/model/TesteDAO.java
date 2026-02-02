/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author higor
 */
public class TesteDAO {
    
    public boolean cadastrar(Num num) throws ClassNotFoundException, SQLException{
        try (Connection con = Conexao.conectar()) {
            String sql = "INSERT INTO testes (n1,n2)" 
                    + "VALUES (?,?)";
            PreparedStatement comando = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            comando.setInt(1, num.getN1());
            comando.setInt(2, num.getN2());
            
            comando.executeUpdate();
            
            comando.close();
            return true;
            
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
            return false;
        }
        
    }
    
}
