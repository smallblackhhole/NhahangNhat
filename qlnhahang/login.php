<?php
 if(isset($_POST['SODT'])&& isset($_POST['MATKHAU'])){
    require_once "dbconnect.php";
    require_once "validate.php";
    $sodt= validate($_POST['SODT']);
    $matkhau= validate($_POST['MATKHAU']);
    $sql = "select * from taikhoankh where SODT='$sodt' and MATKHAU='$matkhau'";
    $result = $connect->query($sql);
    if($result->num_rows>0){
        echo "success";
    }else{
        echo "failure";
    }
}
?>