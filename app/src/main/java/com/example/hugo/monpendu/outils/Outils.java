package com.example.hugo.monpendu.outils;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.hugo.monpendu.R;

/**
 * Class abstraite utilitaire
 * @author Hugo Stéphan
 */
public abstract class Outils {
    /**
     * Affiche l'image symbolisant la progression du joueur
     * @param img afficheur d'image
     * @param nb numéro de l'étape
     */
    public static void afficherImage (ImageView img,int nb)
    {
        switch(nb){
            case 0:
                img.setImageResource(R.drawable.etape0);
                break;
            case 1:
                img.setImageResource(R.drawable.etape1);
                break;
            case 2:
                img.setImageResource(R.drawable.etape2);
                break;
            case 3:
                img.setImageResource(R.drawable.etape3);
                break;
            case 4:
                img.setImageResource(R.drawable.etape4);
                break;
            case 5:
                img.setImageResource(R.drawable.etape5);
                break;
            case 6:
                img.setImageResource(R.drawable.etape6);
                break;
            case 7:
                img.setImageResource(R.drawable.etape7);
                break;
            case 8:
                img.setImageResource(R.drawable.etape8);
                break;
            case 9:
                img.setImageResource(R.drawable.etape9);
                break;
        }
    }
    /**
     * Quitte l'application à partir de l'activité donnée en paramètres
     */
    public static void quitterApp (AppCompatActivity app) {
        app.finish() ;
        System.exit(0) ;
    }
}
