/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commandFactory.controller;
import Model.Dao.MetaDao;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author higor
 */
public class DeletarAction implements ICommand{
    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String registro = request.getParameter("registro");
        String idParam = request.getParameter("id");
        String msg;

        try {
            int metaId = Integer.parseInt(idParam);
            MetaDao metaDao = new MetaDao();
            msg = metaDao.deletar(registro, metaId) ? "Deletado com Sucesso!" : "Erro ao deletar!";
        } catch (Exception e) {
            msg = "Erro ao deletar!";
        }

        request.setAttribute("msg", msg);
        return "resultado.jsp";
    }


}
