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
	    $hinhquangcao = "http://192.168.1.8:8080/img/".$_POST['hinhquangcao'];

	    $insert = mysqli_query($conn,"insert into quangcao values(null,'$hinhquangcao')");

	    if(!$insert)
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
		<div class="header1">Web quản lí thêm quảng cáo</div>
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
					<th width="50px" height="50px">NO.</th>
					<th width="300px">Hình</th>
				</tr>
				<?php
				include "admin/connect.php";
				$query = "select * from Quangcao";

				$data = mysqli_query($conn,$query);
				while ($row = mysqli_fetch_assoc($data)) {
					echo '<tr>
							<td>'.$row['id'].'</td>
							<td><img src="'.$row['hinhquangcao'].'" style="height: 100px;width: 200px;"></td>
						</tr>';
				}
				?>
			</table>
			<form action="/web_mysql/quangcao.php" style="margin:10px" method="POST" id="myform">
			  <label for="myfile">Chọn file hình muốn thêm:</label>
			  <input type="file" id="myfile" name="hinhquangcao"><br><br>
			  <button type="submit" name="submit" style="width: 60px;height: 30px">Thêm</button>
			</form>
		</div>

		

		<div class="footer1">NHÓM 13- QUẢN LÍ APP GYMER</div>
	</div>
</body>
</html>