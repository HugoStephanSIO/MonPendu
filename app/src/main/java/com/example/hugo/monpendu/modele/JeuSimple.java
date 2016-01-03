package com.example.hugo.monpendu.modele;

/**
 * Classe qui implémente les régles du jeu à proprement parler indépendamment de l'affichage ou même de l'accés aux données.
 * @author Hugo Stéphan
 */
public class JeuSimple extends Jeu {
    // PROPRIETES :
    // ------------
    private final String CLASS_TAG = this.getClass().getName() ;


    // CONSTRUCTEURS :
    // ----------------
    /**
     * Constructeur initialise les variables internes
     * @param mot
     */
    public JeuSimple(String mot, String d) {
        motEnClair = mot ;
        difficulte = d ;
        // Le mot caché est un tableau de la taille du mot en clair
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
                nombreDeTentativesMax = 10 ;
                break ;
            case "moyen" :
                nombreDeTentativesMax = 8 ;
                break ;
            case "difficile" :
                nombreDeTentativesMax = 6 ;
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
        if (nbLettreInconnues()==0)
            return true ;
        else
            return false ;
    }
}
