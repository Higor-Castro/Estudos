/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetotransacao;

import java.util.Date;

/**
 *
 * @author ptoledo
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conta conta = new Conta(1234, 100.0);
        
        Saque saque = new Saque();
        saque.setData(new Date());
        saque.setDescricao("Saque ATM");
        saque.setValor(30.0);
        
        conta.novaTransacao(saque);
       
        

    }
    
}
