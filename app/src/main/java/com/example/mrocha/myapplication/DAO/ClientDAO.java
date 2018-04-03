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
    Nom de la classe : ClientDAO
    Ajouter par : Marcoux
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Classe permettant une interaction avec la base de données pour l'objet Client
    ###############################################
     */

public class ClientDAO {

    private MonSQLiteOH dbMyApplication;

    private static final String TABLE_CLIENT = "CLIENT";
    private static final String COL_ID_CLIENT = "IDCLIENT";
    private static final String COL_NOMCLIENT = "NOMCLIENT";
    private static final String COL_CP = "CP";
    private static final String COL_VILLE = "VILLE";
    private static final String COL_ADRESSE = "ADRESSE";
    private static final String COL_COM = "COM"; //COM = COMMENTAIRE
    private static final String COL_COMMERCIAUX = "COMMERCIAUX";
    private static final String COL_IMPORTANCE = "IMPORTANCE";

    private SQLiteDatabase db;

    /*
    ###############################################
    Nom de la méthode : ClientDAO
    Ajouter par : Marcoux
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Méthode créant la base de données bdMyApplication
    ###############################################
     */

    public ClientDAO(Context context) {

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
    Description : Méthode insérant des données tiré de l'objet Client dans la table CLIENT
    ###############################################
    */

    public boolean insert(Client unClient) {
        boolean res = false;
        long insert;

        ContentValues contenu = new ContentValues();
        contenu.put(COL_NOMCLIENT, Client.getNom());
        contenu.put(COL_CP, Client.getCp());
        contenu.put(COL_VILLE, Client.getVille());
        contenu.put(COL_ADRESSE, Client.getAdresse());
        contenu.put(COL_COM, Client.getCom());
        contenu.put(COL_COMMERCIAUX, Client.getLeCommercial());
        contenu.put(COL_IMPORTANCE, Client.getlImportance());

        insert = db.insert(TABLE_CLIENT, null, contenu);

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
Description : Méthode qui met à jour des données tiré de l'objet Client dans la table CLIENT
###############################################
*/
    public boolean update(Client obj) {
        boolean res = false;
        long update;

        ContentValues contenu = new ContentValues();
        contenu.put(COL_NOMCLIENT, obj.getNom());
        contenu.put(COL_CP, obj.getCp());
        contenu.put(COL_VILLE, obj.getVille());
        contenu.put(COL_ADRESSE, obj.getAdresse());
        contenu.put(COL_COM, obj.getCom());
        contenu.put(COL_COMMERCIAUX, obj.getLeCommercial());
        contenu.put(COL_IMPORTANCE, obj.getlImportance());

        update = db.update(TABLE_CLIENT,contenu,null,null);

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
    Description : Méthode supprimant des données dans la table CLIENT
    ###############################################
    */

    public boolean delete(Client obj) {
        boolean res = false;
        long delete;

        delete = db.delete(TABLE_CLIENT, null, null);

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
Description : Fontion récupérant des données de la table CLIENT pour les stocker dans un arraylist qui sera retourné
###############################################
*/
    public ArrayList<Client> read() {
        ArrayList<Client> returnListClient = new ArrayList<Client>();
        Cursor curseur;

        int res;
        int idClient;
        String nomClient;
        int cp;
        String ville;
        String adresse;
        String com;
        Commerciaux unCommercial;
        Importance uneImportance;
        Client unClient;

        res = 0;
        curseur = db.query(TABLE_CLIENT, null, null, null, null, null, null);
        curseur.moveToFirst();
        while (res > curseur.getCount()) {
            idClient = curseur.getInt(0);
            nomClient = curseur.getString(1);
            cp = curseur.getInt(2);
            ville = curseur.getString(3);
            adresse = curseur.getString(4);
            com = curseur.getString(5);
            unCommercial = unCommercial.getNom();
            uneImportance = uneImportance.getNiveau()
            unClient = new Client(idClient, nomClient, cp, ville, adresse, com, unCommercial, uneImportance);
            returnListClient.add(unClient);
        }
        curseur.close();

        return returnListClient;
    }
}
