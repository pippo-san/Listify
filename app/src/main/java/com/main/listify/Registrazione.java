package com.main.listify;

import static com.main.listify.Utils.getMd5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registrazione extends AppCompatActivity {

    String email, confermaEmail, username, password, confermaPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);
    }

        public void doRegistrazione(View view) {
            email = ((EditText) findViewById(R.id.etxt_email)).getText().toString();
            confermaEmail = ((EditText) findViewById(R.id.etxt_conferma_email)).getText().toString();
            username = ((EditText) findViewById(R.id.etxt_username)).getText().toString();
            password = getMd5(((EditText) findViewById(R.id.etxt_password)).getText().toString());
            confermaPassword = getMd5(((EditText) findViewById(R.id.etxt_conferma_password)).getText().toString());
            if (!(email.equals("") && confermaEmail.equals("") && username.equals("") && password.equals("") && confermaPassword.equals(""))) {
                if (email.equalsIgnoreCase(confermaEmail) && password.equals(confermaPassword)){
                    Connection_helper.esegui_query("INSERT INTO UTENTE VALUES('"+username+"', 'Bics', 'Bics2', '"+email+"', '"+password+"')");
                }else {
                    Toast.makeText(getApplicationContext(), "Errore, ricontrolla i dati!!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Inserisci tutti i dati!", Toast.LENGTH_SHORT).show();
            }
        }

    public void open_activity_login(View view) {
        Intent activity = new Intent(this, Login.class);
        startActivity(activity);
    }
}