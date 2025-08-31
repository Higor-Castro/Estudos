
public class Autonomo extends Funcionario {
    public double vlHora;
    public double numHoras;
    
    public double calcSal (){
        return (this.vlHora * this.numHoras);
    }

}
