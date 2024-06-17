package org.example;

import lombok.Getter;
import org.example.trajetDuMarcheur.Carte;
import org.example.trajetDuMarcheur.Lieu;
import org.example.trajetDuMarcheur.Rue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Marcheur {
    private String nom;
    private Carte carte;
    @Getter
    private Lieu positionActuelle;

    public Marcheur(Lieu positionInitiale) {
        this.positionActuelle = positionInitiale;
    }

    public void marcherAleatoirement(Carte carte, String destination) {
        List<Lieu> visite = new ArrayList<>();
        Random aleatoire = new Random();
        Lieu lieuPrecedent = null;

        visite.add(positionActuelle);

        while (!positionActuelle.nom().equals(destination)) {
            List<Rue> rues = positionActuelle.getRuesAdjacentes();
            if (rues.isEmpty()) {
                System.out.println("Pas de rue disponible.");
                return;
            }

            List<Lieu> lieuxAccessibles = new ArrayList<>();
            for (Rue rue : rues) {
                Lieu prochainLieu = rue.allerAutreLieu(positionActuelle);
                if (!prochainLieu.equals(lieuPrecedent)) {
                    lieuxAccessibles.add(prochainLieu);
                }
            }

            if (lieuxAccessibles.isEmpty()) {
                for (Rue rue : rues) {
                    lieuxAccessibles.add(rue.allerAutreLieu(positionActuelle));
                }
            }

            Lieu prochainLieu = lieuxAccessibles.get(aleatoire.nextInt(lieuxAccessibles.size()));

            lieuPrecedent = positionActuelle;
            positionActuelle = prochainLieu;
            visite.add(positionActuelle);
        }

        System.out.print("Marche complétée : ");
        for (int i = 0; i < visite.size(); i++) {
            if (i != 0) {
                System.out.print(" -> ");
            }
            System.out.print(visite.get(i).nom());
        }
        System.out.println();
    }

    public List<Lieu> getVisite() {
        return new ArrayList<>();
    }
}
