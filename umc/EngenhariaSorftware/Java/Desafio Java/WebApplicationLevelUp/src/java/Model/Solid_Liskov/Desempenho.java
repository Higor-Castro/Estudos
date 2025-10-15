package Model.Solid_Liskov;

import Model.Meta;
import java.util.List;

public class Desempenho {
    private List<Meta> metas;
    private Recompensa recompensa;

    public Desempenho(List<Meta> metas) {
        this.metas = metas;
        recompensa = new RecompensaMeta(metas).calcular();
    }

    public Recompensa getRecompensa() { return recompensa; }

    public static class RecompensaMeta extends Recompensa {
        private List<Meta> metas;

        public RecompensaMeta(List<Meta> metas) { this.metas = metas; }

        @Override
        public Recompensa calcular() {
            int media = metas.isEmpty() ? 0 : metas.stream().mapToInt(Meta::getProgresso).sum() / metas.size();

            if(media >= 80) nivel = "Avançado"; 
            else if(media >= 50) nivel = "Intermediário"; 
            else nivel = "Iniciante";

            mensagem = switch(nivel) {
                case "Avançado" -> "Excelente! Você atingiu o nível Avançado.";
                case "Intermediário" -> "Bom trabalho! Você atingiu o nível Intermediário.";
                default -> "Continue se esforçando! Você está no nível Iniciante.";
            };

            return this;
        }
    }
}
