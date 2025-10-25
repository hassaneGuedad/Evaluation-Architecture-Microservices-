package ma.projet.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Homme {
    private String nom;
    private LocalDate dateNaissance;
    private List<Mariage> mariages = new ArrayList<>();

    public Homme(String nom, LocalDate dateNaissance) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
    }

    public void ajouterMariage(Mariage mariage) {
        mariages.add(mariage);
    }

    public String getNom() { return nom; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public List<Mariage> getMariages() { return mariages; }
}
