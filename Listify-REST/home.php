<?php
include "connessione.php";

opendb();

if(isset($_GET['username'])){
    $username = $_GET["username"];
    $query = "SELECT * FROM lista, elenco WHERE username='$username'";

    $res = conta($query);
    if($res == "1")
        echo "ok";
    else echo "utente non trovato";
 }else{
    echo "bad request";
 }
?>