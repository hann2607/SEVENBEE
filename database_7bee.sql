
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = '7bee')
BEGIN
   CREATE DATABASE 7bee;
END;
use [7bee]

go

CREATE TABLE NGUOIDUNG (
   SDT varchar (10) Primary Key not null,
   HoTen nvarchar (50) not null,
   Email varchar (50) not null,
   MatKhau varchar (30) not null,
   NgaySinh datetime ,
   DiaChi nvarchar (255),
   HinhAnh varchar (255),
   VaiTro bit not null,
   isActive bit not null
);

CREATE TABLE PARTNER (
   SDT varchar (10) Primary Key not null,
   Shop_TenShop nvarchar (50) not null UNIQUE ,
   Email varchar(50) not null, 
   NgayDK_Shop datetime not null,
   HinhAnh varchar(255),
   MatKhau varchar(30) not null,
   MoTa_Shop varchar(255) ,
   isActive bit not null
);
--drop table TINTUC
CREATE TABLE TINTUC (
   TT_MA varchar(25) Primary Key not null,
  Shop_TenShop nvarchar (50) not null,
   TT_NgayDang datetime not null,
   TT_Tags nvarchar (50),
   TT_HinhAnh varchar(255),
   TT_NoiDung_Title nvarchar (255) not null,
   TT_NoiDung_Body nvarchar (max)
);

CREATE TABLE DANHGIA_TINTUC (
   DG_TT_MA varchar(25) Primary Key,
   TT_MA varchar(25) not null,
   SDT varchar(10) not null,
   DG_TT_NoiDung nvarchar (255)
);

CREATE TABLE DONHANG (
   DH_MA varchar(25) Primary Key,
   SP_MA varchar(25) not null,
   HoTen nvarchar(50) not null,
   SoLuong int not null,
   Dongia money not null,
   Shop_TenShop nvarchar(50) not null,
   GhiChu nvarchar (255),
   SDT varchar(10) not null,
   DH_DiaChi nvarchar (255) not null
);

CREATE TABLE SANPHAM (
    SP_MA varchar(25) PRIMARY KEY,
    Shop_TenShop nvarchar(50) not null,
    LoaiSP_MA varchar(25) not null,
    SP_Ngaydang datetime not null,
    SP_TenSP nvarchar (255) not null,
    SP_Gia money not null
);

CREATE TABLE LOAISP (
  LoaiSP_MA varchar(25) PRIMARY KEY,
  LoaiSP_Ten nvarchar(255) not null
);

CREATE TABLE CHITIET_SANPHAM (
CTSP_MA varchar(25) PRIMARY KEY,
SP_MA varchar(25) not null,
CTSP_MoTa nvarchar(255) not null,
KichThuoc nvarchar(50),
CTSP_LuotMua int,
CTSP_Mau nvarchar(50),
CTSP_HinhAnh varchar(255),
CTSP_SoLuong int not null
);
--DROP TABLE LICHSU
CREATE TABLE LICHSU (
LS_MA varchar(25) PRIMARY KEY,
DH_MA varchar(25) not null,
SP_TenSP nvarchar (255) not null,
TongTien money not null,
HoTen nvarchar (50) not null,
LS_NgayMua datetime not null
);

CREATE TABLE DANHGIA_SANPHAM (
  DG_SP_MA varchar(25) PRIMARY KEY,
  LS_MA varchar(25) not null,
  SP_MA varchar(25) not null,
  HoTen nvarchar(50) not null,
  DG_SP_Like bit ,
  DG_SP_BinhLuan nvarchar(255),
  DG_SP_NgayDanhGia datetime not null
);


--khoa ngoai 
 
-- TINTUC 
ALTER TABLE TINTUC
ADD CONSTRAINT FK_TINTUC_PARTNER FOREIGN KEY (Shop_TenShop) REFERENCES PARTNER(Shop_TenShop);

--DANHGIA_TINTUC
	
ALTER TABLE DANHGIA_TINTUC ADD CONSTRAINT FK_DANHGIA_TINTUC_TINTUC FOREIGN KEY (TT_MA) REFERENCES TINTUC(TT_MA);

