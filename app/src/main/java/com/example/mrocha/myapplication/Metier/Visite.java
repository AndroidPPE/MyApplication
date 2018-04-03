package com.example.mrocha.myapplication.Metier;

import java.util.Date;

/*
###############################################
Nom de la classe : Visite
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Classe Visite pour la base de donnée
###############################################
 */

public class Visite {
    int id;
    Date date;
    Commerciaux leCommercial;
    Client leClient;

    public Visite(int id, Date date, Commerciaux leCommercial, Client leClient) {
        this.id = id;
        this.date = date;
        this.leCommercial = leCommercial;
        this.leClient = leClient;
    }

    /*
    ###############################################
    Méthodes de la catégorie "Getter & Setter"
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Méthodes permettant de retourner un attribut de l'objet Visite ou de le modifier
    ###############################################
     */

    //Catégorie Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Commerciaux getLeCommercial() {
        return leCommercial;
    }

    public void setLeCommercial(Commerciaux leCommercial) {
        this.leCommercial = leCommercial;
    }

    public Client getLeClient() {
        return leClient;
    }

    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

    //Fin Getter & Setter


    /*
###############################################
Nom de la méthode : toString
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Méthodes permettant de retourner une chaîne de caractères. Dans ce cas, la description de l'objet.
###############################################
 */
    @Override
    public String toString() {
        return "Visite{" +
                "id=" + id +
                ", date=" + date +
                ", leCommercial=" + leCommercial +
                ", leClient=" + leClient +
                '}';
    }
}
