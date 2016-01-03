package com.example.hugo.monpendu.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.hugo.monpendu.R;
import com.example.hugo.monpendu.controleur.Controleur;

/**
 * Classe qui affiche l'activity principale du jeu, celle sur laquelle l'application démarre et qui est enfait simplement un menu.
 */
public class DifficulteActivity extends AppCompatActivity {
    // PROPRIETES :
    // ------------
    private final String CLASS_TAG = this.getClass().getName() ;
    private static String EXTRA_MSG_FACILE = "facile";
    private static String EXTRA_MSG_MEDIUM = "moyen" ;
    private static String EXTRA_MSG_DIFFICILE = "difficile";
    private static String EXTRA_MSG = "";
    private Controleur controle ;


    // FONCTIONS REDEFINIES :
    // ----------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulte);
        // Récupération du controleur
        controle = (Controleur)getIntent().getSerializableExtra("ctrl") ;
        // Lancement des fonctions événementielles
        ecouteDifficulte((Button) findViewById(R.id.boutonFacile), EXTRA_MSG_FACILE);
        ecouteDifficulte((Button) findViewById(R.id.boutonMedium), EXTRA_MSG_MEDIUM);
        ecouteDifficulte((Button) findViewById(R.id.boutonDifficile), EXTRA_MSG_DIFFICILE);
        ecouteRetour();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
     * Fonction événementielle qui lancent le jeu dans la difficulté choisie transmise sous forme d'extra dans l'intent
     */
    private void ecouteDifficulte (Button b, final String MSG) {
        b.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EXTRA_MSG = MSG ;
                controle.setDifficulte(EXTRA_MSG);
                Log.d(CLASS_TAG, "difficulte = " + EXTRA_MSG);
                Intent monIntent = null ;
                if (controle.getTypeJeu().equals("simple")) {
                    monIntent = new Intent(DifficulteActivity.this, JeuSimpleActivity.class);
                } else if (controle.getTypeJeu().equals("parcours")) {
                    monIntent = new Intent(DifficulteActivity.this, JeuParcoursActivity.class);
                }
                assert monIntent != null ;
                monIntent.putExtra("ctrl", controle) ;
                startActivity(monIntent);
                finish();
            }
        });
    }
    private void ecouteRetour () {
        ((Button)findViewById(R.id.boutonRetourMenu)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent monIntent = new Intent(DifficulteActivity.this,MenuActivity.class);
                startActivity(monIntent);
                finish();
            }
        });
    }
}
