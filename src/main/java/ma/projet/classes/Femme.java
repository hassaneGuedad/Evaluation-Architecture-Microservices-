package ma.projet.classes;

import java.time.LocalDate;

public class Femme {
    private String nom;
    private LocalDate dateNaissance;

    public Femme(String nom, LocalDate dateNaissance) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
    }

    public String getNom() { return nom; }
    public LocalDate getDateNaissance() { return dateNaissance; }
}
