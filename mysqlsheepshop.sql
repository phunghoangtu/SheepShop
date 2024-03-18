CREATE DATABASE SheepShop;
USE SheepShop;

CREATE TABLE product (
  id CHAR(36) NOT NULL DEFAULT UUID()product,
  code VARCHAR(30),
  name NVARCHAR(50),
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE image (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  code VARCHAR(255),
  product_id CHAR(36),
  FOREIGN KEY (product_id) REFERENCES product(id),
  PRIMARY KEY (id)
);

CREATE TABLE category (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  name VARCHAR(50),
  description TEXT,
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE brand (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  name VARCHAR(50),
  description TEXT,
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE hand_style (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  name VARCHAR(50),
  description TEXT,
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE collar_style (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  name VARCHAR(50),
  description TEXT,
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE color (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  name VARCHAR(50),
  description TEXT,
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE size (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  name VARCHAR(50),
  description TEXT,
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE material (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  name VARCHAR(50),
  description TEXT,
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE product_detail (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  product_id CHAR(36),
  brand_id CHAR(36),
  hand_style_id CHAR(36),
  collar_style_id CHAR(36),
  color_id CHAR(36),
  size_id CHAR(36),
  material_id CHAR(36),
  quantity INT,
  price DECIMAL(18, 2),
  description TEXT,
  status INT,
  PRIMARY KEY (id),
  FOREIGN KEY (product_id) REFERENCES product(id),
  FOREIGN KEY (brand_id) REFERENCES brand(id),
  FOREIGN KEY (hand_style_id) REFERENCES hand_style(id),
  FOREIGN KEY (collar_style_id) REFERENCES collar_style(id),
  FOREIGN KEY (color_id) REFERENCES color(id),
  FOREIGN KEY (size_id) REFERENCES size(id),
  FOREIGN KEY (material_id) REFERENCES material(id)
);

CREATE TABLE customer (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  code VARCHAR(30),
  fullname VARCHAR(100),
  username VARCHAR(50),
  password VARCHAR(256),
  image TEXT,
  gender BIGINT,
  phone VARCHAR(20),
  email VARCHAR(100),
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE users (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  code VARCHAR(30),
  fullname VARCHAR(100),
  username VARCHAR(50),
  password VARCHAR(256),
  image TEXT,
  gender BIGINT,
  phone VARCHAR(20),
  email VARCHAR(100),
  enabled BIT,
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE role (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  name VARCHAR(30),
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE user_role (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  user_id CHAR(36),
  role_id CHAR(36),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES role(id),
  PRIMARY KEY (id)
);

CREATE TABLE voucher (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  code VARCHAR(30),
  name VARCHAR(100),
  type_voucher BIT,
  discount INT,
  Cash DECIMAL(18, 2),
  start_date DATE,
  end_date DATE,
  status INT,
  PRIMARY KEY (id)
);

CREATE TABLE bill (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  code VARCHAR(30),
  payment_date DATETIME,
  total_price DECIMAL(18, 2),
  total_price_last DATETIME,
  pay_type INT,
  pay_status INT,
  code_ghn VARCHAR(30),
  user_id CHAR(36),
  voucher_id CHAR(36),
  customer_id CHAR(36),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (voucher_id) REFERENCES voucher(id),
 FOREIGN KEY (customer_id) REFERENCES customer(id),
  PRIMARY KEY (id)
);

CREATE TABLE bill_detail (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  bill_id CHAR(36),
  product_detail_id CHAR(36),
  quantity INT,
  price DECIMAL(18, 2),
  FOREIGN KEY (bill_id) REFERENCES bill(id),
  FOREIGN KEY (product_detail_id) REFERENCES product_detail(id),
  PRIMARY KEY (id)
);

CREATE TABLE cart (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  customer_id CHAR(36),
  PRIMARY KEY (id),
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE cart_detail (
  id CHAR(36) NOT NULL DEFAULT UUID(),
  cart_id CHAR(36),
  product_detail_id CHAR(36),
  quantity INT,
  price DECIMAL(18, 2),
  FOREIGN KEY (cart_id) REFERENCES cart(id),
  FOREIGN KEY (product_detail_id) REFERENCES product_detail(id),
  PRIMARY KEY (id)
);