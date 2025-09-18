package model;
public class Pesquisa {   
    // Atributos privados que armazenam as informações da pesquisa
    private String cpf;  // CPF do usuário
    private String nome; // Nome do usuário
    private int p1;      // Resposta para a pergunta 1
    private int p2;      // Resposta para a pergunta 2
    private int p3;      // Resposta para a pergunta 3
    private int p4;      // Resposta para a pergunta 4
    private int p5;      // Resposta para a pergunta 5
    // Métodos getters para acessar os valores dos atributos
    public String getCpf() {
        return cpf; // Retorna o CPF do usuário
    }
    public String getNome() {
        return nome; // Retorna o nome do usuário
    }
    public int getP1() {
        return p1; // Retorna a resposta para a pergunta 1
    }
    public int getP2() {
        return p2; // Retorna a resposta para a pergunta 2
    }
    public int getP3() {
        return p3; // Retorna a resposta para a pergunta 3
    }
    public int getP4() {
        return p4; // Retorna a resposta para a pergunta 4
    }
    public int getP5() {
        return p5; // Retorna a resposta para a pergunta 5
    }   
    // Métodos setters para modificar os valores dos atributos
    public void setCpf(String cpf) {
        this.cpf = cpf; // Define o CPF do usuário
    }
    public void setNome(String nome) {
        this.nome = nome; // Define o nome do usuário
    }
    public void setP1(int p1) {
        this.p1 = p1; // Define a resposta para a pergunta 1
    }
    public void setP2(int p2) {
        this.p2 = p2; // Define a resposta para a pergunta 2
    }
    public void setP3(int p3) {
        this.p3 = p3; // Define a resposta para a pergunta 3
    }
    public void setP4(int p4) {
        this.p4 = p4; // Define a resposta para a pergunta 4
    }
    public void setP5(int p5) {
        this.p5 = p5; // Define a resposta para a pergunta 5
    }
}
