package controller;

import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet(name = "ManterProduto", urlPatterns = {"/ManterProduto"})
public class ManterProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String msg = "";
            String op = request.getParameter("btnop");

            try {
                ProdutoDAO pdao = new ProdutoDAO();

                if (op.equals("CADASTRAR")) {
                    String descricao = request.getParameter("txtdescricao");
                    double preco = Double.parseDouble(request.getParameter("txtpreco"));

                    Produto p = new Produto();
                    p.setDescricao(descricao);
                    p.setPreco(preco);

                    pdao.cadastrar(p);
                    msg = "Cadastrado com sucesso.";

                } else if (op.equals("DELETAR")) {
                    int id = Integer.parseInt(request.getParameter("txtid"));

                    Produto p = new Produto();
                    p.setId(id);

                    pdao.deletar(p);
                    msg = "Deletado com sucesso.";

                } else if (op.equals("ATUALIZAR")) {
                    int id = Integer.parseInt(request.getParameter("txtid"));
                    String descricao = request.getParameter("txtdescricao");
                    double preco = Double.parseDouble(request.getParameter("txtpreco"));

                    Produto p = new Produto();
                    p.setId(id);
                    p.setDescricao(descricao);
                    p.setPreco(preco);

                    pdao.atualizar(p);
                    msg = "Atualizado com sucesso.";

                } else if (op.equals("CONSULTAR")) {
                    int id = Integer.parseInt(request.getParameter("txtid"));

                    Produto prod = new Produto();
                    prod.setId(id);

                    Produto p = pdao.consultarById(prod);
                    if (p != null && p.getId() != 0) {
                        request.setAttribute("produto", p);
                        msg = "Produto encontrado.";
                    } else {
                        msg = "Produto não encontrado.";
                    }

                } else if (op.equals("LISTAR")) {
                    List<Produto> lista = pdao.consultarTodos();
                    request.setAttribute("listaProdutos", lista);
                    msg = "Lista de produtos carregada.";
                }

            } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
                msg = "Erro: " + ex.getMessage();
                ex.printStackTrace();
            }

            request.setAttribute("msg", msg);
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet CRUD Produto";
    }
}
