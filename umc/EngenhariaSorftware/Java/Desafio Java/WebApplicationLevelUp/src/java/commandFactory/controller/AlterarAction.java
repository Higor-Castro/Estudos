/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commandFactory.controller;

import Model.Dao.MetaDao;
import Model.Dao.recomendacaoDao;
import Model.Meta;
import Model.Recomendacao;
import Model.Usuario;
import Model.Dao.UsuarioDao;
import Model.Decorator.INotifier;
import Model.Decorator.MailDecorator;
import Model.Decorator.Notifier;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author higor
 */
public class AlterarAction implements ICommand{
    
    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String msg = ""; // variável para mensagens
        //Usuario
        String registro = request.getParameter("registro"); 
        String nome = request.getParameter("nome");
        String cargo = request.getParameter("cargo");
        String departamento = request.getParameter("departamento");
        String email = request.getParameter("email");
        
        //Metas
        int idMeta = Integer.parseInt(request.getParameter("idMeta"));  
        String tituloMeta = request.getParameter("titulo");
        String descricaoMeta = request.getParameter("descricao");
        String frequencia = request.getParameter("frequencia");
        
        //Recomendação
        int idRecomendacao = Integer.parseInt(request.getParameter("idRecomendacao"));
        String tituloRecomendacao = request.getParameter("tituloRecomendacao");
        String descricaoRecomendacao = request.getParameter("descricaoRecomendacao");
        String urlCurso = request.getParameter("urlCurso");
        
        // Verrificar se a sequencia foi selecionada
        if (!frequencia.equals("diaria") && !frequencia.equals("semanal") && !frequencia.equals("mensal")) {
            msg = "Frequência inválida";
            request.setAttribute("msg", msg);
            return "resultado.jsp";
        }
        
        // Atualizar Usuario
                Usuario usuario = Usuario.builder()
                        .comRegistro(registro)
                        .comNome(nome)
                        .comCargo(cargo)
                        .comDepartamento(departamento)
                        .comEmail(email)
                        .constroi();
        
        UsuarioDao usuarioDao = new UsuarioDao();
        boolean usuarioSalva = false;
        try{
            usuarioSalva = usuarioDao.atualizar(usuario);        
        }catch(Exception ex){
            msg = "Erro ao salvar Usuario(Meta): " + ex.getMessage();
            request.setAttribute("msg", msg);
            return "resultado.jsp";
            
        }
        
        // Atualizar Meta
        Meta meta = Meta.builder()
                    .comId(idMeta)
                    .comTitulo(tituloMeta)
                    .comDescricao(descricaoMeta)
                    .comFrequencia(frequencia)
                    .constroi();

        MetaDao metaDao = new MetaDao();
        boolean metaSalva = false;

        try {
            metaSalva = metaDao.atualizar(meta); // Salva a Meta
        } catch (Exception ex) {
            msg = "Erro ao salvar Meta: " + ex.getMessage();
            request.setAttribute("msg", msg);
            return "resultado.jsp";
        }
        
        // Atualizar Recomendação Atual
        Recomendacao rec = Recomendacao.builder()
                            .comTitulo(tituloRecomendacao)
                            .comDescricao(descricaoRecomendacao)
                            .comUrlCurso(urlCurso)
                            .comId(idRecomendacao)
                            .constroi();
        recomendacaoDao recDao = new recomendacaoDao();
        boolean recomendacaoSalva = false;
        try {
            recomendacaoSalva = recDao.atualizar(rec);
        } catch (Exception ex) {
            msg = "Erro ao salvar Recomendação: " + ex.getMessage();
            request.setAttribute("msg", msg);
            return "resultado.jsp";
        }
        
        
              // Define a mensagem final
        if(metaSalva && recomendacaoSalva){
            msg = "Meta e recomendações Atulizada com sucesso!";
            INotifier notify = new Notifier(usuario);
            notify = new MailDecorator(notify, usuario);
            notify.send(msg);
        } else if(metaSalva){
            msg = "Meta Atulizada, mas houve erro ao Atulizar recomendações!";
        } else {
            msg = "Erro ao Atulizar Meta e recomendações!";
        }

        request.setAttribute("msg", msg );
        return "resultado.jsp"; // Página final que mostra a mensagem



    }
    
}
