<?php

class BaiTap
{
	public $id;
	public $tenbt;
	public $tenvideo;
	public $chitiethuongdan;

	public function __construct($Id,$Tenbt,$Tenvideo,$Chitiethuongdan)
	{
		$this->id =$Id;
		$this->tenbt = $Tenbt;
		$this->tenvideo = $Tenvideo;
		$this->chitiethuongdan = $Chitiethuongdan;
	}
}
class LoaiBaiTap
{
	public $id;
	public $tenloaibt;
	public $mota;
	public $hinh;

	public function __construct($Id,$Tenloaibt,$Mota,$Hinh)
	{
		$this->id =$Id;
		$this->tenloaibt = $Tenloaibt;
		$this->mota = $Mota;
		$this->hinh = $Hinh;
	}
}
include "connect.php";
$query = "select * from loaibt";

$data = mysqli_query($conn,$query);

$arr = array();
while ($row = mysqli_fetch_assoc($data)) {
	array_push($arr,new LoaiBaiTap($row['maloaibt'],$row['tenloaibt'],$row['mota'],$row['hinh']));
}

echo json_encode($arr);
?>
