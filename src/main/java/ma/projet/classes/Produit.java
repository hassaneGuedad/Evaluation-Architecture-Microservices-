package ma.projet.classes;

public class Produit {
    private String reference;
    private double prix;

    public Produit(String reference, double prix) {
        this.reference = reference;
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public double getPrix() {
        return prix;
    }
}
