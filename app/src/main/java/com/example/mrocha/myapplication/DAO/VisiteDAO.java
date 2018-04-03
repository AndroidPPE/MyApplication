package com.example.mrocha.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mrocha.myapplication.Metier.Commerciaux;
import com.example.mrocha.myapplication.Metier.Importance;
import com.example.mrocha.myapplication.Metier.Visite;

import java.util.ArrayList;
import java.util.Date;

/*
    ###############################################
    Nom de la classe : VisiteDAO
    Ajouter par : Marcoux
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Classe permettant une interaction avec la base de données pour l'objet Visite
    ###############################################
     */

public class VisiteDAO {

    private MonSQLiteOH dbMyApplication;

    private static final String TABLE_VISITE = "VISITE";
    private static final String COL_ID_VISITE = "IDVISITE";
    private static final String COL_DATEVISITE = "DATEVISITE";
    private static final String COL_COMMERCIAUX = "COMMERCIAUX";
    private static final String COL_IMPORTANCE = "IMPORTANCE";

    private SQLiteDatabase db;

    /*
    ###############################################
    Nom de la méthode : VisiteDAO
    Ajouter par : Marcoux
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Méthode créant la base de données bdMyApplication
    ###############################################
     */

    public VisiteDAO(Context context) {

        MonSQLiteOH dbMyApplication = new MonSQLiteOH(context);
    }


    /*
###############################################
Nom de la méthode : open
Ajouter par : Marcoux
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Méthode ouvrant la connexion à la base de données (NLDR : dbMyApplication)
###############################################
 */

    public void open() {

        db = dbMyApplication.getWritableDatabase();
    }


    /* ###############################################
     Nom de la méthode : close
     Ajouter par : Marcoux
     Date d'ajout : 03/04/2018
     Version d'ajout : V1
     Description : Méthode fermant la connexion à la base de données
     ###############################################
         */
    public void close() {
        db.close();
    }

    /*
    ###############################################
    Nom de la méthode : insert
    Ajouter par : Marcoux
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Méthode insérant des données tiré de l'objet Importance dans la table VISITE
    ###############################################
    */

    public boolean insert(Visite uneVisite) {
        boolean res = false;
        long insert;
        Commerciaux unCommercial;
        Importance uneImportance;

        unCommercial = new Commerciaux(0,null,null,0);
        uneImportance = new Importance(0,0);

        ContentValues contenu = new ContentValues();
        contenu.put(COL_DATEVISITE, uneVisite.getDate().toString());
        contenu.put(COL_COMMERCIAUX, unCommercial.toString());
        contenu.put(COL_IMPORTANCE,uneImportance.toString());

        insert = db.insert(TABLE_VISITE, null, contenu);

        if (insert != -1){
            res = true;
        }

        return res;
    }

    /*
###############################################
Nom de la méthode : update
Ajouter par : Marcoux
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Méthode qui met à jour des données tiré de l'objet Visite dans la table VISITE
###############################################
*/
    public boolean update(Visite obj) {
        boolean res = false;
        long update;
        Commerciaux unCommercial;
        Importance uneImportance;

        unCommercial = new Commerciaux(0,null,null,0);
        uneImportance = new Importance(0,0);

        ContentValues contenu = new ContentValues();
        contenu.put(COL_DATEVISITE, obj.getDate().toString());
        contenu.put(COL_COMMERCIAUX, unCommercial.toString());
        contenu.put(COL_IMPORTANCE,uneImportance.toString());

        update = db.update(TABLE_VISITE,contenu,null,null);

        if(update == 1){
            res = true;
        }

        return res;
    }

        /*
    ###############################################
    Nom de la méthode : delete
    Ajouter par : Marcoux
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Méthode supprimant des données dans la table VISITE
    ###############################################
    */

    public boolean delete(Visite obj) {
        boolean res = false;
        long delete;

        delete = db.delete(TABLE_VISITE, null, null);

        if(delete > 0){
            res = true;
        }

        return res;
    }

    /*
###############################################
Nom de la méthode : read
Ajouter par : Marcoux
Date d'ajout : 03/04/2018
Version d'ajout : V1
Description : Fontion récupérant des données de la table IMPORTANCE pour les stocker dans un arraylist qui sera retourné
###############################################
*/
    public ArrayList<Visite> read() {
        ArrayList<Visite> returnListVisite = new ArrayList<Visite>();
        Cursor curseur;

        int res;
        int idVisite;
        String dateVisite;
        String leCommercial;
        String lImportance;

        Commerciaux unCommercial = new Commerciaux(0,null,null,0);
        Importance uneImportance = new Importance(0,0);

        res = 0;
        curseur = db.query(TABLE_VISITE, null, null, null, null, null, null);
        curseur.moveToFirst();
        while (res > curseur.getCount()) {
            idVisite = curseur.getInt(0);
            dateVisite = curseur.getString(1);
            leCommercial = unCommercial.toString();
            lImportance = Importance.read(uneImportance);
        }
        curseur.close();

        return returnListVisite;
    }
}
