package model;

/**
 *
 * @author Higor Castro, Henrique Santos
 * 
 * Classe Usuario representa um usuário do sistema.
 * Contém atributos privados como nome, CPF, email, telefone e senha, com seus respectivos métodos getters e setters.
 */
public class Usuario {
    // Atributos privados que armazenam as informações do usuário
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String Senha;
    
    // Métodos getters para acessar os valores dos atributos

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return Senha;
    }
    
    // Métodos setters para modificar os valores dos atributos

    public void setNome(String nome) {
        this.nome = nome;  
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;  
    }

    public void setEmail(String email) {
        this.email = email;  
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone; 
    }

    public void setSenha(String Senha) {
        this.Senha = Senha; 
    }
    
    
}
