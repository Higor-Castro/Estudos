/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder_classeinterna;

import java.text.SimpleDateFormat;
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

    public Paciente() {
    }

    public static PacienteBuilder getBuilder() {
        return new PacienteBuilder();
    }

    public static class PacienteBuilder {

        Paciente pac;

        public PacienteBuilder comNome(String nome) {
            pac.nome = nome;
            return this;
        }

        public PacienteBuilder comCpf(String cpf) {
            pac.cpf = cpf;
            return this;
        }

        public PacienteBuilder comDataNascimento(int dia, int mes, int ano) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data = dia + "/" + mes + "/" + ano;
            try {
                pac.dataNascimento = sdf.parse(data);
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
            return this;
        }

        public PacienteBuilder doSexoMasculino() {
            pac.sexo = 'M';
            return this;
        }

        public PacienteBuilder doSexoFeminino() {
            pac.sexo = 'F';
            return this;
        }

        public PacienteBuilder comTipoSanguineo(String tipoSanguineo) {
            pac.tipoSanguineo = tipoSanguineo;
            return this;
        }

        public PacienteBuilder doadorDeOrgaos() {
            pac.doadorDeOrgaos = true;
            return this;
        }

        public PacienteBuilder comPeso(int peso) {
            pac.peso = peso;
            return this;
        }

        public PacienteBuilder comAltura(int altura) {
            pac.altura = altura;
            return this;
        }

        public PacienteBuilder comEndereco(String rua, int numero) {
            Endereco endereco = new Endereco(rua, numero);
            pac.endereco = endereco;
            return this;
        }

        public Paciente constroi() {
            return pac;
        }
    }
}
