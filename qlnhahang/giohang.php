<?php
require 'dbconnect.php';
$mamon = $_GET['mamon'];
class MONAN{
    function __construct($mamon,$tenmon,$chitiet,$dongia,$hinhanh,$maloai)
    {
        $this->mamon = $mamon;
        $this->tenmon = $tenmon;
        $this->chitiet= $chitiet;
        $this->dongia= $dongia;
        $this->hinhanh= $hinhanh;
        $this->maloai= $maloai;
    }
}

if($mamon == null){
    $query = "select * from monan";
}else{
    $query = "select * from monan where MAMON=$mamon";
}
   
$data = mysqli_query($connect, $query);
$arraylist = array();
while ($row = mysqli_fetch_assoc($data))
{
    array_push($arraylist,new MONAN($row["MAMON"], $row["TENMON"], $row["CHITIET"],$row["DONGIA"],$row["HINHANH"],$row["MALOAI"]));
}

header("Content-type:application/json");
echo json_encode($arraylist,JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>