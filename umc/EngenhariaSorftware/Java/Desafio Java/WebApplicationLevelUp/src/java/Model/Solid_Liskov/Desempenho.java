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

    public Recompensa getRecompensa() {
        return recompensa;
    }
}
