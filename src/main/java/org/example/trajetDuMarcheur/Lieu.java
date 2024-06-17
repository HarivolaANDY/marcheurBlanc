package org.example.trajetDuMarcheur;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public record Lieu(String nom) {
    private static List<Rue> ruesAdjacentes;

    public Lieu(String nom) {
        this.nom = nom;
        ruesAdjacentes = new ArrayList<>();
    }

    public List<Rue> getRuesAdjacentes() {
        return ruesAdjacentes;
    }
    public void ajouterRueAdjacente(Rue rue) {
        ruesAdjacentes.add(rue);
    }

    public String getNom() {
        return nom;
    }
}
