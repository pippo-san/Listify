package com.main.listify;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class CreazioneListaElenco extends AppCompatActivity {
String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creazione_lista_elenco);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.set
            actionBar.setTitle("Nuovo");
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

    }


    public View onCreateView_lista(LayoutInflater inflater, ViewGroup container,
                                    Bundle savedInstanceState) {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creazionelista, container, false);
    }
    public void crea_lista(){
        EditText nome_elenco=findViewById(R.id.etxt_nome_elenco);
        EditText data_elenco=findViewById(R.id.etxt_data_elenco);
        EditText id_gruppo=findViewById(R.id.etxt_id_gruppo);
        //try {
        //    Connection_helper.faiInsert("INSERT INTO elenco VALUES(\""+nome_elenco.getText()+"\", \""+data_elenco.getText()+"\", "+id_gruppo+")");
        //} catch (IOException e) {
        //}
        Toast.makeText(getApplicationContext(), "elenco creata con successo!", Toast.LENGTH_SHORT).show();
        Intent activity = new Intent(this, Home.class);
        activity.putExtra("username", username);
        startActivity(activity);
        finish();
    }

    public View onCreateView_elenco(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creazione_elenco, container, false);
    }

    public void crea_elenco(){
        EditText nome_elenco=findViewById(R.id.etxt_nome_elenco);
        EditText data_elenco=findViewById(R.id.etxt_data_elenco);
        EditText id_gruppo=findViewById(R.id.etxt_id_gruppo);
        //try {
        //    Connection_helper.faiInsert("INSERT INTO elenco VALUES(\""+nome_elenco.getText()+"\", "+id_gruppo+", \""+data_elenco.getText()+"\")");
        //} catch (IOException e) {
        //}
        Toast.makeText(getApplicationContext(), "elenco creato con successo!", Toast.LENGTH_SHORT).show();
        Intent activity = new Intent(this, Home.class);
        activity.putExtra("username", username);
        startActivity(activity);
        finish();
    }
}