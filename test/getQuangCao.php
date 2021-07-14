<?php
class QuangCao
{
	public $id;
	public $hinhquangcao;

	public function __construct($Id,$Hinhquangcao)
	{
		$this->id = $Id;
		$this->hinhquangcao = $Hinhquangcao;
	}
}
include "connect.php";
$query = "select * from Quangcao";

$data = mysqli_query($conn,$query);

$arr = array();
while ($row = mysqli_fetch_assoc($data)) {
	array_push($arr,new Quangcao($row['id'],$row['hinhquangcao']));
}

echo json_encode($arr);
?>