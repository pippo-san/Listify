package com.main.listify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import androidx.activity.OnBackPressedCallback;

public class pagina_profilo extends AppCompatActivity {

    private String username;

    private TextView txt_username;
    private TextView txt_nome;
    private TextView txt_cognome;
    private TextView txt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_profilo);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.set
            actionBar.setTitle("Profilo");
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

        /*GESTISCO IL PULSANTE INDIETRO (BACK)*/
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                onBackPressed();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
        /*END*/

        popolaTextView();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Se premo il bottone indietro vado alla Home, passandogli l'username
        switch (item.getItemId()) {
            case android.R.id.home:
                System.out.println("sas");
                Intent activity = new Intent(this, Home.class);
                activity.putExtra("username", username);
                startActivity(activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void popolaTextView(){
        txt_username = findViewById(R.id.txt_profilo_query_username);
        txt_nome = findViewById(R.id.txt_profilo_query_nome);
        txt_cognome = findViewById(R.id.txt_profilo_query_cognome);
        txt_email = findViewById(R.id.txt_profilo_query_email);

        txt_username.setText(username);
        try {
            txt_nome.setText(Connection_helper.prendiNome(username));
        } catch (IOException e) {
            txt_nome.setText("Errore interno");
        }
        try {
            txt_cognome.setText(Connection_helper.prendiCognome(username));
        } catch (IOException e) {
            txt_cognome.setText("Errore interno");
        }
        try {
            txt_email.setText(Connection_helper.prendiMail(username));
        } catch (IOException e) {
            txt_email.setText("Errore interno");
        }
    }

    public void onBackPressed(){
        System.out.println("Pulsante back premuto");
        Intent activity = new Intent(this, Home.class);
        activity.putExtra("username", username);
        startActivity(activity);
        this.finish();
    }

    public void doLogOut(View view) {
        Intent activity = new Intent(this, Login.class);
        startActivity(activity);
        this.finish();
    }
}