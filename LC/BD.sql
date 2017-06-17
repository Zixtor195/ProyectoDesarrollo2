/*
    Universidad del Valle
    Asignatura: Desarrollo de Software II 750092M
    Tema: Entrega 4 proyecto
    Archivo: BaseDatosDesarrolloll.sql
    Version: 1.0
    Fecha de creacion: 25 abril 2017
    Fecha de modificacion: 14 junio 2017
    Autores:   
                Cristian Camilo Jurado Arboleda
                Monica Marcela Llano
                Sebastian Balante Salazar
                Juan Felipe Orozco Escobar               
    Responsabilidad: Base de datos Restaurante Lenos Y carbon, creacion de tablas e insercion de datos
    Nota: Manipulamos productos y precios reales basados en la carta del menu del Restaurante Lenos & Carbon a la fecha 14 de junio del 2017 Cali - Colombia
*/


--------------------------- Creacion de tablas ----------------------------- 

CREATE TABLE empleado (
	id_empleado integer PRIMARY KEY,
	nombres varchar (100) NOT NULL,
	apellidos varchar (100) NOT NULL,
	cargo varchar (100) NOT NULL,
	tel_fijo varchar (100) NOT NULL,
 	tel_cel varchar (100) NOT NULL,
	Email varchar (100) NOT NULL,
	direccion varchar (100)NOT NULL,
	tipo_documento varchar (100) NOT NULL,
	contrase varchar (100) NOT NULL,
	estado varchar (100) NOT NULL,
	usuario varchar,
	archivo varchar
);

CREATE TABLE turnos_semanales (
    	id integer NOT NULL,
	id_empleado integer NOT NULL,
	dia varchar (100) NOT NULL,   
	hora_inicio varchar (100) NOT NULL,
	hora_fin varchar (100) NOT NULL,
 	FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado),
    	PRIMARY KEY (id)
);

CREATE TABLE item (
	id_item integer PRIMARY KEY,
	descripcion varchar (200) NOT NULL,
	nombre varchar (100) NOT NULL,
	categoria varchar(100),
 	precio integer NOT NULL,
 	estado varchar (100) NOT NULL,
	foto varchar   
);

CREATE TABLE pedido (
	id_pedido integer PRIMARY KEY,
	hora_inicio time (6) NOT NULL,
	hora_ultimo_item time (6),
	tipo varchar (100) NOT NULL, /*puede ser pedido mesa o para llevar*/
	num_mesa integer,
	id_empleado integer NOT NULL,
	estado varchar (100) NOT NULL,
    	fecha_pedido date NOT NULL, /*Cambio realizado*/
	FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado)
);

CREATE TABLE item_pedido (
	id_pedido integer REFERENCES pedido (id_pedido),
	id_item integer REFERENCES item (id_item),
	cantidad integer NOT NULL,
	PRIMARY KEY (id_pedido, id_item)
);

CREATE TABLE factura (
	id_factura integer PRIMARY KEY,
	estado varchar (100) NOT NULL,	
	hora_pago time (6) NOT NULL,
	valor_total integer NOT NULL, 	
	id_pedido integer NOT NULL,
	FOREIGN KEY (id_pedido) REFERENCES pedido (id_pedido)
);

CREATE TABLE items_de_factura (
	nombre varchar (100) NOT NULL,
	cantidad integer NOT NULL,
	precio integer NOT NULL,
	id_factura integer REFERENCES factura (id_factura),	
	PRIMARY KEY (nombre, id_factura)
);

CREATE TABLE pagos (
	id_pago integer NOT NULL,
	tipo varchar (100) NOT NULL,
	valor integer NOT NULL,
	cedula_cliente integer NOT NULL,
	id_factura integer REFERENCES factura (id_factura),	
	PRIMARY KEY (id_pago, id_factura)
);

SET DATESTYLE TO 'European';


--------------------------- Insercion de datos ---------------------------

----- Empleados

