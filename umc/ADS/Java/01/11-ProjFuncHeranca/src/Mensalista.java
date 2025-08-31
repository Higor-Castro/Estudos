public class Mensalista extends Funcionario {
    
    public double proventos;
    public double descontos;
    
    public double calcSal (){
        return (this.proventos - this.descontos);
    }
    
}
