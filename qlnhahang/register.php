<?php
if (isset($_POST['SODT']) && isset($_POST['MATKHAU']) && isset($_POST['TENKH']) && isset($_POST['DIACHI']) && isset($_POST['EMAIL'])) {
    require_once "dbconnect.php";
    require_once "validate.php";
    $sodt = validate($_POST['SODT']);
    $matkhau = validate($_POST['MATKHAU']);
    $tenkh = validate($_POST['TENKH']);
    $diachi = validate($_POST['DIACHI']);
    $email = validate($_POST['EMAIL']);
    $sql = "INSERT INTO taikhoankh VALUES('$sodt','$matkhau','$tenkh','$diachi','$email')";
    try {
        if ($connect->query($sql)) {
            echo "dang ky thanh cong";
        }
    } catch (Exception $e) {
        if ($e->getCode() == 1062) { // MySQL error code for duplicate key
            echo "so dien thoai da ton tai";
        } else {
            echo "Error: " . $e->getMessage();
        }
    }
}
?>