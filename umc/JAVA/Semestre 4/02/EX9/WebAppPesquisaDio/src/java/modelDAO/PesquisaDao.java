/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;
import model.Cadastro;
import java.sql.*;
import util.ConectaBanco;

/**
 *
 * @author alunocmc
 */
public class PesquisaDao {// Atributos
    // (Nenhum atributo declarado explicitamente nesta classe)

    // Método que realiza a consulta e inserção de um usuário no banco de dados
    public boolean consultar(Cadastro p_cadastro) throws ClassNotFoundException{
        Connection conexao = null;  // Conexão com o banco de dados
        try{
            // Estabelece a conexão com o banco de dados
            conexao = ConectaBanco.conectar();
            Statement stmt = conexao.createStatement();    
            
            // Comando SQL para inserir os dados do usuário no banco
            String sql = "Insert INTO respostas_pesquisa(satisfeito, recomendaria, informacoes, seguro, novos_recurso) VALUES ('" + p_cadastro.getSatisfeito()+
                                                                                   "', '" + p_cadastro.getRecomendaria() +
                                                                                   "', '" + p_cadastro.getInformacoes()+ 
                                                                                    "','" + p_cadastro.getSeguro()+ 
                                                                                    "','"+ p_cadastro.getNovos_recursos()+ "')";
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