ALTER TABLE DANHGIA_TINTUC ADD CONSTRAINT FK_DANHGIA_TINTUC_NGUOIDUNG FOREIGN KEY (SDT) REFERENCES NGUOIDUNG(SDT);

-- SANPHAM

ALTER TABLE SANPHAM
ADD CONSTRAINT FK_SANPHAM_LOAISP
FOREIGN KEY (LoaiSP_MA) REFERENCES LOAISP(LoaiSP_MA);

ALTER TABLE SANPHAM
ADD CONSTRAINT FK_SANPHAM_PARTNER
FOREIGN KEY (Shop_Tenshop) REFERENCES PARTNER(Shop_TenShop);

-- CHITIET_SANPHAM

ALTER TABLE CHITIET_SANPHAM
ADD CONSTRAINT FK_CHITIET_SANPHAM_SANPHAM
FOREIGN KEY (SP_MA) REFERENCES SANPHAM(SP_MA);


-- DON HANG 

ALTER TABLE DONHANG
ADD CONSTRAINT FK_DONHANG_SANPHAM
FOREIGN KEY (SP_MA) REFERENCES SANPHAM(SP_MA);

ALTER TABLE DONHANG
ADD CONSTRAINT FK_DONHANG_NGUOIDUNG
FOREIGN KEY (SDT) REFERENCES NGUOIDUNG(SDT);

-- LICHSU 
ALTER TABLE LICHSU
ADD CONSTRAINT FK_LICHSU_DONHANG
FOREIGN KEY (DH_MA) REFERENCES DONHANG(DH_MA);

-- DANHGIA_SP 

ALTER TABLE DANHGIA_SANPHAM
ADD CONSTRAINT FK_DANHGIA_SANPHAM_LICHSU
FOREIGN KEY (LS_MA)
REFERENCES LICHSU(LS_MA);


-- DỮ LIÊU MẪU 

-- Dữ liệu bảng Người Dùng
INSERT INTO NGUOIDUNG VALUES
	(0363278964,N'Nguyễn Văn Lộc','loc12@gmail.com','abc123',1978-05-22, N'quận tân bình, TP.HCM', null,0,1 ),
	(0363438943,N'Nguyễn Trần Minh Hải','Hai123@gmail.com','abc1234',1975-07-28, N'quận 1, TP.HCM', null,1,0 ),
	(0339645424,N'Nguyễn Thị Hoa','Hoa12@gmail.com','abc1235',1986-03-28, N'quận 2, TP.HCM', null,01,1 ),
	(0327544266,N'Nguyễn Kiều Trang','Trang12@gmail.com','ab123',2001-02-22, N'quận 3, TP.HCM', null,1,1 ),
	(0327884256,N'Trần Mạnh Hùng','hung12@gmail.com','ac123',1978-09-27, N'quận 4, TP.HCM', null,01,1 ),
	(0395632154,N'Lê Hoàng Bảo','bao12@gmail.com','bc123',1987-05-22, N'quận tân bình, TP.HCM', null,1,1 ),
	(0375586332,N'Lại Hoàng Long','long124@gmail.com','abc23',1990-10-22, N'quận gò vấp, TP.HCM', null,1,1 ),
	(0954322656,N'Bùi Hoàng Việt','viet12@gmail.com','abc3',1978-05-22, N'quận Bình tân, TP.HCM', null,1,1 ),
	(0953432145,N'Nguyễn Thị Lệ','le12@gmail.com','ac13',1978-09-15, N'quận tân bình, TP.HCM', null,1,1 ),
	(0964532167,N'Nguyễn Kim Hùng','Hung124@gmail.com','ac13',1978-05-22, N'quận 7, TP.HCM', null,1,1 )


-- Dữ liệu bảng Shop
INSERT INTO PARTNER VALUES
	(0244556366, N'Hải Computer','Haishop134@gmail.com',2014-07-23,null,'hai123','Bán các loại máy và thiết bị điện tử',1),
	(0357674867, N'Việt nam food','food1414@gmail.com',2015-09-23,null,'food123','Bán các loại thực phẩm đặc sản vùng miền',1),
	(0124545678, N'Hải âu','Haiaushop134@gmail.com',2018-04-28,null,'hai123','Shop thời trang uy tính',1),
	(0545325675, N'Kim long Computer','longshop134@gmail.com',2014-07-23,null,'hai123','Bán các loại máy và thiết bị điện tử',0),
	(0342655236, N'Sasin quán','Sasin134@gmail.com',2014-07-23,null,'hai123','Mì cay là chân ái',1),
	(0643534678, N'Ba Anh Em','AEshop134@gmail.com',2014-12-06,null,'hai123','Bán sỉ lẻ áo quần cũ',1)

