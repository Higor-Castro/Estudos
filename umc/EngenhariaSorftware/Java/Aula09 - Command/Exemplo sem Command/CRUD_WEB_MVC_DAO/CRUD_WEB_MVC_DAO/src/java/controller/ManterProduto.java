/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author ptoledo
 */
@WebServlet(name = "ManterProduto", urlPatterns = {"/ManterProduto"})
public class ManterProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String msg = "";

            String op = request.getParameter("btnop");


            if (op.equals("CADASTRAR")) {
                try {
                    String descricao = request.getParameter("txtdescricao");
                    double preco = Double.parseDouble(request.getParameter("txtpreco"));

                    ProdutoDAO pdao = new ProdutoDAO();
                    Produto p = new Produto();
                    p.setDescricao(descricao);
                    p.setPreco(preco);

                    pdao.cadastrar(p);
                    msg = "Cadastrado com sucesso.";
                    System.out.println("Cadastrado com sucesso.");
                } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
                    msg = "Erro ao cadastrar.";
                    System.out.println("ERRO: " + ex.getMessage());
                }

            } else if (op.equals("DELETAR")) {
                try {
                    int id = Integer.parseInt(request.getParameter("txtid"));

                    ProdutoDAO pdao = new ProdutoDAO();
                    Produto p = new Produto();
                    p.setId(id);

                    pdao.deletar(p);
                    msg = "Deletado com sucesso.";
                    System.out.println("Deletado com sucesso.");
                } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
                    msg = "Erro ao deletar.";
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

            request.setAttribute("msg", msg);
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
