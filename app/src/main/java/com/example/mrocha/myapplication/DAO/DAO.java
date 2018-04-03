package com.example.mrocha.myapplication.DAO;

/*
    ###############################################
    Nom de la classe : DAO
    Ajouter par : Gwen
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Classe permettant une interaction avec la base de données
    ###############################################
     */

public abstract class DAO<T> {

    /*
    ###############################################
    Méthode insert
    Ajouter par : Gwen
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Permet de créer une entrée dans la base de données par rapport à un objet
    ###############################################
     */

    public abstract boolean insert(T obj);

    /*
    ###############################################
    Méthode update
    Ajouter par : Gwen
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Permet de mettre à jour les données d'une entrée dans la base
    ###############################################
     */

    public abstract boolean update(T obj);

    /*
    ###############################################
    Méthode delete
    Ajouter par : Gwen
    Date d'ajout : 03/04/2018
    Version d'ajout : V1
    Description : Permet la suppression d'une entrée de la base
    ###############################################
     */

    public abstract boolean delete(T obj);
}
