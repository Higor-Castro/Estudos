/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anti_principle;

/**
 *
 * @author proft
 */
public class ProdutoFisico extends Produto{
    public ProdutoFisico(String nome, double preco) {
        super(nome, preco);
    }
    @Override
    public double calcularFrete() {
        return this.preco * 0.15; // 15% do preço
    } 
}
