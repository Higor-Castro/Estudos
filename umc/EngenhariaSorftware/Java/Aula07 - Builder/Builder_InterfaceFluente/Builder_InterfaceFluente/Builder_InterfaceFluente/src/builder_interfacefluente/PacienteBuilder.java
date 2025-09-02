/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder_interfacefluente;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PTOLEDO
 */
///Builder Interface fluente
public class PacienteBuilder {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private char sexo;
    private String tipoSanguineo;
    private boolean doadorDeOrgaos;
    private int peso;
    private int altura;
    private Endereco endereco;

    public PacienteBuilder comNome(String nome){
        this.nome = nome;
        return this;
    }

    public PacienteBuilder comCpf(String cpf){
        this.cpf = cpf;
        return this;
    }
    
    public PacienteBuilder comDataNascimento(int dia, int mes, int ano){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = dia + "/" + mes + "/" + ano;
        try{
            dataNascimento = sdf.parse(data);
        } catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        return this;
    }
    
    public PacienteBuilder doSexoMasculino(){
        sexo = 'M';
        return this;
    }

    public PacienteBuilder doSexoFeminino(){
        sexo = 'F';
        return this;
    }
    
    public PacienteBuilder comTipoSanguineo(String tipoSanguineo){
        this.tipoSanguineo = tipoSanguineo;
        return this;
    }
    
    public PacienteBuilder doadorDeOrgaos(){
        this.doadorDeOrgaos = true;
        return this;
    }
    
    public PacienteBuilder comPeso(int peso){
        this.peso = peso;
        return this;
    }

    public PacienteBuilder comAltura(int altura){
        this.altura = altura;
        return this;
    }
    
    public PacienteBuilder comEndereco(String rua, int numero){
        Endereco endereco = new Endereco(rua, numero);
        this.endereco = endereco;
        return this;
    }

    public Paciente constroi(){
        return new Paciente(nome, cpf, dataNascimento, sexo, tipoSanguineo, doadorDeOrgaos, peso, altura, endereco);
    }
}
