package com.example.mrocha.myapplication.Metier;

/*
###############################################
Nom de la classe : Importance
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Classe Importance permettant pour la base de donnée
###############################################
 */

public class Importance {
    int id;
    int niveau;

    public Importance(int id, int niveau) {
        this.id = id;
        this.niveau = niveau;
    }

    /*
    ###############################################
    Méthodes de la catégorie "Getter & Setter"
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Méthodes permettant de retourner un attribut de l'objet Importance ou de le modifier
    ###############################################
     */

    //Catégorie Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    //Fin Getter & Setter

    @Override
    public String toString() {
        return "Importance{" +
                "id=" + id +
                ", niveau=" + niveau +
                '}';
    }
}
