package com.main.listify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class Home_lista extends AppCompatActivity {
    private String username;
    private TextView txt_nome_lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lista);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.set
            actionBar.setTitle("Home Lista");
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
        txt_nome_lista = findViewById(R.id.listView_visualizza_liste);

        try {
            txt_nome_lista.setText(Connection_helper.prendiRisultati("SELECT nome_lista from lista INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" "));
        } catch (Exception e) {
            TextView errore=findViewById(R.id.errore_home_lista);
            errore.setText("Errore Interno");
        }
    }
}