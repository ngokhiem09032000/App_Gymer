<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/style1.css">
	<title>Web quản lí bán sản phẩm gym</title>
</head>
<body>
	<?php
	include "admin/connect.php"; // Using database connection file here

	if(isset($_POST['submit']))
	{		
		$mahd = $_POST['mahd'];
		$masp = $_POST['masp'];
	    $update = mysqli_query($conn,"delete from chitiethoadon where mahd='$mahd' and masp='$masp'");

	    if(!$update)
	    {
	        echo mysqli_error();
	    }
	    else
	    {
	    }
	}

	mysqli_close($conn); // Close connection
	?>
	<div class="wrapper1">
		<div class="header1">Web quản lí bán sản phẩm gym</div>
		<div class="menu1">
			<ul>
				<li><a href="http://localhost:8080/web_mysql/index.php" class="active">Home</a></li>
				<li><a href="http://localhost:8080/web_mysql/banhang.php">bán hàng</a></li>
				<li><a href="http://localhost:8080/web_mysql/sanpham.php">sản phẩm</a></li>
				<li><a href="http://localhost:8080/web_mysql/quangcao.php">Quảng cáo</a></li>
			</ul>

		</div>
		<div style="text-align: center;">
			
			<table border="10" style="margin: 0px auto;height:auto;width: 1000px">
				<tr>
					<th width="50px" height="50px">Mã hoá đơn</th>
					<th width="50px" height="50px">Mã sản phẩm</th>
					<th width="50px" height="50px">Số lượng</th>
					<th width="50px" height="50px">Giá đã giảm</th>
					<th width="50px" height="50px">Tổng tiền</th>
				</tr>
				<?php
				include "admin/connect.php";
				$query = "select * from ChiTietHoaDon";

				$data = mysqli_query($conn,$query);
				while ($row = mysqli_fetch_assoc($data)) {
					echo '<tr>
							<td>'.$row['mahd'].'</td>
							<td>'.$row['masp'].'</td>
							<td>'.$row['sl'].'</td>
							<td>'.$row['giadagiam'].'</td>
							<td>'.$row['tongtien'].'</td>
						</tr>';
				}
				?>
			</table>
			<form action="/web_mysql/banhang.php" style="margin:10px" method="POST" id="myform">
			  <label for="tensp">Nhập mã hoá đơn :</label>
			  <br><br>
			  <input type="text" id="mahd" name="mahd">
			  <br><br>
			  <label for="tensp">Nhập mã sản phẩm :</label>
			  <br><br>
			  <input type="text" id="masp" name="masp">
			  <br><br>
			  <button type="submit" name="submit" style="width: 60px;height: 30px">Xoá</button>
			</form>
		</div>
		<div class="footer1">NHÓM 13- QUẢN LÍ APP GYMER</div>
	</div>
</body>
</html>