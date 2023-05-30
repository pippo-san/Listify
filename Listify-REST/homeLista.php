<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && $_GET['username']!=""){
    $username = $_GET["username"];

    // echo $username." ".$password;

    $query = "SELECT nome_lista from lista INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like '$username'";

    $res = query($query);
    $valori = $res->fetchAll();
    // Stampo prima lista
    echo $valori[0][0];

}else{
    echo "bad request";
}
?>