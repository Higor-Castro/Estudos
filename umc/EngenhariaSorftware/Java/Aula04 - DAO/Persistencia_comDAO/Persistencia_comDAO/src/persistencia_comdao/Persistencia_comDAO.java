/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia_comdao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PTOLEDO
 */
public class Persistencia_comDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ProdutoDAO pdao = new ProdutoDAO();
            Produto p = new Produto();
            p.setDescricao("Mouse sem fio ergonômico");
            p.setPreco(50);
            pdao.cadastrar(p);
            System.out.println("Cadastrado com sucesso.");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        /*
        ProdutoDAO pdao = new ProdutoDAO();
        try {
            
            
            List<Produto> lprod = pdao.consultarTodos();
            for(int i=0; i < lprod.size(); i++ ){
                Produto p = lprod.get(i);
                System.out.println("\nID..........: " + p.getId() );
                System.out.println("Decricao....: " + p.getDescricao());
                System.out.println("Preco.......: " + p.getPreco() );
            }
            
            
           
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
         */
    }

}
