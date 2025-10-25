package ma.projet.service;

import ma.projet.classes.Projet;
import ma.projet.classes.Tache;

import java.util.List;

public class ProjetService {

    // Afficher la liste des tâches planifiées pour un projet
    public List<Tache> tachesProjet(Projet projet) {
        return projet.getTaches();
    }

    // Afficher la liste des tâches réalisées avec les dates réelles
    public void afficherTachesReelles(Projet projet) {
        System.out.println("Projet : " + projet.getId() + "    Nom : " + projet.getNom() +
                "     Date début : " + projet.getDateDebut());
        System.out.println("Liste des tâches:");
        for(Tache t : projet.getTaches()) {
            System.out.println(t.getNum() + "  " + t.getNom() + "   " +
                    t.getDateDebutReelle() + "   " + t.getDateFinReelle());
        }
    }
}
