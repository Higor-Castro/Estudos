/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.Meta;
import Model.Usuario;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author higor
 */
public class MetaDao {
          // Metodo que vai inserir o cadastro no Banco
    public boolean cadastrar(Meta meta) throws ClassNotFoundException, SQLException {
    try (Connection con = Conexao.conectar()) {
        String sql = "INSERT INTO metas (titulo, descricao, etapas, etapaAtual, registro_usuario, dataCriacao, frequencia) "
                   + "VALUES ( ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement comando = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        comando.setString(1, meta.getTitulo());
        comando.setString(2, meta.getDescricao());
        comando.setInt(3, meta.getEtapas());
        comando.setInt(4, meta.getEtapaAtual());
        comando.setString(5, meta.getUsuario().getRegistro());
        comando.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
        comando.setString(7, meta.getFrequencia());

        comando.executeUpdate();

        // Pega o ID gerado e seta no objeto Meta
        ResultSet rs = comando.getGeneratedKeys();
        if (rs.next()) {
            meta.setId(rs.getInt(1));
        }

  
        comando.close();
        return true;

    } catch (SQLException ex) {
        System.out.println("Erro: " + ex.getMessage());
        return false;
    }


    }
    

    private recomendacaoDao recomendacaoDao = new recomendacaoDao();
    private UsuarioDao usuarioDao = new UsuarioDao();

    // Consulta todas as metas de um usuário pelo registro
    public List<Meta> consultarByRegistro(String registroUsuario) throws ClassNotFoundException, SQLException {
        List<Meta> listaMetas = new ArrayList<>();
        Usuario usuario = usuarioDao.consultarByRegistro(registroUsuario);

        String sql = "SELECT * FROM metas WHERE registro_usuario = ? ORDER BY dataCriacao ASC";

        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, registroUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Meta meta = Meta.builder()
                            .comId(rs.getInt("id"))
                            .comTitulo(rs.getString("titulo"))
                            .comDescricao(rs.getString("descricao"))
                            .comEtapas(rs.getInt("etapas"))
                            .comEtapaAtual(rs.getInt("etapaAtual"))
                            .comUsuario(usuario)
                            .comRecomendacoes(recomendacaoDao.consultarByMetaId(rs.getInt("id")))
                            .comDataCriacao(rs.getTimestamp("dataCriacao"))
                            .comFrequencia(rs.getString("frequencia"))
                            .constroi();

                    listaMetas.add(meta);
                }
            }
        }

        return listaMetas;
    }
    
    
    public boolean deletar(String registro, int metaId) {
        try (Connection con = Conexao.conectar()) {

            // Deleta recomendações da meta
            recomendacaoDao.deletar(con, metaId);

            // Deleta a meta
            try (PreparedStatement ps = con.prepareStatement("DELETE FROM metas WHERE id = ?")) {
                ps.setInt(1, metaId);
                if (ps.executeUpdate() == 0) return false; // meta não existe
            }

            // Deleta usuário se não tiver mais metas
            try (PreparedStatement ps = con.prepareStatement(
                    "SELECT 1 FROM metas WHERE registro_usuario = ? LIMIT 1")) {
                ps.setString(1, registro);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        usuarioDao.deletar(con, registro);
                    }
                }
            }

            return true; // tudo deletado com sucesso

        } catch (Exception e) {
            e.printStackTrace();
            return false; // erro geral
        }
    }




}
