<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && isset($_GET['nome']) && isset($_GET['cognome']) && isset($_GET['email']) && isset($_GET['password'])
 &&  $_GET['username']!="" && $_GET['nome']!="" &&  $_GET['cognome']!="" &&  $_GET['email']!="" &&  $_GET['password']!=""){
    $username = $_GET["username"];
    $nome = $_GET["nome"];
    $cognome = $_GET["cognome"];
    $email = $_GET["email"];
    $password = $_GET["password"];

    $query = "INSERT INTO utente VALUES ('$username', '$nome', '$cognome', '$email', '$password')";

    $res = query($query);
    if($res != "-1")
        echo "ok";
    else echo "bad request";
 }else{
    echo "bad request";
 }
?>