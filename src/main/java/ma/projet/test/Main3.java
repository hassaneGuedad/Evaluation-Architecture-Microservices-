package ma.projet.test;

import ma.projet.classes.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // --- Créer 10 femmes ---
        Femme f1 = new Femme("SALIMA RAMI", LocalDate.of(1970,5,10));
        Femme f2 = new Femme("AMAL ALI", LocalDate.of(1972,8,15));
        Femme f3 = new Femme("WAFA ALAOUI", LocalDate.of(1975,12,20));
        Femme f4 = new Femme("KARIMA ALAMI", LocalDate.of(1968,3,2));
        Femme f5 = new Femme("NADIA BENSAID", LocalDate.of(1978,7,5));
        Femme f6 = new Femme("LAILA ZAHRA", LocalDate.of(1980,9,12));
        Femme f7 = new Femme("HANANE KHALID", LocalDate.of(1965,1,20));
        Femme f8 = new Femme("SAMIRA ELAMI", LocalDate.of(1973,2,28));
        Femme f9 = new Femme("NOURA BOUKILI", LocalDate.of(1976,11,1));
        Femme f10 = new Femme("FATIMA RAHIM", LocalDate.of(1982,4,18));

        List<Femme> femmes = Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10);

        // --- Créer 5 hommes ---
        Homme h1 = new Homme("SAFI SAID", LocalDate.of(1965,1,1));
        Homme h2 = new Homme("MOHAMED ELAMI", LocalDate.of(1968,6,5));
        Homme h3 = new Homme("YASSINE BENJAMIN", LocalDate.of(1970,12,12));
        Homme h4 = new Homme("HICHAM KHALID", LocalDate.of(1969,3,14));
        Homme h5 = new Homme("ADIL RAHIM", LocalDate.of(1972,8,20));

        List<Homme> hommes = Arrays.asList(h1,h2,h3,h4,h5);

        // --- Ajouter des mariages ---
        h1.ajouterMariage(new Mariage(f1, LocalDate.of(1990,9,3), null, 4));
        h1.ajouterMariage(new Mariage(f2, LocalDate.of(1995,9,3), null, 2));
        h1.ajouterMariage(new Mariage(f3, LocalDate.of(2000,11,4), null, 3));
        h1.ajouterMariage(new Mariage(f4, LocalDate.of(1989,9,3), LocalDate.of(1990,9,3), 0));

        h2.ajouterMariage(new Mariage(f5, LocalDate.of(1992,5,3), null, 1));
        h2.ajouterMariage(new Mariage(f6, LocalDate.of(2000,3,2), null, 2));
        h2.ajouterMariage(new Mariage(f7, LocalDate.of(1988,1,10), LocalDate.of(1990,1,15), 0));

        h3.ajouterMariage(new Mariage(f8, LocalDate.of(1995,6,20), null, 3));
        h3.ajouterMariage(new Mariage(f9, LocalDate.of(2000,8,10), null, 2));
        h3.ajouterMariage(new Mariage(f10, LocalDate.of(2005,2,25), null, 1));
        h3.ajouterMariage(new Mariage(f1, LocalDate.of(1985,5,15), LocalDate.of(1988,5,15), 0));

        // --- Afficher la liste des femmes ---
        System.out.println("=== Liste des femmes ===");
        for(Femme f : femmes){
            System.out.println(f.getNom() + " - " + f.getDateNaissance().format(formatter));
        }

        // --- Afficher la femme la plus âgée ---
        Femme plusAgee = femmes.stream().min(Comparator.comparing(Femme::getDateNaissance)).get();
        System.out.println("\nFemme la plus âgée : " + plusAgee.getNom());

        // --- Afficher les épouses d’un homme donné (ex: h1) ---
        System.out.println("\nÉpouses de " + h1.getNom() + " :");
        for(Mariage m : h1.getMariages()){
            System.out.println(m.getFemme().getNom());
        }

        // --- Afficher le nombre d’enfants d’une femme entre deux dates ---
        LocalDate d1 = LocalDate.of(1990,1,1);
        LocalDate d2 = LocalDate.of(2000,12,31);
        System.out.println("\nNombre d'enfants de SALIMA RAMI entre 1990 et 2000 :");
        int nbEnfants = 0;
        for(Homme h : hommes){
            for(Mariage m : h.getMariages()){
                if(m.getFemme().getNom().equals("SALIMA RAMI")){
                    if(!m.getDateDebut().isAfter(d2) && !m.getDateDebut().isBefore(d1)){
                        nbEnfants += m.getNbEnfants();
                    }
                }
            }
        }
        System.out.println(nbEnfants);

        // --- Afficher les femmes mariées deux fois ou plus ---
        System.out.println("\nFemmes mariées deux fois ou plus :");
        Map<String,Integer> compteurMariages = new HashMap<>();
        for(Homme h : hommes){
            for(Mariage m : h.getMariages()){
                compteurMariages.put(m.getFemme().getNom(),
                        compteurMariages.getOrDefault(m.getFemme().getNom(),0)+1);
            }
        }
        compteurMariages.forEach((nom,cpt) -> {
            if(cpt>=2) System.out.println(nom + " - " + cpt + " mariages");
        });

        // --- Afficher les hommes mariés à 4 femmes entre deux dates ---
        System.out.println("\nHommes mariés à 4 femmes :");
        for(Homme h : hommes){
            long count = h.getMariages().stream()
                    .filter(m -> m.getDateDebut().isAfter(LocalDate.of(1980,1,1)) &&
                            m.getDateDebut().isBefore(LocalDate.of(2025,12,31)))
                    .count();
            if(count >= 4) System.out.println(h.getNom());
        }

        // --- Afficher les mariages d’un homme avec tous les détails (ex: h1) ---
        System.out.println("\nDétails des mariages de " + h1.getNom() + " :");
        int i=1;
        for(Mariage m : h1.getMariages()){
            System.out.println(i + ". Femme : " + m.getFemme().getNom() +
                    "   Date Début : " + m.getDateDebut().format(formatter) +
                    (m.estEnCours() ? "" : "    Date Fin : " + m.getDateFin().format(formatter)) +
                    "    Nbr Enfants : " + m.getNbEnfants());
            i++;
        }
    }
}
