<?php
include "connessione.php";

opendb();

if(isset($_GET['username']) && $_GET['username']!="" && isset($_GET['nome_lista']) && $_GET['nome_lista']!=""){
    $username = $_GET["username"];
    $nome_lista = $_GET["nome_lista"];

    // echo $username." ".$password;

    $query = "SELECT nome_oggetto from oggetto inner join lista using(id_lista) INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like '$username' and nome_lista like '$nome_lista'";
    $query2 = "SELECT note from oggetto inner join lista using(id_lista) INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like '$username' and nome_lista like '$nome_lista'";
    $query3 = "SELECT controllo from oggetto inner join lista using(id_lista) INNER JOIN gruppo using (id_gruppo) inner JOIN famiglia USING (id_gruppo) where username like '$username' and nome_lista like '$nome_lista'";


    $res = query($query);
    $valori = $res->fetchAll();
    // Stampo primo nome
    echo $valori[0][0];

    $res = query($query2);
    $valori = $res->fetchAll();
    // Stampo primo oggetto
    echo $valori[0][0];

    $res = query($query3);
    $valori = $res->fetchAll();
    // Stampo primo check
    echo $valori[0][0];

}else{
    echo "bad request";
}
?>