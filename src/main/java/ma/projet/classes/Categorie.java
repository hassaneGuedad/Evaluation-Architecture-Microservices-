package ma.projet.classes;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "categorie")
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Produit> produits;

    public Categorie() {}
    public Categorie(String nom) { this.nom = nom; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Set<Produit> getProduits() { return produits; }
    public void setProduits(Set<Produit> produits) { this.produits = produits; }
}
