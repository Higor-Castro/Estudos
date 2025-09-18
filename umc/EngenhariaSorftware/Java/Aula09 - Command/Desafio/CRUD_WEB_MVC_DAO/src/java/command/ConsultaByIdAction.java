/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import dao.ProdutoDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author ptoledo
 */
public class ConsultaByIdAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String msg = "";
        ProdutoDAO pdao = new ProdutoDAO();
        Produto p = new Produto();
        try {
            int id = Integer.parseInt(request.getParameter("txtid"));
            p.setId(id);
            Produto prod = pdao.consultarById(p);
            request.setAttribute("prod", prod);
        } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
            msg = "Erro ao consultar";
            request.setAttribute("msg", msg);
        }
        return "resultadoconsultarbyid.jsp";
    }
}
