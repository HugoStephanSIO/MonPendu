package com.example.hugo.monpendu.modele;

import java.util.ArrayList;

/**
 * Created by Hugo on 09/12/2015.
 */
public class JeuParcours extends Jeu {
    // PROPRIETES :
    // ------------
    private final String CLASS_TAG = this.getClass().getName() ;
    private ArrayList<String> lesMotsEnClair ;
    private Integer nombreMotTrouves = 0 ;
    private Integer nombreMotATrouver ;

    // CONSTRUCTEURS :
    // ---------------
    public JeuParcours(ArrayList<String> lesMots, String diff) {
        lesMotsEnClair = lesMots ;
        motEnClair = lesMotsEnClair.get(0) ; // On récupére le premier mot de la liste
        motCache = new char[motEnClair.length()] ;
        motCache[0] = motEnClair.charAt(0) ;
        // Que l'on remplit de *
        for(int i = 1;i<motEnClair.length();i++)
        {
            motCache [i] = '*' ;
            // Ou avec la premiére lettre si c'est la même que la lettre courante et qu'on n'est pas en difficile
            if((!difficulte.equals("difficile"))&&motEnClair.charAt(i)==motCache[0])
                motCache[i]=motCache[0];
        }

        // Le nombre de tentatives maximum dépend de la difficulté
        switch (difficulte) {
            case "facile" :
                nombreDeTentativesMax = 20 ;
                nombreMotATrouver = 3 ;
                break ;
            case "moyen" :
                nombreDeTentativesMax = 16 ;
                nombreMotATrouver = 4 ;
                break ;
            case "difficile" :
                nombreDeTentativesMax = 12 ;
                nombreMotATrouver = 5 ;
                break ;
        }
    }


    // FONCTIONS OUTILS/AUTRE :
    // -----------------
    /**
     * Vérifie si l'utilisateur a gagné
     * @return true si le jouer a gagné false sinon
     */
    public boolean aGagne () {
        if (nombreMotTrouves==lesMotsEnClair.size())
            return true ;
        else
            return false ;
    }
}
