    import javax.swing.JOptionPane;

public class Professor {
    public String nome;
    public int idade;
    public int matricula;
    public double salario;
    
    public void Cadastrar(String nm,int id,int matricula,double salario){
        this.nome=nm;
        this.idade=id;
        this.matricula = matricula;
        this.salario= salario;
        JOptionPane.showMessageDialog(null,"Dados Cadastrados com Sucesso !!!");
    }
    
    public void Exibir(){
        JOptionPane.showMessageDialog(null,"Nome: "+this.nome+
                "\nIdade: "+this.idade+"\nRGM: "+this.matricula+"\nValor mensalidade: "+this.salario);
    }
    
}
