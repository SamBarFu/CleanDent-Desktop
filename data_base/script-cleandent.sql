
/*drop database clean_dent*/

create database clean_dent;

use clean_dent;

create table tipo_usuario(
id_tipo_usuario int primary key not null auto_increment,
nombre varchar(20) not null
);

create table usuario(
id_usuario int primary key not null auto_increment,
usuario varchar(20) not null,
contrasena varchar(20) not null,
correo varchar(120) not null,
last_session datetime,
estado boolean, 
id_tipo_usuario int not null,
foreign key (id_tipo_usuario) references tipo_usuario(id_tipo_usuario)
);

create table empleado(
id_empleado int primary key not null auto_increment,
cedula varchar(16),
primer_nombre varchar(50) not null,
segundo_nombre varchar(50) default null,
primer_apellido varchar(50) not null,
segundo_apellido varchar(50) default null,
foto varchar(100) null,
telefono varchar(15) not null, 
fecha_nacimiento date,
genero char(1),
estado boolean,
id_usuario int not null,
foreign key (id_usuario) references usuario(id_usuario)
);

create table especialidad(
id_especialidad int primary key not null auto_increment,
nombre varchar(50)
);

create table doctor(
id_doctor int primary key not null auto_increment,
cedula varchar(16),
primer_nombre varchar(50) not null,
segundo_nombre varchar(50) default null,
primer_apellido varchar(50) not null,
segundo_apellido varchar(50) default null,
foto varchar(100) null,
telefono varchar(15) not null, 
fecha_nacimiento date,
genero char(1),
estado boolean,
id_usuario int not null,
foreign key (id_usuario) references usuario(id_usuario)
);

create table doctor_especialidad(
id_doctor_especialidad int primary key not null auto_increment,
id_doctor int not null,
id_especialidad int not null,
foreign key (id_doctor) references doctor(id_doctor),
foreign key (id_especialidad) references especialidad(id_especialidad)
);

create table paciente (
id_paciente int primary key not null auto_increment, 
cedula varchar(16),
primer_nombre varchar(50) not null,
segundo_nombre varchar(50) default null,
primer_apellido varchar(50) not null,
segundo_apellido varchar(50) default null,
telefono varchar(15) not null, 
fecha_nacimiento date,
genero char(1),
estado boolean
);

create table expediente(
id_expediente int primary key not null auto_increment,
id_paciente int not null,
foreign key (id_paciente) references paciente(id_paciente)
);

Create table servicio(
id_servicio int primary key not null auto_increment,
nombre varchar(80),
descripcion varchar(150),
precio double
);

create table tratamiento(
id_tratamiento int primary key not null auto_increment,
id_servicio int not null,
duracion int, /* duración en meses */
foreign key (id_servicio) references servicio(id_servicio)
);

create table promocion(
id_promocion int primary key not null auto_increment,
nombre varchar(20),
descripcion varchar(150),
fecha_inicio date,
fecha_fin date
);

create table servicio_promocion(
id_servicio_promocion int primary key not null auto_increment,
id_servicio int not null,
id_promocion int not null,
monto double,
foreign key (id_servicio) references servicio(id_servicio),
foreign key (id_promocion) references promocion(id_promocion)
);

create table tratamiento_paciente(
id_tratamiento_paciente int primary key not null auto_increment,
id_expediente int not null,
id_tratamiento int not null, 
fecha_inicio date,
fecha_fin date,
evaluacion varchar(254),
last_update datetime,
foreign key (id_expediente) references expediente(id_expediente),
foreign key (id_tratamiento) references tratamiento(id_tratamiento)
);

create table diente(
id_diente int primary key not null auto_increment,
numero_diente int,
nombre varchar(20), 
posicion varchar(50)
);

create table manifestacion(
id_manifestacion int primary key not null auto_increment,
nombre varchar(50),
descripcion varchar(254)
);

create table odontograma(
id_odontograma int primary key not null auto_increment,
id_expediente int not null,
foreign key (id_expediente) references expediente(id_expediente)
);

create table detalle_odontograma(
id_detalle_odontograma int primary key not null auto_increment,
id_diente int not null,
id_manifestacion int not null,
id_odontograma int not null,
fecha datetime,
foreign key (id_diente) references diente(id_diente),
foreign key (id_manifestacion) references manifestacion(id_manifestacion),
foreign key (id_odontograma) references odontograma(id_odontograma)
);

create table cita(
id_cita int primary key not null auto_increment,
id_paciente int not null,
id_empleado int not null,
fecha datetime,
fecha_cita datetime,
estado varchar(20),
foreign key (id_paciente) references paciente(id_paciente),
foreign key (id_empleado) references empleado(id_empleado)
);

create table consulta(
id_consulta int primary key not null auto_increment,
id_cita int not null,
id_doctor int not null,
fecha datetime,
observacion varchar(254),
diagnostico varchar(254),
foreign key (id_cita) references cita(id_cita),
foreign key (id_doctor) references doctor(id_doctor)
);

create table factura(
id_factura int primary key not null auto_increment,
id_consulta int not null,
fecha datetime,
foreign key (id_consulta) references consulta(id_consulta)
);

create table detalle_factura(
id_detalle_factura int primary key not null auto_increment,
id_factura int not null,
id_servicio int not null,
foreign key (id_factura) references factura(id_factura),
foreign key (id_servicio) references servicio(id_servicio)
);


