package com.main.listify;
import java.io.BufferedReader;
import java.io.IOException;
//import static com.main.listify.Utils.leggiPaginaHTML;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Connection_helper {

    public static boolean registraUtente(String username, String nome, String cognome, String email, String pass) throws IOException {
        String querystring = "?username="+username+"&nome="+nome+"&cognome="+cognome+"&email="+email+"&password="+pass;
        URL url = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/register.php"+querystring);

        System.out.println("URL: "+url);

        HttpURLConnection paginaAccesso = (HttpURLConnection)  url.openConnection();

        String result = leggiPaginaHTML(url);
        System.out.println(result);
        return result.equals("ok");
    }

    public static boolean accessoUtente(String username, String pass) throws IOException {
        String querystring = "?username="+username+"&password="+pass;
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

    public static String leggiPaginaHTML(URL pagina) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(pagina.getInputStream()));
        Scanner in = new Scanner(pagina.openStream());

        String letto = "";
        letto = in.next();
        in.close();

        return letto;

    }

}
