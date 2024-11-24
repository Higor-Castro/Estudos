package model.dao;

import model.Cadastro;
import util.ConectaBanco;
import java.sql.*;

public class CadastroDAO {
    // Método para inserir um novo cadastro no banco de dados
    public boolean consultar(Cadastro p_usuario) throws ClassNotFoundException {
        Connection conexao = null;  // Criação da variável para a conexão com o banco de dados
        try {
            // Estabelece a conexão com o banco de dados
            conexao = ConectaBanco.conectar();
            Statement stmt = conexao.createStatement();    
            
            // Comando SQL para inserir os dados do usuário no banco de dados
            String sql = "Insert INTO usuarios(nome, email, telefone, senha, cpf) VALUES ('" + p_usuario.getNome() +
                                                                                   "', '" + p_usuario.getEmail() +
                                                                                   "', '" + p_usuario.getTelefone() + 
                                                                                    "','" + p_usuario.getSenha() + 
                                                                                    "','"+ p_usuario.getCpf()+ "')";
            // Executa o comando SQL, que realiza a inserção no banco de dados
            stmt.executeUpdate(sql);
            return true;  // Retorna true caso a operação seja bem-sucedida
        } catch (SQLException ex) {
            // Captura e exibe qualquer erro ocorrido durante a execução da consulta
            System.out.println("Erro:" + ex);
            return false;  // Retorna false em caso de erro
        }
    }

    // Método para consultar um cadastro no banco de dados com base no CPF
    public Cadastro consultaCadastro(Cadastro cadastro) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConectaBanco.conectar(); // Estabelece a conexão com o banco de dados
            
            // SQL que seleciona as informações do usuário (exceto senha) baseado no CPF
            String sql = "SELECT cpf, nome, email, telefone " +
                         "FROM usuarios " +
                         "WHERE usuarios.cpf = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cadastro.getCpf()); // Define o CPF do cadastro no parâmetro do SQL
            
            rs = stmt.executeQuery(); // Executa a consulta no banco de dados
            
            if (rs.next()) { 
                // Se um registro for encontrado, preenche os dados do cadastro
                cadastro.setCpf(rs.getString("cpf"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setEmail(rs.getString("email"));
                cadastro.setTelefone(rs.getString("telefone"));
                return cadastro; // Retorna o objeto Cadastro preenchido com os dados encontrados
            } else {
                return null; // Retorna null se não encontrar nenhum registro
            }
        } catch (SQLException ex) {
            // Exibe o erro caso a consulta falhe
            System.out.println("Erro ao consultar cadastro: " + ex);
            return null; // Retorna null caso ocorra um erro
        } finally {
            // Fechamento dos recursos (ResultSet, PreparedStatement e Connection)
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar recursos: " + ex);
            }
        }
    }

    // Método para alterar um cadastro existente no banco de dados
    public boolean alterarCadastro(Cadastro novosDados) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = ConectaBanco.conectar(); // Estabelece a conexão com o banco de dados
            
            // SQL que atualiza os dados do usuário com base no CPF
            String sql = "UPDATE usuarios SET nome = ?, email = ?, telefone = ?, senha = ? WHERE cpf = ?";
            
            stmt = conexao.prepareStatement(sql);
            // Define os valores que serão atualizados
            stmt.setString(1, novosDados.getNome());
            stmt.setString(2, novosDados.getEmail());
            stmt.setString(3, novosDados.getTelefone());
            stmt.setString(4, novosDados.getSenha());
            stmt.setString(5, novosDados.getCpf()); // CPF do usuário que será atualizado
            
            // Executa a atualização
            int linhasAfetadas = stmt.executeUpdate();
            
            // Retorna true se ao menos uma linha foi afetada pela atualização
            return linhasAfetadas > 0;
        } catch (SQLException ex) {
            // Exibe erro caso ocorra algum problema durante a alteração
            System.out.println("Erro ao alterar cadastro: " + ex);
            return false; // Retorna false caso haja erro
        } finally {
            // Fechamento dos recursos (PreparedStatement e Connection)
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar recursos: " + ex);
            }
        }
    }

    // Método para excluir um cadastro com base no CPF
    public boolean excluirCadastro(Cadastro cadastro) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConectaBanco.conectar(); // Estabelece a conexão com o banco de dados

            // SQL para excluir um usuário baseado no CPF
            String sql = "DELETE FROM usuarios WHERE cpf = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cadastro.getCpf()); // Substitui o parâmetro de forma segura pelo CPF do usuário

            // Executa a exclusão e retorna o número de linhas afetadas
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Retorna true se ao menos uma linha foi excluída
        } catch (SQLException ex) {
            // Exibe erro caso ocorra algum problema durante a exclusão
            System.err.println("Erro ao excluir cadastro: " + ex.getMessage());
            return false; // Retorna false caso haja erro
        } finally {
            // Fechamento dos recursos (PreparedStatement e Connection)
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar recursos: " + ex.getMessage());
            }
        }
    }
}
