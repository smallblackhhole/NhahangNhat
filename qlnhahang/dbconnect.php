<?php
$server = "localhost";
$username ="root";
$password = "";
$database = "ql_nhahang";
$connect = new mysqli($server, $username, $password, $database);
if($connect->connect_error){
    die("Connection failed: ".$connect->connect_error);
}
mysqli_query($connect, "SET NAMES 'utf8'");
?>