-- Dữ liệu bảng TIN TỨC
INSERT INTO TINTUC VALUES
	('TT05', N'Hải Computer',2019-09-23,null,null,N'Săn sale máy tính lên tới 50%',null),
	('TT04', N'Hải Computer',2020-09-15,null,null,N'Săn sale Phụ Kiện điện tử lên tới 50%',null),
	('TT03', N'Việt nam food',2022-11-11,null,null,N'Combo 1 ngàn và ưu đãi thức ăn',null),
	('TT02', N'Hải âu',2022-12-23,null,null,N'Săn sale Áo thể thao nam lên tới 50%',null),
	('TT01', N'Ba Anh Em',2021-05-13,null,null,N'Săn sale Combo set đồ cho cặp đôi lên tới 50%',null),
	('TT00', N'Sasin quán',2023-02-23,null,null,N'Combo mì cay hương vị mới',null)

-- Dữ liệu bảng Đánh Giá tin tức
INSERT INTO DANHGIA_TINTUC VALUES
	('DGTT05', 'TT05',0327884256,null),
	('DGTT06', 'TT04',0964532167,null),
	('DGTT07', 'TT03',0327884256,null),
	('DGTT08', 'TT02',0954322656,null),
	('DGTT09', 'TT01',0363278964,null),
	('DGTT10', 'TT05',0953432145,null),
	('DGTT11', 'TT01',0327884256,null)

-- Dữ liệu bảng ĐƠN HÀNG
INSERT INTO DONHANG VALUES
	('DH001', 'SP001',N'Nguyễn Trần Minh Hải',12,1680000,N'Hải Computer',null,0363438943,N'quận 1, TP.HCM'),
	('DH002', 'SP002',N'Lê Hoàng Bảo',2,1680000,N'Hải Computer',null,0395632154,N'quận tân bình, TP.HCM'),
	('DH003', 'SP007',N'Nguyễn Thị Lệ',1,680000,N'Ba Anh Em',null,0953432145,N'quận tân bình, TP.HCM'),
	('DH004', 'SP004',N'Nguyễn Kiều Trang',5,256000,N'Việt nam food',null,0327544266,N'quận 3, TP.HCM'),
	('DH005', 'SP005',N'Nguyễn Trần Minh Hải',5,168000,N'Việt nam food',null,0363438943,N'quận 1, TP.HCM')

-- Dữ liệu Bảng Lịch Sử
INSERT INTO LICHSU VALUES
	('LS001', 'DH001',N'Ổ Đĩa SSD Gen4 500gb',20160000,N'Nguyễn Trần Minh Hải',2023-02-14),
	('LS002', 'DH005',N'Mỳ ý sốt bò hảo hạn',840000,N'Nguyễn Trần Minh Hải',2023-02-13),
	('LS003', 'DH002',N'Ổ Đĩa SSD Gen3 500gb',3360000,N'Lê Hoàng Bảo',2023-02-13),
	('LS004', 'DH003',N'Túi chéo nữ hoàng kim',680000,N'Nguyễn Thị Lệ',2023-02-13),
	('LS005', 'DH004',N'Combo Gà cay + nước ngọt tự chọn',1280000,N'Nguyễn Kiều Trang',2023-02-13)

-- Dữ Liệu bảng đánh giá sản phẩm
INSERT INTO DANHGIA_SANPHAM VALUES
	('DGSP001', 'LS001','SP001',N'Nguyễn Trần Minh Hải',1,N'tốt, đẹp',2023-02-14),
	('DGSP002', 'LS002','SP005',N'Nguyễn Trần Minh Hải',0,N'đồ ăn không ngon lắm',2023-02-14),
	('DGSP003', 'LS003','SP002',N'Lê Hoàng Bảo',1,N'tốt, đẹp',2023-02-14),
	('DGSP004', 'LS004','SP007',N'Nguyễn Thị Lệ',1,N'tốt, đẹp',2023-02-14),
	('DGSP005', 'LS005','SP004',N'Nguyễn Kiều Trang',1,N'tốt, đẹp',2023-02-14)

