package com.main.listify;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.IOException;
//import static com.main.listify.Utils.leggiPaginaHTML;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Connection_helper  {

    private static final int DATABASE_VERSION=3;
    private static final String KEY_ROWID="_id";
    private static final String KEY_NOME_LISTA="nome_lista";
    private static final String KEY_GRUPPO="id_gruppo";
    private Context context;

    public static boolean registraUtente(String username, String nome, String cognome, String email, String pass) throws IOException {
        String querystring = "?username="+username+"&nome="+nome+"&cognome="+cognome+"&email="+email+"&pass="+pass;
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/register.php"+querystring);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();

        String result = leggiPaginaHTML(url);
        System.out.println(result);
        return result.equals("ok");
    }

    public static boolean accessoUtente(String username, String pass) throws IOException {
        String querystring = "?username="+username+"&pass="+pass;
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/login.php"+querystring);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();

        String result = leggiPaginaHTML(url);
        System.out.println(result);
        return result.equals("ok");
    }

    public static boolean schermataHome(String username) throws IOException {
        String querystring = "?username="+username;
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/home.php"+querystring);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();

        String result = leggiPaginaHTML(url);
        System.out.println(result);
        return result.equals("ok");
    }

    public static String prendiRisultati(String query) throws IOException {
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/query.php?query="+query);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();
        String result = leggiPaginaHTML(url);
        /*try {
            String result = leggiPaginaHTML(url);
            do {

            } while ();*/
            System.out.println("risultati lista: " + result);
       /* }catch (Exception e){
            System.out.println("errore do while");
        }*/
        return result;
    }

    public static void creaGruppo(String username, String nomeGruppo, String descrizioneGruppo) throws IOException {
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/creaGruppo.php?username="+username+"&nomeGruppo="+nomeGruppo+"&descrizioneGruppo="+descrizioneGruppo);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();

        //String result = leggiPaginaHTML(url);
        //System.out.println(result);
        // return result;
    }

    public static void visibilita(TextView textView, String s){
        if(s!=""){
            textView.setText(s);
        }else{
            textView.setVisibility(TextView.INVISIBLE);
        }
    }

    public static String prendiMail(String username) throws IOException {
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/prendiMail.php?username="+username);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();
        String result = leggiPaginaHTML(url);

        System.out.println("mail letta: " + result);
       return result;
    }

    public static String leggiPaginaHTML(URL pagina) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(pagina.getInputStream()));
        String letto = "";
        try {
            Scanner in = new Scanner(pagina.openStream());
            while((letto=in.nextLine())!=null){
                letto = in.nextLine();
            }
            in.close();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }


        return letto;

    }
}
