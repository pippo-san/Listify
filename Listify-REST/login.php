<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && isset($_GET['pass'])
 &&  $_GET['username']!="" && $_GET['pass']!=""){
    $username = $_GET["username"];
    $password = $_GET["pass"];

    // echo $username." ".$password;

    $query = "SELECT username FROM utente WHERE username='$username' AND pass='$password'";

    // echo $query;
    $res = conta($query);
    // echo $res;
    if($res == "1")
        echo "ok";
    else echo "utente non trovato";
 }else{
    echo "bad request";
 }
?>