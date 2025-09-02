/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder_interfacefluente;

import java.util.Date;

/**
 *
 * @author PTOLEDO
 */
public class Paciente {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private char sexo;
    private String tipoSanguineo;
    private boolean doadorDeOrgaos;
    private int peso;
    private int altura;
    private Endereco endereco;
    
    public Paciente (String nome, String cpf, Date dataNascimento, char sexo, String tipoSanguineo, boolean doadorDeOrgaos, int peso, int altura, Endereco endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tipoSanguineo = tipoSanguineo;
        this.doadorDeOrgaos = doadorDeOrgaos;
        this.peso = peso;
        this.altura = altura;
        this.endereco = endereco;
    }
    
}
