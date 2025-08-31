
import javax.swing.JOptionPane;


public class ControleLogin {
    Usuario usu = new Usuario ();
    
    
    public void logar ( String log , int senha) {
            usu.login = log;
            usu.senha = senha;
            boolean analisar = usu.validar();
            if(analisar == true) {
                new FormSistema().setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"Login/Senha Incorretos!!!");
                new FromLoginSenha().setVisible(true);
            }
    }
}
