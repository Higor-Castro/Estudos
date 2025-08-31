
import javax.swing.JOptionPane;


public class main {

    public static void main(String[] args) {
        
         hospede hospede= new hospede();
         hospedagem hospedagem = new hospedagem();
    
        int cont = 0;
        while (cont != 4){
             String opcao = JOptionPane.showInputDialog(null,"Digite a opção desejada: "
                    + "\n 1- Cadastrar Hospede: " + "\n 2- Exibir hospedes Cadastrados: " + 
                    "\n 3- Total a pagar : " + "\n 4- Sair: ");
             cont = Integer.parseInt(opcao);
            switch (cont){
                case 1:
                   hospede.Cadastrar();
                   break;
                
                case 2:
                    hospede.Exibir();
                    break;
                
                case 3:
                    hospedagem.calcularDesconto(hospedagem.calcularTotal());
                    break;
                case 4:
                      JOptionPane.showMessageDialog(null," Saindo.... ");
                      break;
                    
                    
            }

        
        }
   
       

        
        
        
       
        
 
    }
    
}

