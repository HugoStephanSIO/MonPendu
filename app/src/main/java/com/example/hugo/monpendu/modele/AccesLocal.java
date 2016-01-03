package com.example.hugo.monpendu.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hugo.monpendu.outils.MySQLiteOpenHelper;

import java.io.Serializable;
import java.util.Random;

/**
 * Classe qui gére la connexion à la BDD qui consiste essentiellement à piocher un mot au hasard
 * @author Hugo Stéphan
 */
public class AccesLocal implements Serializable {
    // PROPRIETES :
    // ------------
    private final String CLASS_TAG = this.getClass().getName() ;
    private String nomBaseLocale = "bdd.sqlite";
    private Integer versionBaseLocale = 1;
    private MySQLiteOpenHelper accesBaseLocale ;
    private SQLiteDatabase bd;
    private Context context ;


    // CONSTRUCTEURS :
    // ---------------
    /**
     * Constructeur : création de la connexion
     */
    public AccesLocal(Context context) {
        // connexion à la base locale
        this.context = context ;
    }


    // FONCTIONS AUTRES :
    // ------------------
    /**
     * Fonction qui tire un mot au hasard dans la BDD locale
     * @param difficulte facile / moyen / difficle
     * @return un mot au hasard ou "" en cas de problèmes
     */
    public String tirerUnMot(String difficulte) {
        this.accesBaseLocale = new MySQLiteOpenHelper(context, nomBaseLocale, versionBaseLocale) ;
        // Initialisation des variables
        String mot = "";
        bd = accesBaseLocale.getReadableDatabase();
        int nombreAleatoire;
        Random r = new Random();
        nombreAleatoire = 1 + r.nextInt(50 - 1);

        // Récupération d'un mot dans la bdd
        Cursor curseur = bd.rawQuery("select mot from " + difficulte + " where id = " + nombreAleatoire, null);
        if (curseur == null) return mot;
        curseur.moveToFirst();
        if (!curseur.isAfterLast()) mot = curseur.getString(0);
        if (mot=="") mot = "ERREUR" ;

        // Fermeture curseur, retour du mot tiré
        curseur.close();
        bd.close();
        accesBaseLocale = null ;
        return mot ;
    }
    public String tirerUnMot(String difficulte, Context c) {
        this.context = c ;
        return this.tirerUnMot(difficulte) ;
    }
}
