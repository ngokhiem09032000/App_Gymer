<?php

class KhachHang
{
	public $hoten;
	public $sdt;
	public $email;
	public $cannang;
	public $chieucao;
	public $matkhau;

	public function __construct($Hoten,$Sdt,$Email,$Cannang,$Chieucao,$Matkhau)
	{
		$this->hoten = $Hoten;
		$this->sdt = $Sdt;
		$this->email = $Email;
		$this->cannang = $Cannang;
		$this->chieucao = $Chieucao;
		$this->matkhau = $Matkhau;
	}
}
include "connect.php";

$hoten= $_POST['hoten'];
$sdt= $_POST['sdt'];
$email= $_POST['email'];
$cannang= $_POST['cannang'];
$chieucao= $_POST['chieucao'];
$matkhau= $_POST['matkhau'];


$query = "insert into KhachHang values('$hoten','$sdt','$email','$cannang','$chieucao','$matkhau')";

if(mysqli_query($conn,$query))
{
	echo "success";
}
else
{
	echo "error";
}
?>