package marcheur.Blanc.marcheurBlanc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Marcheur {
    private Carte carte;
    private Random random;

    public List<Lieux> marche(Lieux lieuDepart, Lieux lieuDestination) {
        List<Lieux> chemin = new ArrayList<>();
        Lieux lieuActuel = lieuDepart;

        while (!lieuActuel.equals(lieuDestination)) {
            List<Lieux> voisins = carte.getVoisins(lieuActuel);
            if (voisins.isEmpty()) break;
            Lieux prochainLieu = voisins.get(random.nextInt(voisins.size()));
            chemin.add(prochainLieu);
            lieuActuel = prochainLieu;
        }

        return chemin;
    }
}
