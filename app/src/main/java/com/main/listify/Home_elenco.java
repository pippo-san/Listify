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

public class Home_elenco extends AppCompatActivity {
    String username;

    TextView txt_nome_elenco_1;
    TextView txt_nome_elenco_2;
    TextView txt_nome_elenco_3;
    TextView txt_nome_elenco_4;
    TextView txt_nome_elenco_5;
    TextView txt_nome_elenco_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_elenco);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.set
            actionBar.setTitle("Visualizzazione degli Elenchi");
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
        txt_nome_elenco_1 = findViewById(R.id.listView_visualizza_elenchi_1);
        txt_nome_elenco_2 = findViewById(R.id.listView_visualizza_elenchi_2);
        txt_nome_elenco_3 = findViewById(R.id.listView_visualizza_elenchi_3);
        txt_nome_elenco_4 = findViewById(R.id.listView_visualizza_elenchi_4);
        txt_nome_elenco_5 = findViewById(R.id.listView_visualizza_elenchi_5);
        txt_nome_elenco_6 = findViewById(R.id.listView_visualizza_elenchi_6);

        try {
            Connection_helper.visibilita(txt_nome_elenco_1, Connection_helper.prendiElenco(username));
            Connection_helper.visibilita(txt_nome_elenco_2, Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 1"));
            Connection_helper.visibilita(txt_nome_elenco_3, Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 2"));
            Connection_helper.visibilita(txt_nome_elenco_4, Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 3"));
            Connection_helper.visibilita(txt_nome_elenco_5, Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 4"));
            Connection_helper.visibilita(txt_nome_elenco_6, Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 5"));
        } catch (Exception e) {
            TextView errore=findViewById(R.id.errore_home_elenco);
            errore.setVisibility(TextView.VISIBLE);
            errore.setText("Errore Interno");
        }
    }

    public void apri_elenco(View view) throws IOException {
        Intent activity = new Intent(this, VisualizzaElenco.class);
        activity.putExtra("username", username);
        activity.putExtra("nome_elenco", Connection_helper.prendiRisultati("SELECT nome_lista from lista INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\""));

        startActivity(activity);
        finish();
    }
}