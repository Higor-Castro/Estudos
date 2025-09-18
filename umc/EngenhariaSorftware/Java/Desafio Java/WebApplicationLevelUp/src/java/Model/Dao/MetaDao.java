/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

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
public class MetaDao {
          // Metodo que vai inserir o cadastro no Banco
    public boolean cadastrar(Meta meta) throws ClassNotFoundException, SQLException {
    try (Connection con = Conexao.conectar()) {
        String sql = "INSERT INTO metas (titulo, descricao, etapas, etapaAtual, registro_usuario, dataCriacao, progresso, frequencia) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement comando = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        comando.setString(1, meta.getTitulo());
        comando.setString(2, meta.getDescricao());
        comando.setInt(3, meta.getEtapas());
        comando.setInt(4, meta.getEtapaAtual());
        comando.setString(5, meta.getUsuario().getRegistro());
        comando.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
        comando.setInt(7, meta.getProgresso());
        comando.setString(8, meta.getFrequencia());

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
}
