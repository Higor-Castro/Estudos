import javax.swing.JOptionPane;

public class Funcionario {
    public String nome;
    public int idade;
    public String cargo;
    public double salario;

    public void Cadastrar (String nome, int idade , String cargo, double salario){

        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void Exibir(){
        JOptionPane.showMessageDialog(null, "Nome: " + nome + " \n Idade:" + idade + "\n Cargo: " + cargo + "\n Salario: " + sa);
    }
}
