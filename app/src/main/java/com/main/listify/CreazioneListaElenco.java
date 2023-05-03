package com.main.listify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CreazioneListaElenco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creazione_lista_elenco);
        //EditText lista= findViewById(R.id.fragment2);
        //EditText elenco= findViewById(R.id.fragment1);
    }

    public View onCreateView_lista(LayoutInflater inflater, ViewGroup container,
                                    Bundle savedInstanceState) {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creazionelista, container, false);
    }

    public View onCreateView_elenco(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creazione_elenco, container, false);
    }
}