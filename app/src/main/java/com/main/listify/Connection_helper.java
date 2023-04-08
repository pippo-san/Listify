package com.main.listify;

import java.io.IOException;
import java.net.*;
import static com.main.listify.Utils.leggiPaginaHTML;

public class Connection_helper {

    public static boolean registraUtente(String username, String nome, String cognome, String email, String pass) throws IOException {
        String querystring = "?username="+username+"&nome="+nome+"&cognome="+cognome+"&email="+email+"&password="+pass;
        URL paginaRegistrazione = new URL("http://meteo.itisarezzo.cloud/progetto_5CIA/register.php"+querystring);

        String result = leggiPaginaHTML(paginaRegistrazione);
        return result.equals("ok");
    }
}
