<?php
$dbhost = "localhost";
$dbuser = "root";
$dbpass = "";
$dbname = "gymer_app";
$conn = mysqli_connect($dbhost,$dbuser,$dbpass,$dbname);

if ($conn)
{
	mysqli_query($conn , "SET NAMES 'utf8'");
}else{
	echo "lỗi rồi".mysqli_connect_error();
}
?>
