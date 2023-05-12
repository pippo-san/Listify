<?php
include "connessione.php";

opendb();

if(isset($_GET['nome_elenco']) && isset($_GET['data_elenco'] && isset($_GET['id_gruppo'])
 &&  $_GET['nome_elenco']!="" && $_GET['data_elenco']!="" && $_GET['id_gruppo']!=""){
    $nome_elenco = $_GET["nome_elenco"];
    $data_elenco = $_GET["data_elenco"];
    $id_gruppo = $_GET["id_gruppo"];

    $query = "INSERT INTO elenco VALUES('$nome_elenco', $id_gruppo, '$data_elenco')";

    // echo $query;
    $res = conta($query);
    // echo $res;
    if($res == "1")
        echo "ok";
    else echo "elenco creato";
 }else{
    echo "bad request";
 }
?>