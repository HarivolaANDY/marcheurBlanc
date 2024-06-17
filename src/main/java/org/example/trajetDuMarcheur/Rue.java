package org.example.trajetDuMarcheur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rue {
    private final String nomDeLaRue;
    private final Lieu lieuA;
    private final Lieu lieuB;

    public Rue(Lieu lieuA, Lieu lieuB) {
        this.nomDeLaRue= null;
        this.lieuA = lieuA;
        this.lieuB = lieuB;
    }

    public Lieu allerAutreLieu(Lieu lieu) {
        if (lieu.equals(lieuA)) {
            return lieuB;
        } else if (lieu.equals(lieuB)) {
            return lieuA;
        }
        return null;
    }
}
