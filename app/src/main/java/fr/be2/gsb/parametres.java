package fr.be2.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;


public class parametres extends MainActivity {
    SQLHelper database;
    EditText Codev;
    EditText Nom;
    EditText Prenom;
    EditText Mail;
    EditText Urlserveur;
    EditText Password;
    Button Valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        database = new SQLHelper(this);
        init();
    }

    public void init() {
        Cursor Param = database.fetch_parametres();
        Param.moveToFirst();
        Codev = findViewById(R.id.Codev);
        Codev.setText(Param.getString(Param.getColumnIndex("codev")));
        Nom = findViewById(R.id.Nom);
        Nom.setText(Param.getString(Param.getColumnIndex("nom")));
        Prenom = findViewById(R.id.Prenom);
        Prenom.setText(Param.getString(Param.getColumnIndex("prenom")));
        Mail = findViewById(R.id.Mail);
        Mail.setText(Param.getString(Param.getColumnIndex("email")));
        Urlserveur = findViewById(R.id.Urlserveur);
        Urlserveur.setText(Param.getString(Param.getColumnIndex("urlserveur")));
        Password = findViewById(R.id.Password);
        Password.setText(Param.getString(Param.getColumnIndex("motdepasse")));
        Valider=findViewById(R.id.btnValider);
    }




    public void ClickValider(View v) {
        switch (v.getId()) {
            case R.id.btnValider:
                if (Codev.getText().toString().trim().length() == 0 || Nom.getText().toString().length() == 0
                        || Prenom.getText().toString().trim().length() == 0 || Mail.getText().toString().trim().length() == 0 ||
                        Urlserveur.getText().toString().trim().length() == 0|| Password.getText().toString().trim().length() == 0) {
                    //getText : recupere , toString met en chiffre trim enleve les espaces lenght compte a longueur
                    afficherMessage("Erreur!", "Champ vide");
                    return;
                } else {

                    Integer codev = Integer.parseInt(String.valueOf(Codev.getText()));
                    String nom = Nom.getText().toString();
                    String prenom = Prenom.getText().toString();
                    String mail = Mail.getText().toString();
                    String urlserveur = Urlserveur.getText().toString();
                    String password = Password.getText().toString();
                    if(database.update_PARAMETRES(codev,nom,prenom,mail,urlserveur,password)){
                        afficherMessage("Succès", "Valeur ajoutée. " );
                        return;
                    }

                }
                break;
        }
    }
    public void clique_retour(View view) {
        finish();
    }


}