Evaluation – Architecture et Programmation Java
Description

Ce projet contient trois exercices pratiques réalisés en Java, visant à développer des applications de gestion avec une architecture orientée objet et services. Chaque exercice comprend :

Une couche persistance (entités et relations)

Une couche service (logique métier)

Un programme de test avec affichage des résultats

Des captures d’écran d’exécution sont fournies pour illustrer le fonctionnement.

Exercice 1 – Gestion de stock d’un magasin de produits informatiques

Contexte :
Développer une application pour gérer les produits, catégories, commandes et lignes de commandes d’un magasin informatique.

Fonctionnalités :

Affichage des produits par catégorie

Affichage des produits commandés dans une commande donnée

Affichage des produits commandés entre deux dates

Affichage des produits dont le prix est supérieur à 100 DH

Exemple d’affichage :

Commande : 4     Date : 14 Mars 2013
Liste des produits :
Référence   Prix    Quantité
ES12        120 DH  7
ZR85        100 DH  14
EE85        200 DH  5


Screenshots :<img width="960" height="540" alt="CAP11" src="https://github.com/user-attachments/assets/60c72509-f485-4d04-a6b7-b889122532eb" />



Exercice 2 – Gestion de projets

Contexte :
Suivre le temps passé sur les projets et calculer les coûts globaux d’un bureau d’études.

Fonctionnalités :

Affichage des tâches planifiées et réalisées pour un projet

Affichage des tâches réalisées par un employé

Méthodes pour filtrer les tâches par prix ou par dates

Exemple d’affichage :

Projet : 4      Nom : Gestion de stock     Date début : 14 Janvier 2013
Liste des tâches:
Num Nom            Date Début Réelle   Date Fin Réelle
12  Analyse        10/02/2013          20/02/2013
13  Conception     10/03/2013          15/03/2013
14  Développement  10/04/2013          25/04/2013


Screenshots : <img width="957" height="540" alt="EX2" src="https://github.com/user-attachments/assets/1e6bb83a-8966-49fd-a59b-ae98157b82f1" />



Exercice 3 – Gestion de l’état civil

Contexte :
Gérer les citoyens et leurs relations matrimoniales dans une province.

Fonctionnalités :

Gestion des hommes et femmes, mariages et nombre d’enfants

Affichage des épouses d’un homme donné

Affichage des femmes mariées deux fois ou plus

Affichage des hommes mariés à quatre femmes entre deux dates

Exemple d’affichage :

Nom : SAFI SAID
Mariages En Cours :
1. Femme : SALIMA RAMI   Date Début : 03/09/1990    Nbr Enfants : 4
2. Femme : AMAL ALI      Date Début : 03/09/1995    Nbr Enfants : 2
3. Femme : WAFA ALAOUI   Date Début : 04/11/2000    Nbr Enfants : 3

Mariages échoués :
1. Femme : KARIMA ALAMI  Date Début : 03/09/1989    Date Fin : 03/09/1990    Nbr Enfants : 0


Screenshots :<img width="960" height="510" alt="ex3-1" src="https://github.com/user-attachments/assets/60d72fca-16ec-4608-b578-6d5b8a8b7f26" />
<img width="960" height="510" alt="ex3-2" src="https://github.com/user-attachments/assets/2c6f140f-5bfb-4b1f-a58f-d64c5d0cbcda" />



Structure du projet
/Evaluation
│
├─ /src
│   ├─ /main/java/ma/projet/classes    # Entités
│   ├─ /main/java/ma/projet/service    # Services
│   ├─ /main/java/ma/projet/dao        # Interface DAO
│   └─ /main/java/ma/projet/test       # Programmes de test
│
├─ /screens                           # Screenshots des exercices
├─ pom.xml                             # Projet Maven
└─ README.md

Instructions pour exécuter

Cloner le dépôt :

git clone https://github.com/hassaneGuedad/Evaluation-Architecture-Microservices-.git


Ouvrir le projet dans IntelliJ IDEA ou Eclipse

Compiler et exécuter les classes Main1.java, Main2.java et Main3.java pour tester les exercices

Vérifier les sorties console pour valider les fonctionnalités
