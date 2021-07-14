<?php

class ChiTietHoaDon
{
	public $mahd;
	public $masp;
	public $sl;
	public $giadagiam;
	public $tongtien;


	public function __construct($Mahd,$Masp,$Sl,$Giadagiam,$Tongtien)
	{
		$this->$mahd = $Mahd;
		$this->masp = $Masp;
		$this->sl = $Sl;
		$this->giadagiam = $Giadagiam;
		$this->tongtien = $Tongtien;
	}
}
include "connect.php";

$mahd= $_POST['mahd'];
$masp= $_POST['masp'];
$sl = $_POST['sl'];
$giadagiam = $_POST['giadagiam'];
$tongtien= $_POST['tongtien'];


$query = "insert into ChiTietHoaDon values('$mahd','$masp','$sl','$giadagiam','$tongtien')";

if(mysqli_query($conn,$query))
{
	echo "success";
}
else
{
	echo "error";
}
?>