/*
 * Nome: Henrique dos Santos Ferreira        RGM: 11231102428
 * Nome: Higor de Castro Venancio da Silva   RGM: 11231102199
 */
public class Imovel {
    public String tipo;
    public String endereço;
    private String nome_proprietario;
    private double valor_aluguel;
    
    public String getNome_proprietario(){
        return this.nome_proprietario;
    }
    public void setNome_proprietario(String nm){
        this.nome_proprietario = nm;
    }
    
    
    public double getValor_aluguel(){
        return this.valor_aluguel;
    }
    public void setValor_aluguel(double vl){
        this.valor_aluguel = vl;
    }

    public double calcValor() {
        switch (this.tipo) {
            case "campo":
                {
                    double descontoPorcentual = (this.valor_aluguel * 10) / 100;
                    return this.valor_aluguel - descontoPorcentual;
                }
            case "praia":
                {
                    double descontoPorcentual = (this.valor_aluguel * 10) / 100;
                    return this.valor_aluguel + descontoPorcentual;
                }
            default:
                return this.valor_aluguel;
        }
    }


}
