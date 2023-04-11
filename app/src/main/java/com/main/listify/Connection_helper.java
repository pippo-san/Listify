package com.main.listify;
import java.io.IOException;
import static com.main.listify.Utils.leggiPaginaHTML;

import java.net.URL;
import java.sql.Connection;

public class Connection_helper {

    public static boolean registraUtente(String username, String nome, String cognome, String email, String pass) throws IOException {
        String querystring = "?username="+username+"&nome="+nome+"&cognome="+cognome+"&email="+email+"&password="+pass;
        URL paginaRegistrazione = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/register.php"+querystring);

        String result = leggiPaginaHTML(paginaRegistrazione);
        return result.equals("ok");
    }

    public static boolean accessoUtente(String username, String pass) throws IOException {
        String querystring = "?username="+username+"&password="+pass;
        URL paginaAccesso = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/login.php"+querystring);

        String result = leggiPaginaHTML(paginaAccesso);
        return result.equals("ok");
    }

    public static boolean schermataHome(String username) throws IOException {
        String querystring = "?username="+username;
        URL paginaAccesso = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/home.php"+querystring);

        String result = leggiPaginaHTML(paginaAccesso);
        return result.equals("ok");
    }

}
