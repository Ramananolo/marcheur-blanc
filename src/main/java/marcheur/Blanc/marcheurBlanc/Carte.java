package marcheur.Blanc.marcheurBlanc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carte {
    private Map<Lieux, List<Lieux>> adjacence;
    private List<Rues> rues;

    public Carte() {
        this.adjacence = new HashMap<>();
        this.rues = new ArrayList<>();
    }

    public void ajouterRoute(Lieux lieu1, Lieux lieu2) {
        if (!adjacence.containsKey(lieu1)) {
            adjacence.put(lieu1, new ArrayList<>());
        }
        adjacence.get(lieu1).add(lieu2);
        if (!adjacence.containsKey(lieu2)) {
            adjacence.put(lieu2, new ArrayList<>());
        }
        adjacence.get(lieu2).add(lieu1);
    }

    public List<Lieux> getVoisins(Lieux lieu) {
        return adjacence.getOrDefault(lieu, new ArrayList<>());
    }

    public Rues getRues(Lieux lieuxDepart, Lieux arrives) {
        for (Rues rue : rues) {
            if (rue.lieu1.equals(lieuxDepart) && rue.lieu2.equals(arrives)) return rue;
        }
        return null;
    }
}
