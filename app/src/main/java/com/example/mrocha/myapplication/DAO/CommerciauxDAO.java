package com.example.mrocha.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mrocha.myapplication.Metier.Client;
import com.example.mrocha.myapplication.Metier.Commerciaux;
import com.example.mrocha.myapplication.Metier.Importance;

import java.util.ArrayList;

/*
    ###############################################
    Nom de la classe : CommerciauxDAO
    Ajouter par : Marcoux
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Classe permettant une interaction avec la base de données pour l'objet Commerciaux
    ###############################################
     */

public class CommerciauxDAO{

    private MonSQLiteOH dbMyApplication;

    private static final String TABLE_COMMERCIAUX = "COMMERCIAUX";
    private static final String COL_ID_COMMERCIAUX = "IDCOMMERCIAUX";
    private static final String COL_NOMCOMMERCIAUX = "NOMCOMMERCIAUX";
    private static final String COL_PRENOMCOMMERCIAUX = "PRENOMCOMMERCIAUX";
    private static final String COL_TELCOMMERCIAUX = "TELCOMMERCIAUX";

    private SQLiteDatabase db;

    /*
    ###############################################
    Nom de la méthode : CommerciauxDAO
    Ajouter par : Marcoux
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Méthode créant la base de données bdMyApplication
    ###############################################
     */

    public CommerciauxDAO(Context context) {

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
    Description : Méthode insérant des données tiré de l'objet Commerciaux dans la table COMMERCIAUX
    ###############################################
    */

    public boolean insert(Commerciaux unCommercial) {
        boolean res = false;
        long insert;

        ContentValues contenu = new ContentValues();
        contenu.put(COL_NOMCOMMERCIAUX, unCommercial.getNom());
        contenu.put(COL_PRENOMCOMMERCIAUX, unCommercial.getPrenom());
        contenu.put(COL_TELCOMMERCIAUX, unCommercial.getTel());

        insert = db.insert(TABLE_COMMERCIAUX, null, contenu);

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
Description : Méthode qui met à jour des données tiré de l'objet Commerciaux dans la table COMMERCIAUX
###############################################
*/
    public boolean update(Commerciaux obj) {
        boolean res = false;
        long update;

        ContentValues contenu = new ContentValues();
        contenu.put(COL_NOMCOMMERCIAUX, obj.getNom());
        contenu.put(COL_PRENOMCOMMERCIAUX, obj.getPrenom());
        contenu.put(COL_TELCOMMERCIAUX, obj.getTel());

        update = db.update(TABLE_COMMERCIAUX,contenu,null,null);

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
    Description : Méthode supprimant des données dans la table COMMERCIAUX
    ###############################################
    */

    public boolean delete(Commerciaux obj) {
        boolean res = false;
        long delete;

        delete = db.delete(TABLE_COMMERCIAUX, null, null);

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
Description : Fontion récupérant des données de la table COMMERCIAUX pour les stocker dans un arraylist qui sera retourné
###############################################
*/
    public ArrayList<Commerciaux> read() {
        ArrayList<Commerciaux> returnListCommerciaux = new ArrayList<Commerciaux>();
        Cursor curseur;

        int res;
        int idCommerciaux;
        String nomCommerciaux;
        String prenomCommerciaux;
        int telCommerciaux;
        Commerciaux unCommercial;

        unCommercial = new Commerciaux(0,null,null,0);

        res = 0;
        curseur = db.query(TABLE_COMMERCIAUX, null, null, null, null, null, null);
        curseur.moveToFirst();
        while (res > curseur.getCount()) {
            idCommerciaux = curseur.getInt(0);
            nomCommerciaux = curseur.getString(1);
            prenomCommerciaux = curseur.getString(2);
            telCommerciaux = curseur.getInt(3);
            returnListCommerciaux.add(unCommercial);
        }
        curseur.close();

        return returnListCommerciaux;
    }
}
