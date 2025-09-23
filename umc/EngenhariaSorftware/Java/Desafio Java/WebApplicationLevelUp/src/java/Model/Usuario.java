/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author higor
 */
public class Usuario {
    private String registro;     // matrícula ou código único
    private String nome;
    private String cargo;
    private String departamento;
    private String email;

    // Construtor privado para usar apenas com Builder
    public Usuario() {}

    // Getters
    public String getRegistro() {
        return registro;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getEmail() {
        return email;
    }
    
    // set Registro

    public void setRegistro(String registro) {
        this.registro = registro;
    }
    

    // Método para iniciar o Builder
    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    // Builder estático
    public static class UsuarioBuilder {
        private Usuario usuario;

        public UsuarioBuilder() {
            usuario = new Usuario();
        }

        public UsuarioBuilder comRegistro(String registro) {
            usuario.registro = registro;
            return this;
        }

        public UsuarioBuilder comNome(String nome) {
            usuario.nome = nome;
            return this;
        }

        public UsuarioBuilder comCargo(String cargo) {
            usuario.cargo = cargo;
            return this;
        }

        public UsuarioBuilder comDepartamento(String departamento) {
            usuario.departamento = departamento;
            return this;
        }

        public UsuarioBuilder comEmail(String email) {
            usuario.email = email;
            return this;
        }

        public Usuario constroi() {
            return usuario;
        }
    }

    
}
