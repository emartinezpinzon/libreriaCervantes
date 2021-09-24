create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table libro (
 id int(11) not null auto_increment,
 titulo varchar(100) not null,
 categoria varchar(100) not null,
 distribucion varchar(40) not null,
 disponibles int(10) not null,
 precio double(10) not null,

 primary key (id)
);

create table compra (
  id int(11) not null auto_increment,
  libroId int(11) null,
  cantidad int(11) null,
  fechaEntrega datetime null,

  primary key (id),
  foreign key (libroId) references libro (id)
);
