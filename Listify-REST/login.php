<?php
include "connessione.php";

opendb();

if(isset($_POST['username']) && isset($_POST['password'])
 &&  $_POST['username']!="" && $_POST['password']!=""){
    $username = $_GET["username"];
    $password = $_GET["password"];

    $query = "SELECT username, pass FROM utente WHERE username='$username' AND pass='$password'";

    $res = query($query);
    if($res != "-1")
        echo "ok";
    else echo "bad request";
 }else{
    echo "bad request";
 }
?>