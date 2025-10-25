package ma.projet.classes;

import java.time.LocalDate;

public class Tache {
    private int num;
    private String nom;
    private double prix;
    private LocalDate dateDebutReelle;
    private LocalDate dateFinReelle;

    public Tache(int num, String nom, double prix, LocalDate dateDebutReelle, LocalDate dateFinReelle) {
        this.num = num;
        this.nom = nom;
        this.prix = prix;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
    }

    public int getNum() { return num; }
    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public LocalDate getDateDebutReelle() { return dateDebutReelle; }
    public LocalDate getDateFinReelle() { return dateFinReelle; }
}
