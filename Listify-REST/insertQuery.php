<?php
include "connessione.php";

opendb();

if(isset($_GET['query']) && $_GET['query']!=""){
    $query = $_GET['query'];

    // echo $query;
    $res = query($query);

    $valori = $res->fetchAll();
    //echo $valori[0][0]; // Leggo solo il primo valore restituito
}else{
   echo "bad request";
}
