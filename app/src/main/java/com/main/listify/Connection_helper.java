package com.main.listify;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.IOException;
//import static com.main.listify.Utils.leggiPaginaHTML;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Connection_helper  {

    private static final int DATABASE_VERSION=3;
    private static final String KEY_ROWID="_id";
    private static final String KEY_NOME_LISTA="nome_lista";
    private static final String KEY_GRUPPO="id_gruppo";
    private Context context;

    public static String leggiPaginaHTML(URL pagina) throws IOException {
        String letto = "";
        try {
            Scanner in = new Scanner(pagina.openStream());
            while((letto=in.nextLine())!=null){
                letto = in.nextLine();
            }
            in.close();
        } catch (NoSuchElementException e) {
            // e.printStackTrace();
        }


        return letto;

    }

    public static ArrayList<String> leggiPaginaHTMLArray(URL pagina) throws IOException {
        ArrayList<String> listaValori = new ArrayList<>();
        String letto = "";
        System.out.println("sas");
        try {
            Scanner in = new Scanner(pagina.openStream());
            while(in.hasNextLine()){
                letto = in.nextLine();
                if (letto.contains("<pre>"))
                    letto = letto.split("<pre>")[1];
                if (!letto.equals("</pre>"))
                    listaValori.add(letto);
                System.out.println("lettooooooooooooooooooooo "+letto);
            }
            in.close();
        } catch (NoSuchElementException e) {
            // e.printStackTrace();
        }


        return listaValori;

    }

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

    public static void visibilita(TextView textView, String nomeElenco){
        // Se leggo un elenco allora scrivo il testo, sennò rendo invisibile l'oggetto
        if(nomeElenco != ""){
            textView.setText(nomeElenco);
        }else{
            textView.setVisibility(TextView.INVISIBLE);
        }
    }

    public static void visibilita(Button button, String nomeElenco){
        // Se leggo un elenco allora scrivo il testo, sennò rendo invisibile l'oggetto
        if(nomeElenco != ""){
            button.setText(nomeElenco);
        }else{
            button.setVisibility(Button.INVISIBLE);
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

    public static String prendiNome(String username) throws IOException {
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/prendiNome.php?username="+username);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();
        String result = leggiPaginaHTML(url);

        System.out.println("nome: " + result);
        return result;
    }

    public static String prendiCognome(String username) throws IOException {
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/prendiCognome.php?username="+username);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();
        String result = leggiPaginaHTML(url);

        System.out.println("cognome: " + result);
        return result;
    }

    public static ArrayList<String> prendiElenco(String username) throws IOException {
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/homeElenco.php?username="+username);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();
        ArrayList <String> result = leggiPaginaHTMLArray(url);

        System.out.println("elenco letto: " + result);
        return result;
    }

    public static ArrayList<String> prendiLista(String username) throws IOException {
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/homeLista.php?username="+username);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();
        ArrayList <String> result = leggiPaginaHTMLArray(url);

        System.out.println("lista letto: " + result);
        return result;
    }

    public static String prendiLista2(String username) throws IOException {
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/homeLista.php?username="+username);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();
        String result = leggiPaginaHTML(url);

        System.out.println("lista letto: " + result);
        return result;
    }

    public static ArrayList<String> prendiGruppi(String username) throws IOException {
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/prendiGruppi.php?username="+username);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();
        ArrayList <String> result = leggiPaginaHTMLArray(url);

        System.out.println("nomi gruppi letti: " + result);
        return result;
    }
}
