package com.main.listify;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.main.listify.databinding.ActivityHomeBinding;
import com.main.listify.ui.visualizza_liste.HomeFragment;

import java.io.IOException;

public class Home extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private AppBarConfiguration mAppBarConfiguration_liste;
    private AppBarConfiguration mAppBarConfiguration_elenchi;
    private ActivityHomeBinding binding;

    private TextView txt_username;
    private TextView txt_nome_gruppo;

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHome.toolbar);
        binding.appBarHome.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity = new Intent(Home.this, CreaGruppo.class);
                activity.putExtra("username", username);
                startActivity(activity);
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

      /*  mAppBarConfiguration_liste = new AppBarConfiguration.Builder(R.id.nav_lista)
                .setOpenableLayout(drawer)
                .build();
        NavController navController_liste = Navigation.findNavController(this, R.id.text_slideshow_liste);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration_liste);
        NavigationUI.setupWithNavController(navigationView, navController_liste);

/*
        mAppBarConfiguration_elenchi = new AppBarConfiguration.Builder(R.id.nav_elenco)
                .setOpenableLayout(drawer)
                .build();
        NavController navController_elenco = Navigation.findNavController(this, R.id.text_slideshow_elenchi);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration_elenchi);
        NavigationUI.setupWithNavController(navigationView, navController_elenco);*/


        // Scritto
        try {
            Bundle passaggioDati = getIntent().getExtras();
            username = passaggioDati.get("username").toString();
        } catch (NullPointerException e) {
            // Se per caso non ho l'username, rimando alla pagina di login
            Intent activity = new Intent(this, Login.class);
            startActivity(activity);
        }

        popolaTextView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        TextView txt_username = (TextView)findViewById(R.id.txt_menu_username);
        TextView txt_email = (TextView)findViewById(R.id.txt_menu_email);
        txt_username.setText(username);
        try {
            txt_email.setText(Connection_helper.prendiRisultati("SELECT email FROM `utente` where username like \""+username+"\" "));
        } catch (IOException e) {
            txt_email.setText("Errore interno");
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void apriImpostazioni(MenuItem item) {
        Intent activity = new Intent(this, SettingsActivity.class);
        activity.putExtra("username", username);
        startActivity(activity);
    }

    public void apriProfilo(MenuItem item) {
        Intent activity = new Intent(this, pagina_profilo.class);
        activity.putExtra("username", username);
        startActivity(activity);
        finish();
    }

    public void nuovaListaElenco(MenuItem item) {
        Intent activity = new Intent(this, CreazioneListaElenco.class);
        activity.putExtra("username", username);
        startActivity(activity);
        finish();
    }

    public void apriHomeListe(MenuItem item) {
        Intent activity = new Intent(this, com.main.listify.ui.visualizza_liste.HomeFragment.class);
        activity.putExtra("username", username);
        startActivity(activity);
        finish();
    }

    public void apriHomeElenchi(MenuItem item) {
        Intent activity = new Intent(this, com.main.listify.ui.visualizza_elenchi.HomeFragment.class);
        activity.putExtra("username", username);
        startActivity(activity);
        finish();
    }

    public void popolaTextView(){
        txt_nome_gruppo = findViewById(R.id.query_nome_gruppo);

        try {
            txt_nome_gruppo.setText(Connection_helper.prendiRisultati("select nome from gruppo inner join famiglia on gruppo.id_gruppo=famiglia.id_gruppo where username like \""+username+"\" "));
        } catch (Exception e) {
            txt_nome_gruppo.setText("Errore interno");
        }
    }
}