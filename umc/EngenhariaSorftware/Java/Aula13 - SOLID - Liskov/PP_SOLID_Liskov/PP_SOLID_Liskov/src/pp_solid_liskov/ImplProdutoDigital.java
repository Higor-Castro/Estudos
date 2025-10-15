/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_solid_liskov;

/**
 *
 * @author proft
 */
public class ImplProdutoDigital implements IProdutoDigital {

    private String nome;
    private double preco;

    public ImplProdutoDigital(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

}
