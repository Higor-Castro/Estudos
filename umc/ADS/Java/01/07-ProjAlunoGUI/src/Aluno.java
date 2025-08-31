
public class Aluno {
    public String Nome;
    public int rgm;
    private int telefone;
    private double vl_mens;
    
    public int getTelefone(){
        return this.telefone;
    }
    public void setTelefone(int tel){
        this.telefone = tel;
    }
    
    
    public double getVl_mens(){
        return this.vl_mens;
    }
    public void setVl_mens(double vl_mens){
        this.vl_mens  = vl_mens;
    }
    
    public double CalcDesconto(){
       
       double desconto = this.vl_mens - ((this.vl_mens * 10 )/ 100);
       return desconto;
    }  
}
