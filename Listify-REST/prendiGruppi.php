<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && $_GET['username']!=""){
    $username = $_GET["username"];

    // echo $username." ".$password;

    $query = "select nome from gruppo inner join famiglia on gruppo.id_gruppo=famiglia.id_gruppo where username like '$username'";

    $res = query($query);
    $valori = $res->fetchAll();
    
    // Stampo nomi gruppi
    foreach ($valori as $value) {
        echo "$value[0] <br>";
    }

}else{
    echo "bad request";
}
?>