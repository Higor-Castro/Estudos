import javax.swing.JOptionPane;


public class hospedagem {
      public int numDias;
      public double vlDiaria;
      public  double vlConsumo;
      public double vlDiverso ;


    public double calcularTotal(){
        this.numDias=Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de Dias "));
        this.vlDiaria=Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da diaria "));
        this.vlConsumo =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do consumo  "));
         this.vlDiverso  =Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor Diverso: "));

        return this.numDias * this.vlDiaria + this.vlConsumo + this.vlDiverso;

    }
    
    public void calcularDesconto( double valor){
        if (this.numDias >= 5){
            double descontoPorcentual = (valor * 10 )/ 100;
            double desconto = valor - descontoPorcentual;
             JOptionPane.showMessageDialog(null,"Você ficou " + this.numDias + " por tanto você recebeu 10% de desconto o valor a ser pago é R$ " + desconto);
        }
        else{
            JOptionPane.showMessageDialog(null,"O valor a pagar é R$" + valor);
        }
        

    }
    
}
