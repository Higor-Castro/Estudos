
public class Assalariado extends Empregado {
   public double salario;
   public double desconto;
    
    public double CalcSal(){
        return this.salario - this.desconto;
    }     
}
