<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && isset($_GET['password'])
 &&  $_GET['username']!="" && $_GET['password']!=""){
    $username = $_GET["username"];
    $password = $_GET["password"];

    $query = "SELECT username, pass FROM utente WHERE username='$username' AND pass='$password'";

    $res = query($query);
    if($res != "-1")
        echo "ok";
    else echo "utente non trovato";
 }else{
    echo "bad request";
 }
?>