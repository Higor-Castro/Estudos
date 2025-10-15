/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pp_solid_liskov;

/**
 *
 * @author proft
 */
public class PP_SOLID_Liskov_ProdutoDigital {

    public static void main(String[] args) {
        IProdutoDigital pd = new ImplProdutoDigital("PDF Curso JAVA", 200.0);
        PedidoProdutoDigital ppd = new PedidoProdutoDigital();
        ppd.finalizarCompra(pd);
    }

}