-- Estos primeros 3 empleados fueron creados para hacer pruebas y tener acceso rapido sobre las interfaces correspondientes a Mesero, Cajero y Gerente

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (111, 'MeseroNombre', 'MeseroApellido', 'Mesero', 'MeseroTel', 'MeseroCel', 'mesero@mesero.com', 'cll mesero # mesero', 'cedula', '111', 'Activo', 'mesero','/Fotos/meseroNombre.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario,archivo) VALUES (222, 'CajeroNombre', 'CajeroApellido', 'Cajero', 'CajeroTel', 'CajeroCel', 'cajero@cajero.com', 'cll cajero # cajero', 'cedula', '222', 'Activo', 'cajero','/Fotos/cajeroNombre.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (333, 'GerenteNombre', 'GerenteApellido', 'Gerente', 'GerenteTel', 'GerenteCel', 'gerente@gerente.com', 'cll gerente # gerente', 'cedula', '333', 'Activo', 'gerente','/Fotos/gerenteNombre.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1130623303, 'Juan Felipe', 'Orozco Escobar', 'Gerente', '3306666', '3168544000', 'juanfe@hotmail.com', 'cr 85b # 33-55', 'cedula', '12345', 'Activo', 'juanfe','/Fotos/juan felipe.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1530526303, 'Jose Fabian', 'Orozco Escobar', 'Cajero', '3406262', '3268541300', 'josefa@hotmail.com', 'cr 90 # 43-22', 'cedula', '75512', 'Activo', 'ferna','/Fotos/jose fabian.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1004155852, 'Fernanda', 'Orozco Escobar', 'Cajero', '6616510', '3168585124', 'ferna@hotmail.com', 'cr 35 # 43-50', 'cedula', '34441', 'Activo', 'josefa','/Fotos/fernanda.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1124554847, 'Ana', 'Arias Chacon', 'Cajero', '4622622', '3123547147', 'anacha@hotmail.com', 'cr 41a # 102-21', 'cedula', '58454', 'Activo', 'anacha','/Fotos/ana.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1114547854, 'Andres', 'Cabezas Aguirre', 'Cajero', '5514547', '3112454784', 'andresca@hotmail.com', 'cr 1a # 45-26', 'cedula', '11241', 'Activo', 'andresca','/Fotos/andres.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1330651303, 'Alberto Jose', 'Chacon Sierra', 'Mesero', '6651022', '3103534000', 'alberjo@hotmail.com', 'cr 3a # 33-125', 'cedula', '89711', 'Activo', 'alberjo','/Fotos/alberto jose.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1030431373, 'Carlos Felipe', 'Aguirre Mera', 'Mesero', '4631022', '3193534001', 'carlosagui@hotmail.com', 'cr 1a # 23-15', 'cedula', '52147', 'Activo', 'carlosagui','/Fotos/carlos felipe.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1230321255, 'Lina', 'Alvarez Agudelo', 'Mesero', '3351012', '3231434341', 'linaalva@hotmail.com', 'cr 5a # 33-05', 'cedula', '18344', 'Activo', 'linaalva','/Fotos/lina.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1520721255, 'Emma', 'Martinez Gonzalez', 'Mesero', '4351442', '3331738941', 'emmamagon@hotmail.com', 'cll 21 # 103-25', 'cedula', '67674', 'Activo', 'emmamagon','/Fotos/emma.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1230421255, 'Valentina', 'Gomez Mendez', 'Mesero', '6672543', '3165588246', 'valenmendez@hotmail.com', 'cll 44 # 43-101', 'cedula', '90991', 'Activo', 'valenmendez','/Fotos/valentina.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1855212335, 'Maria Camila', 'Garcia Gutierrez', 'Mesero', '5526513', '3165588246', 'mariaca@hotmail.com', 'cll 9 # 13-45', 'cedula', '35891', 'Activo', 'mariaca','/Fotos/maria camila.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1125421148, 'Diana Marcela', 'Lopera Zuleta', 'Mesero', '4431660', '3125553251', 'dianalo@hotmail.com', 'cll 5a # 23-63', 'cedula', '90111', 'Activo', 'dianalo','/Fotos/diana marcela.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1352148936, 'Isabela', 'Campos Vallado', 'Mesero', '6656510', '3192254122', 'isaca@hotmail.com', 'cll 12a # 23-63', 'cedula', '90111', 'Activo', 'isaca','/Fotos/isabela.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1064141244, 'Carlos', 'Ocampo Aguirre', 'Mesero', '8891510', '3212090922', 'carlosoca@hotmail.com', 'cll 1 # 66-14', 'cedula', '88212', 'Activo', 'carlosoca','/Fotos/carlos.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1224149586, 'Juan Camilo', 'Ayala Martinez', 'Mesero', '5628811', '3105255922', 'juanca@hotmail.com', 'cll 23 # 66-14', 'cedula', '14452', 'Activo', 'juanca','/Fotos/juan camilo.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1114257489, 'Meliza Andrea', 'Martinez Ayala', 'Mesero', '3328332', '3155142478', 'melian@hotmail.com', 'cr 66 # 21-04', 'cedula', '33585', 'Activo', 'melian','/Fotos/meliza andrea.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1214458745, 'Aura Lizeth', 'Lopez Renteria', 'Mesero', '8826565', '3201148578', 'auraliz@hotmail.com', 'cr 21b # 109-23', 'cedula', '12128', 'Activo', 'auraliz','/Fotos/aura lizhet.jpg');

INSERT INTO empleado (id_empleado, nombres, apellidos, cargo, tel_fijo, tel_cel, Email, direccion, tipo_documento, contrase, estado, usuario, archivo) VALUES (1224112458, 'Andrea', 'Solano Soto', 'Mesero', '5224154', '3112548890', 'andreso@hotmail.com', 'cll 35c # 34-77', 'cedula', '14154', 'Activo', 'andreso','/Fotos/andrea.jpg');



----- Turnos semanales

INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('lunes', '08:00', '16:00', 111, 1);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('martes', '08:00', '16:00', 222, 2);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('miercoles', '08:00', '16:00', 333, 3);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('jueves', '08:00', '16:00', 1530526303, 4);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('viernes', '08:00', '16:00', 1004155852, 5);

INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('lunes', '16:00', '01:00', 1330651303, 6);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('martes', '16:00', '01:00', 1030431373, 7);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('miercoles', '16:00', '01:00', 1230321255, 8);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('jueves', '16:00', '01:00', 1520721255, 9);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('viernes', '16:00', '01:00', 1230421255, 10);

INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('lunes', '16:00', '01:00', 1130623303, 11);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('martes', '16:00', '01:00', 1855212335, 12);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('miercoles', '16:00', '01:00', 1125421148, 13);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('jueves', '16:00', '01:00', 1352148936, 14);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('viernes', '16:00', '01:00', 1064141244, 15);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('viernes', '16:00', '01:00', 1224149586, 16);

INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('lunes', '16:00', '01:00', 1114547854, 17);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('martes', '16:00', '01:00', 1224112458, 18);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('miercoles', '16:00', '01:00', 1214458745, 19);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('jueves', '16:00', '01:00', 1224149586, 20);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('viernes', '16:00', '01:00', 1124554847, 21);
INSERT INTO turnos_semanales (dia, hora_inicio, hora_fin, id_empleado, id) VALUES ('viernes', '16:00', '01:00', 1114257489, 22);


----- Nota: Manipulamos productos y precios reales basados en la carta del menu del Restaurante Lenos & Carbon a la fecha 14 de junio del 2017 Cali - Colombia
----- Items

--- Categoria: Carnes 1xxx
-- Carne Cerdo 10xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1000, 'Chuleta de cerdo ahumada grille 400grs', 'CHULETA DE CERDO AHUMADA', 'CARNE CERDO', 23000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1001, 'Chuleta de cerdo ahumada 400grs (En salsa BBQ o limon)', 'CHULETA DE CERDO AHUMADA', 'CARNE CERDO', 24900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1002, 'Chuleta de cerdo ahumada (En salsa de frutas)', 'CHULETA DE CERDO AHUMADA', 'CARNE CERDO', 25400, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1003, 'Medallones de cerdo grille 380grs', 'MEDALLONES DE CERDO', 'CARNE CERDO', 21900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1004, 'Medallones de cerdo grille 380grs (En salsa BBQ o limon)', 'MEDALLONES DE CERDO', 'CARNE CERDO', 23000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1005, 'Medallones de cerdo (En salsa de frutas)', 'MEDALLONES DE CERDO', 'CARNE CERDO', 24000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1006, 'Medallon de cerdo gratinado', 'MEDALLON DE CERDO GRATINADO', 'CARNE CERDO', 25100, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1007, 'Costilla de cerdo ahumada grille 380grs', 'COSTILLA DE CERDO AHUMADA', 'CARNE CERDO', 20900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1008, 'Costilla de cerdo ahumada grille 380grs (En salsa BBQ o limon)', 'COSTILLA DE CERDO AHUMADA', 'CARNE CERDO', 21500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1009, 'Costilla de cerdo ahumada grille 380grs (En salsa de frutas)', 'COSTILLA DE CERDO AHUMADA', 'CARNE CERDO', 22600, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1010, 'Costilla ST. LOUIS (En salsa BBQ)', 'COSTILLA ST. LOUIS', 'CARNE CERDO', 29900, 'Activo');

