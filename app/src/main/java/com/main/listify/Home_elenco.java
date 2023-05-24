package com.main.listify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

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
            actionBar.setTitle("Home Elenco");
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
            txt_nome_elenco_1.setText(Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\"  limit 1"));
            txt_nome_elenco_2.setText(Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\"  limit 1 offset 1"));
            txt_nome_elenco_3.setText(Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 2"));
            txt_nome_elenco_4.setText(Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 3"));
            txt_nome_elenco_5.setText(Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 4"));
            txt_nome_elenco_6.setText(Connection_helper.prendiRisultati("SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like \""+username+"\" limit 1 offset 5"));

        } catch (Exception e) {
            TextView errore=findViewById(R.id.errore_home_elenco);
            errore.setText("Errore Interno");
        }
    }
}