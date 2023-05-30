<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && $_GET['username']!=""){
    $username = $_GET["username"];

    $query = "SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like '$username' limit 1";

    $res = query($query);
    $valori = $res->fetchAll();
    // Stampo primo elenco
    //echo $valori[0][0];

    echo "<pre>";
    // Stampo nomi elenchi
    foreach ($valori as $value) {
        echo "$value[0]\n";
    }
    echo "</pre>";

}else{
    echo "bad request";
}
?>