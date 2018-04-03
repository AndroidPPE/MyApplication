package com.example.mrocha.myapplication.Metier;

/*
###############################################
Nom de la classe : Commerciaux
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Classe Commerciaux pour la base de données
###############################################
 */

public class Commerciaux {
    int id;
    String nom;
    String prenom;
    int tel;

    public Commerciaux(int id, String nom, String prenom, int tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    /*
###############################################
Méthodes de la catégorie "Getter & Setter"
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Méthodes permettant de retourner un attribut de l'objet Commerciaux ou de le modifier
###############################################
 */

    //Catégorie "Getter & Setter"

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    // Fin catégorie "Getter & Setter"

    @Override
    public String toString() {
        return "Commerciaux{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel=" + tel +
                '}';
    }
}
