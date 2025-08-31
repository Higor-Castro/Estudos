
import javax.swing.JOptionPane;


public class Principal {

    public static void main(String[] args) {
        Funcionario funcionario= new Funcionario();
        funcionario.nome="Li mamei hihihi";
        funcionario.registro=24;
        funcionario.setSetor("Produção");
        funcionario.setCargo("Escravo");
        funcionario.setSalario(171);
        funcionario.setTelefone(40028922);
        funcionario.setFilial("Biqueira da vilinha");
        funcionario.setFilhos(4);
        funcionario.setCidade("Itaquaquistão");
        JOptionPane.showMessageDialog(null,"Nome: "+funcionario.nome+
                "\nRegistro:"+funcionario.registro+
                "\nSetor:"+funcionario.getSetor()+
                "\nCargo:"+funcionario.getCargo()+
                "\nSalario:"+funcionario.getSalario()+
                "\nTelefone:"+funcionario.getTelefone()+
                "\nFilial:"+funcionario.getFilial()+
                "\nFilhos:"+funcionario.getFilhos()+
                "\nCidade:"+funcionario.getCidade());
        
    }
    
}
