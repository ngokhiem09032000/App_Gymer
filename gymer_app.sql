-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th7 11, 2021 lúc 06:54 AM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `gymer_app`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baitap`
--

CREATE TABLE `baitap` (
  `mabt` char(10) NOT NULL,
  `tenbt` varchar(50) DEFAULT NULL,
  `tenvideo` char(20) DEFAULT NULL,
  `chitiethuongdan` varchar(500) DEFAULT NULL,
  `maloaibt` char(10) DEFAULT NULL,
  `dokho` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `baitap`
--

INSERT INTO `baitap` (`mabt`, `tenbt`, `tenvideo`, `chitiethuongdan`, `maloaibt`, `dokho`) VALUES
('bt001', 'Chống đẩy', 'chongday1', 'Nằm áp xuống sàn lấy tay đỡ thân. Giữ thẳng thân trong khi nâng và hạ thân bằng tay. Bài tập này giúp tập ngực, vai , cơ tay sau, lưng và chân', 'loaibt001', 'dokho01'),
('bt002', 'Chống đẩy', 'chongday1', 'Nằm áp xuống sàn lấy tay đỡ thân. Giữ thẳng thân trong khi nâng và hạ thân bằng tay. Bài tập này giúp tập ngực, vai , cơ tay sau, lưng và chân', 'loaibt001', 'dokho02'),
('bt003', 'Chống đẩy', 'chongday1', 'Nằm áp xuống sàn lấy tay đỡ thân. Giữ thẳng thân trong khi nâng và hạ thân bằng tay. Bài tập này giúp tập ngực, vai , cơ tay sau, lưng và chân', 'loaibt001', 'dokho03'),
('bt004', 'Tấn sau', 'tansau1', 'Đứng chân rộng bằng vai, hai tay để trên hông. Bước dài một bước dài một bước về sau bằng chân phải rồi hạ thân người xuống cho tới khi đùi trái song song với sàn. Trở lại tư thế và lặp lại với chân bên kia', 'loaibt002', 'dokho01'),
('bt005', 'Tấn sau', 'tansau1', 'Đứng chân rộng bằng vai, hai tay để trên hông. Bước dài một bước dài một bước về sau bằng chân phải rồi hạ thân người xuống cho tới khi đùi trái song song với sàn. Trở lại tư thế và lặp lại với chân bên kia', 'loaibt002', 'dokho02'),
('bt006', 'Tấn sau', 'tansau1', 'Đứng chân rộng bằng vai, hai tay để trên hông. Bước dài một bước dài một bước về sau bằng chân phải rồi hạ thân người xuống cho tới khi đùi trái song song với sàn. Trở lại tư thế và lặp lại với chân bên kia', 'loaibt002', 'dokho03'),
('bt007', 'Tập cơ bụng', 'tapcobung1', 'Nằm ngửa cong gối và tay duỗi thẳng. Sau đó nhấc thân trên khỏi sàn. Giữ một vài giây rồi từ từ trở lại tư thế ban đầu. Bài tập này chủ yếu cho các cơ bụng thẳng và cơ liên sườn', 'loaibt003', 'dokho01'),
('bt008', 'Tập cơ bụng', 'tapcobung1', 'Nằm ngửa cong gối và tay duỗi thẳng. Sau đó nhấc thân trên khỏi sàn. Giữ một vài giây rồi từ từ trở lại tư thế ban đầu. Bài tập này chủ yếu cho các cơ bụng thẳng và cơ liên sườn', 'loaibt003', 'dokho02'),
('bt009', 'Tập cơ bụng', 'tapcobung1', 'Nằm ngửa cong gối và tay duỗi thẳng. Sau đó nhấc thân trên khỏi sàn. Giữ một vài giây rồi từ từ trở lại tư thế ban đầu. Bài tập này chủ yếu cho các cơ bụng thẳng và cơ liên sườn', 'loaibt003', 'dokho03'),
('bt010', 'Chống đẩy để tay rộng', 'chongdaydetayrong1', 'Bắt đầu với thư thế chống đẩy thông thường nhưng tay dang rộng hơn vai. Sau đó đẩy cơ thể lên xuống. Nhớ phải giữ thẳng cơ thể.', 'loaibt004', 'dokho01'),
('bt011', 'Chống đẩy để tay rộng', 'chongdaydetayrong1', 'Bắt đầu với thư thế chống đẩy thông thường nhưng tay dang rộng hơn vai. Sau đó đẩy cơ thể lên xuống. Nhớ phải giữ thẳng cơ thể.', 'loaibt004', 'dokho02'),
('bt012', 'Chống đẩy để tay rộng', 'chongdaydetayrong1', 'Bắt đầu với thư thế chống đẩy thông thường nhưng tay dang rộng hơn vai. Sau đó đẩy cơ thể lên xuống. Nhớ phải giữ thẳng cơ thể.', 'loaibt004', 'dokho03'),
('bt013', 'hít đất chéo', 'hitdatcheo1', 'Bắt đầu với thư thế hít đất thẳng tay. Nâng tay phải và chân trái lên cho đến khi song song với sàn. Trở lại tư thế  bắt đầu và lặp lại với bên kia.', 'loaibt005', 'dokho01'),
('bt014', 'hít đất chéo', 'hitdatcheo1', 'Bắt đầu với thư thế hít đất thẳng tay. Nâng tay phải và chân trái lên cho đến khi song song với sàn. Trở lại tư thế  bắt đầu và lặp lại với bên kia.', 'loaibt005', 'dokho02'),
('bt015', 'hít đất chéo', 'hitdatcheo1', 'Bắt đầu với thư thế hít đất thẳng tay. Nâng tay phải và chân trái lên cho đến khi song song với sàn. Trở lại tư thế  bắt đầu và lặp lại với bên kia.', 'loaibt005', 'dokho03'),
('bt016', 'gánh đùi', 'ganhdui1', 'Chân đứng rộng bằng vai, tay để thẳng về trước, hạ thấp cơ thể cho tới khi đùi song song với sàn. Đầu gối cùng hướng với ngón chân. Quay lại tư thế ban đầu và lặp lại. Bài tập này giúp tập đùi, hông, cơ đùi trước, gân kheo và thân dưới', 'loaibt006', 'dokho01'),
('bt017', 'gánh đùi', 'ganhdui1', 'Chân đứng rộng bằng vai, tay để thẳng về trước, hạ thấp cơ thể cho tới khi đùi song song với sàn. Đầu gối cùng hướng với ngón chân. Quay lại tư thế ban đầu và lặp lại. Bài tập này giúp tập đùi, hông, cơ đùi trước, gân kheo và thân dưới', 'loaibt006', 'dokho02'),
('bt018', 'gánh đùi', 'ganhdui1', 'Chân đứng rộng bằng vai, tay để thẳng về trước, hạ thấp cơ thể cho tới khi đùi song song với sàn. Đầu gối cùng hướng với ngón chân. Quay lại tư thế ban đầu và lặp lại. Bài tập này giúp tập đùi, hông, cơ đùi trước, gân kheo và thân dưới', 'loaibt006', 'dokho03'),
('bt019', 'kéo cơ thoi', 'keocothoi1', 'Đứng với hai chân rộng bằng vai. Giơ hai tay song song với mặt đất và gập hai khuỷu tay về phía sau và siết chặt hai tay bên xương bả vai. Lặp lại bài tập này.', 'loaibt007', 'dokho01'),
('bt020', 'kéo cơ thoi', 'keocothoi1', 'Đứng với hai chân rộng bằng vai. Giơ hai tay song song với mặt đất và gập hai khuỷu tay về phía sau và siết chặt hai tay bên xương bả vai. Lặp lại bài tập này.', 'loaibt007', 'dokho02'),
('bt021', 'kéo cơ thoi', 'keocothoi1', 'Đứng với hai chân rộng bằng vai. Giơ hai tay song song với mặt đất và gập hai khuỷu tay về phía sau và siết chặt hai tay bên xương bả vai. Lặp lại bài tập này.', 'loaibt007', 'dokho03');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `mahd` int(11) NOT NULL,
  `masp` char(10) NOT NULL,
  `sl` int(11) NOT NULL,
  `giadagiam` float NOT NULL,
  `tongtien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dokho`
--

CREATE TABLE `dokho` (
  `madokho` char(10) NOT NULL,
  `tendokho` varchar(50) DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `dokho`
--

INSERT INTO `dokho` (`madokho`, `tendokho`, `mota`) VALUES
('dokho01', 'de', '10 lan'),
('dokho02', 'vua', '20 lan'),
('dokho03', 'kho', '40 lan');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giamgia`
--

