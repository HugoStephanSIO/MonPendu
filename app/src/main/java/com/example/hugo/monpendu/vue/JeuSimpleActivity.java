package com.example.hugo.monpendu.vue;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hugo.monpendu.R;
import com.example.hugo.monpendu.controleur.Controleur;
import com.example.hugo.monpendu.modele.JeuSimple;
import com.example.hugo.monpendu.outils.Outils;

/**
 * Classe d'interface du jeu simple : gère l'état du jeu et récupére les saisies utilisateurs.
 */
public class JeuSimpleActivity extends AppCompatActivity {
    // PROPRIETES :
    // ------------
    private final String CLASS_TAG = this.getClass().getName() ;
    private Controleur controle ;


    // FONCTIONS REDEFINIES :
    // ----------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu_simple);
        // Récupération du controleur et du niveau de difficulté
        controle = (Controleur)getIntent().getSerializableExtra("ctrl") ;
        // Fonctions événementielles
        this.ecouteProposeLettre();
        this.ecouteProposeMot();
        this.ecouteNouveauJeu();
        this.ecouteQuitter();
        // Création d'un nouveau jeu
        this.nouveauJeu();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_jeu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // FONCTIONS EVENEMENTIELLES :
    // ---------------------------
    /**
     * Fonction événementielle qui réagit au clique sur bouton nouvelle partie
     */
    private void ecouteNouveauJeu() {
        findViewById(R.id.nouveauJeuBouton).setOnClickListener(new Button.OnClickListener () {
            public void onClick (View v) {
                // Retour à l'écran d'accueil
                Intent monIntent = new Intent(JeuSimpleActivity.this,DifficulteActivity.class);
                monIntent.putExtra("ctrl", controle);
                startActivity(monIntent);
                finish() ;
            }
        });
    }
    /**
     * Fonction événementielle qui réagit au clique sur le bouton pour proposer une lettre
     */
    private void ecouteProposeLettre () {
        findViewById(R.id.proposerLettreBouton).setOnClickListener(new Button.OnClickListener () {
            public void onClick(View v) {
                // Récupération de l'entrée de l'utilisateur et controle de son contenu
                String mot = ((EditText) findViewById(R.id.txtLettre)).getText().toString();
                if (mot != "" && mot.length()!=0) {
                    mot = mot.toUpperCase();
                    // La premiére lettre est en clair
                    char lettre = mot.charAt(0) ;
                    JeuSimple j = (JeuSimple)controle.getJeu();
                    if (j.lettreDejaProposee(lettre))
                    {
                        Toast.makeText(JeuSimpleActivity.this, "Lettre déjà proposée !", Toast.LENGTH_SHORT).show();

                        // En difficile (seulement) le fait de reproposer une lettre est pénalisant
                        if (j.getDifficulte().equals("difficile")&&!j.testerUneLettre(lettre)) actualiserNbTentas();
                        ((EditText)findViewById(R.id.txtLettre)).setText("");
                        cacherClavier();
                        return ;
                    }
                    if(j.testerUneLettre(lettre)) {
                        actualiserMotCache();
                    }
                    else {
                        actualiserNbTentas();
                    }
                }
                else {
                    Toast.makeText(JeuSimpleActivity.this, "Veuillez saisir une lettre à proposer !", Toast.LENGTH_SHORT).show();
                    return ;
                }
                cacherClavier();
                ((EditText)findViewById(R.id.txtLettre)).setText("");
                victoireOuDefaite() ;
            }
        });
    }
    /**
     * Fonction événementielle qui réagit sur le bouton pour proposer un mot
     */
    private void ecouteProposeMot () {
        findViewById(R.id.proposerMotBouton).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // Récupération de l'entrée de l'utilisateur et controle de son contenu
                String mot = ((EditText) findViewById(R.id.txtMot)).getText().toString();
                if (mot != "") {
                    mot = mot.toUpperCase();
                    // Si le joueur a trouvé le mot il remporte la partie
                    if (controle.getJeu().getMotEnClair().equals(mot)) {
                        victoire();
                    }
                    // Sinon il perd une tentative
                    else {
                        int n = controle.getJeu().getNombreErreurs();
                        controle.getJeu().setNombreErreurs(n + 1);
                        actualiserNbTentas();
                    }
                    ((EditText) findViewById(R.id.txtMot)).setText("");
                    victoireOuDefaite();
                } else {
                    Toast.makeText(JeuSimpleActivity.this, "Veuillez saisir un mot à proposer !", Toast.LENGTH_SHORT).show();
                    return;
                }
                cacherClavier();
            }
        });
    }
    /**
     * Fonction événementielle appelée en cas de clic sur le bouton quitter
     */
    private void ecouteQuitter () {
        findViewById(R.id.quitterJeuBouton).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Outils.quitterApp (JeuSimpleActivity.this);
            }
        });
    }


    // FONCTIONS AUTRES :
    // ------------------
    /**
     * Fonction qui vérifie si le joueur a gagné ou perdu
     */
    private void victoireOuDefaite () {
        JeuSimple j = (JeuSimple)controle.getJeu();
        if (j.aGagne())
            victoire () ;
        if (j.aPerdu())
            defaite ();
    }
    /**
     * Fonction pour signifier la victoire au joueur affichage d'un message avec les nombres de tentatives utilisées et max
     */
    private void victoire () {
        cacherClavier();
        Toast.makeText(JeuSimpleActivity.this, "VICTOIRE !", Toast.LENGTH_SHORT).show();
        // Variables locales pour éclaircir le code
        TextView tv = ((TextView)findViewById(R.id.msgView)) ;
        ImageView img = (ImageView)findViewById(R.id.smileyView);
        JeuSimple j = (JeuSimple)controle.getJeu();
        int nb = j.getNombreErreurs() ;
        int nbMax = j.getNombreDeTentativesMax();
        String motClair = j.getMotEnClair();
        // On affiche le mot en clair (ce qui devrait toujours être le cas, inutile ??)
        char motClairTab [] = new char [motClair.length()];
        for (int i = 0;i<motClair.length();i++)
        {
            motClairTab[i] = motClair.charAt(i);
        }
        j.setMotCache(motClairTab);
        // Actualisation de l'affichage
        actualiserMotCache();
        tv.setTextColor(Color.GREEN);
        tv.setText("BRAVO ! Vous avez gagné avec " + nb + " erreurs sur " + nbMax + " maximum");
        img.setImageResource(R.drawable.victoire);
        finDePartie();
    }
    /**
     * Fonction pour signifier la défaite au joueur affichage d'un message + boutons rendus non cliquables
     */
    private void defaite () {
        cacherClavier();
        Toast.makeText(JeuSimpleActivity.this, "DEFAITE...", Toast.LENGTH_SHORT).show();
        // Variables pour éclaircir le code
        TextView tv = ((TextView)findViewById(R.id.msgView)) ;
        JeuSimple j = (JeuSimple)controle.getJeu() ;
        ImageView img = ((ImageView)findViewById(R.id.smileyView)) ;
        // Actualisation de l'affichage
        tv.setTextColor(Color.RED);
        tv.setText("DOMMAGE ! Vous avez perdu...\nLe bon mot était " + j.getMotEnClair());
        img.setImageResource(R.drawable.defaite);
        finDePartie();
    }
    /**
     * Fonction qui met à jour l'état des widgets à la fin de la partie
     */
    private void finDePartie () {
        // Désactive le bouton qui permet de proposer un mot
        findViewById(R.id.proposerMotBouton).setClickable(false);
        findViewById(R.id.proposerMotBouton).setEnabled(false);
        // Désactive le bouton qui permet de proposer une lettre
        findViewById(R.id.proposerLettreBouton).setClickable(false);
        findViewById(R.id.proposerLettreBouton).setEnabled(false);
        // Rend visible et utilisable le bouton pour commnencer une nouvelle partie
        findViewById(R.id.nouveauJeuBouton).setVisibility(View.VISIBLE);
        findViewById(R.id.nouveauJeuBouton).setClickable(true);
        // Rend visible et utilisable le bouton pour quitter
        findViewById(R.id.quitterJeuBouton).setVisibility(View.VISIBLE);
        findViewById(R.id.quitterJeuBouton).setClickable(true);
    }
    /**
     * Fonction pour actualiser l'affichage du mot avec des caractères cachés
     */
    private void actualiserMotCache () {
        String motCache = controle.getMotCache() ;
        ((TextView)findViewById(R.id.motCacheView)).setText(motCache) ;
    }
    /**
     * Fonction pour actualiser l'affichage du nombre de tentatives
     */
    private void actualiserNbTentas () {
        // Variables de clarification du code
        int nbRestant = controle.getNbTentasRestantes() ;
        int nbFait = controle.getJeu().getNombreErreurs() ;
        ImageView img = ((ImageView)findViewById(R.id.etapeView)) ;
        // Selection couleur de l'affichage
        if (nbRestant<5) {
            ((TextView) findViewById(R.id.nbTentaView)).setTextColor(Color.RED);
        }
        else if (nbRestant<8) {
            ((TextView) findViewById(R.id.nbTentaView)).setTextColor(Color.YELLOW);
        }
        else {
            ((TextView) findViewById(R.id.nbTentaView)).setTextColor(Color.GREEN);
        }
        // Affichage du message
        String nbTenta = "";
        nbTenta += nbRestant ;
        ((TextView)findViewById(R.id.nbTentaView)).setText(nbTenta) ;
        // Affichage de l'image
        Outils.afficherImage(((ImageView) findViewById(R.id.etapeView)), nbFait);
    }
    /**
     * Fonction pour créer un nouveau jeu ce qui implique de choisir un nouveau mot au hasard et actualiser l'affichage
     */
    private void nouveauJeu () {
        this.controle.newJeuSimple(JeuSimpleActivity.this) ;
        this.actualiserMotCache();
        this.actualiserNbTentas();
    }
    /**
     * Fonction qui masque le clavier
     */
    private void cacherClavier () {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText etLettre = (EditText)findViewById(R.id.txtLettre) ;
        EditText etMot = (EditText)findViewById(R.id.txtMot) ;
        imm.hideSoftInputFromWindow(etLettre.getWindowToken(),0) ;
        imm.hideSoftInputFromWindow(etMot.getWindowToken(),0);
    }
}
