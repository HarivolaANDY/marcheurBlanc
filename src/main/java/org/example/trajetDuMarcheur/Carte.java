package org.example.trajetDuMarcheur;

import lombok.Data;
import java.util.Set;

@Data
public class Carte {
    private final Set<Rue> rues;

    public Carte(Set<Rue> rues) {
        this.rues = rues;
    }
}
