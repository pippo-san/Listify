package com.main.listify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static com.main.listify.Utils.getMd5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;

public class Login extends AppCompatActivity {

    String username, password;
    Connection connect;
    String connection_result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        /*  DA FARE UN REFACTORING DI QUESTO, PRIMA O POI  */

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        /*  https://stackoverflow.com/questions/6343166/how-can-i-fix-android-os-networkonmainthreadexception  */

    }

    public void doLogin(View view) throws IOException {
        username = ((EditText) findViewById(R.id.etxt_username)).getText().toString();
        password = getMd5(( (EditText) findViewById(R.id.etxt_password) ).getText().toString());
        if ( !(username.equals("") && password.equals("")) ){
            if(Connection_helper.accessoUtente(username.toString(), password.toString())){
                open_activity_home(view, username);
            }else{
                Toast.makeText(getApplicationContext(), "username/password errati!", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getApplicationContext(), "Inserisci username/password!", Toast.LENGTH_SHORT).show();
        }
    }

    public void open_activity_registrazione(View view) {
        Intent activity = new Intent(this, Registrazione.class);
        startActivity(activity);
    }

    public void open_activity_home(View view, String username) {
        Intent activity = new Intent(this, Home.class);
        activity.putExtra("username", username);
        startActivity(activity);
    }

    public void open_activity_profile(View view, String username) {
        Intent activity = new Intent(this, pagina_profilo.class);
        activity.putExtra("username", username);
        startActivity(activity);
    }


    public void open_activity_login(View view) {
        Intent activity = new Intent(this, Login.class);
        startActivity(activity);
    }
}