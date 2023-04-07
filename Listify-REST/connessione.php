<?php
try {
    $hostname = "localhost";
    $dbname = "va2666q7_meteo";
    $user = "va2666q7_1";
    $pass = "meteo2022";
    $conn = new PDO ("mysql:host=$hostname;dbname=$dbname", $user, $pass);
} catch (PDOException $e) {
    echo "Errore: " . $e->getMessage();
    die();
}

function query($query){
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