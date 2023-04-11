<?php
include "connessione.php";

if(isset($_POST['username']) && isset($_POST['password'])
 &&  $_POST['username']!="" && $_POST['password']!=""){
    $username = $_GET["username"];
    $nome = $_GET["nome"];
    $cognome = $_GET["cognome"];
    $email = $_GET["email"];
    $password = $_GET["password"];

    $query = "SELECT username, pass FROM utente WHERE username='$username' AND pass='$password'";

    query($query);
    echo "ok";
 }else{
    echo "bad request";
 }
?>