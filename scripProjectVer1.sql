USE [dbSE160841]
GO
/****** Object:  Table [dbo].[tblChiTietHoaDon]    Script Date: 3/24/2023 12:13:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblChiTietHoaDon](
	[mahd] [nvarchar](50) NOT NULL,
	[masp] [nvarchar](5) NOT NULL,
	[soluong] [int] NULL,
	[dongia] [float] NULL,
	[khuyenmai] [float] NULL,
	[giatri] [float] NULL,
 CONSTRAINT [PK__tblChiTi__7A2100DE181D87EA] PRIMARY KEY CLUSTERED 
(
	[mahd] ASC,
	[masp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblDanhMuc]    Script Date: 3/24/2023 12:13:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblDanhMuc](
	[madm] [nvarchar](5) NOT NULL,
	[tendm] [nvarchar](50) NULL,
	[trangthai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[madm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblHoaDon]    Script Date: 3/24/2023 12:13:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblHoaDon](
	[mahd] [nvarchar](50) NOT NULL,
	[ngaydh] [datetime] NULL,
	[trangthaixuly] [int] NULL,
	[makh] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[mahd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblNhaCungCap]    Script Date: 3/24/2023 12:13:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblNhaCungCap](
	[mancc] [nvarchar](5) NOT NULL,
	[tenncc] [nvarchar](50) NULL,
	[diachi] [nvarchar](100) NULL,
	[trangthai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[mancc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblNhomTaiKhoan]    Script Date: 3/24/2023 12:13:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblNhomTaiKhoan](
	[nhomtk] [nvarchar](5) NOT NULL,
	[mota] [nvarchar](50) NULL,
	[trangthai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[nhomtk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblSanPham]    Script Date: 3/24/2023 12:13:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblSanPham](
	[masp] [nvarchar](5) NOT NULL,
	[tensp] [nvarchar](50) NULL,
	[mota] [nvarchar](250) NULL,
	[soluong] [int] NULL,
	[dongia] [float] NULL,
	[hinhanh] [nvarchar](100) NULL,
	[trangthai] [bit] NULL,
	[madm] [nvarchar](5) NULL,
	[mancc] [nvarchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[masp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblTaiKhoan]    Script Date: 3/24/2023 12:13:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTaiKhoan](
	[tentk] [nvarchar](10) NOT NULL,
	[matkhau] [nvarchar](50) NULL,
	[trangthai] [bit] NULL,
	[email] [nvarchar](50) NULL,
	[nhomtk] [nvarchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[tentk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblChiTietHoaDon] ([mahd], [masp], [soluong], [dongia], [khuyenmai], [giatri]) VALUES (N'HD1', N'001', 1, 2900000, 0, 1000)
GO
INSERT [dbo].[tblDanhMuc] ([madm], [tendm], [trangthai]) VALUES (N'1', N'Đồng Hồ 123', 0)
INSERT [dbo].[tblDanhMuc] ([madm], [tendm], [trangthai]) VALUES (N'2', N'Đông Hồ Nam', 1)
INSERT [dbo].[tblDanhMuc] ([madm], [tendm], [trangthai]) VALUES (N'3', N'Đồng Hồ Nữ', 0)
GO
INSERT [dbo].[tblHoaDon] ([mahd], [ngaydh], [trangthaixuly], [makh]) VALUES (N'HD1', CAST(N'2023-04-02T00:00:00.000' AS DateTime), 1, N'quang')
INSERT [dbo].[tblHoaDon] ([mahd], [ngaydh], [trangthaixuly], [makh]) VALUES (N'HD2', CAST(N'2023-12-12T00:00:00.000' AS DateTime), 2, N'quang')
GO
INSERT [dbo].[tblNhaCungCap] ([mancc], [tenncc], [diachi], [trangthai]) VALUES (N'CC1', N'Nguyễn Xuân Quang', N'Q1', 1)
INSERT [dbo].[tblNhaCungCap] ([mancc], [tenncc], [diachi], [trangthai]) VALUES (N'CC2', N'Đinh Văn Nơi', N'Q2', 1)
INSERT [dbo].[tblNhaCungCap] ([mancc], [tenncc], [diachi], [trangthai]) VALUES (N'CC3', N'Sơn Tùng MTP', N'Q3', 0)
GO
INSERT [dbo].[tblNhomTaiKhoan] ([nhomtk], [mota], [trangthai]) VALUES (N'admin', N'quan tri', 1)
INSERT [dbo].[tblNhomTaiKhoan] ([nhomtk], [mota], [trangthai]) VALUES (N'khach', N'vui ve', 1)
GO
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'001', N'Seiko ', N'Đẹp', 1000, 2900000, N'mau1', 1, N'1', N'CC1')
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'002', N'Citizen', N'Xinh', 1000, 4050000, N'mau2', 1, N'2', N'CC1')
GO
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'123', N'123', 1, N'hdwangg09@gmail.com', N'khach')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'admin', N'123456', 1, N'admin@gmail.com', N'admin')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'quang', N'123', 1, N'quang04@gmail.com', N'khach')
GO
ALTER TABLE [dbo].[tblChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_tblChiTietHoaDon_tblHoaDon] FOREIGN KEY([mahd])
REFERENCES [dbo].[tblHoaDon] ([mahd])
GO
ALTER TABLE [dbo].[tblChiTietHoaDon] CHECK CONSTRAINT [FK_tblChiTietHoaDon_tblHoaDon]
GO
ALTER TABLE [dbo].[tblChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_tblChiTietHoaDon_tblSanPham] FOREIGN KEY([masp])
REFERENCES [dbo].[tblSanPham] ([masp])
GO
ALTER TABLE [dbo].[tblChiTietHoaDon] CHECK CONSTRAINT [FK_tblChiTietHoaDon_tblSanPham]
GO
ALTER TABLE [dbo].[tblHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_tblHoaDon_tblTaiKhoan] FOREIGN KEY([makh])
REFERENCES [dbo].[tblTaiKhoan] ([tentk])
GO
ALTER TABLE [dbo].[tblHoaDon] CHECK CONSTRAINT [FK_tblHoaDon_tblTaiKhoan]
GO
ALTER TABLE [dbo].[tblSanPham]  WITH CHECK ADD  CONSTRAINT [FK_tblSanPham_tblDanhMuc] FOREIGN KEY([madm])
REFERENCES [dbo].[tblDanhMuc] ([madm])
GO
ALTER TABLE [dbo].[tblSanPham] CHECK CONSTRAINT [FK_tblSanPham_tblDanhMuc]
GO
ALTER TABLE [dbo].[tblSanPham]  WITH CHECK ADD  CONSTRAINT [FK_tblSanPham_tblNhaCungCap] FOREIGN KEY([mancc])
REFERENCES [dbo].[tblNhaCungCap] ([mancc])
GO
ALTER TABLE [dbo].[tblSanPham] CHECK CONSTRAINT [FK_tblSanPham_tblNhaCungCap]
GO
ALTER TABLE [dbo].[tblTaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_tblTaiKhoan_tblNhomTaiKhoan] FOREIGN KEY([nhomtk])
REFERENCES [dbo].[tblNhomTaiKhoan] ([nhomtk])
GO
ALTER TABLE [dbo].[tblTaiKhoan] CHECK CONSTRAINT [FK_tblTaiKhoan_tblNhomTaiKhoan]
GO
