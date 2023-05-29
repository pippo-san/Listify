package com.main.listify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class VisualizzaLista extends AppCompatActivity {
    private String username;
    private String nomeLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizza_lista);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.set
            actionBar.setTitle("Lista");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        try {
            Bundle passaggioDati = getIntent().getExtras();
            username = passaggioDati.get("username").toString();
            nomeLista = passaggioDati.get("nome_lista").toString();
        } catch (NullPointerException e) {
            // Se per caso non ho l'username, pazienza, farà un altra volta il login
            System.out.println(e);
        }
        popolaLista();
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

    public void popolaLista(){
       TextView oggetto2=findViewById(R.id.textView2);
       TextView oggetto3=findViewById(R.id.textView3);
       TextView oggetto4=findViewById(R.id.textView4);
       TextView oggetto5=findViewById(R.id.textView5);
       TextView oggetto6=findViewById(R.id.textView6);
       TextView oggetto7=findViewById(R.id.textView7);
       TextView oggetto8=findViewById(R.id.textView8);
       CheckBox cb2=findViewById(R.id.checkBox);
       CheckBox cb3=findViewById(R.id.checkBox2);
       CheckBox cb4=findViewById(R.id.checkBox3);
       CheckBox cb5=findViewById(R.id.checkBox4);
       CheckBox cb6=findViewById(R.id.checkBox5);
       CheckBox cb7=findViewById(R.id.checkBox6);
       CheckBox cb8=findViewById(R.id.checkBox7);
       TextView note2=findViewById(R.id.note2);
       TextView note3=findViewById(R.id.note3);
       TextView note4=findViewById(R.id.note4);
       TextView note5=findViewById(R.id.note5);
       TextView note6=findViewById(R.id.note6);
       TextView note7=findViewById(R.id.note7);
       TextView note8=findViewById(R.id.note8);

        try {
            Connection_helper.visibilita(oggetto2, Connection_helper.prendiRisultati("SELECT nome_oggetto from oggetto inner join lista using(id_lista) inner join gruppo using(id_gruppo) inner join famiglia using(id_gruppo) where username like \""+username+"\" and nome_lista like \""+nomeLista+"\""));
            //Connection_helper.visibilita(cb2, Connection_helper.prendiRisultati("SELECT controllo from oggetto inner join lista using(id_lista) inner join gruppo using(id_gruppo) inner join famiglia using(id_gruppo) where username like \""+username+"\" and nome_lista like \""+nomeLista+"\""));
            Connection_helper.visibilita(note2, Connection_helper.prendiRisultati("SELECT note from oggetto inner join lista using(id_lista) inner join gruppo using(id_gruppo) inner join famiglia using(id_gruppo) where username like \""+username+"\" and nome_lista like \""+nomeLista+"\""));

        }catch (Exception e) {
            System.out.println("errore interno");
        }
    }

}
