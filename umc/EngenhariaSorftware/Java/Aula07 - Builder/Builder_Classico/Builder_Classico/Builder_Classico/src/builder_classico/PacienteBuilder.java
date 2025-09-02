/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder_classico;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PTOLEDO
 */
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

    public void comNome(String nome){
        this.nome = nome;
    }

    public void comCpf(String cpf){
        this.cpf = cpf;
    }
    
    public void comDataNascimento(int dia, int mes, int ano){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = dia + "/" + mes + "/" + ano;
        try{
            dataNascimento = sdf.parse(data);
        } catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        
    }
    
    public void doSexoMasculino(){
        sexo = 'M';
    }

    public void doSexoFeminino(){
        sexo = 'F';
    }
    
    public void comTipoSanguineo(String tipoSanguineo){
        this.tipoSanguineo = tipoSanguineo;
    }
    
    public void doadorDeOrgaos(){
        this.doadorDeOrgaos = true;
    }
    
    public void comPeso(int peso){
        this.peso = peso;
    }

    public void comAltura(int altura){
        this.altura = altura;
    }
    
    public void comEndereco(String rua, int numero){
        Endereco endereco = new Endereco(rua, numero);
        this.endereco = endereco;
    }

    public Paciente constroi(){
        return new Paciente(nome, cpf, dataNascimento, sexo, tipoSanguineo, doadorDeOrgaos, peso, altura, endereco);
    }
}
