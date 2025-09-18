package model;
public class Cadastro {
    // Atributos privados que armazenam as informações do usuário
    private String nome;      // Nome do usuário
    private String cpf;       // CPF do usuário
    private String email;     // E-mail do usuário
    private String telefone;  // Telefone do usuário
    private String senha;     // Senha do usuário
    
    // Métodos getters para acessar os valores dos atributos
    // Retorna o nome do usuário
    public String getNome() {
        return nome;
    }
    // Retorna o CPF do usuário
    public String getCpf() {
        return cpf;
    }
    // Retorna o e-mail do usuário
    public String getEmail() {
        return email;
    }
    // Retorna o telefone do usuário
    public String getTelefone() {
        return telefone;
    }
    // Retorna a senha do usuário
    public String getSenha() {
        return senha;
    }    
    // Métodos setters para modificar os valores dos atributos
    // Define o nome do usuário
    public void setNome(String nome) {
        this.nome = nome;  
    }
    // Define o CPF do usuário
    public void setCpf(String cpf) {
        this.cpf = cpf;  
    }
    // Define o e-mail do usuário
    public void setEmail(String email) {
        this.email = email;  
    }
    // Define o telefone do usuário
    public void setTelefone(String telefone) {
        this.telefone = telefone; 
    }

    // Define a senha do usuário
    public void setSenha(String senha) {
        this.senha = senha; 
    }
}
