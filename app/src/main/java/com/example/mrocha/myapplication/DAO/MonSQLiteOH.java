package com.example.mrocha.myapplication.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
    ###############################################
    Nom de la classe : MonSQLiteOH
    Ajouter par : Gwen
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Class permettant de ce connecter à la base de données
    ###############################################
     */

public class MonSQLiteOH extends SQLiteOpenHelper {

    //version de la base de données, à modifier à chaque modification de stucture
    private static final int DATABASE_VERSION = 1;

    //nom de la base de données à utiliser
    private static final String DATABASE_NAME="DbMyApplication";

    //Contexte
    private Context context = null;

    public MonSQLiteOH(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    /*
    ###############################################
    Méthode onCreate
    Ajouter par : Gwen
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Définition de le méthode onCreate éxecutée si la base de données n'éxiste pas déjà, ou à la demande
    ###############################################
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("DROP TABLE IF EXISTE COMMERCIAUX");
            db.execSQL("DROP TABLE IF EXISTE IMPORTANCE");
            db.execSQL("DROP TABLE IF EXISTE CLIENT");
            db.execSQL("DROP TABLE IF EXISTE VISITE");

            db.execSQL("CREATE TABLE COMMERCIAUX (IDCOMMERCIAUX INTEGER PRIMARY KEY AUTOINCREMENT, NOM VARCHAR(100), PRENOM VARCHAR(100), TEL INT(11)" +
                    "CONSTRAINTS PK_COMMERCIAUX PRIMARY KEY (IDCOMMERCIAUX))");
            db.execSQL("CREATE TABLE IMPORTANCE (IDIMPORTANCE INTEGER PRIMARY KEY AUTOINCREMENT,  NIVEAU INT(11)" +
                    "CONSTRAINTS PK_IMPORTANCE PRIMARY KEY (IDIMPORTANCE))");
            db.execSQL("CREATE TABLE CLIENT (IDCLIENT INTEGER PRIMARY KEY AUTOINCREMENT, CP INT(11), VILLE VARCHAR(100), ADRESSE VARCHAR(100), COM VARCHAR(100), COMMERCIAUX INT(11), IMPORTANCE INT(11)" +
                    "CONSTRAINTS PK_CLIENT PRIMARY KEY (IDCLIENT) " +
                    ")");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

     /*
    ###############################################
    Méthode onCreate
    Ajouter par : Gwen
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Définition de le méthode onUpgrade éxecutée si la base de données change de version, ou à la demande
    ###############################################
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
