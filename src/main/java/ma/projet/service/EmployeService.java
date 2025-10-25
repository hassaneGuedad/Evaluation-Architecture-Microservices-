package ma.projet.service;

import ma.projet.classes.Employe;
import ma.projet.classes.Tache;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeService {

    // Afficher la liste des tâches réalisées par un employé
    public List<Tache> tachesParEmploye(Employe e) {
        return e.getTaches();
    }

    // Afficher la liste des projets gérés par un employé (tâches regroupées par projet)
    public List<Tache> projetsParEmploye(Employe e) {
        return e.getTaches();
    }
}
