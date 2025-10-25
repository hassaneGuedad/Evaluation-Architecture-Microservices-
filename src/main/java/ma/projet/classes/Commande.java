package ma.projet.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int numero;
    private LocalDate date;
    private List<LigneCommande> lignes = new ArrayList<>();

    public Commande(int numero, LocalDate date) {
        this.numero = numero;
        this.date = date;
    }

    public void ajouterLigne(LigneCommande ligne) {
        lignes.add(ligne);
    }

    public void afficher() {
        System.out.println("Commande : " + numero + "     Date : " + date);
        System.out.println("Liste des produits :");
        System.out.println("Référence\tPrix\tQuantité");
        for (LigneCommande lc : lignes) {
            System.out.println(lc.getProduit().getReference() + "\t\t" +
                    lc.getProduit().getPrix() + " DH\t" + lc.getQuantite());
        }
    }
}
