/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.desafio_builder;
import java.util.Calendar;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author higor
 */
public class TesteNotaFiscal {

    public static void main(String[] args) {

        List<ItemDaNota> items = Arrays.asList(
                new ItemDaNota("item 1", 200.0),
                new ItemDaNota("item 2", 400.0)
        );

        double total = 0;
        for (ItemDaNota item : items) {
            total += item.getValor();
        }

        double impostos = total * 0.5;

        NotaFiscal nf = new NotaFiscal(
                "razao social", 
                "cnpj", 
                Calendar.getInstance(),
                total, 
                impostos, 
                items, 
                "obs qualquer"
        );
    }
}

