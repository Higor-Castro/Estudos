package util;

import java.sql.*;

public class ConectaBanco {
    // Método responsável por estabelecer a conexão com o banco de dados
    public static Connection conectar() throws ClassNotFoundException {
        Connection conexao = null;  // Objeto que armazenará a conexão com o banco
        try {
            // Carrega o driver MySQL necessário para realizar a conexão
            Class.forName("com.mysql.cj.jdbc.Driver");  // Nome correto do driver
            
            // Estabelece a conexão com o banco de dados usando o JDBC e as credenciais fornecidas
            conexao = DriverManager.getConnection(
                "jdbc:mysql://sql10.freesqldatabase.com/sql10736407?useTimezone=true&serverTimezone=UTC",  // URL do banco de dados
                "sql10736407",  // Nome de usuário para acessar o banco
                "PZe73t13tg"    // Senha para acessar o banco
            );
            return conexao;  // Retorna o objeto Connection se a conexão for bem-sucedida
        } catch (SQLException ex) {
            // Captura e exibe erros relacionados à conexão com o banco de dados
            System.out.println("Error connecting to database: " + ex.getMessage());
            throw new RuntimeException("Connection error!", ex);  // Lança uma exceção em caso de erro
        }
    }
}
