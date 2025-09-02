/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.Conexao;

/**
 *
 * @author PTOLEDO
 */
public class ProdutoDAO {
    
    public void cadastrar(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement comando = con.prepareStatement("insert into produtos (descricao, preco) values (?,?)");
        comando.setString(1, p.getDescricao());
        comando.setDouble(2, p.getPreco());
        comando.execute();
        con.close();
    }

    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement comando = con.prepareStatement("select * from produtos");
        ResultSet rs = comando.executeQuery();

        List<Produto> lprod = new ArrayList<Produto>();
        while (rs.next()) {
            Produto prod = new Produto();
            prod.setId(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setPreco(rs.getDouble("preco"));
            lprod.add(prod);
        }
        return lprod;
    }

    public void deletar(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement comando = con.prepareStatement("delete from produtos where id = ?");
        comando.setInt(1, p.getId());
        comando.execute();
        con.close();
    }

    public void atualizar(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement comando = con.prepareStatement("update produtos set descricao = ?, preco = ? where id = ?");
        comando.setString(1, p.getDescricao());
        comando.setDouble(2, p.getPreco());
        comando.setInt(3, p.getId());
        comando.execute();
        con.close();
    }

    public Produto consultarById(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement comando = con.prepareStatement("select * from produtos where id = ?");
        comando.setInt(1, p.getId());
        ResultSet rs = comando.executeQuery();
        Produto prod = new Produto();
        if (rs.next()) {
            prod.setId(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setPreco(rs.getDouble("preco"));
        }
        return prod;
    }
}
