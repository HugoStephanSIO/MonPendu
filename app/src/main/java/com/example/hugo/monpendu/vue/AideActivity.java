package com.example.hugo.monpendu.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hugo.monpendu.R;

/**
 * Classe qui affiche la rubrique aide
 * @author Hugo Stéphan
 */
public class AideActivity extends AppCompatActivity {
    // PROPRIETES :
    // ------------
    private final String CLASS_TAG = this.getClass().getName() ;


    // FONCTIONS REDEFINIES :
    // ----------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aide);
        ecouteRetour() ;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aide, menu);
        remplirTexteAide () ;
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
     * Fonction événementielle qui réagit au clique sur le bouton retour
     */
    private void ecouteRetour () {
        findViewById(R.id.boutonRetour).setOnClickListener(new Button.OnClickListener () {
            public void onClick (View v) {
                Intent monIntent = new Intent(AideActivity.this,MenuActivity.class);
                startActivity(monIntent);
                finish();
            }
        });
    }


    // FONCTIONS OUTILS/AUTRES :
    // -------------------------
    /**
     * Fonction qui affiche le contenu de l'aide
     */
    private void remplirTexteAide () {
        String aide = "";
        aide += "Bienvenue dans le jeu du Pendu !\n";
        aide += "Les régles sont simples :" +
                "\n- Un mot est tiré au hasard, vous devez alors le deviner. " +
                "\n- Vous avez un certain nombre de tentatives maximum pour y arriver (dépendant du niveau de difficulté choisi)."+
                "\n- Vous pouvez soit proposer une seule lettre dont la(ou les) position(s) seront révélées si le mot contient cette lettre." +
                "\n- Vous pouvez également proposer un mot complet si vous pensez l'avoir deviné !" +
                "\n- Chaque erreur sur un des deux procédés mentionnés ci dessus diminiue de 1 votre nombre de tentatives, une fois arrivé à 0 vous avez perdu." +
                "\n -Si vous proposez plusieurs fois la même lettre vous en serez informé et votre nombre de tentatives ne diminuera pas (sauf en difficile)." +
                "\n- Si vous entrez plusieurs lettres dans le champ pour proposer une lettre, seule la première sera prise en compte." +
                "\n- Les lettres avec accent ou cédille sont sondiérées comme des lettres normales.";

        aide += "\n\nIl y a 3 niveaux de difficulté :" +
                "\n- FACILE : Les mots à deviner sont simples et vous avez 10 tentatives." +
                "\n- MEDIUM : Les mots à deviner sont plus compliqués et vous n'avez plus que 8 tentatives." +
                "\n- DIFFICILE : Les mots à deviner sont encre plus compliqués, vous n'avez plus que 6 tentatives, si la première lettre est présente plusieurs fois dans le mot seule la premiére occurence apparaît en clair et enfin le fait de proposer une lettre déjà proposée vous fait maintenant perdre une tentative !" ;

        aide += "\n\nIl y a 2 modes de jeux :" +
                "\n-JEU SIMPLE : Une partie rapide un seul mot à deviner en suivant les régles énoncées précédemment." +
                "\n-JEU PARCOURS : Une série de mot à deviner d'affilé en suivant les régles énoncées précédemment.";

        ((TextView)findViewById(R.id.aideView)).setText(aide);
    }
}
