/*
    Universidad del Valle
    Asignatura: Desarrollo de Software II 750092M
    Tema: Entrega 4 proyecto
    Archivo: BaseDatosDesarrolloll.sql
    Version: 1.0
    Fecha de creacion: 25 abril 2017
    Autores:   
                Cristian Camilo Jurado Arboleda
                Monica Marcela Llano
                Sebastian Balante Salazar
                Juan Felipe Orozco Escobar               
    Responsabilidad: Base de datos Restaurante Lenos Y carbon, creacion de tablas e insercion de datos
*/


-- Creacion de tablas



CREATE TABLE empleado
(
	id_empleado integer PRIMARY KEY,
	nombres varchar(100) NOT NULL,
	apellidos varchar(100) NOT NULL,
	cargo varchar(100) NOT NULL,
	tel_fijo varchar(100) NOT NULL,
 	tel_cel varchar(100) NOT NULL,
	Email varchar(100) NOT NULL,
	direccion varchar(100)NOT NULL,
	tipo_documento varchar(100) NOT NULL,
	contrase varchar(100) NOT NULL,
	estado varchar(100) NOT NULL,
        usuario varchar,
	archivo varchar
);


CREATE TABLE turnos_semanales
(
	id integer PRIMARY KEY
	id_empleado integer NOT NULL,
	dia varchar(100) NOT NULL,   
	hora_inicio varchar(100) NOT NULL,
	hora_fin varchar(100) NOT NULL,
 	FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado),
);


CREATE TABLE item
(
	id_item integer PRIMARY KEY,
	descripcion varchar(100) NOT NULL,
	nombre varchar(20) NOT NULL,
	categoria varchar(100),
 	precio integer NOT NULL,
 	estado varchar(100) NOT NULL,
	foto varchar   
);


CREATE TABLE pedido
(
	id_pedido integer PRIMARY KEY,
	hora_inicio varchar(100) NOT NULL,
	hora_ultimo_item varchar(100),
	tipo varchar(100) NOT NULL, /*puede ser pedido mesa o para llevar*/
	num_mesa integer,
	id_empleado integer NOT NULL,
	estado varchar(100) NOT NULL,
	FOREIGN KEY (id_empleado) REFERENCES empleado 	(id_empleado)
);


CREATE TABLE item_pedido
(
	id_pedido integer REFERENCES pedido(id_pedido),
	id_item integer REFERENCES item (id_item ),
	cantidad integer NOT NULL,
	PRIMARY KEY (id_pedido , id_item)
);


CREATE TABLE factura
(
	id_factura integer PRIMARY KEY,
	estado varchar (100) NOT NULL,	
	hora_pago varchar(100) NOT NULL,
	valor_total integer NOT NULL, 	
	id_pedido integer NOT NULL,
	FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido)
);

CREATE TABLE items_de_factura
(
	nombre varchar(100) NOT NULL,
	cantidad integer NOT NULL,
	precio integer NOT NULL,
	id_factura integer REFERENCES factura(id_factura),	
	PRIMARY KEY (nombre , id_factura)
);

CREATE TABLE pagos
(
	id_pago integer NOT NULL,
	tipo varchar(100) NOT NULL,
	valor integer NOT NULL,
	cedula_cliente integer NOT NULL,
	id_factura integer REFERENCES factura(id_factura),	
	PRIMARY KEY (id_pago , id_factura)
);



-- Insercion de datos

INSERT INTO empleado(id_empleado ,nombres ,apellidos ,cargo ,tel_fijo ,tel_cel ,Email ,direccion,tipo_documento ,contrase,estado) VALUES(111,'Pepito','Perez','Mesero','1234','4567','mesero@quehambre.com','cll5','cedula','111','Activo');
INSERT INTO empleado(id_empleado ,nombres ,apellidos ,cargo ,tel_fijo ,tel_cel ,Email ,direccion,tipo_documento ,contrase,estado) VALUES(222,'Armando','Casas','Cajero','1234','4567','cajero@quehambre.com','cll6','cedula','222','Activo');
INSERT INTO empleado(id_empleado ,nombres ,apellidos ,cargo ,tel_fijo ,tel_cel ,Email ,direccion,tipo_documento ,contrase,estado) VALUES(333,'Pepa','Pig','Gerente','1234','4567','gerenteo@quehambre.com','cll7','cedula','333','Activo');

INSERT INTO turnos_semanales (dia , hora_fin, hora_inicio, id_empleado,id) VALUES('lunes','14:00','08:00',111,1);
INSERT INTO turnos_semanales (dia , hora_fin, hora_inicio, id_empleado,id) VALUES('martes','10:00','15:00',111,2);
INSERT INTO turnos_semanales (dia , hora_fin, hora_inicio, id_empleado,id) VALUES('jueves','12:00','18:00',222,3);
INSERT INTO turnos_semanales (dia , hora_fin, hora_inicio, id_empleado,id) VALUES('viernes','16:00','22:00',333,4);

INSERT INTO item(id_item ,descripcion ,nombre ,categoria ,precio,estado) VALUES(100,'rica-chuleta','chuleta-a-las-brasas','Res',25000,'Activo');
INSERT INTO item(id_item ,descripcion ,nombre ,categoria ,precio,estado) VALUES(200,'rico-helado','helado-coco','Postre',15000,'Activo');
INSERT INTO item(id_item ,descripcion ,nombre ,categoria ,precio,estado) VALUES(300,'rico-jugo','jugo-uva','Bebida',9000,'Activo');

INSERT INTO pedido(id_pedido ,hora_inicio ,hora_ultimo_item ,tipo ,num_mesa ,id_empleado,estado) VALUES(1,'10:25','11:25','Mesa','10',111,'Activo');
INSERT INTO pedido(id_pedido ,hora_inicio ,hora_ultimo_item ,tipo ,num_mesa ,id_empleado,estado) VALUES(2,'16:25','17:25','Llevar','6',111,'Activo');
INSERT INTO pedido(id_pedido ,hora_inicio ,tipo ,num_mesa ,id_empleado,estado) VALUES(3,'14:25','Mesa','11',111,'Activo');
INSERT INTO pedido(id_pedido ,hora_inicio ,tipo ,num_mesa ,id_empleado,estado) VALUES(4,'14:25','Llevar','11',222,'Activo');

INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(1,100,4);
INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(1,300,4);
INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(2,300,1);
INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(3,200,2);

