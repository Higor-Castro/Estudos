
import javax.swing.JOptionPane;





public class Principal {

    public static void main(String[] args) {
        Aluno aluno =new Aluno();
        aluno.nome="li mamei";
        aluno.idade=24;
        aluno.setTel(40028922);
        aluno.setVlmens(244);
        JOptionPane.showMessageDialog(null,"Nome: "+aluno.nome + 
                "\nIdade: " +aluno.idade+
                "\nTelefone:"+aluno.getTel()+
                "\nMensalidade:"+aluno.getVlmens());
        

    }
    
}
