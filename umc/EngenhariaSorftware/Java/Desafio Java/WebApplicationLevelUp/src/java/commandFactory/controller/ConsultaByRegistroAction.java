/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commandFactory.controller;
import Model.Dao.MetaDao;
import Model.Meta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author higor
 */
public class ConsultaByRegistroAction implements ICommand{
@Override
public String executar(HttpServletRequest request, HttpServletResponse response) {
    String registro = request.getParameter("registro");
    List<Meta> metas = new ArrayList<>();
    MetaDao metaDao = new MetaDao();

    try {
        metas = metaDao.consultarByRegistro(registro);
        request.setAttribute("metas", metas); 
    } catch (ClassNotFoundException | SQLException ex) {
        System.out.println("ERRO: " + ex.getMessage());
    }

    return "Metas.jsp";
}

    
}
