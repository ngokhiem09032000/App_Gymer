<?php

include "connect.php";
$query = "select max(mahd) from hoadon";

$result = mysqli_query($conn,$query);

while ($row = mysqli_fetch_assoc($result)) {
	echo $row['max(mahd)'];
}
?>