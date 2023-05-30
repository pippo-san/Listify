<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && $_GET['username']!="" && isset($_GET['nome_elenco']) && $_GET['nome_elenco']!=""){
    $username = $_GET["username"];
    $nome_elenco = $_GET["nome_elenco"];

    // echo $username." ".$password;

    $query = "SELECT contenuto from elenco INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like '$username' and nome_elenco like '$nome_elenco'";
    

    $res = query($query);
    $valori = $res->fetchAll();
    // Stampo primo nome
    echo $valori[0][0];

}else{
    echo "bad request";
}
?>