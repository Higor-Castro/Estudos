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
public class CadastraAction implements ICommand{
    
    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {

        String msg = ""; // variável para mensagens
        boolean sucessoRecomendacoes = true;

        // Captura os parâmetros do formulário
        String nome = request.getParameter("nome");
        String cargo = request.getParameter("cargo");
        String departamento = request.getParameter("departamento");
        String email = request.getParameter("email");
        String registro = request.getParameter("registro");
        String tituloMeta = request.getParameter("titulo");
        String descricaoMeta = request.getParameter("descricao");
        String qtdEtapasStr = request.getParameter("etapas");
        String frequencia = request.getParameter("frequencia");
        
        // Verrificar se a sequencia foi selecionada
        if (!frequencia.equals("diaria") && !frequencia.equals("semanal") && !frequencia.equals("mensal")) {
            msg = "Frequência inválida";
            request.setAttribute("msg", msg);
            return "resultado.jsp";
        }



        int qtdEtapas = 0;
        try {
            qtdEtapas = Integer.parseInt(qtdEtapasStr);
        } catch (Exception e) {
            msg = "Quantidade de etapas inválida!";
            request.setAttribute("msg", msg);
            return "resultado.jsp";
        }
        // Criar o Objeto Usuario usando Builder
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
            usuarioSalva = usuarioDao.cadastrar(usuario);        
        }catch(Exception ex){
            msg = "Erro ao salvar Usuario(Meta): " + ex.getMessage();
            request.setAttribute("msg", msg);
            return "resultado.jsp";
            
        }

        // Cria o objeto Meta usando Builder
        Meta meta = Meta.builder()
                        .comTitulo(tituloMeta)
                        .comDescricao(descricaoMeta)
                        .comEtapas(qtdEtapas)
                        .comEtapaAtual(1)
                        .comUsuario(usuario)
                        .comFrequencia(frequencia)
                        .constroi();

        MetaDao metaDao = new MetaDao();
        boolean metaSalva = false;

        try {
            metaSalva = metaDao.cadastrar(meta); // Salva a Meta
        } catch (Exception ex) {
            msg = "Erro ao salvar Meta: " + ex.getMessage();
            request.setAttribute("msg", msg);
            return "resultado.jsp";
        }

        if(metaSalva){
            recomendacaoDao recDao = new recomendacaoDao();

            for(int i = 1; i <= qtdEtapas; i++){
                String tituloRec = request.getParameter("titulo_" + i);
                String descricaoRec = request.getParameter("descricao_" + i);
                String urlCurso = request.getParameter("url_" + i);
                
                int idMeta = meta.getId();

                if(tituloRec != null && descricaoRec != null && urlCurso != null){
                    Recomendacao rec = Recomendacao.builder()
                                                   .comTitulo(tituloRec)
                                                   .comDescricao(descricaoRec)
                                                   .comUrlCurso(urlCurso)
                                                   .comEtapa(i)
                                                   .comMetaId(idMeta)
                                                   .constroi();
                    try {
                        boolean ok = recDao.cadastrar(rec);
                        if(!ok) sucessoRecomendacoes = false;
                    } catch(Exception ex) {
                        sucessoRecomendacoes = false;
                    }
                } else {
                    sucessoRecomendacoes = false;
                }
            }
        }

        // Define a mensagem final
        if(metaSalva && sucessoRecomendacoes){
            msg = "Meta e recomendações cadastradas com sucesso!";
            INotifier notify = new Notifier(usuario);
            notify = new MailDecorator(notify, usuario);
            notify.send(msg);
        } else if(metaSalva){
            msg = "Meta cadastrada, mas houve erro ao salvar algumas recomendações!";
        } else {
            msg = "Erro ao cadastrar Meta e recomendações!";
        }
        



        request.setAttribute("msg", msg );
        return "resultado.jsp"; // Página final que mostra a mensagem
    }
}
