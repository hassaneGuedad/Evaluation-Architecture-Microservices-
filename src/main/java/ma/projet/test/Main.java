package ma.projet.test;

import ma.projet.classes.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Commande c = new Commande(4, LocalDate.of(2013, 3, 14));

        Produit p1 = new Produit("ES12", 120);
        Produit p2 = new Produit("ZR85", 100);
        Produit p3 = new Produit("EE85", 200);

        c.ajouterLigne(new LigneCommande(p1, 7));
        c.ajouterLigne(new LigneCommande(p2, 14));
        c.ajouterLigne(new LigneCommande(p3, 5));

        c.afficher();
    }
}
