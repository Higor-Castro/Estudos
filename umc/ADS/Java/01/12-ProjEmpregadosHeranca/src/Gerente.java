public class Gerente extends Empregado {
    public double salario;
    public double gratificacao;
    
    public double CalcSal(){
        return this.salario + this.gratificacao;
    } 
}
