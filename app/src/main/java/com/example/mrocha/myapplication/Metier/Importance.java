package com.example.mrocha.myapplication.Metier;

/**
 * Created by gboisson on 03/04/2018.
 */

public class Importance {
    int id;
    int niveau;

    public Importance(int id, int niveau) {
        this.id = id;
        this.niveau = niveau;
    }

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

    @Override
    public String toString() {
        return "Importance{" +
                "id=" + id +
                ", niveau=" + niveau +
                '}';
    }
}