CREATE TABLE `giamgia` (
  `masp` char(10) NOT NULL,
  `chisogiam` int(11) NOT NULL,
  `ngaybatdau` date NOT NULL,
  `ngayketthuc` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `mahd` int(11) NOT NULL,
  `sdtkh` char(13) NOT NULL,
  `ngaylap` date NOT NULL,
  `tongtien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `hoten` varchar(50) DEFAULT NULL,
  `sdt` char(13) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `cannang` float DEFAULT NULL,
  `chieucao` float DEFAULT NULL,
  `matkhau` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`hoten`, `sdt`, `email`, `cannang`, `chieucao`, `matkhau`) VALUES
('Ngo Khiem', '0833123', 'ngokhiem@gmail.com', 70, 180, '123'),
('Ngo Khuong', '0833124', 'ngokhuong@gmail.com', 40, 150, '123'),
('Ngo Khanh', '0833125', 'ngokhanh@gmail.com', 50, 170, '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaibt`
--

CREATE TABLE `loaibt` (
  `maloaibt` char(10) NOT NULL,
  `tenloaibt` varchar(50) DEFAULT NULL,
  `mota` varchar(500) DEFAULT NULL,
  `hinh` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loaibt`
--

INSERT INTO `loaibt` (`maloaibt`, `tenloaibt`, `mota`, `hinh`) VALUES
('loaibt001', 'Toàn Thân', 'tất cả các bộ phận của cơ thể', 'http://192.168.1.8:8080/img/Toanthan.jpg'),
('loaibt002', 'Thân Dưới', 'cơ bắp chân, cơ đùi, cơ mông', 'http://192.168.1.8:8080/img/Thanduoi.jpg'),
('loaibt003', 'Bụng', 'cơ bụng', 'http://192.168.1.8:8080/img/Bung.jpg'),
('loaibt004', 'Ngực', 'cơ ngực', 'http://192.168.1.8:8080/img/Nguc.jpg'),
('loaibt005', 'Cánh tay', 'cơ tay', 'http://192.168.1.8:8080/img/Canhtay.jpg'),
('loaibt006', 'Chân', 'cơ chân', 'http://192.168.1.8:8080/img/Chan.jpg'),
('loaibt007', 'Vai Lưng', 'cơ vai lưng', 'http://192.168.1.8:8080/img/Vailung.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisp`
--

CREATE TABLE `loaisp` (
  `maloai` char(10) NOT NULL,
  `tenloai` varchar(50) DEFAULT NULL,
  `gia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loaisp`
--

INSERT INTO `loaisp` (`maloai`, `tenloai`, `gia`) VALUES
('loai001', 'USA', 130),
('loai002', 'Viet Nam', 130),
('loai003', 'Trung Quốc', 130);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quangcao`
--

CREATE TABLE `quangcao` (
  `id` int(11) NOT NULL,
  `hinhquangcao` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `quangcao`
--

INSERT INTO `quangcao` (`id`, `hinhquangcao`) VALUES
(1, 'http://192.168.1.8:8080/img/QuangCao1.jpg'),
(2, 'http://192.168.1.8:8080/img/QuangCao2.png'),
(3, 'http://192.168.1.8:8080/img/QuangCao3.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `masp` char(10) NOT NULL,
  `tensp` varchar(50) DEFAULT NULL,
  `gia` int(11) DEFAULT NULL,
  `slton` int(11) DEFAULT NULL,
  `maloai` char(10) DEFAULT NULL,
  `hinh` varchar(500) DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`masp`, `tensp`, `gia`, `slton`, `maloai`, `hinh`, `mota`) VALUES
('sp001', 'giày tập gym', 500000, 10, 'loai001', 'http://192.168.1.8:8080/img/Giay.jpg', 'giày chạy rất êm và đẹp'),
('sp002', 'áo tập gym', 200000, 10, 'loai002', 'http://192.168.1.8:8080/img/Ao.jpg', 'thoáng mát'),
('sp003', 'quần tập gym', 100000, 10, 'loai002', 'http://192.168.1.8:8080/img/Quan.jpg', 'mỏng, nhẹ và thoải mái');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `baitap`
--
ALTER TABLE `baitap`
  ADD PRIMARY KEY (`mabt`),
  ADD KEY `maloaibt` (`maloaibt`),
  ADD KEY `dokho` (`dokho`);

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`mahd`,`masp`);

--
-- Chỉ mục cho bảng `dokho`
--
ALTER TABLE `dokho`
  ADD PRIMARY KEY (`madokho`);

--
-- Chỉ mục cho bảng `giamgia`
--
ALTER TABLE `giamgia`
  ADD PRIMARY KEY (`masp`,`ngaybatdau`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahd`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`sdt`);

--
-- Chỉ mục cho bảng `loaibt`
--
ALTER TABLE `loaibt`
  ADD PRIMARY KEY (`maloaibt`);

--
-- Chỉ mục cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  ADD PRIMARY KEY (`maloai`);

--
-- Chỉ mục cho bảng `quangcao`
--
ALTER TABLE `quangcao`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`masp`),
  ADD KEY `maloai` (`maloai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `mahd` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `quangcao`
--
ALTER TABLE `quangcao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `baitap`
--
ALTER TABLE `baitap`
  ADD CONSTRAINT `baitap_ibfk_1` FOREIGN KEY (`maloaibt`) REFERENCES `loaibt` (`maloaibt`),
  ADD CONSTRAINT `baitap_ibfk_2` FOREIGN KEY (`dokho`) REFERENCES `dokho` (`madokho`);

--
-- Các ràng buộc cho bảng `giamgia`
--
ALTER TABLE `giamgia`
  ADD CONSTRAINT `giamgia_ibfk_1` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`maloai`) REFERENCES `loaisp` (`maloai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
