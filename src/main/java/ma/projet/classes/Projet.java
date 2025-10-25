package ma.projet.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projet {
    private int id;
    private String nom;
    private LocalDate dateDebut;
    private List<Tache> taches = new ArrayList<>();

    public Projet(int id, String nom, LocalDate dateDebut) {
        this.id = id;
        this.nom = nom;
        this.dateDebut = dateDebut;
    }

    public void ajouterTache(Tache tache) {
        taches.add(tache);
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public LocalDate getDateDebut() { return dateDebut; }
    public List<Tache> getTaches() { return taches; }
}
