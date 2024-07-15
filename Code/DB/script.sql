USE [master]
GO
/****** Object:  Database [JewelrySystemDB]    Script Date: 7/12/2024 12:50:44 AM ******/
CREATE DATABASE [JewelrySystemDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'JewelrySystemDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\JewelrySystemDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'JewelrySystemDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\JewelrySystemDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [JewelrySystemDB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [JewelrySystemDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [JewelrySystemDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [JewelrySystemDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [JewelrySystemDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [JewelrySystemDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET  ENABLE_BROKER 
GO
ALTER DATABASE [JewelrySystemDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [JewelrySystemDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [JewelrySystemDB] SET  MULTI_USER 
GO
ALTER DATABASE [JewelrySystemDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [JewelrySystemDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [JewelrySystemDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [JewelrySystemDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [JewelrySystemDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [JewelrySystemDB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [JewelrySystemDB] SET QUERY_STORE = OFF
GO
USE [JewelrySystemDB]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Accounts](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[Password] [varchar](30) NOT NULL,
	[Phone] [varchar](20) NULL,
	[Deposit] [money] NULL,
	[Address] [nvarchar](100) NULL,
	[Role] [varchar](20) NULL,
	[Status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [varchar](20) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Gemstones]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gemstones](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[GemstoneCost] [money] NULL,
	[Status] [bit] NULL,
	[Jewelryid] [int] NULL,
	[Image] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Jewelries]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Jewelries](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Cost] [money] NULL,
	[Quantity] [int] NULL,
	[Status] [bit] NULL,
	[ChargeId] [int] NULL,
	[QuotationId] [int] NULL,
	[WarehouseId] [int] NULL,
	[SubCateId] [varchar](20) NULL,
	[Image] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[JewelryMakingCharges]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JewelryMakingCharges](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Price] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[JewelryMetals]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JewelryMetals](
	[jewelryid] [int] NULL,
	[metalpriceid] [int] NULL,
	[Weight] [decimal](10, 2) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[loyalty_cards]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[loyalty_cards](
	[card_id] [int] IDENTITY(1,1) NOT NULL,
	[acc_id] [int] NULL,
	[card_name] [varchar](255) NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[card_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoyaltyCards]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoyaltyCards](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Status] [bit] NULL,
	[AccId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Messages]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Messages](
	[Messageid] [int] IDENTITY(1,1) NOT NULL,
	[Message] [nvarchar](max) NULL,
	[Image] [varbinary](max) NULL,
	[Timestamp] [datetime] NOT NULL,
	[IsRead] [bit] NULL,
	[Accid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Messageid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[Orderdetailid] [int] IDENTITY(1,1) NOT NULL,
	[Quantity] [int] NULL,
	[Createdate] [date] NULL,
	[Detailstatus] [nvarchar](50) NULL,
	[Jewelryid] [int] NULL,
	[Orderid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Orderdetailid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Orderdate] [date] NULL,
	[Orderstatus] [nvarchar](50) NULL,
	[Status] [bit] NULL,
	[Accid] [int] NULL,
	[Shippingid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quotations]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quotations](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Totalprice] [money] NULL,
	[Discount] [decimal](10, 2) NULL,
	[Quotationstatus] [nvarchar](100) NULL,
	[Status] [bit] NULL,
	[Accid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shippings]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shippings](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SpotMetalPrices]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SpotMetalPrices](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Metaltype] [nvarchar](20) NOT NULL,
	[Spotprice] [money] NULL,
	[Daterecorded] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SubCategories]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SubCategories](
	[Id] [varchar](20) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Status] [bit] NULL,
	[Cateid] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Warehouses]    Script Date: 7/12/2024 12:50:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Warehouses](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Location] [nvarchar](100) NULL,
	[Limitamount] [int] NULL,
	[Status] [bit] NULL,
	[Name] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Accounts] ON 

INSERT [dbo].[Accounts] ([Id], [Name], [Email], [Password], [Phone], [Deposit], [Address], [Role], [Status]) VALUES (1, N'Ngô Tấn Lợi', N'Loint@gmail.com', N'123', N'09123', 10.0000, N'135 NTD', N'AD', 1)
INSERT [dbo].[Accounts] ([Id], [Name], [Email], [Password], [Phone], [Deposit], [Address], [Role], [Status]) VALUES (2, N'Ðinh Quốc Huy', N'Huydq@gmail.com', N'123', N'0123', 90.0000, N'133NT', N'MN', 1)
INSERT [dbo].[Accounts] ([Id], [Name], [Email], [Password], [Phone], [Deposit], [Address], [Role], [Status]) VALUES (3, N'Hacker', N'hacker@gmail.com', N'123', N'0321', 10.0000, N'130NTD', N'US', 3)
INSERT [dbo].[Accounts] ([Id], [Name], [Email], [Password], [Phone], [Deposit], [Address], [Role], [Status]) VALUES (4, N'Ngô Thế An', N'Annt@gmail.com', N'123', NULL, NULL, NULL, N'US', 2)
INSERT [dbo].[Accounts] ([Id], [Name], [Email], [Password], [Phone], [Deposit], [Address], [Role], [Status]) VALUES (5, N'Nguyễn Danh Minh', N'Minhnd@gmail.com', N'123', NULL, NULL, NULL, N'SS', 1)
INSERT [dbo].[Accounts] ([Id], [Name], [Email], [Password], [Phone], [Deposit], [Address], [Role], [Status]) VALUES (6, N'Lại Ðức Hùng', N'Hungld@gmail.com', N'123', NULL, NULL, NULL, N'DS', 1)
INSERT [dbo].[Accounts] ([Id], [Name], [Email], [Password], [Phone], [Deposit], [Address], [Role], [Status]) VALUES (7, N'Lê Thị Thu Phượng', N'Phuongltt@gmail.com', N'123', NULL, NULL, NULL, N'PS', 1)
INSERT [dbo].[Accounts] ([Id], [Name], [Email], [Password], [Phone], [Deposit], [Address], [Role], [Status]) VALUES (8, N'loi', N'Loint123@gmail.com', N'123', N'12345', 10.0000, N'137 NTD', N'US', 1)
SET IDENTITY_INSERT [dbo].[Accounts] OFF
GO
INSERT [dbo].[Categories] ([Id], [Name], [Status]) VALUES (N'J001', N'Jewelry', 1)
INSERT [dbo].[Categories] ([Id], [Name], [Status]) VALUES (N'M001', N'Mens', 1)
INSERT [dbo].[Categories] ([Id], [Name], [Status]) VALUES (N'P001', N'Jewelry Processing', 1)
INSERT [dbo].[Categories] ([Id], [Name], [Status]) VALUES (N'W001', N'Womens', 1)
GO
SET IDENTITY_INSERT [dbo].[Jewelries] ON 

INSERT [dbo].[Jewelries] ([Id], [Name], [Cost], [Quantity], [Status], [ChargeId], [QuotationId], [WarehouseId], [SubCateId], [Image]) VALUES (1, N'Nhan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Jewelries] OFF
GO
SET IDENTITY_INSERT [dbo].[JewelryMakingCharges] ON 

INSERT [dbo].[JewelryMakingCharges] ([Id], [Name], [Price]) VALUES (1, N'Gold Ring Making', 20.0000)
INSERT [dbo].[JewelryMakingCharges] ([Id], [Name], [Price]) VALUES (2, N'Silver Ring Making', 10.0000)
INSERT [dbo].[JewelryMakingCharges] ([Id], [Name], [Price]) VALUES (3, N'Gold BraceLet Making', 25.0000)
INSERT [dbo].[JewelryMakingCharges] ([Id], [Name], [Price]) VALUES (4, N'Silver BraceLet Making', 12.5000)
INSERT [dbo].[JewelryMakingCharges] ([Id], [Name], [Price]) VALUES (5, N'Gold NeckLace Making', 22.0000)
INSERT [dbo].[JewelryMakingCharges] ([Id], [Name], [Price]) VALUES (6, N'Silver NackLace Making', 11.0000)
SET IDENTITY_INSERT [dbo].[JewelryMakingCharges] OFF
GO
SET IDENTITY_INSERT [dbo].[SpotMetalPrices] ON 

INSERT [dbo].[SpotMetalPrices] ([Id], [Metaltype], [Spotprice], [Daterecorded]) VALUES (1, N'Gold', 307.9200, CAST(N'1900-01-01T00:00:00.000' AS DateTime))
INSERT [dbo].[SpotMetalPrices] ([Id], [Metaltype], [Spotprice], [Daterecorded]) VALUES (2, N'Silver', 0.9460, CAST(N'1900-01-01T00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[SpotMetalPrices] OFF
GO
INSERT [dbo].[SubCategories] ([Id], [Name], [Status], [Cateid]) VALUES (N'B001', N'BraceLet', 1, N'M001')
INSERT [dbo].[SubCategories] ([Id], [Name], [Status], [Cateid]) VALUES (N'B002', N'BraceLet', 1, N'W001')
INSERT [dbo].[SubCategories] ([Id], [Name], [Status], [Cateid]) VALUES (N'N001', N'NeckLace', 1, N'M001')
INSERT [dbo].[SubCategories] ([Id], [Name], [Status], [Cateid]) VALUES (N'N002', N'NeckLace', 1, N'W001')
INSERT [dbo].[SubCategories] ([Id], [Name], [Status], [Cateid]) VALUES (N'R001', N'Ring', 1, N'M001')
INSERT [dbo].[SubCategories] ([Id], [Name], [Status], [Cateid]) VALUES (N'R002', N'Ring', 1, N'W001')
GO
SET IDENTITY_INSERT [dbo].[Warehouses] ON 

INSERT [dbo].[Warehouses] ([Id], [Location], [Limitamount], [Status], [Name]) VALUES (1, N'Bình Tâ', 2000, 1, N'NULL')
INSERT [dbo].[Warehouses] ([Id], [Location], [Limitamount], [Status], [Name]) VALUES (2, N'Bình Tân', 1500, 1, NULL)
INSERT [dbo].[Warehouses] ([Id], [Location], [Limitamount], [Status], [Name]) VALUES (3, N'Bình Tân', 5000, 1, NULL)
INSERT [dbo].[Warehouses] ([Id], [Location], [Limitamount], [Status], [Name]) VALUES (4, N'Bình Tân', 4000, 1, NULL)
SET IDENTITY_INSERT [dbo].[Warehouses] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Accounts__A9D1053472AEC109]    Script Date: 7/12/2024 12:50:44 AM ******/
ALTER TABLE [dbo].[Accounts] ADD UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [UQ__LoyaltyC__91CBC37955D2189D]    Script Date: 7/12/2024 12:50:44 AM ******/
ALTER TABLE [dbo].[LoyaltyCards] ADD UNIQUE NONCLUSTERED 
(
	[AccId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [UQ__Messages__91CBC3791B78C6C6]    Script Date: 7/12/2024 12:50:44 AM ******/
ALTER TABLE [dbo].[Messages] ADD UNIQUE NONCLUSTERED 
(
	[Accid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Messages] ADD  DEFAULT (getdate()) FOR [Timestamp]
GO
ALTER TABLE [dbo].[Gemstones]  WITH CHECK ADD FOREIGN KEY([Jewelryid])
REFERENCES [dbo].[Jewelries] ([Id])
GO
ALTER TABLE [dbo].[Jewelries]  WITH CHECK ADD FOREIGN KEY([ChargeId])
REFERENCES [dbo].[JewelryMakingCharges] ([Id])
GO
ALTER TABLE [dbo].[Jewelries]  WITH CHECK ADD FOREIGN KEY([QuotationId])
REFERENCES [dbo].[Quotations] ([Id])
GO
ALTER TABLE [dbo].[Jewelries]  WITH CHECK ADD FOREIGN KEY([SubCateId])
REFERENCES [dbo].[SubCategories] ([Id])
GO
ALTER TABLE [dbo].[Jewelries]  WITH CHECK ADD FOREIGN KEY([WarehouseId])
REFERENCES [dbo].[Warehouses] ([Id])
GO
ALTER TABLE [dbo].[JewelryMetals]  WITH CHECK ADD FOREIGN KEY([jewelryid])
REFERENCES [dbo].[Jewelries] ([Id])
GO
ALTER TABLE [dbo].[JewelryMetals]  WITH CHECK ADD FOREIGN KEY([metalpriceid])
REFERENCES [dbo].[SpotMetalPrices] ([Id])
GO
ALTER TABLE [dbo].[LoyaltyCards]  WITH CHECK ADD FOREIGN KEY([AccId])
REFERENCES [dbo].[Accounts] ([Id])
GO
ALTER TABLE [dbo].[Messages]  WITH CHECK ADD FOREIGN KEY([Accid])
REFERENCES [dbo].[Accounts] ([Id])
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([Jewelryid])
REFERENCES [dbo].[Jewelries] ([Id])
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([Orderid])
REFERENCES [dbo].[Orders] ([Id])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([Accid])
REFERENCES [dbo].[Accounts] ([Id])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([Shippingid])
REFERENCES [dbo].[Shippings] ([Id])
GO
ALTER TABLE [dbo].[Quotations]  WITH CHECK ADD FOREIGN KEY([Accid])
REFERENCES [dbo].[Accounts] ([Id])
GO
ALTER TABLE [dbo].[SubCategories]  WITH CHECK ADD FOREIGN KEY([Cateid])
REFERENCES [dbo].[Categories] ([Id])
GO
USE [master]
GO
ALTER DATABASE [JewelrySystemDB] SET  READ_WRITE 
GO
