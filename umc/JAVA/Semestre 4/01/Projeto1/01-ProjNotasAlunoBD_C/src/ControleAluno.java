
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ControleAluno {
    ResultSet rs;
    PreparedStatement sql;
    Statement comando;
    Connection conexao;
    
    Aluno aluno = new Aluno();
   
    public void Conexao(){
        try{
            // Variáveis com os dados da conexão ao BD
            String nomeservidor = "localhost:3306";
            String nomebanco = "notasalunosbd";
            String nomeusuario = "root";
            String senha= "";
            // especificação do driver a ser utilizado
            String nomedriver = "com.mysql.cj.jdbc.Driver";
            // ativa o driver
            Class.forName(nomedriver);
            // Criando a conexão ao Banco
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
    
    
    
    public void Cadastrar(int numrgm, String nm, double n1, double n2){
        aluno.setRgm(numrgm);
        aluno.setNome(nm);
        aluno.setNota1(n1);
        aluno.setNota2(n2);
        
        // Inserindo valor a o banco 
        try{
        sql = conexao.prepareStatement("Insert into alunos (rgm,nome_aluno,nota1,nota2)" + 
                "values (?,?,?,?)");
        sql.setInt(1,aluno.getRgm());
        sql.setString(2,aluno.getNome());
        sql.setDouble(3,aluno.getNota1());
        sql.setDouble(4, aluno.getNota2());
        int reg = sql.executeUpdate();
        
        // verrificar se a valor no banco
        if(reg!= 0){
            JOptionPane.showMessageDialog(null,"Dados Cadastrador com sucesso!!");
        }
        else{
            JOptionPane.showMessageDialog(null,"Erro ao Cadastradar !!");
        }
        }
        //Teste deconexão ao banco de dados 
        catch(Exception e){
            JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados ");
        }
    }
    
    public void listar(){
            try{
                sql= conexao.prepareStatement("Select * from Alunos");
                rs=sql.executeQuery();
                while(rs.next()){
                    System.out.println(" Registro: " + rs.getString("rgm")+ " Nome: " + rs.getString("nome_aluno")+ " Nota1: " + 
                    rs.getString("nota1")+ " Nota2: " + rs.getString("nota2"));
        }
        }
            catch(Exception e){
                JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados ");
        }
}
    public String Consultar(int rgm){
        String dados = "";
        try{
            sql = conexao.prepareStatement("Select * from alunos where rgm = ? ");
            sql.setInt(1, rgm);
            rs = sql.executeQuery();
            if(rs.next()){
                dados += rs.getString("nome_aluno");
                dados += ";";
                dados += rs.getString("nota1");
                dados += ";";
                dados += rs.getString("nota2");
            }
            else{
                JOptionPane.showMessageDialog(null," RGM não enconrado!!");
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados ");
        }
        return dados;
    }
    
    public void Alterar (int numrgm, String nm, double n1, double n2){
        try {
            sql = conexao.prepareStatement("update alunos set nome_aluno='"+ nm + "',nota1='"+n1+"',nota2='"+n2+"' where rgm="+numrgm);
            int verifica = sql.executeUpdate();
            if(verifica >0){
                JOptionPane.showMessageDialog(null," Regiro alterado com sucesso!!!!!");
            }
            else{
                JOptionPane.showMessageDialog(null," Regiro não alterado!!!!!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados ");
        }
    }
    
    
    public void Excluir (int numrgm){
        try{
            sql = conexao.prepareStatement("delete from alunos where rgm="+ numrgm);
            int verificar = sql.executeUpdate();
            if(verificar >0){
                JOptionPane.showMessageDialog(null," Regiro Excluido com sucesso!!!!!");
            }
            else{
                JOptionPane.showMessageDialog(null," Regiro não exclui!!!!!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null," Erro ao conectar o Banco de Dados ");
        }

    }
    public double CalcularMedia(double n1, double n2){
            return (n1+n2)/2;
    
    }

     
}

