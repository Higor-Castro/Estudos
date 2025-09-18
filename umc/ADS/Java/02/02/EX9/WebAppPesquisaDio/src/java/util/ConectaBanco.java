package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {

    // Método para estabelecer a conexão com o banco de dados MySQL
    public static Connection conectar() throws ClassNotFoundException {
        Connection conexao = null;
        try {
            // Carrega o driver MySQL JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Informações de conexão
            String url = "jdbc:mysql://sql3.freesqldatabase.com/sql3738477?useTimezone=true&serverTimezone=UTC";
            String usuario = "sql3738477";
            String senha = "94NqH4xhpj";

            // Estabelece a conexão
            conexao = DriverManager.getConnection(url, usuario, senha);

            return conexao;  // Retorna a conexão estabelecida

        } catch (SQLException ex) {
            // Exibe mensagem de erro no console e lança uma exceção de runtime
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
            throw new RuntimeException("Erro de conexão!", ex);
        }
    }
}
