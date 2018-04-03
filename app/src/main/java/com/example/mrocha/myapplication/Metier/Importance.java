package com.example.mrocha.myapplication.Metier;

/*
###############################################
Nom de la classe : ImportanceDAO
Ajouter par : Marco
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Classe ImportanceDAO pour la base de données
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
Ajouter par : Marco
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Méthodes permettant de retourner un attribut de l'objet ImportanceDAO ou de le modifier
###############################################
*/

    //Catégorie "Getter & Setter"

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

    //Fin catégorie "Getter & Setter"

        /*
###############################################
Nom de la méthode : toString
Ajouter par : Marco
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Méthodes permettant de retourner une chaîne de caractères. Dans ce cas, la description de l'objet.
###############################################
 */

    @Override
    public String toString() {
        return "ImportanceDAO{" +
                "id=" + id +
                ", niveau=" + niveau +
                '}';
    }
}
