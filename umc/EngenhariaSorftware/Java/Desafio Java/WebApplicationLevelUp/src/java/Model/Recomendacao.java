package Model;

public class Recomendacao {
    // Atributos privados que armazenam as informações da recomendação
    private int id;
    private int metaId;           // FK para vincular à meta
    private String titulo;        // Nome do curso/recomendação
    private String descricao;     // O que será aprendido
    private String urlCurso;      // Link do curso
    private int etapa;            // A etapa em que essa recomendação aparece
    
    // Construtor privado para usar apenas com o Builder
    private Recomendacao() {}
    
    // Getters
    public int getId() {
        return id;
    }

    public int getMetaId() {
        return metaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrlCurso() {
        return urlCurso;
    }

    public int getEtapa() {
        return etapa;
    }

    // Método para iniciar o Builder
    public static RecomendacaoBuilder builder() {
        return new RecomendacaoBuilder();
    }

    // Builder estático
    public static class RecomendacaoBuilder {
        private Recomendacao recomendacao;

        public RecomendacaoBuilder() {
            recomendacao = new Recomendacao();
        }

        public RecomendacaoBuilder comId(int id) {
            recomendacao.id = id;
            return this;
        }

        public RecomendacaoBuilder comMetaId(int metaId) {
            recomendacao.metaId = metaId;
            return this;
        }

        public RecomendacaoBuilder comTitulo(String titulo) {
            recomendacao.titulo = titulo;
            return this;
        }

        public RecomendacaoBuilder comDescricao(String descricao) {
            recomendacao.descricao = descricao;
            return this;
        }

        public RecomendacaoBuilder comUrlCurso(String urlCurso) {
            recomendacao.urlCurso = urlCurso;
            return this;
        }

        public RecomendacaoBuilder comEtapa(int etapa) {
            recomendacao.etapa = etapa;
            return this;
        }

        public Recomendacao constroi() {
            return recomendacao;
        }
    }
}
