package com.main.listify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.main.listify.Utils.getMd5;

public class Login extends AppCompatActivity {

    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void doLogin(View view) {
        username = ((EditText) findViewById(R.id.etxt_username)).getText().toString();
        password = getMd5(( (EditText) findViewById(R.id.etxt_password) ).getText().toString());
        if ( !(username.equals("") && password.equals("")) ){
            // TODO
        }else {
            Toast.makeText(getApplicationContext(), "Inserisci username/password!", Toast.LENGTH_SHORT).show();
        }
    }

    public void open_activity_registrazione(View view) {
        Intent activity = new Intent(this, Registrazione.class);
        startActivity(activity);
    }
}