CREATE DATABASE SheepShop
GO
USE SheepShop
GO

CREATE TABLE product(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	code varchar(30) ,
	name nvarchar(50),
	status	int,
)
GO
CREATE TABLE image(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	code varchar(255) ,
	product_id UNIQUEIDENTIFIER REFERENCES product(id),
)
GO
CREATE TABLE category(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	name varchar(50),
	description nvarchar(max) ,
	status	int,
)
GO
CREATE TABLE brand(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	name varchar(50),
	description nvarchar(max) ,
	status	int,
)
GO
CREATE TABLE hand_style(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	name varchar(50),
	description nvarchar(max) ,
	status	int,
)
GO
CREATE TABLE collar_style(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	name varchar(50),
	description nvarchar(max) ,
	status	int,
)
GO
CREATE TABLE color(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	name varchar(50),
	description nvarchar(max) ,
	status	int,
)
GO
CREATE TABLE size(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	name varchar(50),
	description nvarchar(max) ,
	status	int,
)
GO
CREATE TABLE material(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	name varchar(50),
	description nvarchar(max) ,
	status	int,
)
GO
CREATE TABLE product_detail(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	product_id UNIQUEIDENTIFIER REFERENCES product(id),
	brand_id UNIQUEIDENTIFIER REFERENCES brand(id),
	hand_style_id UNIQUEIDENTIFIER REFERENCES hand_style(id),
	collar_style_id UNIQUEIDENTIFIER REFERENCES collar_style(id),
	color_id UNIQUEIDENTIFIER REFERENCES color(id),
	size_id UNIQUEIDENTIFIER REFERENCES size(id),
	material_id UNIQUEIDENTIFIER REFERENCES material(id),
	quantity int ,
	price money ,
	description nvarchar(max) ,
	status	int,
)
GO
CREATE TABLE customer (
    id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    code varchar(30) ,
    fullname VARCHAR(100),
    username VARCHAR(50),
    password VARCHAR(256),
    image VARCHAR(max),
    gender bigint,
    phone VARCHAR(20),
    email VARCHAR(100),
    status INT
)
GO
CREATE TABLE users (
    id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    code varchar(30) ,
    fullname VARCHAR(100),
    username VARCHAR(50),
    password VARCHAR(256),
    image VARCHAR(max),
    gender bigint,
    phone VARCHAR(20),
    email VARCHAR(100),
	enabled bit,
    status INT
)
GO
CREATE TABLE role (
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	name VARCHAR(30),
	status INT
)
GO
CREATE TABLE user_role (
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	user_id UNIQUEIDENTIFIER REFERENCES users(id),
	role_id UNIQUEIDENTIFIER REFERENCES role(id),
)
GO
CREATE TABLE voucher (
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	code varchar(30) ,
    name VARCHAR(100) ,
	type_voucher bit ,
	discount int ,
	Cash money ,
	start_date date,
	end_date date,
	status INT
)
GO

CREATE TABLE bill(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	code varchar(30) ,
	payment_date datetime2 ,
	total_price money ,
	total_price_last datetime2 ,
	pay_type  int ,
	pay_status int ,
	code_ghn varchar(30),
	user_id UNIQUEIDENTIFIER REFERENCES users(id),
	voucher_id UNIQUEIDENTIFIER REFERENCES voucher(id),
	customer_id UNIQUEIDENTIFIER REFERENCES customer(id),
)
GO
CREATE TABLE bill_detail(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	bill_id UNIQUEIDENTIFIER REFERENCES bill(id),
	product_detail_id UNIQUEIDENTIFIER REFERENCES product_detail(id),
	quantity int ,
	price money 
)
GO
CREATE TABLE cart(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	customer_id UNIQUEIDENTIFIER REFERENCES customer(id),
)
GO
CREATE TABLE cart_detail(
	id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	cart_id UNIQUEIDENTIFIER REFERENCES bill(id),
	product_detail_id UNIQUEIDENTIFIER REFERENCES product_detail(id),
	quantity int ,
	price money 
)
GO

