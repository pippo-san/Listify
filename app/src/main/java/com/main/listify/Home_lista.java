package com.main.listify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class Home_lista extends AppCompatActivity {
    private String username;
    Button txt_nome_lista_1;
    Button txt_nome_lista_2;
    Button txt_nome_lista_3;
    Button txt_nome_lista_4;
    Button txt_nome_lista_5;
    Button txt_nome_lista_6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lista);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.set
            actionBar.setTitle("Visualizzazione delle Liste");
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
        txt_nome_lista_1=findViewById(R.id.listView_visualizza_liste_1);
        txt_nome_lista_2=findViewById(R.id.listView_visualizza_liste_2);
        txt_nome_lista_3=findViewById(R.id.listView_visualizza_liste_3);
        txt_nome_lista_4=findViewById(R.id.listView_visualizza_liste_4);
        txt_nome_lista_5=findViewById(R.id.listView_visualizza_liste_5);
        txt_nome_lista_6=findViewById(R.id.listView_visualizza_liste_6);

        try {
            Connection_helper.visibilita(txt_nome_lista_1, Connection_helper.prendiLista(username));
            Connection_helper.visibilita(txt_nome_lista_2, Connection_helper.prendiRisultati("SELECT nome_lista from lista INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 1"));
            Connection_helper.visibilita(txt_nome_lista_3, Connection_helper.prendiRisultati("SELECT nome_lista from lista INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 2"));
            Connection_helper.visibilita(txt_nome_lista_4, Connection_helper.prendiRisultati("SELECT nome_lista from lista INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 3"));
            Connection_helper.visibilita(txt_nome_lista_5, Connection_helper.prendiRisultati("SELECT nome_lista from lista INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 4"));
            Connection_helper.visibilita(txt_nome_lista_6, Connection_helper.prendiRisultati("SELECT nome_lista from lista INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 5"));


        } catch (Exception e) {
            TextView errore=findViewById(R.id.errore_home_lista);
            errore.setVisibility(TextView.VISIBLE);
            errore.setText("Errore Interno");
        }
    }

    public void apri_lista(View view) throws IOException {
        Intent activity = new Intent(this, VisualizzaLista.class);
        activity.putExtra("username", username);
        activity.putExtra("nome_lista", Connection_helper.prendiRisultati("SELECT nome_lista from lista INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\""));
        startActivity(activity);
        finish();
    }
}