create database Sistema_Citas_Dentales
go 

create table Consultorio
(Id_Consultorio int primary key identity(0,1),
Nombre_Consultorio varchar(80),
Dirección varchar(80), 
Correo varchar(80)
)

Create table Doctor
(Id_Doctor int primary key identity(0,1),
  Nombre varchar(50),
  Apellido varchar(50),
  Correo varchar(50),
  Número_Celular varchar(50),
  Especialidad varchar(50)
)

create table Paciente
 (Id_Paciente int primary key identity(0,1),
 Nombre varchar(50),
 Apellido varchar(50),
 Correo varchar(50),
 Teléfono int,
 Descripción varchar(100)
 )

 Create table Servicios
 (Id_Servicio int primary key identity(0,1),
  Descripción varchar(80),
  Duración int, /*Tiempo en meses*/
  Costo money,
  Tipo_Pago varchar(50)
 )
 Create table Servicio_Consulta
 (Id_Servicio_Consulta int primary key identity(0,1),
  Descripción varchar(80),
  Costo money,
  Tipo_Pago varchar(50)
 )

 Create table Pago_Contado
 ( IdPago_Contado int primary key identity(0,1),
   Id_Servicio int foreign key references Servicios(Id_Servicio),
   Id_Paciente int foreign key references Paciente(Id_Paciente),
   Total money,
   Fecha date
 )

 Create table Pago_Crédito
 (Id_Credito int primary key identity (0,1),
  Id_Servicio int foreign key references Servicios(Id_Servicio),
   Id_Paciente int foreign key references Paciente(Id_Paciente),
  Total_servicio int, 
  Monto_Abonado int,
  fecha date,Restante float
 )
  
  Create table Cita
  (Id_Cita int primary key identity (0,1),
     Id_Paciente int foreign key references Paciente(Id_Paciente),
   Id_Doctor int foreign key references Doctor(Id_Doctor),
    Id_Servicio int foreign key references Servicios(Id_Servicio),
	Fecha date,
	Hora time
  )
  Create table Consulta
  (Id_Consulta int primary key identity(0,1),
  Id_Paciente int foreign key references Paciente(Id_Paciente),
  Id_Doctor int foreign key references Doctor(Id_Doctor),
  Id_Servicio_Consulta int foreign key references Servicio_Consulta(Id_Servicio_Consulta),
  Descripción Varchar(100)
  )

  /*select*from Cita
  Insert into Doctor values ('Kelvin','Vargas','Kelvin@gmail.com', '67890059','Ortodoncia')
  insert into Paciente values ('Isabela','Useda','Isabela@gmail.com','59795236','Ligero Apiñamiento de dientes')
  Insert into Servicios values ('Valoracion','Horas','50', 'Contado')
  Insert into Cita values (0,0,0,'2019-06-15','14:30')
  insert into Pago_Contado values (0,0, '150','2019-06-15') */

 


  select c.Fecha, c.Hora, P.Nombre as Nombre_Cliente, d.Nombre as Nombre_Doctor, s.Descripción
  from cita c
  inner join Paciente P
  on P.Id_Paciente= c.Id_Paciente
  inner join Doctor D
  on d.Id_Doctor=c.Id_Doctor
  inner join Servicios s
  on s.Id_Servicio= c.Id_Servicio
  where Id_Cita = 2

  select PC.Fecha, P.Nombre as Nombre_Cliente, s.Descripción as Servicio, PC.Total
  from Pago_Contado PC
 inner join Paciente P
  on P.Id_Paciente= PC.Id_Paciente
  inner join Servicios s
  on s.Id_Servicio= PC.Id_Servicio
  where IdPago_Contado = 2
 
