<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && isset($_GET['nomeGruppo']) && isset($_GET['descrizioneGruppo'])
 &&  $_GET['username']!="" && $_GET['nomeGruppo']!="" && $_GET['descrizioneGruppo']!=""){
    $username = $_GET["username"];
    $nomeGruppo = $_GET["nomeGruppo"];
    $descrizioneGruppo = $_GET["descrizioneGruppo"];

    // echo($username."<br>");
    // echo($nomeGruppo."<br>");
    // echo($descrizioneGruppo."<br>");

    $query = "INSERT INTO gruppo VALUES(null, '$nomeGruppo', '$descrizioneGruppo')";
    $res = query($query);

    $query2 = "INSERT INTO famiglia values((SELECT id_gruppo FROM gruppo where nome like '$nomeGruppo' order by id_gruppo desc limit 1), '$username')";
    $res2 = query($query2);

}else{
   echo "bad request";
}
