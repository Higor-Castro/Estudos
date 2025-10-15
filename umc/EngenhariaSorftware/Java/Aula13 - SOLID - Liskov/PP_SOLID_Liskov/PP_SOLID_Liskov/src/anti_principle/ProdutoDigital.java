/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anti_principle;

/**
 *
 * @author proft
 */
public class ProdutoDigital extends Produto{
    public ProdutoDigital(String nome, double preco) {
        super(nome, preco);
    }
    @Override
    public double calcularFrete() {
        throw new UnsupportedOperationException("Produto digital não tem frete!");
    }
}
