import org.example.Marcheur;

import org.example.trajetDuMarcheur.Carte;
import org.example.trajetDuMarcheur.Lieu;
import org.example.trajetDuMarcheur.Rue;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarcheurTest {
    @Test
    void bjarni_de_hei_vers_esti(){
        var sekolintsika = new Lieu("Sekolintsika");
        var marais = new Lieu("Marais");
        var hei = new Lieu("HEI");
        var esti = new Lieu("ESTI");
        var pullman = new Lieu("Pullman");
        var boulevardDeLEurope = new Lieu("Boulevard De L'Europe");
        var nexta = new Lieu("Nexta");
        var balancoire = new Lieu("Balancoire");

        var bjarni = new Marcheur("Bjarni");
        var tana = new Carte(new HashSet<>(Set.of(
                new Rue(marais, sekolintsika),
                new Rue(sekolintsika, hei),
                new Rue("Rue Andriatsihorana", hei, pullman),
                new Rue(hei, balancoire),
                new Rue(pullman, nexta),
                new Rue(pullman, balancoire),
                new Rue(balancoire, boulevardDeLEurope),
                new Rue(balancoire, esti),
                new Rue(boulevardDeLEurope, esti)
        )));

        var trajets = bjarni.marcher(hei, esti);

        assertEquals(trajets.get(trajets.size() - 1), esti);
        assertTrue(trajets.contains(balancoire));
    }

    @Test
    void bjarni_de_esti_vers_marais(){
        var sekolintsika = new Lieu("Sekolintsika");
        var marais = new Lieu("Marais");
        var hei = new Lieu("HEI");
        var esti = new Lieu("ESTI");
        var pullman = new Lieu("Pullman");
        var boulevardDeLEurope = new Lieu("Boulevard De L'Europe");
        var nexta = new Lieu("Nexta");
        var balancoire = new Lieu("Balancoire");

        var bjarni = new Marcheur("Bjarni");
        var tana = new Carte(new HashSet<>(Set.of(
                new Rue(marais, sekolintsika),
                new Rue(sekolintsika, hei),
                new Rue("Rue Andriatsihorana", hei, pullman),
                new Rue(hei, balancoire),
                new Rue(pullman, nexta),
                new Rue(pullman, balancoire),
                new Rue(balancoire, boulevardDeLEurope),
                new Rue(balancoire, esti),
                new Rue(boulevardDeLEurope, esti)
        )));

        var trajets = bjarni.marcher(esti, marais);
        assertEquals(trajets.get(trajets.size() - 1), marais);
        assertTrue(trajets.containsAll(List.of(balancoire, hei, sekolintsika, marais)));
    }
}