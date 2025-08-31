 
public class Numero {
    
    public int CalcSoma(int n1,int n2){
        return n1+n2;
    }
    public int CalcIdade(int ano){
        return 2024-ano;
    }
    public boolean CalcAprovado(double media){
        if (media>=7){
            return true;
        }
        else{
            return false;
        }
    }
    public int calcMaior(int n1, int n2, int n3){
    return Math.max(n1, Math.max(n2, n3));
    }
       // Método que retorna o volume do cilindro
    public  double calcularVolumeCilindro(double raio, double altura) {
        // Calcula o volume utilizando a fórmula Volume = ao valor de pi * raioa potencia2 * h
        return  Math.PI * Math.pow(raio, 2) * altura;
    }
    
}
