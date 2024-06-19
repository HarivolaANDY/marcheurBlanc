package org.example.trajetDuMarcheur;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@Getter
@EqualsAndHashCode
public class Rue {
    private final String nom;
    private final Lieu lieuA;
    private final Lieu lieuB;

    public Rue(String nom, Lieu lieuA, Lieu lieuB) {
        this.nom = nom;
        this.lieuA = lieuA;
        this.lieuB = lieuB;
        lieuA.ajouterRue(this);
        lieuB.ajouterRue(this);
    }

    public Rue(Lieu lieuA, Lieu lieuB) {
        this("", lieuA, lieuB);
    }
}
