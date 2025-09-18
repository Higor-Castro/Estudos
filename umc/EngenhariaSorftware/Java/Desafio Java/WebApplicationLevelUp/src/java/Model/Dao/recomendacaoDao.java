/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.Recomendacao;
import Model.Meta;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author higor
 */


public class recomendacaoDao {
        // Metodo que vai inserir o cadastro no Banco
    public boolean cadastrar(Recomendacao recomendacao) throws ClassNotFoundException, SQLException {
        try {
            Connection con = Conexao.conectar();
            
            // Busca o MetaId pelo registro informado
     
            
            PreparedStatement comando = con.prepareStatement(
            "INSERT INTO recomendacoes (id_meta, titulo, descricao, urlCurso, etapa) " +
            "VALUES (?, ?, ?, ?, ?)"
        );

        comando.setInt(1, recomendacao.getMetaId());
        comando.setString(2, recomendacao.getTitulo());
        comando.setString(3, recomendacao.getDescricao());
        comando.setString(4, recomendacao.getUrlCurso());
        comando.setInt(5, recomendacao.getEtapa());


            comando.execute();
            con.close();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return false;
        }
    }
    

    
}
