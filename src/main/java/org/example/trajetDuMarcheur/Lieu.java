package org.example.trajetDuMarcheur;

import lombok.Data;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
public class Lieu {
    private final String nom;
    private final Set<Rue> rues = new HashSet<>();

    public Lieu(String nom) {
        this.nom = nom;
    }

    public void ajouterRue(Rue rue) {
        rues.add(rue);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lieu lieu = (Lieu) o;
        return Objects.equals(nom, lieu.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nom);
    }
}
