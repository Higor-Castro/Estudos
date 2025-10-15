package commandFactory.controller;

import Model.Dao.MetaDao;
import Model.Meta;
import Model.Solid_Liskov.Desempenho;
import Model.Solid_Liskov.Recompensa;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DesempenhoAction implements ICommand {
    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String registro = request.getParameter("registro");
        List<Meta> metas = null;
        Recompensa recompensa = null;

        try {
            MetaDao metaDao = new MetaDao();
            metas = metaDao.consultarByRegistro(registro);

            if (metas != null && !metas.isEmpty()) {
                Desempenho desempenho = new Desempenho(metas);
                recompensa = desempenho.getRecompensa();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        request.setAttribute("metas", metas);
        request.setAttribute("recompensa", recompensa);
        request.setAttribute("registro", registro);

        return "Desempenho.jsp";
    }
}
