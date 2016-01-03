package com.example.hugo.monpendu.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.hugo.monpendu.R;
import com.example.hugo.monpendu.controleur.Controleur;
import com.example.hugo.monpendu.outils.Outils;

import java.io.Serializable;

public class MenuActivity extends AppCompatActivity implements Serializable {
    // PROPRIETES :
    // ------------
    private final String CLASS_TAG = this.getClass().getName() ;
    private Controleur controle ;


    // FONCTIONS REDEFINIES :
    // ----------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controle = new Controleur ();
        setContentView(R.layout.activity_menu);
        ecouteAide() ;
        ecouteQuitter() ;
        ecouteJeuSimple() ;
        ecouteJeuParcours() ;
        // Désactivation options non fonctionnelles
        findViewById(R.id.boutonOptions).setClickable(false) ;
        findViewById(R.id.boutonOptions).setEnabled(false) ;
        findViewById(R.id.boutonJeuParcours).setClickable(false) ;
        findViewById(R.id.boutonJeuParcours).setEnabled(false) ;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // FONCTIONS EVENEMENTIELLES :
    // ---------------------------
    /**
     * Fonction événementielle appelée en cas de clique sur le bouton Aide ouvre l'activité Aide
     */
    private void ecouteAide () {
        findViewById(R.id.boutonAide).setOnClickListener(new Button.OnClickListener () {
            public void onClick(View v) {
                Intent monIntent = new Intent(MenuActivity.this, AideActivity.class);
                startActivity(monIntent);
                finish();
            }
        });
    }
    /**
     * Fonction événementielle appelée en cas de clic sur le bouton Jeu Simple, ouvre l'activité choix de la difficulté
     */
    private void ecouteJeuSimple () {
        findViewById(R.id.boutonJeuSimple).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                controle.setTypeJeu("simple") ;
                Intent monIntent = new Intent(MenuActivity.this, DifficulteActivity.class);
                monIntent.putExtra("ctrl",controle);
                startActivity(monIntent);
                finish() ;
            }
        });
    }
    /**
     * Fonction événementielle appelée en cas de clic sur le bouton Jeu Parcours, ouvre l'activité choix de la difficulté
     */
    private void ecouteJeuParcours () {
        findViewById(R.id.boutonJeuParcours).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                controle.setTypeJeu("parcours") ;
                Intent monIntent = new Intent(MenuActivity.this, DifficulteActivity.class);
                monIntent.putExtra("ctrl",controle);
                startActivity(monIntent);
                finish() ;
            }
        });
    }
    /**
     * Fonction événementielle appelée en cas de clique sur le bouton Quitter ferme l'activité
     */
    private void ecouteQuitter () {
        findViewById(R.id.boutonQuitter).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Outils.quitterApp(MenuActivity.this);
            }
        });
    }
}
