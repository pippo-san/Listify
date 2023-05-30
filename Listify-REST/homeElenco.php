<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && $_GET['username']!=""){
    $username = $_GET["username"];

    // echo $username." ".$password;

    $query = "SELECT nome_elenco from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like '$username' limit 1";

    $res = query($query);
    $valori = $res->fetchAll();
    // Stampo primo elenco
    echo $valori[0][0];

}else{
    echo "bad request";
}
?>