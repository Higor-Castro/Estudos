/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pp_solid_liskov;

/**
 *
 * @author proft
 */
public class PP_SOLID_Liskov_ProdutoFisico {

    public static void main(String[] args) {
        IProdutoFisico pf = new ImplProdutoFisico("Camisa Polo", 100.0);
        PedidoProdutoFisico ppf = new PedidoProdutoFisico();
        ppf.finalizarCompra(pf);
    }

}
