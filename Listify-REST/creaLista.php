<?php
include "connessione.php";

opendb();

if(isset($_GET['nome_lista']) && isset($_GET['data_lista'] && isset($_GET['id_gruppo'])
 &&  $_GET['nome_lista']!="" && $_GET['data_lista']!="" && $_GET['id_gruppo']!=""){
    $nome_lista = $_GET["nome_lista"];
    $data_lista = $_GET["data_lista"];
    $id_gruppo = $_GET["id_gruppo"];

    $query = "INSERT INTO lista VALUES('$nome_lista', '$data_lista', $id_gruppo)";

    // echo $query;
    $res = conta($query);
    // echo $res;
    if($res == "1")
        echo "ok";
    else echo "lista creata";
 }else{
    echo "bad request";
 }
?>