package com.example.hugo.monpendu.modele;

import java.io.Serializable;

/**
 * Classe abstraite
 */
public abstract class Jeu implements Serializable {
    // PROPRIETES :
    // ------------
    private final String CLASS_TAG = this.getClass().getName() ;
    protected String motEnClair ;
    protected char motCache [];
    protected String lettreProposees = "" ;
    protected Integer nombreErreurs = 0 ;
    protected Integer nombreDeTentativesMax ;
    protected String difficulte ;


    // ACCESSEURS :
    // ------------
    // Getters
    public char[] getMotCache() {
        return motCache;
    }
    public String getMotEnClair() {
        return motEnClair;
    }
    public Integer getNombreErreurs() {
        return nombreErreurs;
    }
    public Integer getNombreDeTentativesMax() {
        return nombreDeTentativesMax;
    }
    public String getDifficulte() {
        return difficulte;
    }
    // Setters
    public void setNombreErreurs(Integer nombreErreurs) {
        this.nombreErreurs = nombreErreurs;
    }
    public void setMotCache(char[] motCache) {
        this.motCache = motCache;
    }


    // FONCTIONS OUTILS/AUTRES :
    // -------------------------
    /**
     * Fonction qui retourne le nombre de lettres qui reste à trouver, utiliser pour vérifier si le joueur a gagné
     * @return le nombre de lettre qui restent inconnues
     */
    public int nbLettreInconnues () {
        int nb = 0 ;
        for (int i = 0;i<motEnClair.length();i++) {
            if (motCache[i]=='*') {
                nb ++ ;
            }
        }
        return nb ;
    }
    /**
     * Vérifie si l'utilisateur a perdu, le principe de la défaite ne différe pas selon les modes de jeu
     * @return true si le joueur a perdu false sinon
     */
    public boolean aPerdu () {
        if (nombreErreurs>=nombreDeTentativesMax) {
            return true ;
        }
        else
            return false ;
    }
    /**
     * Fonction qui vérifie si une lettre donnée en argument est présente dans le mot
     * @param lettre
     * @return vrai si la lettre est dans le mot faux sinon
     */
    public boolean testerUneLettre (char lettre) {
        // On ajoute la lettre aux lettre proposées
        lettreProposees += lettre ;
        // Si la lettre n'est pas dans le mot on renvoie false
        if (motEnClair.indexOf(lettre) == -1)
        {
            nombreErreurs++;
            return false;
        }
        // Sinon on remplace toutes les occurences de la lettre dans le mot caché
        else {
            for(int i = 0;i<motEnClair.length();i++) {
                if(motEnClair.charAt(i)==lettre) {
                    motCache[i]=lettre ;
                }
            }
            return true;
        }
    }
    /**
     * Fonction qui vérifie si une lettre a déjà été proposée
     * @param lettre
     * @return vrai si la lettre a déjà été proposée faux sinon
     */
    public boolean lettreDejaProposee (char lettre) {
        if (lettreProposees.indexOf(lettre)==-1)
            return false ;
        else
            return true ;
    }
}
