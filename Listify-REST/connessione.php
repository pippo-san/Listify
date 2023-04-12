<?php

global $conn;
global $stmt;

function opendb(){
    global $conn;
    $hostname = "localhost";
    $dbname = "va2666q7_meteo";
    $user = "va2666q7_1";
    $pass = "meteo2022";
    $conn = new mysqli("localhost","va2666q7_1","meteo2022","va2666q7_meteo");

    if ($conn->connect_error) {
        die('Connessione fallita ' . $conn->connect_error);
    }
}

function query($query){
    global $conn;
    global $stmt;
    try
    {
        // $sql = $query;
        // $stmt = $conn->prepare($sql);
        // $stmt->execute();

        $stmt = $conn->query($query);
    }
    catch (Exception $ex) {
        $stmt = "-1";
    }
    return $stmt;
}

function conta($query){
    global $conn;
    global $stmt;
    try
    {
        $sql = $query;
        $stmt = $conn->prepare($sql);
        $stmt->execute();
    }
    catch (Exception $ex) {
        $stmt = "-1";
    }
    return oci_num_rows();
}

function closedb(): void
{
    global $conn;
    $conn = null;
}
?>