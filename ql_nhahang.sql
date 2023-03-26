-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 26, 2023 at 08:25 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ql_nhahang`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `MADH` char(10) NOT NULL,
  `MAMON` char(50) NOT NULL,
  `SOLUONG` int(30) NOT NULL,
  `DONGIA` int(30) NOT NULL,
  `NGAYDAT` date NOT NULL,
  `TONGTIEN` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `danhgia`
--

CREATE TABLE `danhgia` (
  `SODT` int(10) NOT NULL,
  `MAMON` char(50) NOT NULL,
  `NGAYDANHGIA` date NOT NULL,
  `BINHLUAN` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `MADH` char(10) NOT NULL,
  `SDT` int(10) NOT NULL,
  `SOLUONG` int(30) NOT NULL,
  `DONGIA` int(30) DEFAULT NULL,
  `TONGTIEN` int(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loai`
--

CREATE TABLE `loai` (
  `MALOAI` int(10) NOT NULL,
  `TENLOAI` varchar(100) NOT NULL,
  `HINHANH` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loai`
--

INSERT INTO `loai` (`MALOAI`, `TENLOAI`, `HINHANH`) VALUES
(1, 'Đồ uống', 'douong1.png'),
(2, 'Maki', 'maki.png'),
(3, 'Sashimi', 'sashimi.png'),
(4, 'Sushi', 'sushi1.png'),
(5, 'Udon', 'udon.png');

-- --------------------------------------------------------

--
-- Table structure for table `monan`
--

CREATE TABLE `monan` (
  `MAMON` char(50) NOT NULL,
  `TENMON` varchar(100) NOT NULL,
  `CHITIET` mediumtext NOT NULL,
  `SPNOIBAT` char(50) DEFAULT NULL,
  `DONGIA` int(11) NOT NULL,
  `HINHANH` varchar(100) NOT NULL,
  `MALOAI` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `monan`
--

INSERT INTO `monan` (`MAMON`, `TENMON`, `CHITIET`, `SPNOIBAT`, `DONGIA`, `HINHANH`, `MALOAI`) VALUES
('01', 'Sushi Cá Hồi', 'Sushi cá hồi được xếp vào nhóm nigiri sushi, một trong những loại sushi phổ biến nhất. Để tạo ra một miếng sushi cá hồi đẹp mắt, người làm sushi sẽ phải thật khéo léo để cắt lát cá hồi mỏng và bóp cơm lại thành hình oval tròn hoặc hình tam giác phù hợp.\r\n\r\nSushi cá hồi không chỉ ngon mà còn có lợi cho sức khỏe. Cá hồi là nguồn cung cấp chất đạm và axit béo omega-3 tốt cho tim mạch. Vì vậy, khi ăn sushi cá hồi, bạn sẽ không chỉ thưởng thức hương vị ngon miệng mà còn giúp cho cơ thể của mình khỏe mạnh hơn.\r\n\r\nSushi cá hồi là món ăn truyền thống của Nhật Bản, được làm từ miếng cơm trộn với giấm gạo và một lát cá hồi tươi ngon. Cá hồi được chọn lựa kỹ càng và thường được cắt thành từng miếng nhỏ phù hợp với kích thước của cơm.\r\n\r\nKhi ăn sushi cá hồi, bạn có thể thưởng thức hương vị thơm ngon của cá hồi tươi, hòa quyện với vị giấm gạo chua nhẹ và lượng muối vừa đủ. Ngoài ra, món sushi này thường được kèm với wasabi (một loại gia vị cay) và tương xốt đậm đà, giúp làm tăng thêm hương vị cho món ăn.', 'YES', 59000, 'sushicahoi.png', 4),
('02', 'Sushi Cá Trích', 'Sushi cá trích là một loại sushi truyền thống của Nhật Bản được làm từ thịt cá trích tươi ngon. Cá trích thường được đánh giá cao vì hương vị ngọt ngào và thịt đậm đà.\r\n\r\nĐể tạo ra món sushi cá trích, thợ sushi sẽ lựa chọn những miếng thịt cá trích tươi ngon và cắt thành các miếng nhỏ. Sau đó, họ sẽ trộn với một chút muối và đường để tăng cường hương vị và giữ cho cá tươi lâu hơn.\r\n\r\nCác miếng cá trích sau đó được đặt lên một miếng cơm sushi trắng, trộn với một chút wasabi để tăng thêm hương vị cay và chấm với một ít nước tương đậm đà. Sau đó, thợ sushi sẽ cuộn món sushi lại với một chiếc lá nori để giữ cho các thành phần bên trong vừa ăn vừa đẹp mắt.\r\n\r\nKhi ăn, món sushi cá trích sẽ mang lại cảm giác tươi mát, ngọt ngào và giòn tan. Cá trích sẽ có hương vị đậm đà nhưng không quá đắng, đem lại cho người thưởng thức một trải nghiệm ẩm thực độc đáo và hấp dẫn.', NULL, 59000, 'sushicatrich.png', 4),
('03', 'Sushi Trứng', 'Sushi trứng, hay còn được gọi là \"tamago sushi\" trong tiếng Nhật, là một loại sushi được làm từ trứng gà. Đây là một món ăn được ưa chuộng trong ẩm thực Nhật Bản và được coi là một phần quan trọng của các bữa tiệc sushi.\r\n\r\nSushi trứng thường được làm bằng cách đánh tan trứng gà với đường, nước dashi (nước cá hoặc rau củ), và một ít muối. Hỗn hợp được đánh tan và đổ vào một khay nhỏ, sau đó được nướng trong lò nướng. Khi đã chín, trứng sẽ có một màu vàng nhạt và có cảm giác mịn màng trên lưỡi.\r\n\r\nKhi được sử dụng trong sushi, trứng thường được cắt thành hình vuông và đặt lên một miếng sushi cùng với cơm sushi. Khi ăn, người thưởng thức sẽ cảm nhận được vị ngọt nhẹ và mềm mại của trứng hòa quyện với hương vị cơm sushi cùng với gia vị như giấm gạo và muối.\r\n\r\nSushi trứng thường được sử dụng để cân bằng vị ngọt trong các bữa tiệc sushi, và là một lựa chọn tuyệt vời cho những người không thích những loại sushi có hương vị mặn hoặc cá.', 'YES', 42000, 'sushitrung.png', 4),
('04', 'Sushi Lươn', 'Sushi lươn là một loại sushi truyền thống của Nhật Bản, được làm từ miếng lươn tươi, được cắt mỏng và chế biến cùng với cơm và các loại gia vị.\r\n\r\nMiếng lươn được chọn kỹ và chế biến cẩn thận để giữ nguyên hương vị tươi ngon của loài động vật biển này. Sau đó, lươn được cắt mỏng và trộn đều với gia vị như nước tương, giấm, đường và muối để tạo ra một mùi vị đặc trưng cho sushi lươn.\r\n\r\nCơm sushi được chuẩn bị bằng cách trộn gạo với hỗn hợp giấm và đường, tạo thành một hỗn hợp dẻo và mềm mượt. Miếng lươn sau đó được đặt lên trên cơm sushi và cuộn lại với một chiếc lá nori mỏng.\r\n\r\nSushi lươn thường được ăn kèm với các loại gia vị như wasabi, gừng đỏ và nước tương để tăng thêm hương vị và tạo ra một trải nghiệm ăn uống thú vị. Với hương vị đặc trưng của lươn và cơm sushi, sushi lươn là một món ăn ngon và đầy chất dinh dưỡng mà rất được yêu thích tại Nhật Bản và trên toàn thế giới.', 'YES', 59000, 'sushiluon.png', 4),
('05', 'Sushi Cá Ngừ', 'Sushi cá ngừ là món ăn Nhật Bản phổ biến được làm từ miếng cơm trộn giấm được ướp với các loại gia vị như đường, muối và rượu sake, sau đó được chia thành từng viên nhỏ hình trụ. Mỗi viên cơm được phủ lên trên một miếng cá ngừ tươi, thường được cắt mỏng và dài để phù hợp với kích thước của viên cơm.\r\n\r\nCá ngừ được sử dụng trong sushi thường được chọn từ những con cá ngừ tươi ngon, có thịt đỏ tươi, dai và ngọt. Cá được cắt thành những miếng dài và mỏng để phù hợp với kích thước của viên cơm, và thường được phủ lên trên bằng một lớp rong biển khô, tạo thành một hình dáng tròn đẹp mắt và hương vị độc đáo.\r\n\r\nSushi cá ngừ thường được ăn kèm với wasabi (tương ớt Nhật Bản) và xì dầu đậu nành (shoyu), tạo ra hương vị độc đáo và đầy đủ. Hương vị của sushi cá ngừ rất tươi mới, hòa quyện giữa vị chua của cơm giấm, vị ngọt của cá ngừ và vị cay của wasabi, tạo nên một hương vị đặc trưng của ẩm thực Nhật Bản.', NULL, 59000, 'sushicangu.png', 4),
('06', 'Gunkan Trứng Cá', 'Gunkan trứng cá là món ăn truyền thống của Nhật Bản, được tạo thành từ các nguyên liệu chính gồm rượu gạo, lá nori và trứng cá.\r\n\r\nĐể tạo ra gunkan trứng cá, trước hết cần phải chuẩn bị một miếng lá nori, sau đó cắt thành dải rộng khoảng 2,5cm. Dải lá nori được cuộn tròn để tạo thành hình trụ nhỏ và được giữ vững bằng một miếng gạo đã nhúng nước. Tiếp theo, một lượng nhỏ trứng cá đã đánh tan được đổ lên miếng gạo, tạo thành một chiếc \"đĩa\" trứng cá trên đỉnh gạo.\r\n\r\nGunkan trứng cá thường được trang trí với một lượng nhỏ các nguyên liệu khác như rong biển, tôm khô, trứng cá muối, hoặc các loại gia vị như wasabi hoặc mù tạt. Với màu vàng nhạt của trứng cá, hương vị béo ngậy và vị ngọt nhẹ, gunkan trứng cá là món ăn nhẹ đầy hấp dẫn và được yêu thích bởi nhiều người.\r\n\r\nGunkan trứng cá thường được ăn kèm với rượu sake hoặc nước trà xanh. Nó thường được phục vụ trong các nhà hàng sushi và đặc biệt là trong các bữa tiệc sushi, nơi nó trở thành một món ăn khoái khẩu và được đánh giá cao bởi sự tươi ngon và hương vị đặc biệt của nó.', NULL, 45000, 'gunkantrungca.png', 4),
('07', 'Sashimi Cá Hồi', 'Sashimi cá hồi là món ăn truyền thống của Nhật Bản, được làm từ thịt cá hồi tươi ngon và được cắt thành từng lát mỏng và đẹp mắt.\r\n\r\nĐể tạo ra sashimi cá hồi, cần phải sử dụng loại cá hồi tươi ngon và được chế biến ngay sau khi đánh bắt để giữ cho thịt cá tươi ngon và giữ được độ đàn hồi. Sau khi lựa chọn được loại cá hồi tươi ngon, các đầu cá, xương và da được loại bỏ kỹ càng, để lại chỉ một miếng thịt cá to và đẹp.\r\n\r\nSau đó, miếng thịt cá hồi được cắt thành từng lát mỏng và đẹp mắt. Việc cắt sashimi cần phải thật tinh tế và chính xác để các miếng sashimi có độ dày đều nhau và có thể tan chảy trong miệng.\r\n\r\nSashimi cá hồi thường được phục vụ với wasabi, rau xà lách, rong biển và nước tương đặc biệt để tăng cường hương vị. Khi ăn, bạn nên chấm miếng sashimi vào nước tương hoặc wasabi trước khi cho vào miệng để tạo ra một hương vị thật ngon và đầy đặc trưng của sashimi cá hồi.\r\n\r\nSashimi cá hồi là món ăn tuyệt vời cho những người yêu thích đồ ăn Nhật Bản. Với hương vị thơm ngon, mềm mại và đầy dinh dưỡng của cá hồi, sashimi cá hồi không chỉ là một món ăn ngon mà còn là một món ăn rất tốt cho sức khỏe của con người.', 'YES', 119000, 'sashimicahoi.png', 3),
('08', 'Sashimi Cá Ngừ', 'Sashimi cá ngừ là một món ăn truyền thống của Nhật Bản, được chế biến từ thịt cá ngừ tươi ngon và được cắt thành những miếng mỏng và đều nhau. Sashimi cá ngừ thường được phục vụ với rau sống, gừng tươi, wasabi và nước sốt đậm đà.\r\n\r\nThịt cá ngừ được chọn lựa kỹ càng và cắt ra thành những lát mỏng và đều nhau để tạo ra một món ăn có hương vị đậm đà và tươi ngon. Khi thưởng thức sashimi cá ngừ, người ta thường chấm miếng cá vào nước tương hoặc nước sốt wasabi để tăng thêm hương vị.\r\n\r\nRau sống và gừng tươi thường được sử dụng để làm đồ gia vị cho sashimi cá ngừ. Rau sống thường được chọn từ những loại rau như rau mùi, rau cải xoong và lá ngón. Gừng tươi được cắt thành những sợi mỏng để tạo ra một hương vị cay nhẹ và thơm ngon.\r\n\r\nSashimi cá ngừ được coi là một món ăn rất tinh tế và đòi hỏi kỹ năng cắt dao tinh tế để tạo ra những miếng thịt cá đẹp mắt và đồng đều. Đây là một món ăn rất phổ biến trong các nhà hàng Nhật Bản và được đánh giá cao bởi những người yêu thích ẩm thực Nhật Bản.', NULL, 109000, 'sashimicangu.png', 3),
('09', 'Sashimi Sò Đỏ', 'Sashimi sò đỏ là một món ăn nhẹ được làm từ các lát mỏng của con sò đỏ tươi ngon, được cắt thành những miếng hình tròn hoặc hình bầu dục để tạo ra hình dạng đẹp mắt. Sashimi sò đỏ thường được đặt trên một tô hoặc đĩa, và được trang trí bằng các loại rau củ tươi ngon để tăng thêm hương vị và màu sắc.\r\n\r\nSashimi sò đỏ có vị ngọt, thịt săn chắc và mềm mại. Khi ăn, bạn cảm nhận được vị ngọt tự nhiên của sò kết hợp với hương vị của sốt chấm đặc trưng, thường là nước tương hoặc wasabi, giúp tăng cường hương vị và mang lại cảm giác sảng khoái khi thưởng thức.\r\n\r\nNgoài ra, sashimi sò đỏ còn rất giàu dinh dưỡng với nhiều protein, chất béo không no và chất khoáng, là một lựa chọn ăn kiêng khá tốt cho những người yêu thích ẩm thực Nhật Bản và đang tìm kiếm những món ăn lành mạnh và giàu dinh dưỡng.', NULL, 109000, 'sashimisodo.png', 3),
('10', 'Sashimi Bạch Tuột', 'Sashimi bạch tuột là một món ăn truyền thống của ẩm thực Nhật Bản được làm từ bạch tuột tươi ngon, được cắt thành những lát mỏng và được bày trên một đĩa để tạo ra một bức tranh ẩm thực đẹp mắt.\r\n\r\nBạch tuột được cắt thành những miếng nhỏ, hình chữ nhật hoặc hình tam giác, và được trang trí bằng các loại rau củ tươi ngon như rau thơm, cải xoong và ớt tươi. Khi thưởng thức, sashimi bạch tuột có mùi hôi thơm đặc trưng của hải sản, cùng với vị ngọt thanh, thịt bạch tuột mềm và dai, tạo cảm giác ngon miệng và đầy đủ.\r\n\r\nMón ăn này thường được kèm theo một số loại nước chấm như nước tương, nước chanh, đường và wasabi, giúp tăng cường hương vị và mang lại cảm giác sảng khoái khi thưởng thức.\r\n\r\nSashimi bạch tuột là một món ăn giàu chất dinh dưỡng, chứa nhiều protein, canxi, magiê và các khoáng chất khác, là một lựa chọn tuyệt vời cho những người ưa thích hải sản và đang tìm kiếm những món ăn giàu dinh dưỡng và lành mạnh.', NULL, 99000, 'sashimibachtuot.png', 3),
('11', 'Sashimi Mực', 'Sashimi mực là một món ăn truyền thống của ẩm thực Nhật Bản được làm từ mực tươi ngon, được cắt thành những lát mỏng và được bày trên một đĩa để tạo ra một bức tranh ẩm thực đẹp mắt.\r\n\r\nMực được cắt thành những miếng mỏng, hình chữ nhật hoặc hình tam giác và được trang trí bằng các loại rau củ tươi ngon như rau thơm, cải xoong và ớt tươi. Khi thưởng thức, sashimi mực có hương vị đặc trưng của hải sản, vị ngọt, thịt mực dai và béo, cùng với độ nhạt nhẽo của một số loại nước chấm như nước tương, nước chanh, đường và wasabi.\r\n\r\nMón ăn này có vị thanh mát, tươi ngon, mang lại cảm giác sảng khoái cho thực khách. Ngoài ra, sashimi mực còn rất giàu chất dinh dưỡng, chứa nhiều protein, vitamin và khoáng chất, là một lựa chọn tuyệt vời cho những người ưa thích hải sản và đang tìm kiếm những món ăn lành mạnh và giàu dinh dưỡng.\r\n\r\nSashimi mực thường được kèm theo các loại rau củ tươi ngon và các loại nước chấm như nước tương, nước chanh, đường và wasabi, tạo nên một hương vị đa dạng và phong phú, thích hợp cho những người yêu thích ẩm thực Nhật Bản và muốn khám phá hương vị của các loại hải sản khác nhau.', NULL, 99000, 'sashimimuc.png', 3),
('12', 'Sashimi Cá Trích', 'Sashimi cá trích là một món ăn truyền thống của ẩm thực Nhật Bản, được làm từ cá trích tươi ngon, được cắt thành những lát mỏng và được bày trên một đĩa để tạo ra một bức tranh ẩm thực đẹp mắt.\r\n\r\nCá trích được cắt thành những miếng nhỏ, hình chữ nhật hoặc hình tam giác, và được trang trí bằng các loại rau củ tươi ngon như rau thơm, cải xoong và ớt tươi. Khi thưởng thức, sashimi cá trích có hương vị đặc trưng của hải sản, vị ngọt thanh, thịt cá mềm và dai, tạo cảm giác ngon miệng và đầy đủ.\r\n\r\nMón ăn này thường được kèm theo một số loại nước chấm như nước tương, nước chanh, đường và wasabi, giúp tăng cường hương vị và mang lại cảm giác sảng khoái khi thưởng thức.\r\n\r\nSashimi cá trích là một món ăn giàu chất dinh dưỡng, chứa nhiều protein, omega-3 và các khoáng chất khác, là một lựa chọn tuyệt vời cho những người ưa thích hải sản và đang tìm kiếm những món ăn giàu dinh dưỡng và lành mạnh.\r\n\r\nNgoài ra, sashimi cá trích còn có màu sắc tươi sáng, độc đáo, là một trong những món ăn được ưa chuộng trong các bữa tiệc hoặc các dịp đặc biệt tại Nhật Bản.', 'YES', 119000, 'sashimicatrich.png', 3),
('13', 'Mì Udon Thịt Heo', 'Mì udon thịt heo là một món ăn đặc trưng của ẩm thực Nhật Bản, được làm từ sợi mì udon mềm mại, thấm đượm vị nước dùng ngọt thanh, kết hợp cùng thịt heo tươi ngon và các loại rau củ tươi ngon.\r\n\r\nMì udon được làm từ bột mì, có độ dày vừa phải, giòn và dai, làm cho món ăn trở nên thơm ngon và bổ dưỡng. Thịt heo được chế biến sao cho giòn mềm, cắt thành từng lát mỏng và được nướng trước khi được thả vào nồi nước dùng.\r\n\r\nNước dùng của mì udon thịt heo được chế biến từ các nguyên liệu như đường, nước tương, dashi (một loại nước dùng truyền thống của Nhật Bản) và rau củ tươi ngon, tạo ra một hương vị đậm đà và ngon miệng.\r\n\r\nMón ăn này thường được kèm theo một số loại rau củ như măng tây, nấm, cải bắp, cải thảo, cải xoăn và hành tây, tạo nên một hương vị đa dạng và phong phú.\r\n\r\nMì udon thịt heo là một món ăn giàu chất dinh dưỡng, chứa nhiều protein, vitamin và khoáng chất, là một lựa chọn tuyệt vời cho những người đang tìm kiếm những món ăn bổ dưỡng và giàu dinh dưỡng.\r\n\r\nNgoài ra, mì udon thịt heo còn có màu sắc tươi sáng, hương vị thơm ngon và phù hợp cho những người muốn thưởng thức ẩm thực Nhật Bản truyền thống.', 'YES', 79000, 'Udonheo.png', 5),
('14', 'Mì Udon Thịt Bò', 'Mì udon thịt bò là một món ăn truyền thống của ẩm thực Nhật Bản, được làm từ sợi mì udon mềm mại, thấm đượm vị nước dùng ngọt thanh, kết hợp cùng thịt bò tươi ngon và các loại rau củ tươi ngon.\r\n\r\nMì udon được làm từ bột mì, có độ dày vừa phải, giòn và dai, làm cho món ăn trở nên thơm ngon và bổ dưỡng. Thịt bò được cắt thành từng miếng mỏng, ướp với gia vị và nướng trước khi được thả vào nồi nước dùng.\r\n\r\nNước dùng của mì udon thịt bò được chế biến từ các nguyên liệu như đường, nước tương, dashi (một loại nước dùng truyền thống của Nhật Bản) và rau củ tươi ngon, tạo ra một hương vị đậm đà và ngon miệng.\r\n\r\nMón ăn này thường được kèm theo một số loại rau củ như măng tây, nấm, cải bắp, cải thảo, cải xoăn và hành tây, tạo nên một hương vị đa dạng và phong phú.\r\n\r\nMì udon thịt bò là một món ăn giàu chất dinh dưỡng, chứa nhiều protein, vitamin và khoáng chất, là một lựa chọn tuyệt vời cho những người đang tìm kiếm những món ăn bổ dưỡng và giàu dinh dưỡng.\r\n\r\nNgoài ra, mì udon thịt bò còn có màu sắc tươi sáng, hương vị thơm ngon và phù hợp cho những người muốn thưởng thức ẩm thực Nhật Bản truyền thống. Món ăn này có vị ngọt thanh, béo ngậy và giòn dai, tạo nên một trải nghiệm ẩm thực đặc biệt cho thực khách', 'YES', 89000, 'Udonbo.png', 5),
('15', 'Mì Udon Thịt Gà', 'Mì udon thịt bò là một món ăn truyền thống của ẩm thực Nhật Bản, được làm từ sợi mì udon mềm mại, thấm đượm vị nước dùng ngọt thanh, kết hợp cùng thịt bò tươi ngon và các loại rau củ tươi ngon.\r\n\r\nMì udon được làm từ bột mì, có độ dày vừa phải, giòn và dai, làm cho món ăn trở nên thơm ngon và bổ dưỡng. Thịt bò được cắt thành từng miếng mỏng, ướp với gia vị và nướng trước khi được thả vào nồi nước dùng.\r\n\r\nNước dùng của mì udon thịt bò được chế biến từ các nguyên liệu như đường, nước tương, dashi (một loại nước dùng truyền thống của Nhật Bản) và rau củ tươi ngon, tạo ra một hương vị đậm đà và ngon miệng.\r\n\r\nMón ăn này thường được kèm theo một số loại rau củ như măng tây, nấm, cải bắp, cải thảo, cải xoăn và hành tây, tạo nên một hương vị đa dạng và phong phú.\r\n\r\nMì udon thịt bò là một món ăn giàu chất dinh dưỡng, chứa nhiều protein, vitamin và khoáng chất, là một lựa chọn tuyệt vời cho những người đang tìm kiếm những món ăn bổ dưỡng và giàu dinh dưỡng.\r\n\r\nNgoài ra, mì udon thịt bò còn có màu sắc tươi sáng, hương vị thơm ngon và phù hợp cho những người muốn thưởng thức ẩm thực Nhật Bản truyền thống. Món ăn này có vị ngọt thanh, béo ngậy và giòn dai, tạo nên một trải nghiệm ẩm thực đặc biệt cho thực khách.\r\n\r\n\r\n\r\n\r\ntrungthinh10063009@gmail.com\r\nviết cho tôi mô tả mì udon thịt gà \r\nMì udon thịt gà là một món ăn truyền thống của ẩm thực Nhật Bản, được làm từ sợi mì udon mềm mại, thấm đượm vị nước dùng ngọt thanh, kết hợp cùng thịt gà tươi ngon và các loại rau củ tươi ngon.\r\n\r\nMì udon được làm từ bột mì, có độ dày vừa phải, giòn và dai, làm cho món ăn trở nên thơm ngon và bổ dưỡng. Thịt gà được cắt thành từng miếng nhỏ và ướp với gia vị trước khi được thả vào nồi nước dùng.\r\n\r\nNước dùng của mì udon thịt gà được chế biến từ các nguyên liệu như đường, nước tương, dashi (một loại nước dùng truyền thống của Nhật Bản) và rau củ tươi ngon, tạo ra một hương vị đậm đà và ngon miệng.\r\n\r\nMón ăn này thường được kèm theo một số loại rau củ như măng tây, nấm, cải bắp, cải thảo, cải xoăn và hành tây, tạo nên một hương vị đa dạng và phong phú.\r\n\r\nMì udon thịt gà là một món ăn giàu chất dinh dưỡng, chứa nhiều protein, vitamin và khoáng chất, là một lựa chọn tuyệt vời cho những người đang tìm kiếm những món ăn bổ dưỡng và giàu dinh dưỡng.\r\n\r\nNgoài ra, mì udon thịt gà còn có màu sắc tươi sáng, hương vị thơm ngon và phù hợp cho những người muốn thưởng thức ẩm thực Nhật Bản truyền thống. Món ăn này có vị ngọt thanh, béo ngậy và giòn dai, tạo nên một trải nghiệm ẩm thực đặc biệt cho thực khách.', NULL, 79000, 'Udonga.png', 5),
('16', 'Mì Udon Trộn Cay', 'Mì udon trộn cay là một món ăn phổ biến trong ẩm thực Hàn Quốc, được làm từ mì udon, thịt heo hoặc thịt gà, rau củ và gia vị cay nồng.\r\n\r\nMì udon được chế biến từ bột mì, có độ dày vừa phải, giòn và dai, tạo nên hương vị đặc trưng và bổ dưỡng. Thịt heo hoặc thịt gà được cắt thành từng miếng nhỏ và ướp với gia vị trước khi được chiên giòn.\r\n\r\nSau đó, mì udon và thịt được trộn đều với một số loại rau củ như cà rốt, dưa chuột và cải xoăn, tạo nên hương vị đa dạng và phong phú.\r\n\r\nGia vị của món ăn này là một sự kết hợp giữa tương ớt, tỏi, đường, dầu hạt cải và bột chiên giòn, tạo nên hương vị cay nồng, đậm đà và hấp dẫn. Sự kết hợp giữa mì udon giòn dai và thịt heo hoặc thịt gà giòn rụm, tạo nên một trải nghiệm ẩm thực thú vị và đầy thử thách cho thực khách.\r\n\r\nMì udon trộn cay là một món ăn ngon miệng và bổ dưỡng, giàu chất dinh dưỡng, chứa nhiều protein, vitamin và khoáng chất. Đặc biệt, món ăn này còn là lựa chọn tuyệt vời cho những người yêu thích món ăn cay, vì hương vị cay nồng của nó.', NULL, 59000, 'Udontroncay.png', 5),
('17', 'Mì Udon Xào', 'Mì udon xào là một món ăn được chế biến từ mì udon và các loại rau củ, thịt, hải sản tùy theo khẩu vị. Món ăn này thường được phục vụ như một món chính trong bữa ăn hoặc có thể là món ăn nhẹ vào bữa sáng hay bữa trưa.\r\n\r\nMì udon có hình dạng bán tròn và được chế biến từ bột mì, có độ dày vừa phải, giòn và dai. Khi nấu chín, mì udon có mùi thơm đặc trưng và hương vị ngọt.\r\n\r\nMón ăn này thường được chế biến bằng cách xào các loại rau củ như cà rốt, hành tây, cải thảo, nấm và thịt gà, heo hoặc hải sản như tôm, mực, cá hoặc cua. Các nguyên liệu này được chế biến và xào chín trước khi được trộn với mì udon.\r\n\r\nSau đó, các nguyên liệu được hỗn hợp với các gia vị như xì dầu, hạt nêm, dầu hạt cải và bột ngọt để tăng thêm hương vị và độ ngon của món ăn.\r\n\r\nMón mì udon xào có mùi thơm và hương vị đa dạng, từ hương vị đậm đà của thịt đến mùi thơm của các loại rau củ và hải sản. Kết hợp với độ giòn và dai của mì udon, món ăn này tạo nên một trải nghiệm ẩm thực đầy hấp dẫn cho người thưởng thức.\r\n\r\nMì udon xào là một món ăn giàu chất dinh dưỡng, chứa nhiều protein và các loại vitamin và khoáng chất cần thiết cho cơ thể. Đây là một món ăn đầy dinh dưỡng và vô cùng thú vị cho bữa ăn của bạn.', NULL, 79000, 'Udonxaothitheo.png', 5),
('18', 'Mì Udon Tôm ', 'Mì udon tôm là một món ăn phổ biến của ẩm thực Nhật Bản, được chế biến từ mì udon, tôm và rau củ tươi ngon. Mì udon là loại mì truyền thống của Nhật Bản, được chế biến từ bột mì và có hình dạng bán tròn với độ dày vừa phải, giòn và dai.\r\n\r\nMón ăn này thường được chế biến bằng cách nấu chín mì udon trong nước sôi, sau đó cho thêm tôm, cà rốt, bông cải xanh và hành tây để tạo ra một hỗn hợp đầy màu sắc. Tôm được chọn lựa tươi ngon, tươi tắn và được chế biến với các gia vị như tỏi, tiêu và xì dầu để tăng thêm hương vị cho món ăn.\r\n\r\nSau khi nấu chín, các nguyên liệu được trộn đều với mì udon để tạo ra một món ăn thơm ngon và bổ dưỡng. Mì udon tôm có hương vị đậm đà của tôm, hòa quyện với vị ngọt của rau củ và độ giòn của mì udon.\r\n\r\nMón ăn này thường được trang trí với một vài lát cà rốt và hành tây cắt nhỏ, tạo ra một hình ảnh bắt mắt và hấp dẫn cho người thưởng thức. Mì udon tôm là một món ăn giàu chất dinh dưỡng, chứa nhiều protein và các loại vitamin và khoáng chất cần thiết cho sức khỏe.\r\n\r\nVới hương vị thơm ngon và đa dạng, món ăn này là một sự lựa chọn tuyệt vời cho bữa ăn của bạn, đặc biệt là vào mùa đông hoặc ngày gió lạnh.', NULL, 85000, 'Udontom.png', 5),
('19', 'Maki Cá Hồi Cheese', 'Cuộn maki cá hồi cheese là một loại sushi truyền thống Nhật Bản với một sự kết hợp độc đáo giữa cá hồi tươi và phô mai kem. Một cuộn maki cá hồi cheese thường được làm từ rong biển nori, cơm sushi truyền thống được trộn với giấm và đường, cá hồi tươi và phô mai kem.\r\n\r\nKhi chế biến, miếng nori được đặt lên một tấm mặt phẳng, sau đó lớp cơm sushi được phân phối đều lên trên miếng nori. Cá hồi tươi được cắt thành dải mỏng và được đặt lên trên lớp cơm sushi. Tiếp theo, phô mai kem được thêm vào trên cùng của cá hồi tươi. Sau đó, cuộn sushi được cuộn chặt lại bằng cách sử dụng một tấm chắn cuộn sushi để đảm bảo rằng mọi thứ được giữ lại chặt chẽ và đều nhau.\r\n\r\nCuối cùng, cuộn maki cá hồi cheese được cắt thành các miếng nhỏ bằng một dao sắc. Mỗi miếng có kích thước khoảng 2-3 cm và được bày trên một đĩa hoặc khay, thường được phục vụ với một chút nước tương, wasabi và đồ gia vị khác để tăng thêm hương vị.\r\n\r\nVới hương vị béo ngậy của phô mai kem kết hợp cùng cá hồi tươi thơm ngon, cuộn maki cá hồi cheese là món ăn nhẹ và hấp dẫn, được yêu thích bởi những người yêu sushi trên khắp thế giới.', 'YES', 149000, 'makicahoiphomai.png', 2),
('20', 'Maki Cá Hồi Chiên', 'Cuộn maki cá hồi chiên là một món ăn Nhật Bản thơm ngon và hấp dẫn. Được làm từ cơm trộn với giấm và đường, được cuốn chặt trong một tấm rong biển, và bên trong là miếng cá hồi chiên giòn.\r\n\r\nMiếng cá hồi tươi được cắt thành hình sợi và được chiên giòn để tạo ra một vị giòn tan và thơm ngon. Sau đó, miếng cá hồi chiên được đặt vào một tấm rong biển, cùng với cơm trộn.\r\n\r\nSau khi đặt cá hồi lên tấm rong biển, cơm được cuốn chặt để tạo thành một cuộn dài và hẹp, sau đó được cắt thành các miếng vừa phải. Cuộn maki cá hồi chiên có màu trắng của cơm và màu nâu vàng của cá hồi chiên giòn.\r\n\r\nCuộn maki cá hồi chiên thường được ăn với nước tương và wasabi, và có thể được trang trí bằng các loại rau củ như rau mùi, rau thơm, hoặc hành tây. Với vị giòn tan của cá hồi chiên và hương vị đậm đà của cơm trộn với giấm, cuộn maki cá hồi chiên là một món ăn nhẹ nhàng và ngon miệng, thường được ăn kèm với một tách trà xanh nhẹ nhàng để tạo ra một bữa ăn Nhật Bản hoàn hảo.', NULL, 119000, 'makidacahoichien.png', 2),
('21', 'Maki Lươn Nhật', 'Maki lươn là một loại sushi truyền thống của Nhật Bản, được làm từ lươn tươi và các nguyên liệu khác như rong biển nori và cơm sushi. Maki lươn thường có hương vị đậm đà, thơm ngon và có màu sắc hấp dẫn.\r\n\r\nĐể chế biến maki lươn, đầu tiên, lươn được tách ra từ da và cắt thành từng miếng nhỏ để đảm bảo rằng chúng có thể được cuộn chặt trong maki. Sau đó, rong biển nori được đặt lên một tấm mặt phẳng, và một lượng nhỏ cơm sushi được phân phối đều lên trên miếng nori.\r\n\r\nTiếp theo, một lượng nhỏ lươn tươi được đặt lên cơm sushi, sau đó cuộn chặt bằng cách sử dụng một tấm chắn cuộn sushi để đảm bảo rằng mọi thứ được giữ lại chặt chẽ và đều nhau.\r\n\r\nCuối cùng, maki lươn được cắt thành các miếng nhỏ bằng một dao sắc. Mỗi miếng có kích thước khoảng 2-3 cm và được bày trên một đĩa hoặc khay. Nó thường được phục vụ với nước tương, wasabi và đồ gia vị khác để tăng thêm hương vị.\r\n\r\nVới hương vị đậm đà, thơm ngon của lươn kết hợp với cơm sushi và rong biển nori, maki lươn là món ăn nhẹ và hấp dẫn, được yêu thích bởi những người yêu sushi trên khắp thế giới.', 'YES', 159000, 'makiluon.png', 2),
('22', 'Maki Phô Mai', 'Cuộn maki phô mai là một món sushi truyền thống của Nhật Bản với hương vị béo ngậy và thơm ngon của phô mai. Một cuộn maki phô mai thường được làm từ rong biển nori, cơm sushi truyền thống được trộn với giấm và đường, và phô mai kem.\r\n\r\nKhi chế biến, miếng nori được đặt lên một tấm mặt phẳng, sau đó lớp cơm sushi được phân phối đều lên trên miếng nori. Sau đó, một lượng nhỏ phô mai kem được thêm vào trên cùng của lớp cơm sushi. Nếu muốn, bạn cũng có thể thêm thêm các nguyên liệu như tôm, cá hồi hoặc trứng cá hồi lên trên phô mai kem.\r\n\r\nSau đó, cuộn sushi được cuộn chặt lại bằng cách sử dụng một tấm chắn cuộn sushi để đảm bảo rằng mọi thứ được giữ lại chặt chẽ và đều nhau. Cuối cùng, cuộn maki phô mai được cắt thành các miếng nhỏ bằng một dao sắc.\r\n\r\nMỗi miếng có kích thước khoảng 2-3 cm và được bày trên một đĩa hoặc khay, thường được phục vụ với một chút nước tương, wasabi và đồ gia vị khác để tăng thêm hương vị.\r\n\r\nVới hương vị béo ngậy của phô mai kem, kết hợp với cơm sushi và rong biển nori, cuộn maki phô mai là một món ăn nhẹ và hấp dẫn, được yêu thích bởi những người yêu sushi trên khắp thế giới.', 'YES', 139000, 'makiphomaitrungtom.png', 2),
('23', 'Maki Tôm Tempura', 'Cuộn maki tôm tempura là một món ăn sushi truyền thống của Nhật Bản, được làm từ tôm tươi và các nguyên liệu khác như rong biển nori, cơm sushi và bột tempura. Cuộn maki tôm tempura có vị giòn tan, thơm ngon và rất hấp dẫn.\r\n\r\nĐể chế biến món sushi này, đầu tiên tôm được tẩm bột tempura và chiên giòn để tạo ra lớp vỏ giòn và vàng ươm. Sau đó, miếng rong biển nori được đặt lên một tấm mặt phẳng, và một lượng nhỏ cơm sushi được phân phối đều lên trên miếng nori.\r\n\r\nTiếp theo, tôm tempura đã chiên giòn được đặt lên cơm sushi, và cuộn sushi được cuộn chặt bằng cách sử dụng một tấm chắn cuộn sushi để đảm bảo rằng mọi thứ được giữ lại chặt chẽ và đều nhau.\r\n\r\nCuối cùng, cuộn maki tôm tempura được cắt thành các miếng nhỏ bằng một dao sắc. Mỗi miếng có kích thước khoảng 2-3 cm và được bày trên một đĩa hoặc khay. Nó thường được phục vụ với nước tương, wasabi và đồ gia vị khác để tăng thêm hương vị.\r\n\r\nVới vỏ giòn và vàng ươm của tôm tempura, kết hợp với cơm sushi và rong biển nori, cuộn maki tôm tempura là một món ăn nhẹ và hấp dẫn, được yêu thích bởi những người yêu sushi trên khắp thế giới.', 'YES', 149000, 'makitomtempura.png', 2),
('24', 'Maki Trứng Tôm', 'Cuộn maki trứng tôm là một món ăn sushi truyền thống của Nhật Bản, được làm từ trứng đánh nhuyễn, tôm tươi và các nguyên liệu khác như rong biển nori và cơm sushi. Cuộn maki trứng tôm có vị ngọt mát, thơm ngon và rất hấp dẫn.\r\n\r\nĐể chế biến món sushi này, đầu tiên, trứng được đánh nhuyễn và nướng để tạo ra một lớp trứng mỏng và xốp. Sau đó, tôm được chế biến và cắt thành từng sợi nhỏ.\r\n\r\nMiếng rong biển nori được đặt lên một tấm mặt phẳng, và một lượng nhỏ cơm sushi được phân phối đều lên trên miếng nori. Tiếp theo, một lớp trứng đánh nhuyễn được phân phối đều lên trên cơm sushi, và từng sợi tôm được đặt lên trên trứng.\r\n\r\nCuối cùng, cuộn sushi được cuộn chặt bằng cách sử dụng một tấm chắn cuộn sushi để đảm bảo rằng mọi thứ được giữ lại chặt chẽ và đều nhau. Cuộn maki trứng tôm được cắt thành các miếng nhỏ bằng một dao sắc. Mỗi miếng có kích thước khoảng 2-3 cm và được bày trên một đĩa hoặc khay.\r\n\r\nVới vị ngọt mát của trứng đánh nhuyễn và vị tươi ngon của tôm tươi, kết hợp với cơm sushi và rong biển nori, cuộn maki trứng tôm là một món ăn nhẹ và hấp dẫn, được yêu thích bởi những người yêu sushi trên khắp thế giới.', NULL, 119000, 'makitrungtom.png', 2),
('25', 'Dasani', 'Nước suôi Dasani là một sản phẩm nước uống được sản xuất và phân phối bởi công ty Coca-Cola. Nước suôi Dasani được sản xuất bằng cách sử dụng nước sạch, được lọc và tinh chế đến mức độ cao để đảm bảo rằng nước uống được cung cấp là một sản phẩm chất lượng cao.\r\n\r\nNước suôi Dasani có vị thanh mát, tươi mới và không chứa đường, màu nhân tạo, hoặc bất kỳ chất phụ gia nào khác. Điều này đảm bảo rằng nước uống không chỉ ngon miệng, mà còn là một sản phẩm an toàn và lành mạnh cho sức khỏe.\r\n\r\nNước suôi Dasani có thể được tìm thấy trong nhiều địa điểm bán lẻ, từ siêu thị, cửa hàng tiện lợi đến quán cà phê và nhà hàng. Nó được đóng trong các chai nhựa hoặc lon nhôm, dễ dàng mang theo khi di chuyển hoặc tham gia các hoạt động ngoài trời.\r\n\r\nVới chất lượng và vị ngon đặc trưng của mình, nước suôi Dasani đã trở thành một sản phẩm nước uống phổ biến trên khắp thế giới, đáp ứng nhu cầu của những người tìm kiếm một loại nước uống lành mạnh và ngon miệng.', NULL, 15000, 'dasani.png', 1),
('26', 'Coca Cola', 'Coca Cola là một loại đồ uống có gas được sản xuất và phân phối bởi công ty Coca Cola. Nó có màu nâu đặc trưng và có vị ngọt, thơm và có gas. Coca Cola là một trong những đồ uống phổ biến nhất trên toàn cầu và được bán ở hầu hết các quốc gia trên thế giới.\r\n\r\nCoca Cola được sản xuất bằng cách pha trộn các thành phần chính gồm nước, đường, acid phosphoric và chất tạo màu và vị. Mỗi thành phần được chọn kỹ lưỡng để đảm bảo chất lượng và vị ngon của sản phẩm.\r\n\r\nĐược đóng gói trong các lon, chai thủy tinh hoặc nhựa, Coca Cola là một loại đồ uống tiện lợi và dễ dàng sử dụng. Nó được bán rộng rãi tại các cửa hàng, siêu thị, nhà hàng và quán cà phê trên khắp thế giới.\r\n\r\nCoca Cola còn có một loạt các sản phẩm khác nhau, bao gồm Coca Cola Diet, Coca Cola Zero và Coca Cola Light, để đáp ứng nhu cầu khác nhau của người tiêu dùng. Nó cũng có thể được kết hợp với nhiều loại rượu và được sử dụng làm thành phần chính trong các cocktail và đồ uống khác.\r\n\r\nVới vị ngon đặc trưng của mình, Coca Cola đã trở thành một trong những thương hiệu đồ uống nổi tiếng và phổ biến nhất trên toàn thế giới, được yêu thích bởi hàng triệu người tiêu dùng trên khắp thế giới.', NULL, 18000, 'coca.png', 1),
('27', 'Sprite', 'Sprite là một loại đồ uống có gas được sản xuất và phân phối bởi công ty Coca-Cola. Nó có màu trắng đục đặc trưng và có vị chua, ngọt và có gas. Sprite là một trong những đồ uống không cồn phổ biến nhất trên toàn cầu và được bán ở hầu hết các quốc gia trên thế giới.\r\n\r\nSprite được sản xuất bằng cách pha trộn nước, đường, acid citric, chất tạo màu, chất bảo quản và hương liệu. Tất cả các thành phần được kết hợp với nhau để tạo nên vị chua mát, thanh khiết và tươi mới của Sprite.\r\n\r\nĐược đóng gói trong các chai thủy tinh hoặc nhựa, Sprite là một loại đồ uống tiện lợi và dễ dàng sử dụng. Nó được bán rộng rãi tại các cửa hàng, siêu thị, nhà hàng và quán cà phê trên khắp thế giới.\r\n\r\nSprite còn có các sản phẩm khác nhau, bao gồm Sprite Zero, Sprite Cranberry và Sprite Cherry, để đáp ứng nhu cầu khác nhau của người tiêu dùng. Nó cũng có thể được kết hợp với nhiều loại rượu và được sử dụng làm thành phần chính trong các cocktail và đồ uống khác.\r\n\r\nVới vị chua mát, thanh khiết và tươi mới của mình, Sprite đã trở thành một trong những thương hiệu đồ uống phổ biến và được yêu thích nhất trên toàn thế giới. Nó được xem là một lựa chọn đồ uống giải khát tuyệt vời cho mọi người, đặc biệt là trong những ngày nóng bức hoặc khi cần thêm năng lượng.', NULL, 18000, 'sprite.png', 1),
('28', 'Sting', 'Sting là một thương hiệu nước giải khát năng lượng được sản xuất bởi công ty đồ uống danh tiếng Red Bull GmbH. Nước giải khát này được đặc trưng bởi màu vàng và có hương vị độc đáo với một chút hơi cay, đắng và ngọt. Nó chứa caffeine, taurine và các thành phần năng lượng khác, được thiết kế để cung cấp năng lượng và sức mạnh cho cơ thể trong suốt quá trình hoạt động.\r\n\r\nSting được sản xuất dưới nhiều dạng và kích thước khác nhau, từ chai thủy tinh đơn giản đến lon nhôm tiện lợi và chai nhựa tái chế. Nó được bán rộng rãi tại các cửa hàng tiện lợi, siêu thị và quán cà phê trên khắp thế giới.\r\n\r\nVới thành phần năng lượng và hương vị đặc trưng, Sting đã trở thành một trong những loại nước giải khát được yêu thích nhất trên thế giới. Nó thường được sử dụng để cung cấp năng lượng và tăng cường khả năng tập trung cho người làm việc văn phòng, các vận động viên và người chơi thể thao. Tuy nhiên, do nồng độ caffeine và taurine có thể gây tác dụng phụ đối với sức khỏe, nên người tiêu dùng nên sử dụng Sting với một cách cẩn thận và hợp lý.', NULL, 18000, 'sting.png', 1),
('29', 'Fanta', 'Fanta là một thương hiệu nước giải khát có gas được sản xuất bởi công ty Coca-Cola. Nước giải khát này có màu sắc tươi sáng và hương vị trái cây đa dạng, như cam, chanh, dưa hấu, nho, dâu tây và nhiều loại trái cây khác.\r\n\r\nFanta được sản xuất dưới nhiều dạng và kích thước khác nhau, bao gồm chai thủy tinh, lon nhôm và chai nhựa. Nó có thể được tìm thấy tại các cửa hàng tiện lợi, siêu thị và quán cà phê trên khắp thế giới.\r\n\r\nVới hương vị trái cây đa dạng và màu sắc tươi sáng, Fanta đã trở thành một trong những loại nước giải khát được yêu thích nhất trên thế giới, đặc biệt là trong giới trẻ. Nó thường được sử dụng trong các buổi tiệc và sự kiện và là một lựa chọn phổ biến trong các nhà hàng, quán bar và quán cà phê.\r\n\r\nTuy nhiên, do Fanta chứa đường và các thành phần khác có thể gây hại cho sức khỏe nếu sử dụng quá mức, nên người tiêu dùng cần sử dụng Fanta một cách cẩn thận và hợp lý.', NULL, 18000, 'fanta.png', 1),
('30', 'Tiger', 'Tiger là một thương hiệu bia rất nổi tiếng, được sản xuất tại Việt Nam bởi Tập đoàn Bia - Rượu - Nước giải khát Việt Nam (Sabeco). Bia Tiger có màu vàng nhạt và hương vị đắng nhẹ, với một chút hương trái cây và hoa.\r\n\r\nTiger được sản xuất từ những nguyên liệu tốt nhất, bao gồm lúa mạch, nước và hoa bia. Quy trình sản xuất của Tiger được kiểm soát chặt chẽ để đảm bảo chất lượng tốt nhất. Bia Tiger có nồng độ cồn khoảng 5%, là một lựa chọn phổ biến trong các bữa tiệc và sự kiện.\r\n\r\nTiger có nhiều phiên bản khác nhau, bao gồm Tiger Crystal - một phiên bản bia nhẹ và mát lạnh, Tiger Black - phiên bản bia đen đặc biệt, và Tiger Radler - phiên bản bia hỗn hợp với nước ép trái cây, có hương vị tươi mát.\r\n\r\nTiger đã trở thành một trong những thương hiệu bia hàng đầu tại Việt Nam và trên thế giới, và được yêu thích bởi người tiêu dùng nhờ chất lượng tốt và hương vị độc đáo của nó.', NULL, 25000, 'tiger.png', 1),
('31', 'Rượu Sake', 'Rượu sake là một loại rượu truyền thống của Nhật Bản, được làm từ gạo nấu chín, nước và men. Sake có màu sắc trong suốt và hương vị đa dạng, từ nhẹ nhàng đến đậm đà, tùy thuộc vào quá trình sản xuất và loại men được sử dụng.\r\n\r\nQuá trình sản xuất rượu sake khá phức tạp, bao gồm việc nấu gạo, pha trộn với men, lên men và lên men thứ hai. Các bước này được thực hiện bằng cách sử dụng các phương pháp truyền thống và công nghệ hiện đại để đảm bảo rượu sake có chất lượng tốt và hương vị độc đáo.\r\n\r\nRượu sake có thể được uống nóng hoặc lạnh, tùy thuộc vào sở thích của người uống. Nó được uống trong các dịp đặc biệt, như lễ hội và các buổi tiệc cưới, và thường được uống trong các ly nhỏ được gọi là choko hoặc trong các ống tre nhỏ được gọi là sakazuki.\r\n\r\nRượu sake đã trở thành một biểu tượng của văn hóa Nhật Bản và được yêu thích trên khắp thế giới, nhờ vào hương vị độc đáo và sự đa dạng của nó. Tuy nhiên, do rượu sake có nồng độ cồn khá cao, người tiêu dùng cần sử dụng một cách cẩn thận và hợp lý.', NULL, 250000, 'sake.png', 1),
('32', 'Rượu Sochu', 'Rượu shochu là một loại rượu truyền thống của Nhật Bản, được làm từ khoai tây, lúa mì hoặc sắn. Rượu shochu có nồng độ cồn từ 25-40%, tùy thuộc vào loại nguyên liệu được sử dụng để sản xuất.\r\n\r\nQuá trình sản xuất rượu shochu bao gồm nấu cơm, lên men và ép nước từ nguyên liệu để thu được chất lỏng. Sau đó, chất lỏng sẽ được chưng cất bằng máy móc để tách ra các thành phần cần thiết. Quá trình này sẽ tạo ra một loại rượu tinh khiết và không có màu sắc, giống như rượu sake.\r\n\r\nRượu shochu có mùi thơm đặc trưng và vị đậm đà, độc đáo. Nó có thể được uống trực tiếp hoặc trộn với đá hoặc nước. Nó cũng có thể được sử dụng để pha chế các loại cocktail.\r\n\r\nRượu shochu là một phần quan trọng của văn hóa ẩm thực của Nhật Bản, thường được uống trong các dịp đặc biệt như các buổi tiệc và cuộc họp mặt. Nó cũng được yêu thích ở nhiều nơi trên thế giới như một loại rượu có hương vị độc đáo và sự đa dạng. Tuy nhiên, do nồng độ cồn khá cao, người tiêu dùng cần sử dụng một cách cẩn thận và hợp lý.', NULL, 200000, 'sochu.png', 1),
('33', 'Rượu Mơ Hoa Hồng', 'Rượu mơ hoa hồng là một loại rượu trái cây được làm từ trái mơ và hoa hồng. Khi uống, bạn sẽ cảm nhận được hương thơm ngọt ngào của hoa hồng, kết hợp với vị chua nhẹ và ngọt của trái mơ.\r\n\r\nRượu mơ hoa hồng có màu vàng nhạt đến màu hổ phách tùy thuộc vào cách làm của từng nhà sản xuất. Khi thưởng thức, bạn sẽ cảm nhận được vị ngọt ngào của trái mơ và hương thơm tinh tế của hoa hồng, tạo nên một cảm giác mượt mà và nhẹ nhàng trên đầu lưỡi.\r\n\r\nRượu mơ hoa hồng thường được uống trong các dịp đặc biệt hoặc làm quà tặng. Đây là một loại rượu trái cây đầy màu sắc và hương vị độc đáo, giúp tạo nên một không gian ấm cúng và lãng mạn cho bữa tiệc của bạn.', NULL, 230000, 'mohoahong.png', 1);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoankh`
--

CREATE TABLE `taikhoankh` (
  `SODT` int(10) NOT NULL,
  `MATKHAU` char(30) NOT NULL,
  `TENKH` varchar(50) NOT NULL,
  `DIACHI` varchar(100) NOT NULL,
  `EMAIL` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoankh`
--

INSERT INTO `taikhoankh` (`SODT`, `MATKHAU`, `TENKH`, `DIACHI`, `EMAIL`) VALUES
(1, '1', '1', '1', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD KEY `MADH` (`MADH`),
  ADD KEY `MAMON` (`MAMON`);

--
-- Indexes for table `danhgia`
--
ALTER TABLE `danhgia`
  ADD KEY `SODT` (`SODT`),
  ADD KEY `MAMON` (`MAMON`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`MADH`);

--
-- Indexes for table `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`MALOAI`);

--
-- Indexes for table `monan`
--
ALTER TABLE `monan`
  ADD PRIMARY KEY (`MAMON`),
  ADD KEY `MALOAI` (`MALOAI`);

--
-- Indexes for table `taikhoankh`
--
ALTER TABLE `taikhoankh`
  ADD PRIMARY KEY (`SODT`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `loai`
--
ALTER TABLE `loai`
  MODIFY `MALOAI` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
