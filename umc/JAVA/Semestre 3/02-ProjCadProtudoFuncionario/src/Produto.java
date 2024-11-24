import javax.swing.JOptionPane;

public class Produto {
    public String nome;
    public int codigo;
    public String marca;
    public double valor;
    

    public void Cadastrar (String nome, int codigo,String marca,double valor){
        this.nome = nome;
        this.codigo = codigo;
        this.marca = marca;
        this.valor = valor;
        JOptionPane.showMessageDialog(null,"Dados Cadastrados com Sucesso !!!");
    }

    public void Exibir (){
        JOptionPane.showMessageDialog(null, "Marca: " + this.marca + "\n Nome do Produto: "+ this.nome +  "\n Codigo: " + this.codigo + "\n Valor: " + this.valor );
    }
}
