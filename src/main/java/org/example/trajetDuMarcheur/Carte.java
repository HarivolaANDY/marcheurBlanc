package org.example.trajetDuMarcheur;

import java.util.List;

public record Carte(List<Rue> rues)  {

    public void ajouterLieu(Lieu depart) {
        Lieu lieu= depart;
        rues.add(new Rue(lieu, null));
    }

    public void ajouterRue(Rue rue) {
        Rue rue1= rue;
        rues.add()
    }
}