-- Carne Pollo 11xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1100, 'Filete de pechuga grille servido en una cama de vegetales frescos', 'POLLO A LA BRASA', 'CARNE POLLO', 18400, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1101, 'Filete de pechuga banado en salsa BBQ o limon', 'FILETE DE POLLO EN SALSA', 'CARNE POLLO', 18900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1102, 'Filete de pechuga banado en salsa de champinones', 'FILETE DE POLLO EN SALSA', 'CARNE POLLO', 19900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1103, 'Filete de pechuga relleno de jamon y queso banado en salsa de queso', 'POLLO FLORENTINO', 'CARNE POLLO', 19500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1104, 'Filete de pechuga banado en salsa bechamel fundido en queso doble crema y queso parmesano', 'POLLO GRATINADO', 'CARNE POLLO', 21900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1105, 'Hamburguesa de pollo', 'HAMBURGUESA DE POLLO', 'CARNE POLLO', 14500, 'Activo');

-- Carne Res 12xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1200, 'Corte mariposa de lomo ancho de res asado al carbon 1/2', 'CHURRASCO 400grs', 'CARNE RES', 17500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1201, 'Corte mariposa de lomo ancho de res asado al carbon', 'CHURRASCO 400grs', 'CARNE RES', 25800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1202, 'Filete de lomito de res asado al carbon 1/2', 'BABY BEEF 400grs', 'CARNE RES', 18500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1203, 'Filete de lomito de res asado al carbon', 'BABY BEEF 400grs', 'CARNE RES', 27500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1204, 'Corte grueso de lomo ancho de res asado al carbon', 'BIFE DE CHORIZO NACIONAL 500gr', 'CARNE RES', 29200, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1205, 'Medallones de lomito de res asados al carbon', 'LOMITO TIERNO 400gr', 'CARNE RES', 28900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1206, 'Medallones de lomito de res asados al carbon con salsa de champinones', 'LOMITO TIERNO EN SALSA 400gr', 'CARNE RES', 31000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1207, 'Medallones de lomo de res asados al carbon con tocineta en salsa de champinones', 'FILET MIGNON 300gr', 'CARNE RES', 29900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1208, 'Punta de anca 1/2', 'PUNTA DE ANCA 400gr', 'CARNE RES', 19900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1209, 'Punta de anca', 'PUNTA DE ANCA 400gr', 'CARNE RES', 28900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1210, 'Medallones de lomito de res en salsa pimienta asados al carbon', 'STEAK PIMIENTA 400gr', 'CARNE RES', 31000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1211, 'Super punta de anca', 'SUPER PUNTA 500gr', 'CARNE RES', 32900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1212, 'Hamburguesa de res con papas a la francesa', 'HAMBURGUESA DE RES CON PAPAS A LA FRANCESA', 'CARNE RES', 14500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1213, 'Corte grueso de lomo ancho de res angus asado al carbon', 'BIFE DE CHORIZO ANGUS 500gr', 'CARNE RES', 39900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1214, 'Corte mariposa de lomo ancho de res angus asado al carbon 1/2', 'CHURRASCO ANGUS 400gr', 'CARNE RES', 24500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1215, 'Corte mariposa de lomo ancho de res angus asado al carbon', 'CHURRASCO ANGUS 400gr', 'CARNE RES', 36800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1216, 'Corte grueso especial de lomo ancho de res angus asado al carbon 1/2', 'NEW YORK STEAK ANGUS 400gr', 'CARNE RES', 36800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1217, 'Corte fino de res angus asado al carbon', 'CORTE ESPECIAL ANGUS 400gr', 'CARNE RES', 30900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1218, 'Hamburguesa de res angus 1/2 lb', 'HAMBURGUESA DE RES ANGUS', 'CARNE RES', 17900, 'Activo');

-- Especiales de la casa L&C 13xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1300, 'Plato mixto de res, lomo de cerdo, filete de pechuga y costillas de cerdo aumadas en salsa BBQ', 'ESPECIAL L&C', 'ESPECIAL L&C', 26500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1301, 'Plato mixto de res, lomo de cerdo, pollo al horno, matambre, chorizo de la casa y costillas de cerdo ahumadas en salsa BBQ', 'PARRILLADA ARGENTINA', 'ESPECIAL L&C', 34900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1302, 'Mezcla de lomo de res y de cerdo, filete de pollo, costilla de cerdo ahumada, chorizo de la casa, papas a la francesa, anillos de cebolla y platanos', 'PICADA L&C', 'ESPECIAL L&C', 39400, 'Activo');

-- Comida Mar 14xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1400, 'Trucha a la plancha', 'TRUCHA A LA PLANCHA', 'COMIDA MAR', 19500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1401, 'Trucha asada a la plancha y acompanada con una deliciosa salsa de mantequilla, ajo y perejil', 'TRUCHA AL AJILLO', 'COMIDA MAR', 21600, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1402, 'Trucha asada a la carbon, rellena de camaron y vegetales', 'TRUCHA RELLENA', 'COMIDA MAR', 24500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1403, 'Trucha asada a la plancha y acompanada con nuestra salsa de camarones y calamares', 'TRUCHA A LA MARINERA', 'COMIDA MAR', 27500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1404, 'Filete de pescado dorado a la plancha', 'ROBALO A LA PLANCHA', 'COMIDA MAR', 25900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1405, 'Exquisito filete de pescado con nuestra salsa de camarones y calamares', 'ROBALO A LA MARINERA', 'COMIDA MAR', 32900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1406, 'Filete de salmon a la plancha o en salsa BBQ', 'FILETE DE SALMON L&C A LA PLANCHA', 'COMIDA MAR', 32500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1407, 'Filete de salmon asado en nuestra parrilla con exquisita salsa de frutos del mar', 'FILETE DE SALMON EN SALSA MARINERA', 'COMIDA MAR', 40500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1408, 'Langostinos al ajillo salteados con salsa de mantequilla, ajo y perejil', 'LANGOSTINOS AL AJILLO', 'COMIDA MAR', 39500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1409, 'Langostinos al wok con vegetales al estilo oriental', 'LANGOSTINOS AL WOK', 'COMIDA MAR', 41800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1410, 'Langostinos en salsa marinera con nuestra sin igual salsa de camarones y calamares al estilo de la casa', 'LANGOSTINOS EN SALSA MARINERA', 'COMIDA MAR', 47000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1411, 'Langostinos, pimenton, champinones y tomate sobre una cama de arroz', 'BROCHETA DE LANGOSTINOS', 'COMIDA MAR', 29000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1412, 'Exquisita combinacion de mariscos y pescado', 'CAZUELA DE MARISCOS', 'COMIDA MAR', 38500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1413, 'Camarones en salsa picante, limon y cilantro', 'CEVICHE DE CAMARON', 'COMIDA MAR', 14900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (1414, 'Cubitos de filete de corvina  en salsa picante, limon y cilantro', 'CEVICHE DE CORVINA', 'COMIDA MAR', 14900, 'Activo');


