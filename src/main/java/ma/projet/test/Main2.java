package ma.projet.test;

import ma.projet.classes.Tache;
import ma.projet.classes.Projet;
import ma.projet.classes.Employe;
import ma.projet.service.TacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.EmployeService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        // --- Créer quelques tâches ---
        Tache t1 = new Tache(12,"Analyse",1500, LocalDate.of(2013,2,10), LocalDate.of(2013,2,20));
        Tache t2 = new Tache(13,"Conception",900, LocalDate.of(2013,3,10), LocalDate.of(2013,3,15));
        Tache t3 = new Tache(14,"Développement",2000, LocalDate.of(2013,4,10), LocalDate.of(2013,4,25));
        Tache t4 = new Tache(15,"Tests",800, LocalDate.of(2013,5,1), LocalDate.of(2013,5,10));

        List<Tache> toutesTaches = Arrays.asList(t1,t2,t3,t4);

        // --- Créer projet ---
        Projet p1 = new Projet(4,"Gestion de stock", LocalDate.of(2013,1,14));
        p1.ajouterTache(t1);
        p1.ajouterTache(t2);
        p1.ajouterTache(t3);

        // --- Créer employé ---
        Employe e1 = new Employe(1,"Ali");
        e1.ajouterTache(t1);
        e1.ajouterTache(t2);

        // --- Services ---
        TacheService ts = new TacheService();
        ProjetService ps = new ProjetService();
        EmployeService es = new EmployeService();

        // --- Afficher tâches projet ---
        ps.afficherTachesReelles(p1);

        // --- Tâches prix > 1000 ---
        System.out.println("\nTâches avec prix > 1000 DH :");
        List<Tache> tachesPrixEleve = ts.tachesPrixSuperieur(toutesTaches,1000);
        for(Tache t : tachesPrixEleve){
            System.out.println(t.getNom() + " - " + t.getPrix() + " DH");
        }

        // --- Tâches entre deux dates ---
        System.out.println("\nTâches réalisées entre 01/02/2013 et 30/04/2013 :");
        List<Tache> tachesEntre = ts.tachesEntreDates(toutesTaches, LocalDate.of(2013,2,1), LocalDate.of(2013,4,30));
        for(Tache t : tachesEntre){
            System.out.println(t.getNom() + " - " + t.getDateDebutReelle() + " à " + t.getDateFinReelle());
        }

        // --- Tâches par employé ---
        System.out.println("\nTâches réalisées par l'employé " + e1.getNom() + " :");
        List<Tache> tachesEmploye = es.tachesParEmploye(e1);
        for(Tache t : tachesEmploye){
            System.out.println(t.getNom());
        }

        // --- Projets/Tâches gérés par l'employé ---
        System.out.println("\nProjets/Tâches gérés par l'employé " + e1.getNom() + " :");
        List<Tache> projetsEmploye = es.projetsParEmploye(e1);
        for(Tache t : projetsEmploye){
            System.out.println(t.getNom());
        }
    }
}
