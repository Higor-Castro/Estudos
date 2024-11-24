
public class Produto {
    public String descriçao;
    public String marca;
    private int qtestoque;
    private double valor;
    
    public int getqtestoque (){
        return this.qtestoque;
    }
    public void setqtestoque (int qt){
        this.qtestoque=qt;
    }
    public double getvalor(){
        return this.valor;
    }
    public void setvalor (double vl){
        this.valor=vl;
    }
    public double CalcDesc(){
        if (this.qtestoque<50){
            return this.valor*0.90;
        }
        else{
            return this.valor;
        }
    }
}
