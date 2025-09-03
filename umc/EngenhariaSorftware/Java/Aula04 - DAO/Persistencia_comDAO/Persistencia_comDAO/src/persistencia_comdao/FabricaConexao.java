/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia_comdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PTOLEDO
 */
public class FabricaConexao {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        //Verificar em seu computador
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/ nome do seu banco"; //Verificar em seu computador
        String USERNAME = ""; //Verificar em seu computador
        String PASSWORD = ""; //Verificar em seu computador
        
        // O método forName carrega e inicia o driver passado por parâmetro
        Class.forName(DRIVER);
        // Estabelecendo a conexão
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
