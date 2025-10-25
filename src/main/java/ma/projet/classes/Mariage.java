package ma.projet.classes;

import java.time.LocalDate;

public class Mariage {
    private Femme femme;
    private LocalDate dateDebut;
    private LocalDate dateFin; // null = mariage en cours
    private int nbEnfants;

    public Mariage(Femme femme, LocalDate dateDebut, LocalDate dateFin, int nbEnfants) {
        this.femme = femme;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbEnfants = nbEnfants;
    }

    public Femme getFemme() { return femme; }
    public LocalDate getDateDebut() { return dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public int getNbEnfants() { return nbEnfants; }

    public boolean estEnCours() { return dateFin == null; }
}