--- Categoria: Ensaladas 2xxx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (2000, 'Lechuga romana y champinones frescos banados con salsa Cesar y queso parmesano, coronados con crutones', 'ENSALADA CESAR', 'ENSALADAS', 12100, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (2001, 'Acompanada con julianas de pechuga de pollo grille', 'ENSALADA CESAR CON POLLO', 'ENSALADAS', 14200, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (2002, 'Vistosos colores y deliciosos sabores de la naturaleza', 'ENSALADA DELUXE', 'ENSALADAS', 14900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (2003, 'Frescos ingredientes de nuestro huerto en un mix de lechuga, pepino, cebolla, tomate, pimenton, aderezado con queso fresco y vinagreta de la casa 1/2', 'ENSALADA GRIEGA', 'ENSALADAS', 9400, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (2004, 'Frescos ingredientes de nuestro huerto en un mix de lechuga, pepino, cebolla, tomate, pimenton, aderezado con queso fresco y vinagreta de la casa', 'ENSALADA GRIEGA', 'ENSALADAS', 14900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (2005, 'Una deliciosa variedad de vegetales salteados al wok entrelazados con robalo y camarones', 'VERDURA MARINERA AL WOK', 'ENSALADAS', 17500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (2006, 'Mix de calamares, aceitunas verdes y moradas, pimenton asado y tomates secos, entremezclados con lechuga y queso parmesano 1/2', 'ENSALADA MEDITERRANEA', 'ENSALADAS', 12700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (2007, 'Mix de calamares, aceitunas verdes y moradas, pimenton asado y tomates secos, entremezclados con lechuga y queso parmesano', 'ENSALADA MEDITERRANEA', 'ENSALADAS', 19900, 'Activo');


--- Categoria: Sopas 3xxx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (3000, 'Deliciosa crema de tomate con tomates frescos y finas hierbas', 'CREMA DE TOMATE', 'SOPAS', 9900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (3001, 'Espectacular crema de champinones del huerto', 'CREMA DE CHAMPINONES', 'SOPAS', 9900, 'Activo');


--- Categoria: Adiciones 4xxx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (4001, 'Lechuga, tomate, apio, pimenton y repollo', 'ENSALADA DE VERDURAS', 'ADICIONES', 1900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (4002, 'Arroz de la casa con un toque de verduras', 'ARROZ DE LA CASA', 'ADICIONES', 2900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (4003, 'Papas al horno con sour cream y chips de tocineta', 'PAPAS AL HORNO', 'ADICIONES', 3200, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (4004, 'Pure de papa gratinado', 'PURE DE PAPA GRATINADO', 'ADICIONES', 4000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (4005, 'Papas a la francesa', 'PAPAS A LA FRANCESA', 'ADICIONES', 3300, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (4006, 'Mezcla de verduras salteadas al estilo oriental', 'VEGETALES AL WOK', 'ADICIONES', 4000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (4007, 'Anillos de cebolla', 'ANILLOS DE CEBOLLA', 'ADICIONES', 4200, 'Activo');


-- Categoria: Postres 5xxx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (5000, 'Brownie con helado', 'BROWNIE CON HELADO', 'POSTRES', 5800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (5001, 'Crema de vainilla horneada y azucar acaramelada', 'CREME BRULEE', 'POSTRES', 5900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (5002, 'Torta de queso con salsa de fresa, frutos rojos o mora', 'CHEESECAKE', 'POSTRES', 5500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (5003, 'Flan de queso y caramelo', 'POSTRE DE LA CASA', 'POSTRES', 5500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (5004, 'Postre italiano con bizcochuelo y licor de cafe', 'TIRAMISU', 'POSTRES', 6200, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (5005, 'Rollo de helado con salsa de caramelo, fresa o chocolate', 'ROLLO DE HELADO', 'POSTRES', 5900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (5006, 'Mousse de frutas de temporada', 'MOUSSE DE FRUTAS DE TEMPORADA', 'POSTRES', 5500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (5007, 'Copa de helado', 'COPA DE HELADO', 'POSTRES', 6900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (5008, 'Combinacion de confitura de manzana y nueces horneadas', 'STRUDEL DE MANZANA', 'POSTRES', 6900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (5009, 'Torta rellena de chocolate claiente servida con helado', 'VOLCAN DE CHOCOALTE', 'POSTRES', 7000, 'Activo');


--- Categoria: Entradas 6xxx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (6000, 'Chorizo parrilla con arepa', 'CHORIZO PARRILLA CON AREPA', 'ENTRADAS', 4900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (6001, 'Deliciosos y crocantes anillos de calamar', 'CALAMARES CRUJIENTES', 'ENTRADAS', 10200, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (6002, 'Combinacion de quesos aromatizados y presentados con fina textura crocante', 'CRUJIENTES DE QUESO', 'ENTRADAS', 10300, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (6003, 'Tomates frescos cubiertos con queso mozzarella, aceite de oliva y albahaca del huerto', 'TOMATES MOZARELLA', 'ENTRADAS', 11500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (6004, 'Frescos champinones banados en una deliciosa salsa al ajillo', 'CHAMPINONES AL AJILLO', 'ENTRADAS', 11300, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (6005, 'Champinones sumergidos en una cremosa salsa de tres quesos', 'DELICIA DE CHAMPINONES', 'ENTRADAS', 12700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (6006, 'Nuggets de camaron acompanados de miel mostaza y tartara', 'NUGGETS DE CAMARON', 'ENTRADAS', 15000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (6007, 'Espectaculares langostinos en nuestra salsa calypso', 'COCTEL DE LANGOSTINOS', 'ENTRADAS', 26000, 'Activo');


--- Categoria: Bebidas 7xxx
-- Limonadas y Jugos 70xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7000, 'Limonada natural', 'LIMONADA NATURAL', 'BEBIDAS', 3800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7001, 'Limonada cerezada', 'LIMONADA CEREZADA', 'BEBIDAS', 4800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7002, 'Jugo de naranja', 'JUGO DE NARANJA', 'BEBIDAS', 4100, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7003, 'Fresa, guanabana, pina, mango, maracuya, mora, lulo, banano, guayaba, melon, uva y papaya', 'JUGOS EN AGUA', 'BEBIDAS', 4100, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7004, 'Banano, fresa, guanabana, guayaba, lulo, mango, maracuya, melon, mora, papaya, pina y uva', 'JUGOS EN LECHE', 'BEBIDAS', 4600, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7005, 'Jugo de mandarina', 'JUGO DE MANDARINA', 'BEBIDAS', 5900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7006, 'Vaso de leche', 'VASO DE LECHE', 'BEBIDAS', 3000, 'Activo');

-- Frias 71xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7100, 'Agua cristal', 'AGUA CRISTAL', 'BEBIDAS', 3200, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7101, 'Ginger, soda, tonica', 'GINGER, SODA, TONICA', 'BEBIDAS', 3100, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7102, 'Gaseosa dispensador', 'GASEOSA DISPENSADOR', 'BEBIDAS', 3100, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7103, 'Gaseosa personal', 'GASEOSA PERSONAL', 'BEBIDAS', 4000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7104, 'H2Oh', 'H2Oh', 'BEBIDAS', 3800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7105, 'Mr. tea', 'MR. TEA', 'BEBIDAS', 3800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7106, 'Lipton', 'LIPTON', 'BEBIDAS', 4300, 'Activo');

-- Calientes 72xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7200, 'Cafe tinto', 'CAFE TINTO', 'BEBIDAS', 2300, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7201, 'Espresso', 'ESPRESSO', 'BEBIDAS', 2600, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7202, 'Espresso doble', 'ESPRESSO DOBLE', 'BEBIDAS', 3600, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7203, 'Capuccino (Cafe latte)', 'CAPUCCINO', 'BEBIDAS', 3400, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7204, 'Capuccino Baileys o Amaretto', 'CAPUCCINO', 'BEBIDAS', 6200, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7205, 'Macciato (Espresso con leche cremada)', 'MACCIATO', 'BEBIDAS', 3600, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7206, 'Macciato Frappe (Cafe mocka helado)', 'MACCIATO FRAPPE', 'BEBIDAS', 6800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7207, 'Cafe Mocka', 'CAFE MOCKA', 'BEBIDAS', 3900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7208, 'Cafe Vienes', 'CAFE VIENES', 'BEBIDAS', 3900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7209, 'Te', 'TE', 'BEBIDAS', 2300, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7210, 'Aromatica de frutas', 'AROMATICA DE FRUTAS', 'BEBIDAS', 3500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7211, 'Frapuccino', 'FRAPUCCINO', 'BEBIDAS', 6500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7212, 'Irish Coffee (Cafe negro, whisky y crema de chantilly)', 'IRISH COFFEE', 'BEBIDAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7213, 'Aromatica', 'AROMATICA', 'BEBIDAS', 2300, 'Activo');

-- Sin licor 73xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7300, 'Gin Citrus', 'GIN CITRUS', 'BEBIDAS', 5000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7301, 'Green Day', 'GREEN DAY', 'BEBIDAS', 5000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7302, 'Fantasy', 'FANTASY', 'BEBIDAS', 5000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7303, 'Cafeto', 'CAFETO', 'BEBIDAS', 8200, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7304, 'Caribbean', 'CARIBBEAN', 'BEBIDAS', 6200, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7305, 'Kilimanjaro', 'KILIMANJARO', 'BEBIDAS', 6800, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7306, 'Sunset', 'SUNSET', 'BEBIDAS', 8200, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (7307, 'Twister', 'TWISTER', 'BEBIDAS', 6900, 'Activo');


--- Categoria: Bebidas alcoholicas 8xxx
-- Cervezas 80xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8000, 'Aguila Light', 'AGUILA LIGHT', 'BEBIDAS ALCOHOLICAS', 4700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8001, 'Club Colombia', 'CLUB COLOMBIA', 'BEBIDAS ALCOHOLICAS', 4700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8002, 'Corona, Heineken, Peroni', 'CORONA, HEINEKEN, PERONI', 'BEBIDAS ALCOHOLICAS', 7900, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8003, 'Sifon 1 litro', 'SIFON', 'BEBIDAS ALCOHOLICAS', 13500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8004, 'Sifon 1/2 litro', 'SIFON', 'BEBIDAS ALCOHOLICAS', 7000, 'Activo');

-- Cocteles 81xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8100, 'Brandy crema de cacao', 'ALEXANDER', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8101, 'Brandy crema de cacao', 'ALEXANDER COCO', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8102, 'Vodka Smirnoff Apple, vermouth dry', 'APPLE MARTINI', 'BEBIDAS ALCOHOLICAS', 15700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8103, 'Vodka, jugo de tomate, tabasco', 'BLOODY MARY', 'BEBIDAS ALCOHOLICAS', 15700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8104, 'Vino caliente triple sec, brandy, jugo de naranja', 'BROULET', 'BEBIDAS ALCOHOLICAS', 15700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8105, 'Ron, soda, limon', 'CAIPIRINA', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8106, 'Vodka, soda, limon, azucar', 'CAIPIROSCA', 'BEBIDAS ALCOHOLICAS', 15700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8107, 'Smirnoff Citrus, vermouth dry', 'CITRUS MARTINI', 'BEBIDAS ALCOHOLICAS', 15700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8108, 'Brandy amaretto', 'COGNARETTO', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8109, 'Cuba libre', 'CUBA LIBRE', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8110, 'Ron, fresa, jugo de fresa', 'DAIQUIRI FRESA', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8111, 'Ron, limon', 'DAIQUIRI LIMON', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8112, 'Ginebra, vermouth dry', 'DRY MARTINI', 'BEBIDAS ALCOHOLICAS', 15700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8113, 'Whisky, vermouth rojo', 'MANHATTAN', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8114, 'Tequila, triple sec, limon', 'MARGARITA', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8115, 'Ron, hierbabuena, soda', 'MOJITO CUBANO', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8116, 'Whisky, amaretto', 'PADRINO', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8117, 'Ron, jugo de pina, crema de coco', 'PINA COLADA', 'BEBIDAS ALCOHOLICAS', 18000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8118, 'Hypnotic', 'HYPNOTIC', 'BEBIDAS ALCOHOLICAS', 20000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8119, 'Ruso Negro', 'RUSO NEGRO', 'BEBIDAS ALCOHOLICAS', 14700, 'Activo');

-- Licores 82xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8201, 'Sangria 1 vaso', 'SANGRIA', 'BEBIDAS ALCOHOLICAS', 6000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8202, 'Sangria 1 jarra', 'SANGRIA', 'BEBIDAS ALCOHOLICAS', 17000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8203, 'Vino tinto de verano 1 vaso', 'VINO TINO DE VERANO', 'BEBIDAS ALCOHOLICAS', 5000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8204, 'Aperitivo 1 trago', 'DUBONET', 'BEBIDAS ALCOHOLICAS', 9000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8205, 'Aperitivo 1 botella', 'DUBONET', 'BEBIDAS ALCOHOLICAS', 95000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8206, 'Aperitivo 1 trago', 'APERITIVO JEREZ TIO PEPE', 'BEBIDAS ALCOHOLICAS', 9000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8207, 'Aperitivo 1 botella', 'APERITIVO JEREZ TIO PEPE', 'BEBIDAS ALCOHOLICAS', 90000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8208, 'Aperitivo 1 trago', 'APERITIVO CAMPARI', 'BEBIDAS ALCOHOLICAS', 9000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8209, 'Aperitivo 1 botella', 'APERITIVO CAMPARI', 'BEBIDAS ALCOHOLICAS', 90000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8210, 'Vino espumoso 1 botella', 'TRIVENTO EXTRA BRUT', 'BEBIDAS ALCOHOLICAS', 35000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8211, 'Vino espumoso 1 botella', 'CHANDON ROSE', 'BEBIDAS ALCOHOLICAS', 60000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8212, 'Aguardiente 1 trago', 'NECTAR', 'BEBIDAS ALCOHOLICAS', 5000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8213, 'Aguardiente 1 1/2 botella', 'NECTAR', 'BEBIDAS ALCOHOLICAS', 25000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8214, 'Aguardiente 1 botella', 'NECTAR', 'BEBIDAS ALCOHOLICAS', 50000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8215, 'Aguardiente 1 trago', 'ANTIOQUENO', 'BEBIDAS ALCOHOLICAS', 6000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8216, 'Aguardiente 1 1/2 botella', 'ANTIOQUENO', 'BEBIDAS ALCOHOLICAS', 32000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8217, 'Aguardiente 1 botella', 'NECTAR', 'BEBIDAS ALCOHOLICAS', 60000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8218, 'Brandy 1 trago', 'DOMECQ', 'BEBIDAS ALCOHOLICAS', 5000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8219, 'Brandy 1 botella', 'DOMECQ', 'BEBIDAS ALCOHOLICAS', 55000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8220, 'Ron 1 trago', 'VIEJO DE CALDAS', 'BEBIDAS ALCOHOLICAS', 7000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8221, 'Ron 1 botella', 'VIEJO DE CALDAS', 'BEBIDAS ALCOHOLICAS', 68000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8222, 'Ron 1 trago', 'ZACAPA 15 ANOS', 'BEBIDAS ALCOHOLICAS', 17000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8223, 'Ron 1 botella', 'ZACAPA 15 ANOS', 'BEBIDAS ALCOHOLICAS', 170000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8224, 'Ron 1 trago', 'MEDELLIN', 'BEBIDAS ALCOHOLICAS', 7000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8225, 'Ron 1/2 botella', 'MEDELLIN', 'BEBIDAS ALCOHOLICAS', 37000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8226, 'Ron 1 botella', 'MEDELLIN', 'BEBIDAS ALCOHOLICAS', 68000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8227, 'Vodka 1 trago', 'ABSOLUT', 'BEBIDAS ALCOHOLICAS', 9000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8228, 'Vodka 1/2 botella', 'ABSOLUT', 'BEBIDAS ALCOHOLICAS', 50000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8229, 'Vodka 1 botella', 'ABSOLUT', 'BEBIDAS ALCOHOLICAS', 90000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8230, 'Vodka 1 trago', 'FINLANDIA', 'BEBIDAS ALCOHOLICAS', 9000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8231, 'Vodka 1/2 botella', 'FINLANDIA', 'BEBIDAS ALCOHOLICAS', 50000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8232, 'Vodka 1 botella', 'FINLANDIA', 'BEBIDAS ALCOHOLICAS', 90000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8233, 'Tequila 1 trago', 'JOSE CUERVO ESPECIAL', 'BEBIDAS ALCOHOLICAS', 9000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8234, 'Tequila 1 botella', 'JOSE CUERVO ESPECIAL', 'BEBIDAS ALCOHOLICAS', 90000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8235, 'Tequila 1 trago', 'JOSE CUERVO CLASICO', 'BEBIDAS ALCOHOLICAS', 9000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8236, 'Tequila 1 botella', 'JOSE CUERVO CLASICO', 'BEBIDAS ALCOHOLICAS', 90000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8237, 'Ginebra 1 trago', 'GINEBRA GORDONS', 'BEBIDAS ALCOHOLICAS', 15000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8238, 'Ginebra 1 botella', 'GINEBRA GORDONS', 'BEBIDAS ALCOHOLICAS', 150000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8239, 'Ginegra 1 trago', 'GINEBRA TANQUERAY', 'BEBIDAS ALCOHOLICAS', 18000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8240, 'Ginegra 1 botella', 'GINEBRA TANQUERAY', 'BEBIDAS ALCOHOLICAS', 180000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8241, 'Whisky 1 trago', 'JOHNNIE WALKER RED LABEL 8 ANHOS', 'BEBIDAS ALCOHOLICAS', 10000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8242, 'Whisky 1/2 botella', 'JOHNNIE WALKER RED LABEL 8 ANHOS', 'BEBIDAS ALCOHOLICAS', 60000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8243, 'Whisky 1 botella', 'JOHNNIE WALKER RED LABEL 8 ANHOS', 'BEBIDAS ALCOHOLICAS', 110000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8244, 'Whisky 1 trago', 'JOHNNIE WALKER BLACK LABEL 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 15000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8245, 'Whisky 1/2 botella', 'JOHNNIE WALKER BLACK LABEL 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 80000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8246, 'Whisky 1 botella', 'JOHNNIE WALKER BLACK LABEL 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 150000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8247, 'Whisky 1 trago', 'BUCHANNAS 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 15000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8248, 'Whisky 1/2 botella', 'BUCHANNAS 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 85000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8249, 'Whisky 1 botella', 'BUCHANNAS 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 160000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8250, 'Whisky 1 trago', 'BUCHANNAS 18 ANHOS', 'BEBIDAS ALCOHOLICAS', 29000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8251, 'Whisky 1 botella', 'BUCHANNAS 18 ANHOS', 'BEBIDAS ALCOHOLICAS', 290000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8252, 'Whisky 1 trago', 'OLD PARR 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 15000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8253, 'Whisky 1/2 botella', 'OLD PARR 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 110000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8254, 'Whisky 1 botella', 'OLD PARR 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 160000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8255, 'Whisky 1 trago', 'JACK DANIELS', 'BEBIDAS ALCOHOLICAS', 14000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8256, 'Whisky 1/2 botella', 'JACK DANIELS', 'BEBIDAS ALCOHOLICAS', 75000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8257, 'Whisky 1 botella', 'JACK DANIELS', 'BEBIDAS ALCOHOLICAS', 140000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8258, 'Whisky 1 trago', 'CHIVAS REGAL 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 15000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8259, 'Whisky 1/2 botella', 'CHIVAS REGAL 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 85000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8260, 'Whisky 1 botella', 'CHIVAS REGAL 12 ANHOS', 'BEBIDAS ALCOHOLICAS', 160000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8261, 'Cognac 1 trago', 'HENNESSY', 'BEBIDAS ALCOHOLICAS', 20000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8262, 'Cognac 1 botella', 'HENNESSY', 'BEBIDAS ALCOHOLICAS', 200000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8263, 'Cognac 1 trago', 'REMY MARTIN', 'BEBIDAS ALCOHOLICAS', 26000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8264, 'Cognac 1 botella', 'REMY MARTIN', 'BEBIDAS ALCOHOLICAS', 260000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8265, 'Pousse cafe 1 trago', 'BAILEYS', 'BEBIDAS ALCOHOLICAS', 9000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8266, 'Pousse cafe 1 botella', 'BAILEYS', 'BEBIDAS ALCOHOLICAS', 80000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8267, 'Pousse cafe 1 trago', 'SAMBUCA', 'BEBIDAS ALCOHOLICAS', 10000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8268, 'Pousse cafe 1 botella', 'SAMBUCA', 'BEBIDAS ALCOHOLICAS', 100000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8269, 'Pousse cafe 1 trago', 'COINTREAU', 'BEBIDAS ALCOHOLICAS', 13000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8270, 'Pousse cafe 1 botella', 'COINTREAU', 'BEBIDAS ALCOHOLICAS', 130000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8271, 'Pousse cafe 1 trago', 'AMARETO LUXARDO', 'BEBIDAS ALCOHOLICAS', 8500, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (8272, 'Pousse cafe 1 botella', 'AMARETO LUXARDO', 'BEBIDAS ALCOHOLICAS', 85000, 'Activo');


--- Categoria: Vinos 9xxx
-- Vinos tintos chilenos 90xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9000, 'Joven 1 botella', 'MERLOT FRONTERA', 'VINOS', 47000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9001, 'Reserva 1 botella', 'CARMENERE SANTA DIGNA', 'VINOS', 55000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9002, 'Varietal 1 botella', 'CARMENERE SUNRISE', 'VINOS', 52000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9003, 'Varietal 1/2 botella', 'CABERNET SAUVIGNON SUNRISE', 'VINOS', 27000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9004, 'Varietal 1 botella', 'CABERNET SAUVIGNON SUNRISE', 'VINOS', 53000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9005, 'Varietal 1/2 botella', 'MERLOT SUNRISE', 'VINOS', 28000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9006, 'Varietal 1 botella', 'MERLOT SUNRISE', 'VINOS', 55000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9007, 'Gran Reserva 1 botella', 'MERLOT MONTGRAS', 'VINOS', 52000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9008, 'Varietal 1 botella', 'CABERNET SAUVIGNON MORANDE PIONERO', 'VINOS', 50000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9009, 'Reserva 1 botella', 'CARMENERE CARMEN CLASSIC', 'VINOS', 55000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9010, 'Premium 1 botella', 'CARMENERE CASILLERO DEL DIABLO', 'VINOS', 74000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9011, 'Premium 1/2 botella', 'CABERNET SAUVIGNON CASILLERO DEL DIABLO', 'VINOS', 39000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9012, 'Premium 1 botella', 'CABERNET SAUVIGNON CASILLERO DEL DIABLO', 'VINOS', 74000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9013, 'Premium 1 botella', 'MALBEC CASILLERO DEL DIABLO', 'VINOS', 74000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9014, 'Premium 1/2 botella', 'MERLOT CASILLERO DEL DIABLO', 'VINOS', 39000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9015, 'Premium 1 botella', 'MERLOT CASILLERO DEL DIABLO', 'VINOS', 74000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9016, 'Premium 1 botella', 'RESERVA PRIVADA CASILLERO DEL DIABLO', 'VINOS', 90000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9017, 'Premium 1 botella', 'MERLOT, CARMENERE, CABERNET SAUVIGNON TRIO', 'VINOS', 80000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9018, 'Premium 1 botella', 'CABERNET SAUVIGNON, SHIRAZ FRANCES TRIO', 'VINOS', 80000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9019, 'Ultra Premium 1 botella', 'CABERNET SAUVIGNON, TERRUNYO', 'VINOS', 85000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9020, 'Super Premium 1 botella', 'CABERNET SAUVIGNON GRAN RESERVA', 'VINOS', 90000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9021, 'Super Premium 1 botella', 'CABERNET SAUVIGNON MARQUES CASA CONCHA', 'VINOS', 108000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9022, 'Super Premium 1 botella', 'MERLOT MARQUES CASA CONCHA', 'VINOS', 108000, 'Activo');

-- Vinos blancos chilenos 91xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9100, 'Joven 1 botella', 'SAUVIGNON BLANC FRONTERA', 'VINOS', 48000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9101, 'Joven 1 botella', 'CABERNET SAUVIGNON HEMISFERIO', 'VINOS', 50000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9102, 'Varietal 1 botella', 'CHARDONNAY MORANDE PIONERO', 'VINOS', 52000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9103, 'Varietal 1 botella', 'SAUVIGNON BLANC MONTGRAS', 'VINOS', 55000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9104, 'Premium 1 botella', 'SAUVIGNON BLANC CASILLERO DEL DIABLO RESERVA', 'VINOS', 74000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9105, 'Premium 1 botella', 'CHARDONNAY, PINOT GRIGIO, RIESLING TRIO', 'VINOS', 80000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9106, 'Super Premium 1 botella', 'CHARDONNAY MARQUES CASA CONCHA', 'VINOS', 108000, 'Activo');

-- Vinos tintos argentinos 92xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9200, 'Joven 1 botella', 'SYRAH TRIVENTO TRIBU', 'VINOS', 52000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9201, 'Joven 1 botella', 'MERLOT TRIVENTO TRIBU', 'VINOS', 52000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9202, 'Joven 1/2 botella', 'MALBEC TRIVENTO TRIBU', 'VINOS', 28000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9203, 'Joven 1 botella', 'MALBEC TRIVENTO TRIBU', 'VINOS', 55000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9204, 'Joven 1/2 botella', 'CARBENET SAUVIGNON TRIVENTO TRIBU', 'VINOS', 28000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9205, 'Joven 1 botella', 'CARBENET SAUVIGNON TRIVENTO TRIBU', 'VINOS', 50000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9206, 'Reserva 1 botella', 'CARBENET SAUVIGNON TRIVENTO', 'VINOS', 65000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9207, 'Premium 1 botella', 'MALBEC TRIVENTO GOLDEN RESERVA', 'VINOS', 95000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9208, 'Premium 1 botella', 'MALBEC, BONARDA, SYRAH AMADO SUR', 'VINOS', 85000, 'Activo');

-- Vinos blancos argentinos 93xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9300, 'Joven 1 botella', 'CHARDONNAY TRIVENTO', 'VINOS', 50000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9301, 'Joven 1/2 botella', 'CHARDONNAY TRIVENTO TRIBU', 'VINOS', 28000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9302, 'Joven 1 botella', 'CHARDONNAY TRIVENTO TRIBU', 'VINOS', 53000, 'Activo');

-- Vinos rose 94xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9400, 'Reserva 1 botella', 'MERLOT ROSE FRONTERA', 'VINOS', 45000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9401, 'Reserva 1 botella', 'ROSE CABERNET SANTA DIGNA', 'VINOS', 60000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9402, 'Reserva 1 botella', 'ARGENTINO FAMILIA GASCON', 'VINOS', 65000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9403, 'Premium 1 botella', 'SHIRAZ ROSE CASILLERO DEL DIABLO', 'VINOS', 74000, 'Activo');

-- Vino tinto de la casa 95xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9500, 'Reserva 1 copa', 'MALBEC TRIVENTO RESERVA', 'VINOS', 14000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9501, 'Reserva 1 botella', 'MALBEC TRIVENTO RESERVA', 'VINOS', 65000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9502, 'Premium 1 copa', 'SHIRAZ CASILLERO DEL DIABLO', 'VINOS', 15000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9503, 'Premium 1 botella', 'SHIRAZ CASILLERO DEL DIABLO', 'VINOS', 74000, 'Activo');

-- Vino blanco de la casa 96xx
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9600, 'Reserva 1 copa', 'CHARDONNAY TRIVENTO RESERVA', 'VINOS', 14000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9601, 'Reserva 1 botella', 'CHARDONNAY TRIVENTO RESERVA', 'VINOS', 65000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9602, 'Premium 1 copa', 'SAUVIGNON BLANC CASILLERO DEL DIABLO', 'VINOS', 15000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9603, 'Premium 1/2 botella', 'SAUVIGNON BLANC CASILLERO DEL DIABLO', 'VINOS', 39000, 'Activo');
INSERT INTO item (id_item, descripcion, nombre, categoria, precio, estado) VALUES (9604, 'Premium 1 botella', 'SAUVIGNON BLANC CASILLERO DEL DIABLO', 'VINOS', 74000, 'Activo');


----- Pedidos

INSERT INTO pedido (id_pedido, hora_inicio, hora_ultimo_item, tipo, num_mesa, id_empleado, estado, fecha_pedido) VALUES (1, '10:25', '10:45', 'Llevar', null, 1330651303, 'Activo', '2008-12-31');

INSERT INTO pedido (id_pedido, hora_inicio, hora_ultimo_item, tipo, num_mesa, id_empleado, estado, fecha_pedido) VALUES (2, '16:25', '16:45', 'Llevar', null, 1330651303, 'Activo', '2008-12-31');

INSERT INTO pedido (id_pedido, hora_inicio, hora_ultimo_item, tipo, num_mesa, id_empleado, estado, fecha_pedido) VALUES (3, '14:25', '14:38', 'Mesa', '1',  1330651303, 'Activo', '2008-12-31');

INSERT INTO pedido (id_pedido, hora_inicio, hora_ultimo_item, tipo, num_mesa, id_empleado, estado, fecha_pedido) VALUES (4, '14:45:', '14:55', 'Llevar', null, 1330651303, 'Activo', '2008-12-31');

INSERT INTO pedido (id_pedido, hora_inicio, hora_ultimo_item, tipo, num_mesa, id_empleado, estado, fecha_pedido) VALUES (5, '15:20', '15:50', 'Llevar', null, 1004155852, 'Activo', '2008-12-31');

INSERT INTO pedido (id_pedido, hora_inicio, hora_ultimo_item, tipo, num_mesa, id_empleado, estado, fecha_pedido) VALUES (6, '16:20', '16:40', 'Mesa', '2',  1004155852, 'Activo', '2008-12-31');

INSERT INTO pedido (id_pedido, hora_inicio, hora_ultimo_item, tipo, num_mesa, id_empleado, estado, fecha_pedido) VALUES (7, '17:20', '17:40', 'Mesa', '3',  1224112458, 'Activo', '2008-11-11');

INSERT INTO pedido (id_pedido, hora_inicio, hora_ultimo_item, tipo, num_mesa, id_empleado, estado, fecha_pedido) VALUES (8, '9:20', '9:40', 'Mesa', '4',  1530526303, 'Activo', '2008-11-09');

INSERT INTO pedido (id_pedido, hora_inicio, hora_ultimo_item, tipo, num_mesa, id_empleado, estado, fecha_pedido) VALUES (9, '12:20', '12:40', 'Mesa', '5', 1530526303, 'Activo', '2008-11-08');

INSERT INTO pedido (id_pedido, hora_inicio, hora_ultimo_item, tipo, num_mesa, id_empleado, estado, fecha_pedido) VALUES (10, '8:25', '8:40', 'Llevar', null, 1330651303, 'Activo', '2008-12-31');

---Facturas

INSERT INTO factura (id_factura, estado, hora_pago, valor_total,id_pedido) VALUES (1, 'cancelado', '11:26',40000,1);

INSERT INTO factura (id_factura, estado, hora_pago, valor_total,id_pedido) VALUES (2, 'cancelado', '17:27',5000,2);

INSERT INTO factura (id_factura, estado, hora_pago, valor_total,id_pedido) VALUES (3, 'cancelado', '14:51',7000,3);

INSERT INTO factura (id_factura, estado, hora_pago, valor_total,id_pedido) VALUES (4, 'cancelado', '15:53',4000,4);

INSERT INTO factura (id_factura, estado, hora_pago, valor_total,id_pedido) VALUES (5, 'cancelado', '14:54',100000,5);

INSERT INTO factura (id_factura, estado, hora_pago, valor_total,id_pedido) VALUES (6, 'cancelado', '16:42',200000,6);

INSERT INTO factura (id_factura, estado, hora_pago, valor_total,id_pedido) VALUES (7, 'cancelado', '17:42',30000,7);

INSERT INTO factura (id_factura, estado, hora_pago, valor_total,id_pedido) VALUES (8, 'cancelado', '9:42',7000,8);

----- Items pedido

INSERT INTO item_pedido (id_pedido, id_item, cantidad) VALUES (1, 8004, 4);
INSERT INTO item_pedido (id_pedido, id_item, cantidad) VALUES (2, 2004, 3);
INSERT INTO item_pedido (id_pedido, id_item, cantidad) VALUES (3, 9101, 2);
