/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import util.Conexao;

/**
 *
 * @author PTOLEDO
 */
@WebServlet(name = "controle_produto", urlPatterns = {"/controle_produto"})
public class controle_produto extends HttpServlet {

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
            /* TODO output your pageh ere. You may use following sample code. */

            String op = request.getParameter("op");
            ProdutoDAO pdao = new ProdutoDAO();
            Produto p = new Produto();

            if (op.equals("CADASTRAR")) {
                String descricao = request.getParameter("txtdescricao");
                double preco = Double.parseDouble(request.getParameter("txtpreco"));
                p.setDescricao(descricao);
                p.setPreco(preco);
                String msg = "Cadastrar";
                try {
                    
                    pdao.cadastrar(p);
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);

                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);

                }
            } else if (op.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                p.setId(id);
                String msg = "Deletar";
                try {
                    pdao.deletar(p);
                    List<Produto> lprod = pdao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else if (op.equals("CONSULTAR BY ID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                p.setId(id);
                try {
                    p = pdao.consultarById(p);
                    request.setAttribute("p", p);
                    request.getRequestDispatcher("resultadocosultarbyid.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR TODOS")) {
                //NÃO IMPLEMENTADO
                try {
                    List<Produto> lprod = pdao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }

            } else if (op.equals("ATUALIZAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                p.setId(id);
                try {
                    p = pdao.consultarById(p);
                    request.setAttribute("p", p);
                    request.getRequestDispatcher("resultadocosultaratualizar.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
            } else if (op.equals("EFETIVAR ATUALIZAÇÃO")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                String descricao = request.getParameter("txtdescricao");
                double preco = Double.parseDouble(request.getParameter("txtpreco"));
                p.setId(id);
                p.setDescricao(descricao);
                p.setPreco(preco);
                String msg = "Atualizar";
                try {
                    pdao.atualizar(p);
                    System.out.println("Atuaizado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            }

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
