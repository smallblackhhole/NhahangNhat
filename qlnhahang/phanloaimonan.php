<?php
require 'dbconnect.php';
$maloai = $_GET['maloai'];
class MONAN{
    function __construct($mamon,$tenmon,$chitiet,$spnoibat,$dongia,$hinhanh,$maloai)
    {
        $this->mamon = $mamon;
        $this->tenmon = $tenmon;
        $this->chitiet= $chitiet;
        $this->spnoibat= $spnoibat;
        $this->dongia= $dongia;
        $this->hinhanh= $hinhanh;
        $this->maloai= $maloai;
    }
}

if($maloai == null){
    $query = "select * from monan";
}else{
    $query = "select * from monan where MALOAI=$maloai";
}
   
$data = mysqli_query($connect, $query);
$arraylist = array();
while ($row = mysqli_fetch_assoc($data))
{
    array_push($arraylist,new MONAN($row["MAMON"], $row["TENMON"], $row["CHITIET"],$row["SPNOIBAT"],$row["DONGIA"],$row["HINHANH"],$row["MALOAI"]));
}

header("Content-type:application/json");
echo json_encode($arraylist,JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>