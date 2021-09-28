insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into libro(titulo, categoria, distribucion, disponibles, precio) values ('Titulo', 'Literatura', 'Internacional', 3, 45000);

insert into compra(libroId, cantidad) values (1, 3);

insert into factura(precioFinal) values (50000);