/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;
import model.Num;
import model.TesteDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "Controll", urlPatterns = {"/Controll"})
public class TesteControll extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html;charset=UTF-8");
            
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));
            
            Num num = new Num();
            num.setN1(n1);
            num.setN2(n2);
            
            int calc = num.getN1() + num.getN2();
            
            TesteDAO dao = new TesteDAO();
            boolean sucesso = dao.cadastrar(num);
            
            if (sucesso) {
                response.getWriter().println("Inserido com sucesso! O Valor das Somas é: " + calc);
            } else {
                response.getWriter().println("Erro ao inserir!");
            }
        } catch (ClassNotFoundException ex) {
            System.getLogger(TesteControll.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(TesteControll.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
}
