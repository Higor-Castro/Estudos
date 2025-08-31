import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ControleProduto {
    ResultSet rs;
    PreparedStatement sql;
    Statement comando;
    Connection conexao;
    
    Produto produto = new Produto();
    
    public void Conexao(){
        try{
            // Variáveis para criar conexão com banco de dados
            String nomeservidor = "sql10.freesqldatabase.com";
            String nomebanco = "sql10736407";
            String nomeusuario = "sql10736407";
            String senha= "PZe73t13tg";
            // especificação do driver a ser utilizado
            String nomedriver = "com.mysql.cj.jdbc.Driver";
            // ativa o driver
            Class.forName(nomedriver);
            // Criando a conexão ao Banco de dados
            String url = "jdbc:mysql://"+nomeservidor+"/"+nomebanco+"?useTimezone=true&serverTimezone=UTC";
            conexao=DriverManager.getConnection(url,nomeusuario,senha);
            comando = conexao.createStatement();
            
        }
        catch (ClassNotFoundException e)
	     {
	       JOptionPane.showMessageDialog(null,"Driver não encontrado!");
             }
        catch (Exception e){
               JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados ");
        }
    }
    
    public void cadastroProduto(int idProd, String nomeProd, double precoProd, int qndProd){
        // inserindo o valor dos parametros no sets
        produto.setId(idProd);
        produto.setNome(nomeProd);
        produto.setPreco(precoProd);
        produto.setQuantidadeEstoque(qndProd);
        
        // Inserindo valor a o banco 
        try{
        sql = conexao.prepareStatement("Insert into estoque_produto (id,nome,preco,quantidade)" + 
                "values (?,?,?,?)");
        sql.setInt(1,produto.getId());
        sql.setString(2,produto.getNome());
        sql.setDouble(3,produto.getPreco());
        sql.setDouble(4,produto.getQuantidadeEstoque());
        int reg = sql.executeUpdate();
        
        // verrificar se a valor no banco
        if(reg!= 0){
            JOptionPane.showMessageDialog(null,"Dados Cadastrador com sucesso!!");
        }
        else{
            JOptionPane.showMessageDialog(null,"Erro ao Cadastradar !!");
        }
        }
        //Teste de conexão ao banco de dados 
        catch(Exception e){
            JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados !! ");
        }
    }
    
    public void alterarProduto (int idProd,String nomeProd, double precoProd , int qndProd){
         
        try {
            // inserindo os valores novos para atualização do banco do dados 
            sql = conexao.prepareStatement("update estoque_produto set nome='"+ nomeProd + "',preco='"+ precoProd +"',quantidade='"+ qndProd+"' where id="+idProd);
            int verifica = sql.executeUpdate();
            //varrifica se a valor valor no banco
            if(verifica >0){
                JOptionPane.showMessageDialog(null," Produto alterado com sucesso!!!!!");
            }
            // se não existir reporta um erro 
            else{
                JOptionPane.showMessageDialog(null," Produto não alterado!!!!!");
            }
        }
        //Verreificando se a conexão com banco de dados 
        catch(Exception e){
            JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados!!!!");
        }
    }
    
    public void ExcluirProduto (int idProd){
        try{
            // Buscando o valor Excluir 
            sql = conexao.prepareStatement("delete from estoque_produto where id="+ idProd);
            int verificar = sql.executeUpdate();
            //verrificando se a valor no banco de dados
            if(verificar >0){
                JOptionPane.showMessageDialog(null," Produto Excluido com sucesso!!!!!");
            }
            // se não existir reporta erro
            else{
                JOptionPane.showMessageDialog(null," Produto não exclui!!!!!");
            }
        }
        //testando conexão com banco de dados
        catch(Exception e){
            JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados ");
        }

    }

    public void listar(){
            try{
                // Selecinando o valor para poder listar
                sql= conexao.prepareStatement("Select * from estoque_produto");
                rs=sql.executeQuery();
                while(rs.next()){
                    System.out.println(" ID: " + rs.getString("id")+ "; Nome: " + rs.getString("nome")+ "; Quantidade: " + 
                    rs.getString("quantidade")+ "; Preco: " + rs.getString("preco"));
        }
        }
            // Testando conexão com banco de dados
            catch(Exception e){
                JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados ");
        }

    }
    
    public String ConsultarProduto(int idProd){
        String dados = "";
        try{ 
            //buscando valor para realizar a consulta
            sql = conexao.prepareStatement("Select * from estoque_produto where id = ? ");
            sql.setInt(1, idProd);
            rs = sql.executeQuery();
            if(rs.next()){
                dados += rs.getString("nome");
                dados += ";";
                dados += rs.getString("quantidade");
                dados += ";";
                dados += rs.getString("preco");
            }
            // caso não escontrar o valor reporta erro
            else{
                JOptionPane.showMessageDialog(null," ID não encontrado!!");
            }
            
        }
        // Testando conexão com banco de daos 
        catch(Exception e){
            JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados ");
        }
        return dados;
    }
    
    public double venda (double troco, double preco){
        if(troco > preco){
           return troco - preco;
        }
        else{
            JOptionPane.showMessageDialog(null,"Dinheiro Menor que o valor do produto");
        }
        return 0;
        
    }
 


}
