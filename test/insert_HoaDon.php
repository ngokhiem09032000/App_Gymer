<?php

class HoaDon
{
	public $sdtkh;
	public $ngaylap;
	public $tongtien;


	public function __construct($Sdtkh,$Ngaylap,$Tongtien)
	{
		$this->sdtkh = $Sdtkh;
		$this->ngaylap = $Ngaylap;
		$this->tongtien = $Tongtien;
	}
}
include "connect.php";

$sdtkh= $_POST['sdtkh'];
$ngaylap= $_POST['ngaylap'];
$tongtien= $_POST['tongtien'];


$query = "insert into HoaDon values(null,'$sdtkh','$ngaylap','$tongtien')";

if(mysqli_query($conn,$query))
{
	echo "success";
}
else
{
	echo "error";
}
?>