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
        // Método responsável por estabelecer a conexão com o banco de dados
    public static Connection conectar() throws ClassNotFoundException, SQLException {
        // MySQL
        // O método forName carrega e inicia o driver passado por parâmetro
        Class.forName("com.mysql.cj.jdbc.Driver");

        // URL com UTF-8
        String URL = "jdbc:mysql://localhost:3306/levelUp?useUnicode=true&characterEncoding=UTF-8";

        String USER = "root";
        String PASSWORD = "Mortadela.1";

        // Estabelecendo a conexão
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}
