/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_solid_liskov;

/**
 *
 * @author proft
 */
public class ImplProdutoFisico implements IProdutoFisico {

    private String nome;
    private double preco;

    public ImplProdutoFisico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public double calcularFrete() {
        return this.preco * 0.1; // 10% do preço
    }

}
