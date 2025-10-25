package ma.projet.service;

import ma.projet.classes.Tache;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TacheService {

    // Afficher les tâches dont le prix est supérieur à 1000 DH
    public List<Tache> tachesPrixSuperieur(List<Tache> taches, double montant) {
        return taches.stream()
                .filter(t -> t.getPrix() > montant)
                .collect(Collectors.toList());
    }

    // Afficher les tâches réalisées entre deux dates
    public List<Tache> tachesEntreDates(List<Tache> taches, LocalDate d1, LocalDate d2) {
        return taches.stream()
                .filter(t -> !t.getDateDebutReelle().isBefore(d1) && !t.getDateFinReelle().isAfter(d2))
                .collect(Collectors.toList());
    }
}
