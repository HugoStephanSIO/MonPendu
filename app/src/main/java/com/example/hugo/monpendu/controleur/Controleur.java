package com.example.hugo.monpendu.controleur;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.hugo.monpendu.modele.Jeu;
import com.example.hugo.monpendu.modele.JeuSimple;
import com.example.hugo.monpendu.vue.JeuSimpleActivity;
import com.example.hugo.monpendu.modele.AccesLocal;

import java.io.Serializable;

/**
 * Classe qui fait l'intermédiaire entre le modele (BDD/classe métier) et la vue
 * @author Hugo Stéphan
 */
public class Controleur implements Serializable {
    // PROPRIETES :
    // ------------
    private final String CLASS_TAG = this.getClass().getName() ;
    private AccesLocal accesLocal ;
    private Jeu jeu ;
    private String typeJeu;
    private String difficulte;
    public void setTypeJeu (String t) {
        this.typeJeu = t ;
    }
    public String getTypeJeu () {
        return this.typeJeu ;
    }
    public void setDifficulte (String d) {
        this.difficulte = d ;
    }
    public String getDifficulte () {
        return this.difficulte ;
    }


    // FONCTIONS OUTILS/AUTRES :
    // -------------------------
    /**
     * Fonction qui créé un nouveau jeu simple
     */
    public void newJeuSimple (Context c) {
        Log.d (CLASS_TAG, "difficulte = "+difficulte) ;
        // Récupération d'un mot au hasard
        accesLocal = new AccesLocal (c) ;
        String mot = tirerUnMot(difficulte);
        accesLocal = null ;
        // Créaton d'un nouveau jeu simple avec le mot tiré au hasard
        jeu = new JeuSimple(mot, difficulte) ;
    }
    /**
     * Renvoie le mot caché mis en forme
     * @return le mot caché
     */
    public String getMotCache () {
        String s = new String(jeu.getMotCache()) ;
        String sFinal = "" ;
        for (int i = 0;i<s.length();i++)
        {
            sFinal += jeu.getMotCache()[i] ;
            sFinal += " ";
        }
        return s ;
    }
    /**
     * getter de l'objet jeu courant
     * @return l'objet jeu courant
     */
    public Jeu getJeu () {
        return this.jeu ;
    }
    /**
     * getter du nombre de tentatives restantes pour le jeu courant
     * @return nombre de tentatives restantes (String)
     */
    public int getNbTentasRestantes () {
        int nbRestantes = jeu.getNombreDeTentativesMax() - jeu.getNombreErreurs() ;
        return nbRestantes ;
    }
    /**
     * Encapsulation accés local tire un mot au hasard
     * @param difficulte
     * @return
     */
    public String tirerUnMot (String difficulte) {
        return accesLocal.tirerUnMot(difficulte) ;
    }
}
