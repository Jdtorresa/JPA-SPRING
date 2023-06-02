create database cellphone_market_bd;
use cellphone_market_bd;
CREATE TABLE Proveedores (
  nit VARCHAR(50) PRIMARY KEY,
  razon_social VARCHAR(100) NOT NULL,
  direccion VARCHAR(200) NOT NULL
);
CREATE TABLE Productos (
  id_producto AUTO_INCREMENT INT PRIMARY KEY ,
  referencia VARCHAR(100) NOT NULL,
  precio DOUBLE NOT NULL,
  proveedor_nit VARCHAR(50),
  FOREIGN KEY (proveedor_nit) REFERENCES Proveedores(nit)
);


-- Registros en la tabla Proveedor
INSERT INTO Proveedores (nit, razon_social, direccion) VALUES ('123456789', 'Apple Colombia S.A', 'Calle Principal 123');
INSERT INTO Proveedores (nit, razon_social, direccion) VALUES ('987654321', 'Samsung Colombia S.A', 'Avenida Central 456');
INSERT INTO Proveedores (nit, razon_social, direccion) VALUES ('543216789', 'Xiaomi Colombia Ltda', 'Paseo del Sol 789');
INSERT INTO Proveedores (nit, razon_social, direccion) VALUES ('987612345', 'Google LLC Colombia', 'Plaza Mayor 456');
INSERT INTO Proveedores (nit, razon_social, direccion) VALUES ('678912345', 'BBK Electronics Col', 'Callejón del Arte 789');

-- Registros en la tabla Producto
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (1, 'iPhone 13', 4949955, '123456789');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (2, 'Samsung Galaxy S21', 4049955, '987654321');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (3, 'Xiaomi Redmi Note 10', 1349955, '543216789');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (4, 'Google Pixel 6', 3599955, '987612345');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (5, 'OnePlus 9 Pro', 4049955, '678912345');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (6, 'iPhone 12 Mini', 3599955, '123456789');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (7, 'Google Pixel Buds', 809955, '987612345');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (8, 'OnePlus 9', 3149955, '678912345');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (9, 'OPPO Find X3 Pro', 4499955, '678912345');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (10, 'Samsung Galaxy A52', 1799955, '987654321');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (11, 'Samsung Galaxy Watch Active2', 1124955, '987654321');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (12, 'Xiaomi Redmi Note 9 Pro', 1124955, '543216789');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (13, 'Xiaomi Mi 10T', 1799955, '543216789');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (14, 'Xiaomi Poco X3 Pro',1349955, '543216789');
INSERT INTO Productos (id_producto, referencia, precio, proveedor_nit) VALUES (15, 'Xiaomi Redmi 9A', 674955, '543216789');