import javax.swing.JOptionPane;

public class Main {
        public static void main(String[] args) {
        String nome =JOptionPane.showInputDialog("Digite o nome do Produto: ");
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do Produto: "));
        String Marca = JOptionPane.showInputDialog("Digita a Marca do Protudo: ");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor do Produto: "));

        Produto produto = new Produto();
        produto.Cadastrar(nome, codigo, Marca, valor);
        produto.Exibir();

        String nomeFun = JOptionPane.showInputDialog("Digite o nome do Funcionario: ");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do Funcionario: "));
        String cargo = JOptionPane.showInputDialog("Digite o cargo:");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario: "));

        Funcionario funcionario = new Funcionario();
        funcionario.Cadastrar(nomeFun, idade, cargo, salario);
        funcionario.Exibir();



  
        }
}
