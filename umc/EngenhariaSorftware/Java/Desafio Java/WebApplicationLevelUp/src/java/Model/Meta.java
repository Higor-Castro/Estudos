/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.Usuario;
import Model.Recomendacao;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author higor
 */
public class Meta {
    private int id;
    private String titulo;
    private String descricao;
    private int etapas;
    private int etapaAtual;
    private Usuario usuario;                     // objeto do usuário
    private List<Recomendacao> recomendacoes;    // lista de recomendações
    private Timestamp dataCriacao;               // data de criação da meta
    private int progresso;                       // percentual de conclusão (0 a 100)
    private String frequencia;                   // qualquer anotação simples da meta

    // Construtor privado para usar apenas com Builder
    public Meta() {}

    // Getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public int getEtapas() { return etapas; }
    public int getEtapaAtual() { return etapaAtual; }
    public Usuario getUsuario() { return usuario; }
    public List<Recomendacao> getRecomendacoes() { return recomendacoes; }
    public Timestamp getDataCriacao() { return dataCriacao; }
    
    public int getProgresso() {     
        if (getEtapas() > 0) {
        this.progresso = (int) (((double) getEtapaAtual() / getEtapas()) * 100);
    } else {
        this.progresso = 0;
    }   return this.progresso; }
    public String getFrequencia() { return frequencia; }
    
    // set ido
    public void setId(int id) { this.id = id;}
    
   

    // Método para iniciar o Builder
    public static MetaBuilder builder() {
        return new MetaBuilder();
    }

    // Builder estático
    public static class MetaBuilder {
        private Meta meta;

        public MetaBuilder() {
            meta = new Meta();
        }

        public MetaBuilder comId(int id) { meta.id = id; return this; }
        public MetaBuilder comTitulo(String titulo) { meta.titulo = titulo; return this; }
        public MetaBuilder comDescricao(String descricao) { meta.descricao = descricao; return this; }
        public MetaBuilder comEtapas(int etapas) { meta.etapas = etapas; return this; }
        public MetaBuilder comEtapaAtual(int etapaAtual) { meta.etapaAtual = etapaAtual; return this; }
        public MetaBuilder comUsuario(Usuario usuario) { meta.usuario = usuario; return this; }
        public MetaBuilder comRecomendacoes(List<Recomendacao> recomendacoes) { meta.recomendacoes = recomendacoes; return this; }
        public MetaBuilder comDataCriacao(Timestamp dataCriacao) { meta.dataCriacao = dataCriacao; return this; }
        public MetaBuilder comFrequencia(String frequencia) { meta.frequencia = frequencia; return this; }

        public Meta constroi() { return meta; }
    }



}

