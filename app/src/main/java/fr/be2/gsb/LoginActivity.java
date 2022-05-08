package fr.be2.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

        SQLHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = new SQLHelper(this);
        a Cursor Param =database.fetch_parametres();
        Param.moveToFirst();
        CodeVisiteur=Param.getString(Param.getColumnIndex(CodeV));

        if(Integer.parseInt(CodeVisiteur)==0)
        {
            Intent intent = new Intent(getApplicationContext(),parametres.class);
            startActivity(intent);
        }
    }
}