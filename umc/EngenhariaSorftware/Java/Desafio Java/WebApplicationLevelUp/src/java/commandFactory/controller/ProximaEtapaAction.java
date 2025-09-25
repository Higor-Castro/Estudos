/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commandFactory.controller;

import Model.Dao.MetaDao;
import Model.Meta;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author higor
 */
public class ProximaEtapaAction implements ICommand{
    
@Override
public String executar(HttpServletRequest request, HttpServletResponse response) {
    String msg = ""; // variável para mensagem
    int idMeta = Integer.parseInt(request.getParameter("idMeta")); 
    int etapas = Integer.parseInt(request.getParameter("etapas")); 
    int etapaAtual = Integer.parseInt(request.getParameter("etapaAtual")); 
           
    MetaDao metaDao = new MetaDao();
    
    try {
        if (etapaAtual < etapas) {
            int novaEtapa = etapaAtual + 1;
            boolean ok = metaDao.atualizarEtapa(idMeta, novaEtapa);
            
            if (ok) {
                msg = "Etapa atualizada com sucesso!";
            } else {
                msg = " Não foi possível atualizar a etapa!";
            }
        } else {
            msg = " Meta já está na última etapa.";
        }
    } catch (Exception e) {
        e.printStackTrace();
        msg = " Ocorreu um erro: " + e.getMessage();
    }
    
    request.setAttribute("msg", msg); // envia a mensagem para o JSP
    return "resultado.jsp"; // ou o JSP que você usar
}

    
}
