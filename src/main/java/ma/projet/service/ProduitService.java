package ma.projet.service;

import ma.projet.classes.Commande;
import ma.projet.classes.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.time.LocalDate;
import java.util.List;

public class ProduitService {

    public List<Produit> findByCategorie(Long categorieId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query<Produit> q = s.createQuery("SELECT p FROM Produit p WHERE p.categorie.id = :cid", Produit.class);
        q.setParameter("cid", categorieId);
        List<Produit> res = q.list();
        s.close();
        return res;
    }

    // produits commandés entre deux dates : retourne liste d'objets [commandeId, date, reference, prix, quantite]
    public List<Object[]> produitsCommandesEntre(LocalDate d1, LocalDate d2) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "SELECT cmd.id, cmd.dateCommande, p.reference, lc.prixUnitaire, lc.quantite " +
                "FROM LigneCommande lc JOIN lc.commande cmd JOIN lc.produit p " +
                "WHERE cmd.dateCommande BETWEEN :d1 AND :d2";
        Query<Object[]> q = s.createQuery(hql, Object[].class);
        q.setParameter("d1", d1);
        q.setParameter("d2", d2);
        List<Object[]> res = q.list();
        s.close();
        return res;
    }

    public List<Produit> produitsDansCommande(Long commandeId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "SELECT lc.produit FROM LigneCommande lc WHERE lc.commande.id = :cid";
        List<Produit> res = s.createQuery(hql, Produit.class)
                .setParameter("cid", commandeId)
                .list();
        s.close();
        return res;
    }

    public List<Produit> produitsPrixSup(double prix) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Produit> res = s.createNamedQuery("Produit.findPrixSup", Produit.class)
                .setParameter("prix", prix)
                .getResultList();
        s.close();
        return res;
    }
}
