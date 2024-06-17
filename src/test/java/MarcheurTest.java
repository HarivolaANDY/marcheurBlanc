import org.example.Marcheur;
import org.example.trajetDuMarcheur.Carte;
import org.example.trajetDuMarcheur.Lieu;
import org.example.trajetDuMarcheur.Rue;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MarcheurTest {
    @Test
    public void testMarcheur1() {
        Carte carte = new Carte();
        Lieu depart = new Lieu("Départ");
        Lieu destination = new Lieu("Destination");
        Rue rue = new Rue(depart, destination);
        carte.ajouterLieu(depart);
        carte.ajouterLieu(destination);
        carte.ajouterRue(rue);

        Marcheur marcheur = new Marcheur(depart);

        marcheur.marcherAleatoirement(carte, destination.getNom());

        Assert.assertEquals(destination, marcheur.getPositionActuelle());

        List<Lieu> visite = marcheur.getVisite();
        Assert.assertEquals(2, visite.size());
        Assert.assertEquals(depart, visite.get(0));
        Assert.assertEquals(destination, visite.get(1));
    }
}
