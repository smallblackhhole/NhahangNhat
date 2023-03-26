<?php
require 'dbconnect.php';
class MENU{
    function __construct($maloai,$tenloai,$hinhloai)
    {
        $this->maloai = $maloai;
        $this->tenloai = $tenloai;
        $this->hinhloai= $hinhloai;
    }
}
$query = "select * from loai";
$data = mysqli_query($connect, $query);
$arraylist = array();

while ($row = mysqli_fetch_assoc($data))
{
    array_push($arraylist,new MENU($row["MALOAI"], $row["TENLOAI"], $row["HINHANH"]));
}

header("Content-type:application/json");
echo json_encode($arraylist,JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);
?>