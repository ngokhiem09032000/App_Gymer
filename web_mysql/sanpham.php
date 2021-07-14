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
		$soluong = $_POST['soluong'];
		$masp = $_POST['masp'];
	    $update = mysqli_query($conn,"update sanpham set  slton='$soluong' where masp ='$masp'");

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
		<div class="header1">Web quản lí update số lượng sản phẩm</div>
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
					<th width="50px" height="50px">Mã sản phẩm</th>
					<th width="50px" height="50px">Tên sản phẩm</th>
					<th width="50px" height="50px">Giá</th>
					<th width="50px" height="50px">Số lượng tồn</th>
					<th width="50px" height="50px">Hình</th>
					<th width="50px" height="50px">Mô tả</th>
				</tr>
				<?php
				include "admin/connect.php";
				$query = "select * from Sanpham";

				$data = mysqli_query($conn,$query);
				while ($row = mysqli_fetch_assoc($data)) {
					echo '<tr>
							<td>'.$row['masp'].'</td>
							<td>'.$row['tensp'].'</td>
							<td>'.$row['gia'].'</td>
							<td>'.$row['slton'].'</td>
							<td><img src="'.$row['hinh'].'" style="height: 100px;width: 100px;"></td>
							<td>'.$row['mota'].'</td>
						</tr>';
				}
				?>
			</table>
			<form action="/web_mysql/sanpham.php" style="margin:10px" method="POST" id="myform">
			  <label for="tensp">Nhập mã sản phẩm :</label>
			  <br><br>
			  <input type="text" id="masp" name="masp">
			  <br><br>
			  <label for="tensp">Nhập số lượng update:</label>
			  <br><br>
			  <input type="text" id="soluong" name="soluong">
			  <br><br>
			  <button type="submit" name="submit" style="width: 60px;height: 30px">Cập nhật</button>
			</form>
		</div>
		<div class="footer1">NHÓM 13- QUẢN LÍ APP GYMER</div>
	</div>
</body>
</html>