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
	cargo varchar(20) NOT NULL,
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
 	FOREIGN KEY (id_empleado) REFERENCES empleado 	(id_empleado),
 	PRIMARY KEY (id_empleado, turno)
);


CREATE TABLE item
(
	id_item integer PRIMARY KEY,
	descripcion varchar(100) NOT NULL,
      /* la foto varchar(100),*/
	nombre varchar(20) NOT NULL,
	categoria varchar(100) NOT NULL,
 	precio integer NOT NULL
);


CREATE TABLE pedido
(
	id_pedido integer PRIMARY KEY,
	hora_inicio varchar(100) NOT NULL,
	hora_ultimo_item varchar(100),
	tipo varchar(100) NOT NULL, /*puede ser pedido mesa o para 	llevar*/
	num_mesa integer,
	id_empleado integer,
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
	estado varchar(100) NOT NULL,
	forma_pago varchar(100) NOT NULL,
	hora_pago varchar(100) NOT NULL,
	valor_total integer NOT NULL, 
	cedula_cliente integer NOT NULL,
	id_pedido integer NOT NULL,
	FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido)
);



-- Insercion de datos

INSERT INTO empleado(id_empleado ,nombres ,apellidos ,cargo ,tel_fijo ,tel_cel ,Email ,direccion,tipo_documento ,contrase) VALUES(111,'Pepito','Perez','mesero','1234','4567','mesero@quehambre.com','cll5','cedula','111');
INSERT INTO empleado(id_empleado ,nombres ,apellidos ,cargo ,tel_fijo ,tel_cel ,Email ,direccion,tipo_documento ,contrase) VALUES(222,'Armando','Casas','cajero','1234','4567','cajero@quehambre.com','cll6','cedula','222');
INSERT INTO empleado(id_empleado ,nombres ,apellidos ,cargo ,tel_fijo ,tel_cel ,Email ,direccion,tipo_documento ,contrase) VALUES(333,'Pepa','Pig','gerente','1234','4567','gerenteo@quehambre.com','cll7','cedula','333');


INSERT INTO turnos_semanales (id_empleado ,turno) VALUES(111,'diurno-lunes');
INSERT INTO turnos_semanales (id_empleado ,turno) VALUES(111,'nocturno-martes');
INSERT INTO turnos_semanales (id_empleado ,turno) VALUES(222,'nocturno-jueves');
INSERT INTO turnos_semanales (id_empleado ,turno) VALUES(333,'diurno-viernes');


INSERT INTO item(id_item ,descripcion ,nombre ,categoria ,precio) VALUES(100,'rica-chuleta','chuleta-a-las-brasas','plato-fuerte',25000);
INSERT INTO item(id_item ,descripcion ,nombre ,categoria ,precio) VALUES(200,'rico-helado','helado-coco','postre',15000);
INSERT INTO item(id_item ,descripcion ,nombre ,categoria ,precio) VALUES(300,'rico-jugo','jugo-uva','bebida',9000);


INSERT INTO pedido(id_pedido ,hora_inicio ,hora_ultimo_item ,tipo ,num_mesa ,id_empleado) VALUES(1,'10:25','11:25','mesa','10',111);
INSERT INTO pedido(id_pedido ,hora_inicio ,hora_ultimo_item ,tipo ,num_mesa ,id_empleado) VALUES(2,'16:25','17:25','llevar','6',111);
INSERT INTO pedido(id_pedido ,hora_inicio ,tipo ,num_mesa ,id_empleado) VALUES(3,'14:25','mesa','11',111);
INSERT INTO pedido(id_pedido ,hora_inicio ,tipo ,num_mesa ,id_empleado) VALUES(4,'14:25','llevar','11',222);


INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(1,100,4);
INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(1,300,4);
INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(2,300,1);
INSERT INTO item_pedido(id_pedido ,id_item ,cantidad) VALUES(3,200,2);


INSERT INTO factura(id_factura ,estado ,forma_pago ,hora_pago ,valor_total ,cedula_cliente ,id_pedido) VALUES(1,'pagado','efectivo','1050',25000,13255,1);
INSERT INTO factura(id_factura ,estado ,forma_pago ,hora_pago ,valor_total ,cedula_cliente ,id_pedido) VALUES(2,'pagado','mixto','2350',9000,1758,2);
