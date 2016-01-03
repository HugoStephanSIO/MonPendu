package com.example.hugo.monpendu.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

/**
 * Encapsule et simplifie la connexion à la BDD locale
 * @author Hugo Stéphan
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper implements Serializable {
    // PROPRIETES :
    // ------------
    private final String CLASS_TAG = this.getClass().getName() ;
    private String creationFacile="create table facile ("
            + "id INTEGER PRIMARY KEY,"
            + "mot TEXT);";
    private String creationMoyen="create table moyen ("
            + "id INTEGER PRIMARY KEY,"
            + "mot TEXT);";
    private String creationDifficile="create table difficile ("
            + "id INTEGER PRIMARY KEY,"
            + "mot TEXT);";


    // CONSTRUCTEUR :
    // --------------
    /**
     * Construction de l'accès à une base de données locale
     * @param context
     * @param name
     * @param version
     */
    public MySQLiteOpenHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }


    // FONCTIONS REDEFINIES :
    // ----------------------
    /**
     * méthode redéfinie appelée automatiquement par le constructeur
     * uniquement si celui-ci repère que la base n'existe pas encore
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(creationFacile);
        db.execSQL(creationMoyen);
        db.execSQL(creationDifficile);
        creerTableFacile(db);
        creerTableMoyen(db);
        creerTableDifficile(db);
    }
    /**
     * méthode redéfinie appelée automatiquement s'il y a changement de version de la base
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS facile");
        db.execSQL("DROP TABLE IF EXISTS moyen");
        db.execSQL("DROP TABLE IF EXISTS difficile");
        onCreate(db);
    }


    // FONCTIONS AUTRES :
    // ------------------
    /**
     * Créer la table des mots faciles en local
     * @param db
     */
    public void creerTableFacile (SQLiteDatabase db) {
        db.execSQL("INSERT INTO facile (id,mot) values (1,\"FLAGRANT\");");
        db.execSQL("INSERT INTO facile (id,mot) values (2,\"VIOLON\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (3,\"MARCHAND\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (4,\"SCAPHANDRE\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (5,\"AMOUREUX\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (6,\"FASCINANT\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (7,\"ANACONDA\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (8,\"SAUVETAGE\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (9,\"MICROSCOPE\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (10,\"EXTRAORDINAIRE\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (11,\"POTENTIEL\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (12,\"ORDINATEUR\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (13,\"IMAGINATION\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (14,\"ENVIRONNEMENT\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (15,\"BETTERAVE\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (16,\"BRICOLAGE\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (17,\"CORRECTION\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (18,\"DIMINUTIF\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (19,\"GESTATION\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (20,\"WAGONNET\");") ;
        db.execSQL("INSERT INTO facile (id,mot) values (21,\"BLANCHEUR\");");
        db.execSQL("INSERT INTO facile (id,mot) values (22,\"PIROUETTE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (23,\"MECANIQUE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (24,\"INFERIEUR\");");
        db.execSQL("INSERT INTO facile (id,mot) values (25,\"POSTERIEUR\");");
        db.execSQL("INSERT INTO facile (id,mot) values (26,\"ANABOLISANT\");");
        db.execSQL("INSERT INTO facile (id,mot) values (27,\"PESTICIDE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (28,\"HYPNOSE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (29,\"TECHNOLOGIE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (30,\"VEROUILLAGE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (31,\"MERVEILLEUX\");");
        db.execSQL("INSERT INTO facile (id,mot) values (32,\"TELEVISION\");");
        db.execSQL("INSERT INTO facile (id,mot) values (33,\"VOITURE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (34,\"NUCLEAIRE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (35,\"DEMOCRATIE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (36,\"AVANTAGE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (37,\"MISERABLE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (38,\"PROFESSEUR\");");
        db.execSQL("INSERT INTO facile (id,mot) values (39,\"FORMIDABLE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (40,\"CARDIAQUE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (41,\"COURAGEUX\");");
        db.execSQL("INSERT INTO facile (id,mot) values (42,\"PULVERISER\");");
        db.execSQL("INSERT INTO facile (id,mot) values (43,\"DIVERSITE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (44,\"ARTISTIQUE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (45,\"PAYSANNE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (46,\"REPRODUCTION\");");
        db.execSQL("INSERT INTO facile (id,mot) values (47,\"MATERNITE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (48,\"PHILOSOPHIE\");");
        db.execSQL("INSERT INTO facile (id,mot) values (49,\"MIROBOLANT\");");
        db.execSQL("INSERT INTO facile (id,mot) values (50,\"DIPLOMATIQUE\");");
    }
    /**
     * Créer la table des mots moyens en local
     * @param db
     */
    public void creerTableMoyen (SQLiteDatabase db) {
        db.execSQL("INSERT INTO moyen (id,mot) values (1,\"EXTRAORDINAIRE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (2,\"ENVIRONNEMENT\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (3,\"IMAGINATION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (4,\"ABSTRACTION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (5,\"DEFLAGRATION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (6,\"AUTOMATISATION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (7,\"EXTRAVERTI\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (8,\"INIMAGINABLE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (9,\"MANUFACTURE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (10,\"ENDIGUEMENT\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (11,\"ONDULATOIRE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (12,\"MICROSCOPE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (13,\"METAPHYSIQUE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (14,\"HYPOTHESE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (15,\"WATERPROOF\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (16,\"ZENITHAL\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (17,\"ABSOLUTION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (18,\"ZOOLOGIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (19,\"ORTHOGONAL\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (20,\"CARTESIEN\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (21,\"PLASMODIER\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (22,\"HYDROPHOBE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (23,\"RELATIVITE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (24,\"PROGRAMMATION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (25,\"PHENOMENAL\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (26,\"PSEUDONYME\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (27,\"AFFRONTEMENT\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (28,\"MYTHOLOGIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (29,\"APOSTASIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (30,\"AMELIORATION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (31,\"REPRODUCTION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (32,\"METHODOLOGIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (33,\"ARISTOCRATIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (34,\"BOURGEOISIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (35,\"AGGLOMERATION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (36,\"MICROCOSME\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (37,\"BIODIVERSITE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (38,\"HALTEROPHILIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (39,\"ABSOLUTISME\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (40,\"HOMOPHOBIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (41,\"HYPERTROPHIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (42,\"SYNAGOGUE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (43,\"PALEONTHOLOGIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (44,\"ARCHEOLOGIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (45,\"SOCIOLOGIE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (46,\"RADIOACTIVITE\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (47,\"MEDIATISATION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (48,\"OPPORTUNISME\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (49,\"DESINTEGRATION\");");
        db.execSQL("INSERT INTO moyen (id,mot) values (50,\"ASYMPTOTIQUE\");");
    }
    /**
     * Créer la table des mots difficiles en local
     * @param db
     */
    public void creerTableDifficile (SQLiteDatabase db) {
        db.execSQL("INSERT INTO difficile (id,mot) values (1,\"FLAVESCENT\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (2,\"ATARAXIQUE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (3,\"ANECDOTIQUE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (4,\"NECROPHAGIE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (5,\"SUSTENTATION\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (6,\"IGNOMINIEUSEMENT\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (7,\"HYPOTHERMIE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (8,\"TECHNOCRATIE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (9,\"CONSTITUTIONNEL\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (10,\"MERITOCRATIE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (11,\"HYPOTHYROIDIE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (12,\"PSYCHOTHERAPEUTE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (13,\"GERONTOLOGIE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (14,\"KALEIDOSCOPIQUE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (15,\"KINESITHERAPEUTE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (16,\"BACTERIOSTATIQUE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (17,\"BADIGEONNER\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (18,\"DECLOISONNEMENT\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (19,\"EPITHETIQUE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (20,\"ZYGOMORPHE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (21,\"PLASMODIER\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (22,\"HYDROPHOBIE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (23,\"DEMOCRATISATION\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (24,\"ANACHRONISME\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (25,\"POLYMORPHISME\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (26,\"HYPOCONDRIAQUE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (27,\"IDEALISATION\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (28,\"SECURITARISME\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (29,\"PETRIFICATION\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (30,\"MICROSCOPIQUE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (31,\"ASTROPHYSICIEN\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (32,\"OLIGARCHIQUE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (33,\"REDIBITOIRE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (34,\"NATIONALISME\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (35,\"PLURIMILLENAIRE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (36,\"ALPHABETISATION\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (37,\"HYPERSUSCEPTIBILITE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (38,\"PROCRASTINATION\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (39,\"ELECTROMAGNETISME\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (40,\"THERMINOLOGIE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (41,\"DIFFERENCIATION\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (42,\"PRECARISATION\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (43,\"PHYTOTHERAPEUTE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (44,\"ALGORITHMIQUE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (45,\"PUERICULTRICE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (46,\"DEMOCRATIQUEMENT\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (47,\"DESHUMIDIFICATEUR\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (48,\"EXTRASENSORIELLE\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (49,\"MINUTIEUSEMENT\");");
        db.execSQL("INSERT INTO difficile (id,mot) values (50,\"NITROGLYCERINE\");");
    }
}
