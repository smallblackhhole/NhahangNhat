<?php
    if(isset($_POST['SODT']) && isset($_POST['MATKHAU']) && isset($_POST['TENKH']) && isset($_POST['DIACHI']) && isset($_POST['EMAIL'])){
        require_once "dbconnect.php";
        require_once "validate.php";
        $sodt= validate($_POST['SODT']);
        $matkhau= validate($_POST['MATKHAU']);
        $tenkh= validate($_POST['TENKH']);
        $diachi= validate($_POST['DIACHI']);
        $email= validate($_POST['EMAIL']);
        $sql = "UPDATE taikhoankh SET matkhau='$matkhau', tenkh='$tenkh', diachi='$diachi', email='$email' WHERE sodt='$sodt'";
        if($connect->query($sql)){
            echo "update thanh cong";
        } else{
            echo "update that bai";
        }
    }
?>
