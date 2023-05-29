<?php
include "connessione.php";

opendb();

if(isset($_GET['query']) && $_GET['query']!=""){
    $query = $_GET['query'];

    $res = query($query);
    $valori = $res->fetchAll();
    for($i=0; $i<4; $i++){
    echo $valori[$i][$i];
    }

        /*echo $valori[0][0];
        echo $valori[1][1];
        echo $valori[2][2];
        echo $valori[3][3];*/

}else{
   echo "bad request";
}
