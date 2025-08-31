/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetotransacao;

/**
 *
 * @author ptoledo
 */
public class Saque extends Transacao{

    @Override
    public void realizarTransacao(){
        System.out.println("Saque realizado em " + getData());
        System.out.println("Descricao: " + getDescricao());
        System.out.println("Valor: R$ " + getValor());
    } 
    
}
