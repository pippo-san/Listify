<?php
include "connessione.php";

if(isset($_POST['username'])){
    $username = $_GET["username"];
        $query = "SELECT * FROM lista, elenco WHERE username='$username'";

    query($query);
    echo "ok";
 }else{
    echo "bad request";
 }
?>