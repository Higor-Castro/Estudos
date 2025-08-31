package model.dao;

import model.Pesquisa;
import java.sql.*;
import util.ConectaBanco;

public class PesquisaDAO {

    // Método para inserir uma nova pesquisa no banco de dados
    public boolean consultar(Pesquisa p_pesquisa) throws ClassNotFoundException {
        Connection conexao = null;  // Variável para a conexão com o banco de dados
        try {
            // Estabelece a conexão com o banco de dados
            conexao = ConectaBanco.conectar();
            Statement stmt = conexao.createStatement();    

            // Comando SQL para inserir os dados da pesquisa no banco
            String sql = "Insert INTO pesquisa(cpf, pergunta1, pergunta2, pergunta3, pergunta4, pergunta5) VALUES ('" + p_pesquisa.getCpf() +
                                                                                   "', '" +  p_pesquisa.getP1() + 
                                                                                   "', '" +  p_pesquisa.getP2() +
                                                                                   "', '" + p_pesquisa.getP3() + 
                                                                                    "','" + p_pesquisa.getP4() + 
                                                                                    "','"+ p_pesquisa.getP5() + "')";
            // Executa o comando SQL de inserção
            stmt.executeUpdate(sql); 
            return true;  // Retorna true se a operação for bem-sucedida
        } catch (SQLException ex) {
            // Captura e exibe qualquer erro durante a execução da consulta
            System.out.println("Erro:" + ex);
            return false;  // Retorna false em caso de erro
        }
    }

    // Método para consultar a pesquisa de um usuário baseado no CPF
    public Pesquisa consultaPesquisa(Pesquisa pesquisa) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConectaBanco.conectar(); // Estabelece a conexão com o banco de dados
            
            // Comando SQL para selecionar a pesquisa e o nome do usuário com base no CPF
            String sql = "SELECT pesquisa.*, usuarios.nome FROM pesquisa " +
                         "JOIN usuarios ON pesquisa.cpf = usuarios.cpf " +
                         "WHERE pesquisa.cpf = ?";
            
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisa.getCpf()); // Define o CPF no PreparedStatement
            
            rs = stmt.executeQuery(); // Executa a consulta

            if (rs.next()) {
                // Preenche os dados da pesquisa com os valores retornados
                pesquisa.setCpf(rs.getString("cpf"));
                pesquisa.setP1(rs.getInt("pergunta1"));
                pesquisa.setP2(rs.getInt("pergunta2"));
                pesquisa.setP3(rs.getInt("pergunta3"));
                pesquisa.setP4(rs.getInt("pergunta4"));
                pesquisa.setP5(rs.getInt("pergunta5"));
                pesquisa.setNome(rs.getString("nome"));
                return pesquisa; // Retorna o objeto preenchido
            } else {
                return null; // Retorna null se não encontrar registros
            }
        } catch (SQLException ex) {
            // Exibe o erro em caso de falha na consulta
            System.out.println("Erro ao consultar pesquisa: " + ex);
            return null; // Retorna null se ocorrer erro
        } finally {
            // Fecha os recursos (ResultSet, PreparedStatement e Connection)
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar recursos: " + ex);
            }
        }
    }

    // Método para alterar os dados de uma pesquisa no banco de dados
    public boolean alterarPesquisa(Pesquisa novosDados) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = ConectaBanco.conectar(); // Estabelece a conexão com o banco de dados

            // Comando SQL para atualizar os dados da pesquisa com base no CPF
            String sql = "UPDATE pesquisa SET pergunta1 = ?, pergunta2 = ?, pergunta3 = ?, pergunta4 = ?, pergunta5 = ? WHERE cpf = ?";

            stmt = conexao.prepareStatement(sql);
            // Define os valores a serem atualizados
            stmt.setInt(1, novosDados.getP1());
            stmt.setInt(2, novosDados.getP2());
            stmt.setInt(3, novosDados.getP3());
            stmt.setInt(4, novosDados.getP4());
            stmt.setInt(5, novosDados.getP5());
            stmt.setString(6, novosDados.getCpf()); // CPF do usuário a ser alterado

            // Executa a atualização
            int linhasAfetadas = stmt.executeUpdate();
            
            // Retorna true se pelo menos uma linha foi atualizada
            return linhasAfetadas > 0;
        } catch (SQLException ex) {
            // Exibe erro caso a alteração falhe
            System.out.println("Erro ao alterar pesquisa: " + ex);
            return false; // Retorna false em caso de erro
        } finally {
            // Fecha os recursos (PreparedStatement e Connection)
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar recursos: " + ex);
            }
        }
    }

    // Método para excluir uma pesquisa no banco de dados baseado no CPF
    public boolean excluirPesquisa(Pesquisa pesquisa) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConectaBanco.conectar(); // Estabelece a conexão com o banco de dados

            // Comando SQL para excluir uma pesquisa com base no CPF
            String sql = "DELETE FROM pesquisa WHERE cpf = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisa.getCpf()); // Define o CPF no parâmetro

            // Executa a exclusão
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Retorna true se ao menos uma linha foi excluída
        } catch (SQLException ex) {
            // Exibe erro em caso de falha na exclusão
            System.err.println("Erro ao excluir pesquisa: " + ex.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            // Garante o fechamento dos recursos (PreparedStatement e Connection)
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar recursos: " + ex.getMessage());
            }
        }
    }
}
