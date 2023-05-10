package com.main.listify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class CreaGruppo extends AppCompatActivity {
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_gruppo);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.set
            actionBar.setTitle("Crea Gruppo");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        try {
            Bundle passaggioDati = getIntent().getExtras();
            username = passaggioDati.get("username").toString();
        } catch (NullPointerException e) {
            // Se per caso non ho l'username, pazienza, farà un altra volta il login
            System.out.println(e);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Se premo il bottone indietro vado alla Home, passandogli l'username
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent activity = new Intent(this, Home.class);
                activity.putExtra("username", username);
                startActivity(activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void creaGruppo(View view) {
        EditText etxt_nome_gruppo = findViewById(R.id.etxt_nome_gruppo);
        EditText etxt_descrizione_gruppo = findViewById(R.id.etxt_descrizione);

        // Query ultimo gruppo creato
        // SELECT id_gruppo FROM gruppo where nome like "prova" order by id_gruppo desc limit 1

        try {
            Connection_helper.faiInsert("INSERT INTO gruppo VALUES(null, \""+etxt_nome_gruppo.getText()+"\", \""+etxt_descrizione_gruppo.getText()+"\")");
            Connection_helper.faiInsert("INSERT INTO famiglia values(" +
                    "\""+username+"\", SELECT id_gruppo FROM gruppo where nome like \""+etxt_nome_gruppo.getText()+"\" order by id_gruppo desc limit 1 )");
        } catch (IOException e) {
        }
        Toast.makeText(getApplicationContext(), "Gruppo creato", Toast.LENGTH_SHORT).show();
    }
}