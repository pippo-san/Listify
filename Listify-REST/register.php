<?php
include "connessione.php";

$username = $_GET["username"];
$nome = $_GET["nome"];
$cognome = $_GET["cognome"];
$email = $_GET["email"];
$password = $_GET["password"];

$query = "INSERT INTO UTENTE VALUES ('$username', '$nome', '$cognome', '$email', '$password')";

query($query);
echo "ok";