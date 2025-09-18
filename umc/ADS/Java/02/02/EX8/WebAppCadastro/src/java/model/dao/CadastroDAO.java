package model.dao;

import model.Usuario;
import util.ConectaBanco;
import java.sql.*;
/**
 *
 * @author Higor Castro, Henrique Santos 
 * 
 * Classe CadastroDAO para manipular operações de inserção no banco de dados.
 */
public class CadastroDAO {
    // Atributos
    // (Nenhum atributo declarado explicitamente nesta classe)

    // Método que realiza a consulta e inserção de um usuário no banco de dados
    public boolean consultar(Usuario p_usuario) throws ClassNotFoundException{
        Connection conexao = null;  // Conexão com o banco de dados
        try{
            // Estabelece a conexão com o banco de dados
            conexao = ConectaBanco.conectar();
            Statement stmt = conexao.createStatement();    
            
            // Comando SQL para inserir os dados do usuário no banco
            String sql = "Insert INTO usuarios(nome, email, telefone, senha, cpf) VALUES ('" + p_usuario.getNome() +
                                                                                   "', '" + p_usuario.getEmail() +
                                                                                   "', '" + p_usuario.getTelefone() + 
                                                                                    "','" + p_usuario.getSenha() + 
                                                                                    "','"+ p_usuario.getCpf()+ "')";
            // Executa o comando SQL
            stmt.executeUpdate(sql); // Executa a inserção (ou exclusão/atualização)
            return true;  // Retorna true se a operação foi bem-sucedida
        }catch(SQLException ex){
            // Captura e exibe qualquer erro que possa ocorrer durante a execução da consulta
            System.out.println("Erro:" + ex);
            return false;  // Retorna false caso ocorra algum erro
        }
    }
}
