<?php
    if(isset($_POST['SODT']) && isset($_POST['MATKHAU'])){
        require_once "dbconnect.php";
        require_once "validate.php";
        $sodt= validate($_POST['SODT']);
        $matkhau= validate($_POST['MATKHAU']);
        $sql = "DELETE FROM taikhoankh WHERE sodt='$sodt' AND matkhau='$matkhau'";
        if($connect->query($sql)){
            echo "xoa thanh cong";
        } else{
            echo "xoa that bai";
        }
    }
?>