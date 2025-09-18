/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package builder_classeinterna;

/**
 *
 * @author PTOLEDO
 */
public class Builder_ClasseInterna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Paciente p = Paciente.getBuilder()
                .comNome("Maria")
                .comCpf("123456")
                .comDataNascimento(01, 01, 1990)
                .comAltura(170)
                .comPeso(60)
                .comTipoSanguineo("A+")
                .doSexoFeminino()
                .doadorDeOrgaos()
                .comEndereco("Rua Norte", 100)
                .constroi();
    }

}
