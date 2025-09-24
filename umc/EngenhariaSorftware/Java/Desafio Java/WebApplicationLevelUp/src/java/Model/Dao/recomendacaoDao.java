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
import java.util.ArrayList;
import java.util.List;

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
    

    // Consulta todas as recomendações de uma meta específica
    public List<Recomendacao> consultarByMetaId(int MetaId) throws ClassNotFoundException, SQLException {
        List<Recomendacao> recomendacoes = new ArrayList<>();

        String sql = "SELECT * FROM recomendacoes WHERE id_meta = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            
            ps.setInt(1, MetaId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Recomendacao r = Recomendacao.builder()
                            .comTitulo(rs.getString("titulo"))
                            .comDescricao(rs.getString("descricao"))
                            .comUrlCurso(rs.getString("urlCurso"))
                            .comEtapa(rs.getInt("etapa"))
                            .comId(rs.getInt("id"))
                            .comMetaId(rs.getInt("id_meta"))
                            .constroi();
                    recomendacoes.add(r);
                }
            }
        }

        return recomendacoes;
    }
    
    public void deletar(Connection con, int metaId) throws SQLException {
        String sql = "DELETE FROM recomendacoes WHERE id_meta = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, metaId);
            ps.executeUpdate();
        }
    }
    
    
    public boolean atualizar(Recomendacao recomendacao) throws ClassNotFoundException, SQLException {
         try {
            Connection con = Conexao.conectar();
            PreparedStatement comando = con.prepareStatement("update recomendacoes set titulo = ?, descricao = ?, urlCurso = ? where id = ?");
            comando.setString(1, recomendacao.getTitulo());
            comando.setString(2, recomendacao.getDescricao());
            comando.setString(3, recomendacao.getUrlCurso());
            comando.setInt(4, recomendacao.getId());
            comando.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return false;
        }
    } 







  
}
