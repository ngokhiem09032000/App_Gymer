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
$query = "select * from KhachHang";

$data = mysqli_query($conn,$query);

$arr = array();
while ($row = mysqli_fetch_assoc($data)) {
	array_push($arr,new KhachHang($row['hoten'],$row['sdt'],$row['email'],$row['cannang'],
		$row['chieucao'],$row['matkhau']));
}

echo json_encode($arr);
?>