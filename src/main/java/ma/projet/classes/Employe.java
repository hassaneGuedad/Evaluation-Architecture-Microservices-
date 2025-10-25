package ma.projet.classes;

import java.util.ArrayList;
import java.util.List;

public class Employe {
    private int id;
    private String nom;
    private List<Tache> taches = new ArrayList<>();

    public Employe(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void ajouterTache(Tache tache) {
        taches.add(tache);
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public List<Tache> getTaches() { return taches; }
}
