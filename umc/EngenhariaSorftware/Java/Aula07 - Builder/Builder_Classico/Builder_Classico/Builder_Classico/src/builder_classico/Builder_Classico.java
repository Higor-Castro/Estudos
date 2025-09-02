/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package builder_classico;

/**
 *
 * @author PTOLEDO
 */
public class Builder_Classico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        PacienteBuilder builder = new PacienteBuilder();
        
        builder.comNome("Maria");
        builder.comCpf("123456");
        builder.comDataNascimento(01, 01, 1990);
        builder.comAltura(170);
        builder.comPeso(60);
        builder.comTipoSanguineo("A+");
        builder.doSexoFeminino();
        builder.doadorDeOrgaos();
        builder.comEndereco("Rua Norte", 100);
        
        
        Paciente p = builder.constroi();
        
    }
    
}
