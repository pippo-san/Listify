<?php

global $conn;
global $stmt;
function opendb(): void
{
   global $conn;
   $dbhost="localhost";
   $dbname = "va2666q7_meteo";
   $dbuser = "va2666q7_1";
   $dbpass = "meteo2022";
	try {
	 $conn = new PDO ("mysql:host=$dbhost;dbname=$dbname", $dbuser, $dbpass);
   } catch (PDOException $e) {
    echo "Errore: ".$e->getMessage();
    die();
}
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
    return $stmt->rowCount();
}

function closedb(): void
{
    global $conn;
    $conn = null;
}
?>