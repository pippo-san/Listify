<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && $_GET['username']!=""){
    $username = $_GET["username"];

    // echo $username." ".$password;

    $query = "SELECT cognome FROM `utente` where username like '$username'";

    $res = query($query);
    $valori = $res->fetchAll();
    // Stampo mail
    echo $valori[0][0];

}else{
    echo "bad request";
}
?>