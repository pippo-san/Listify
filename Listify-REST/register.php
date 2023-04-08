<?php
include "connessione.php";

if(isset($_POST['username']) && isset($_POST['nome']) && isset($_POST['cognome']) && isset($_POST['email']) && isset($_POST['password'])
 &&  $_POST['username']!="" && $_POST['nome']!="" &&  $_POST['cognome']!="" &&  $_POST['email']!="" &&  $_POST['password']!=""){
    $username = $_GET["username"];
    $nome = $_GET["nome"];
    $cognome = $_GET["cognome"];
    $email = $_GET["email"];
    $password = $_GET["password"];

    $query = "INSERT INTO UTENTE VALUES ('$username', '$nome', '$cognome', '$email', '$password')";

    query($query);
    echo "ok";
 }else{
    echo "bad request";
 }

