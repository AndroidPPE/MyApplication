package com.example.mrocha.myapplication.Metier;

/**
 * Created by gboisson on 03/04/2018.
 */

public class Client {
    int id;
    String nom;
    int cp;
    String ville;
    String adresse;
    String com;
    Commerciaux leCommercial;
    Importance lImportance;

    public Client(int id, String nom, int cp, String ville, String adresse, String com, Commerciaux leCommercial, Importance lImportance) {
        this.id = id;
        this.nom = nom;
        this.cp = cp;
        this.ville = ville;
        this.adresse = adresse;
        this.com = com;
        this.leCommercial = leCommercial;
        this.lImportance = lImportance;
    }

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

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public Commerciaux getLeCommercial() {
        return leCommercial;
    }

    public void setLeCommercial(Commerciaux leCommercial) {
        this.leCommercial = leCommercial;
    }

    public Importance getlImportance() {
        return lImportance;
    }

    public void setlImportance(Importance lImportance) {
        this.lImportance = lImportance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", cp=" + cp +
                ", ville='" + ville + '\'' +
                ", adresse='" + adresse + '\'' +
                ", com='" + com + '\'' +
                ", leCommercial=" + leCommercial +
                ", lImportance=" + lImportance +
                '}';
    }
}

