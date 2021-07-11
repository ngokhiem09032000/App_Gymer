<?php

class SanPham
{
	public $id;
	public $tensp;
	public $gia;
	public $soluongton;
	public $maloai;
	public $hinh;
	public $mota;

	public function __construct($Id,$Tensp,$Gia,$Soluongton,$Maloai,$Hinh,$Mota)
	{
		$this->id =$Id;
		$this->tensp = $Tensp;
		$this->gia = $Gia;
		$this->soluongton = $Soluongton;
		$this->maloai = $Maloai;
		$this->hinh = $Hinh;
		$this->mota = $Mota;
	}
}

include "connect.php";
$query = "select * from sanpham";

$data = mysqli_query($conn,$query);

$arr = array();
while ($row = mysqli_fetch_assoc($data)) {
	array_push($arr,new SanPham($row['masp'],$row['tensp'],$row['gia'],$row['slton'],$row['maloai'],
		$row['hinh'],$row['mota']));
}

echo json_encode($arr);
?>