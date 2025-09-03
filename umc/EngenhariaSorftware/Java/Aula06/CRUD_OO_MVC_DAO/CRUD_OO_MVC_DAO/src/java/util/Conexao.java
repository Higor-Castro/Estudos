/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PTOLEDO
 */
public class Conexao {

    /**
     * Este método cria conexão com Postgres
     *
     * @return Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConexaoPostgres() throws ClassNotFoundException, SQLException {
        //Carregar Driver  e criar conexao
        String DRIVER = "org.postgresql.Driver";
        String URL = "jdbc:postgresql://localhost:5432/nome do seu banco";
        String USER = "";
        String PASSWORD = "";
        Class.forName(DRIVER);
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;
    }

    /**
     * Este método cria conexão com MySQL
     *
     * @return Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConexaoMySQL() throws ClassNotFoundException, SQLException {
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/nome do seu banco";
        String USER = "";
        String PASSWORD = "";
        Class.forName(DRIVER);
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;
    }

}
