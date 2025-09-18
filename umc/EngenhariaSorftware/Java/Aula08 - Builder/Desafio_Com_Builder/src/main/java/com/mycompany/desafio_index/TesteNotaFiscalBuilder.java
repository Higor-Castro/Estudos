/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.desafio_index;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author higor
 */
public class TesteNotaFiscalBuilder {

    public static void main(String[] args) {
       NotaFiscalBuilder nf = NotaFiscalBuilder.getBuilder()
                .comRazaoSocial("Minha Empresa LTDA")
                .comCnpj("12.345.678/0001-99")
                .comDataEmissao(Calendar.getInstance())
                .comValorBruto(1000.0)
                .comImpostos(500.0)
                .comItens(Arrays.asList(
                        new ItemDaNotaBuilder("Item 1", 200.0),
                        new ItemDaNotaBuilder("Item 2", 800.0)
                ))
                .comObservacoes("Observações da nota fiscal")
                .constroi();

        System.out.println(nf);
    }
}

