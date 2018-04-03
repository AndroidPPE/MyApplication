package com.example.mrocha.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mrocha.myapplication.Metier.Importance;

import java.util.ArrayList;

/*
    ###############################################
    Nom de la classe : VisiteDAO
    Ajouter par : Marcoux
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Classe permettant une interaction avec la base de données pour l'objet Importance
    ###############################################
     */

public class ImportanceDAO {

    private MonSQLiteOH dbMyApplication;

    private static final String TABLE_IMPORTANCE = "COMMERCIAUX";
    private static final String COL_ID_IMPORTANCE = "IDIMPORTANCE";
    private static final String COL_NIVEAUIMPORTANCE = "NIVEAUIMPORTANCE";

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

    public ImportanceDAO(Context context) {

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
    Description : Méthode insérant des données tiré de l'objet Importance dans la table IMPORTANCE
    ###############################################
    */

    public boolean insert(Importance uneImportance) {
        boolean res = false;
        long insert;

        ContentValues contenu = new ContentValues();
        contenu.put(COL_NIVEAUIMPORTANCE, uneImportance.getNiveau());

        insert = db.insert(TABLE_IMPORTANCE, null, contenu);

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
Description : Méthode qui met à jour des données tiré de l'objet Importance dans la table IMPORTANCE
###############################################
*/
    public boolean update(Importance obj) {
        boolean res = false;
        long update;

        ContentValues contenu = new ContentValues();
        contenu.put(COL_NIVEAUIMPORTANCE, obj.getNiveau());

        update = db.update(TABLE_IMPORTANCE,contenu,null,null);

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
    Description : Méthode supprimant des données dans la table IMPORTANCE
    ###############################################
    */

    public boolean delete(Importance obj) {
        boolean res = false;
        long delete;

        delete = db.delete(TABLE_IMPORTANCE, null, null);

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
    public ArrayList<Importance> read() {
        ArrayList<Importance> returnListImportance = new ArrayList<Importance>();
        Cursor curseur;

        int res;
        int idImportance;
        int niveauImportance;

        res = 0;
        curseur = db.query(TABLE_IMPORTANCE, null, null, null, null, null, null);
        curseur.moveToFirst();
        while (res > curseur.getCount()) {
            idImportance = curseur.getInt(0);
            niveauImportance = curseur.getInt(1);
        }
        curseur.close();

        return returnListImportance;
    }
}