-- Dữ liệu sản phẩm
INSERT INTO SANPHAM VALUES
	('SP001',N'Hải Computer','LSP003',2021-08-25,N'Ổ Đĩa SSD Gen4 500gb',1680000),
	('SP002',N'Hải Computer','LSP003',2021-08-25,N'Ổ Đĩa SSD Gen3 500gb',1480000),
	('SP003',N'Hải Computer','LSP003',2021-08-25,N'Ổ Đĩa SSD Gen4 250gb',1250000),
	('SP004',N'Việt nam food','LSP001',2022-11-25,N'Combo Gà cay + nước ngọt tự chọn',256000),
	('SP005',N'Việt nam food','LSP001',2021-08-25,N'Mỳ ý sốt bò hảo hạn',168000),
	('SP006',N'Ba Anh Em','LSP002',2023-02-25,N'Áo thun nam co dãn',180000),
	('SP007',N'Ba Anh Em','LSP002',2023-02-25,N'Túi chéo nữ hoàng kim',680000),
	('SP008',N'Ba Anh Em','LSP002',2023-02-25,N'Giày adidas nam siêu chất',1575000),
	('SP009',N'Kim long Computer','LSP003',2023-01-25,N'Màn hình Samsung siêu tràn viền',5680000)
	

-- Dữ liệu bảng chi tiết sản phẩm
INSERT INTO CHITIET_SANPHAM VALUES
	('CTSP001','SP001',N'Ổ Đĩa SSD Gen4 500gb','500gb',2300,N'Xanh',null,24),
	('CTSP002','SP002',N'Ổ Đĩa SSD Gen3 500gb','500gb',56353,N'Xanh',null,512),
	('CTSP003','SP003',N'Ổ Đĩa SSD Gen4 250gb','250gb',34376,N'Xanh',null,532),
	('CTSP004','SP004',N'Combo Gà cay + nước ngọt tự chọn','M, L, S',2300,null,null,425),
	('CTSP005','SP005',N'Mỳ ý sốt bò hảo hạn','S, M, L',14534,null,null,106),
	('CTSP006','SP006',N'Áo thun nam co dãn','XL, M, S',2300,N'Xanh',null,24),
	('CTSP007','SP007',N'Túi chéo nữ hoàng kim','M, S',2300,N'Xanh',null,24),
	('CTSP008','SP008',N'Giày adidas nam siêu chất','36,37,38,39,40,41',2300,N'Xanh',null,24),
	('CTSP009','SP009',N'Màn hình Samsung siêu tràn viền','52 inch',2300,N'Xanh',null,24)

-- Dữ liệu bảng Loại SP
INSERT INTO LOAISP VALUES
	('LSP001',N'Đồ Ăn'),
	('LSP002',N'Thời Trang'),
	('LSP003',N'Điện Tử')
	


-- Sp dùng sẵn
-- Sp Tìm người dùng 
create proc sp_TimND
	@sdt varchar(10)
as
begin
	 select * from NGUOIDUNG where SDT = @sdt
end

exec sp_TimND 0395632154 ;
go

-- Sp tìm SP khi nhập tên shop
create proc sp_TimSPtheoShop
	@Shop_tenshop nvarchar(50)
as
begin
	 select PARTNER.Shop_TenShop, SANPHAM.SP_TenSP  
	 from PARTNER  inner join SANPHAM on PARTNER.Shop_TenShop = SANPHAM.Shop_TenShop where PARTNER.Shop_TenShop = @Shop_tenshop
end

exec sp_TimSPtheoShop N'Hải Computer' ;
go

-- Trigger thêm sản phẩm
Create trigger tr_insND  on NGUOIDUNG for insert 
as
begin
	if (select SDT from inserted) = 10
	begin 
		print N'SDT phải là 10 số'
		rollback transaction
	end
end


