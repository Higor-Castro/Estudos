
import javax.swing.JOptionPane;




public class hospede {
    public String nome;
    public String cpf;
    public int idade;
    public double numDependentes;
    
    public void Cadastrar(){
        this.nome=JOptionPane.showInputDialog("Digite o nome ");
        this.cpf=JOptionPane.showInputDialog("Digite o cpf ");
        this.idade=Integer.parseInt(JOptionPane.showInputDialog("Digite a idade "));
        this.numDependentes =Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de Dependentes: "));
        JOptionPane.showMessageDialog(null,"Dados Cadastrados com Sucesso !!!");
    }
    
    public void Exibir(){
        JOptionPane.showMessageDialog(null,"Nome: "+this.nome+
                "\nCpf: "+this.cpf+"\nIdade: "+this.idade+"\nNumero dependentes: "+this.numDependentes);
    }
    
    
}
