<?php
require 'dbconnect.php';
$sodt= $_GET['sodt'];
class TAIKHOAN{
    function __construct($sodt,$matkhau,$tenkh,$diachi,$email)
    {
        $this->sodt = $sodt;
        $this->matkhau = $matkhau;
        $this->tenkh= $tenkh;
        $this->diachi= $diachi;
        $this->email= $email;
    }
}

if($sodt == null){
    $query = "select * from taikhoankh";
}else{
    $query = "select * from taikhoankh where SODT=$sodt";
}

$data = mysqli_query($connect, $query);
$arraylist = array();
while ($row = mysqli_fetch_assoc($data))
{
    array_push($arraylist,new TAIKHOAN($row["SODT"], $row["MATKHAU"], $row["TENKH"],$row["DIACHI"],$row["EMAIL"]));
}

header("Content-type:application/json");
echo json_encode($arraylist,JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>