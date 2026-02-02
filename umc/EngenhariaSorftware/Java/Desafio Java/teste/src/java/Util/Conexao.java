/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author higor
 */
public class Conexao {
    public static Connection conectar() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String URL = "jdbc:mysql://localhost:3306/teste?useUnicode=true&characterEncoding=UTF-8";
        String User = "root";
        String Password = "Mortadela.1";
       
        return DriverManager.getConnection(URL, User, Password);
    }
}
