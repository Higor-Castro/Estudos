package commandFactory.controller;

import Model.DIP.Tempo;
import Model.DIP.EscolherRegra;
import Model.Dao.MetaDao;
import Model.Meta;
import Model.Solid_Liskov.Desempenho;
import Model.Solid_Liskov.Recompensa;
import Model.Solid_Liskov.RecompensaMotivacional;
import Model.Solid_Liskov.IRecompensaMotivacional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DesempenhoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String registro = request.getParameter("registro");
        List<Meta> metas = null;
        Recompensa recompensa = null;
        String motivacional = null;
        Map<Integer, Integer> tempos = new HashMap<>();

        try {
            MetaDao metaDao = new MetaDao();
            metas = metaDao.consultarByRegistro(registro);

            IRecompensaMotivacional recompensaMotivacional = new RecompensaMotivacional();

            if (metas != null && !metas.isEmpty()) {
                // Calcula desempenho
                Desempenho desempenho = new Desempenho(metas);
                recompensa = desempenho.getRecompensa();
                motivacional = recompensaMotivacional.getFrase();

                // Calcula tempo individual de cada meta
                for (Meta meta : metas) {
                    System.out.println("Meta: " + meta.getTitulo() + " Etapas: " + meta.getEtapas()); // debug

                    Tempo tempo = new Tempo();
                    tempo.setMetas(List.of(meta));
                    tempo.setRegraDeCalculo(EscolherRegra.escolher(meta.getFrequencia()));

                    int tempoTotal = tempo.calcularTempo();
                    tempos.put(meta.getId(), tempoTotal);
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO ClassNotFound: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("ERRO SQL: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERRO Genérico: " + ex.getMessage());
        }

        // Envia atributos para o JSP
        request.setAttribute("metas", metas);
        request.setAttribute("recompensa", recompensa);
        request.setAttribute("registro", registro);
        request.setAttribute("Motivacional", motivacional);
        request.setAttribute("tempos", tempos);

        return "Desempenho.jsp";
    }
}
