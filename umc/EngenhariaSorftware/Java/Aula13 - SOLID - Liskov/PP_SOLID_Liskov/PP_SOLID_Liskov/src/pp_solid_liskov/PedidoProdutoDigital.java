/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_solid_liskov;

/**
 *
 * @author proft
 */
public class PedidoProdutoDigital {
    public void finalizarCompra(IProdutoDigital prod) {
        System.out.println("Compra finalizada! Valor: R$" + prod.getPreco());
    }
}
