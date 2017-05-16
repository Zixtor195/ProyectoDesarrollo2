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

CREATE TYPE CARGO AS ENUM ('Mesero','Cajero','Gerente');
CREATE TYPE CATEGORIA AS ENUM ('Res','Cerdo','Pollo','Pescado','Adicione','Postre','Bebida');
CREATE TYPE TIPO_PEDIDO AS ENUM('Mesa','Llevar');
CREATE TYPE ESTADO AS ENUM('Pagado','Sin Pagar');
CREATE TYPE TIPO_PAGO AS ENUM('Debito','Credito', 'Efectivo');

CREATE TABLE empleado
(
	id_empleado integer PRIMARY KEY,
	nombres varchar(100) NOT NULL,
	apellidos varchar(100) NOT NULL,
	cargo CARGO,
	tel_fijo varchar(100) NOT NULL,
 	tel_cel varchar(100) NOT NULL,
	Email varchar(100) NOT NULL,
	direccion varchar(100)NOT NULL,
	tipo_documento varchar(100) NOT NULL,
	contrase varchar(100) NOT NULL,
	archivo varchar
);


CREATE TABLE turnos_semanales
(
	id_empleado integer NOT NULL,
	turno varchar(100) NOT NULL,
 	FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado),
 	PRIMARY KEY (id_empleado, turno)
);


CREATE TABLE item
(
	id_item integer PRIMARY KEY,
	descripcion varchar(100) NOT NULL,
	nombre varchar(20) NOT NULL,
	categoria CATEGORIA NOT NULL,
 	precio integer NOT NULL,
	foto varchar   
);


CREATE TABLE pedido
(
	id_pedido integer PRIMARY KEY,
	hora_inicio varchar(100) NOT NULL,
	hora_ultimo_item varchar(100),
	tipo TIPO_PEDIDO NOT NULL, /*puede ser pedido mesa o para llevar*/
	num_mesa integer,
	id_empleado integer NOT NULL,
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
	estado ESTADO NOT NULL,	
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
	tipo TIPO_PAGO NOT NULL,
	valor integer NOT NULL,
	cedula_cliente integer NOT NULL,
	id_factura integer REFERENCES factura(id_factura),	
	PRIMARY KEY (id_pago , id_factura)
);



-- Insercion de datos

INSERT INTO empleado(id_empleado ,nombres ,apellidos ,cargo ,tel_fijo ,tel_cel ,Email ,direccion,tipo_documento ,contrase) VALUES(111,'Pepito','Perez','Mesero','1234','4567','mesero@quehambre.com','cll5','cedula','111');
INSERT INTO empleado(id_empleado ,nombres ,apellidos ,cargo ,tel_fijo ,tel_cel ,Email ,direccion,tipo_documento ,contrase) VALUES(222,'Armando','Casas','Cajero','1234','4567','cajero@quehambre.com','cll6','cedula','222');
INSERT INTO empleado(id_empleado ,nombres ,apellidos ,cargo ,tel_fijo ,tel_cel ,Email ,direccion,tipo_documento ,contrase) VALUES(333,'Pepa','Pig','Gerente','1234','4567','gerenteo@quehambre.com','cll7','cedula','333');

INSERT INTO turnos_semanales (id_empleado ,turno) VALUES(111,'diurno-lunes');
INSERT INTO turnos_semanales (id_empleado ,turno) VALUES(111,'nocturno-martes');
INSERT INTO turnos_semanales (id_empleado ,turno) VALUES(222,'nocturno-jueves');
INSERT INTO turnos_semanales (id_empleado ,turno) VALUES(333,'diurno-viernes');

INSERT INTO item(id_item ,descripcion ,nombre ,categoria ,precio) VALUES(100,'rica-chuleta','chuleta-a-las-brasas','Res',25000);
INSERT INTO item(id_item ,descripcion ,nombre ,categoria ,precio) VALUES(200,'rico-helado','helado-coco','Postre',15000);
INSERT INTO item(id_item ,descripcion ,nombre ,categoria ,precio) VALUES(300,'rico-jugo','jugo-uva','Bebida',9000);

INSERT INTO pedido(id_pedido ,hora_inicio ,hora_ultimo_item ,tipo ,num_mesa ,id_empleado) VALUES(1,'10:25','11:25','Mesa','10',111);
INSERT INTO pedido(id_pedido ,hora_inicio ,hora_ultimo_item ,tipo ,num_mesa ,id_empleado) VALUES(2,'16:25','17:25','Llevar','6',111);
INSERT INTO pedido(id_pedido ,hora_inicio ,tipo ,num_mesa ,id_empleado) VALUES(3,'14:25','Mesa','11',111);
INSERT INTO pedido(id_pedido ,hora_inicio ,tipo ,num_mesa ,id_empleado) VALUES(4,'14:25','Llevar','11',222);

INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(1,100,4);
INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(1,300,4);
INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(2,300,1);
INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(3,200,2);

INSERT INTO factura(id_factura ,estado ,hora_pago ,valor_total ,id_pedido) VALUES(1,'Sin Pagar','1050',25000,1);
INSERT INTO factura(id_factura ,estado ,hora_pago ,valor_total ,id_pedido) VALUES(2,'Pagado','2350',9000,2);

INSERT INTO items_de_factura(nombre ,cantidad ,precio ,id_factura) VALUES('chuleton',1,20000,1);
INSERT INTO items_de_factura(nombre ,cantidad ,precio ,id_factura) VALUES('juguito',1,5000,1);
INSERT INTO items_de_factura(nombre ,cantidad ,precio ,id_factura) VALUES('jugo-uva',1,9000,2);

INSERT INTO pagos(id_pago ,tipo ,valor ,cedula_cliente, id_factura) VALUES(1,'Debito',3000,1515,2);
INSERT INTO pagos(id_pago ,tipo ,valor ,cedula_cliente, id_factura) VALUES(2,'Credito',3000,1656,2);
INSERT INTO pagos(id_pago ,tipo ,valor ,cedula_cliente, id_factura) VALUES(3,'Efectivo',3000,5587,2);
