use clean_dent;

INSERT INTO `clean_dent`.`diente`
(`numero_diente`,
`nombre`)
VALUES
(11,"incisivo central"),
(12,"incisivo lateral"),
(13,"canino"),
(14,"primer premolar"),
(15,"segundo premolar"),
(16,"primer molar"),
(17,"segundo molar"),
(18,"tercer molar"),
(21,"incisivo central"),
(22,"incisivo lateral"),
(23,"canino"),
(24,"primer premolar"),
(25,"segundo premolar"),
(26,"primer molar"),
(27,"segundo molar"),
(28,"tercer molar"),
(31,"incisivo central"),
(32,"incisivo lateral"),
(33,"canino"),
(34,"primer premolar"),
(35,"segundo premolar"),
(36,"primer molar"),
(37,"segundo molar"),
(38,"tercer molar"),
(41,"incisivo central"),
(42,"incisivo lateral"),
(43,"canino"),
(44,"primer premolar"),
(45,"segundo premolar"),
(46,"primer molar"),
(47,"segundo molar"),
(48,"tercer molar");

select * from diente;

INSERT INTO `clean_dent`.`manifestacion`
(`nombre`,
`descripcion`)
VALUES
("Caries","Disolución del componente orgánico y la desmineralizacióndel componente inorgánico de los tejidos duros del diente"),
("Diente ausente",""),
("Diente a extraer",""),
("Obturación",""),
("Corona",""),
("Tramo",""),
("Estracción indicada",""),
("Diastema",""),
("Sano","");

select * from manifestacion;

INSERT INTO `clean_dent`.`especialidad`
(`nombre`)
VALUES
("Rehabilitación oral"),
("Periodoncia"),
("Endodoncia"),
("Odontopediatría"),
("Ortodoncia"),
("Odontología estetica"),
("Odontología forense"),
("Odontología preventiva"),
("Cariología");

select * from especialidad;

INSERT INTO `clean_dent`.`servicio`
(`nombre`,
`descripcion`,
`precio`)
VALUES
("Rehabilitación protestíca","",0),
("Implantes dentales","",0),
("Endodoncia","",0),
("Ortodoncia","",0),
("Periodoncia","",0),
("Odontopediatría","",0),
("Odontología estética","",0),
("Odontología restaurativa","",0),
("Cirugía oral y maxifacial","",0);

select * from servicio;

INSERT INTO `clean_dent`.`paciente`
(`cedula`,
`primer_nombre`,
`segundo_nombre`,
`primer_apellido`,
`segundo_apellido`,
`telefono`,
`fecha_nacimiento`,
`genero`,
`estado`)
VALUES
("001-110599-1003B","Samuel","Mohasir","Barberena","Fuentes","86459488",STR_TO_DATE('10.31.2003' ,GET_FORMAT(date,'USA')),'M',1);

select * from paciente;

INSERT INTO `clean_dent`.`expediente`
(`id_paciente`)
VALUES
(1);

select * from expediente;

INSERT INTO `clean_dent`.`odontograma`
(`id_expediente`)
VALUES
(1);

select * from odontograma;

INSERT INTO `clean_dent`.`detalle_odontograma`
(`id_diente`,
`id_manifestacion`,
`id_odontograma`,
`fecha`)
VALUES
/*(1,9,1,now()),*/
(2,9,1,now()),
(3,9,1,now()),
(4,9,1,now()),
(5,1,1,now()),
(6,9,1,now()),
(7,9,1,now()),
(8,9,1,now()),
(9,1,1,now()),
(10,9,1,now()),
(10,9,1,now()),
(12,9,1,now()),
(13,5,1,now()),
(14,9,1,now()),
(15,9,1,now()),
(16,9,1,now()),
(17,9,1,now()),
(18,9,1,now()),
(19,1,1,now()),
(20,9,1,now()),
(21,9,1,now()),
(22,9,1,now()),
(23,9,1,now()),
(24,9,1,now()),
(25,9,1,now()),
(26,9,1,now()),
(27,9,1,now()),
(28,9,1,now()),
(29,9,1,now()),
(30,9,1,now()),
(31,9,1,now()),
(32,9,1,now());

select * from diente;
select * from manifestacion;
select * from detalle_odontograma;

select d.nombre, d.numero_diente, m.nombre from detalle_odontograma deo
inner join odontograma o on o.id_odontograma=deo.id_odontograma
inner join expediente e on e.id_expediente=o.id_expediente
inner join paciente p on p.id_paciente=e.id_paciente
inner join diente d on deo.id_diente=d.id_diente
inner join manifestacion m on deo.id_manifestacion=m.id_manifestacion
where p.cedula = "001-110599-1003B";

INSERT INTO `clean_dent`.`rol`
(`nombre`)
VALUES
("Gerente"),
("Doctor"),
("Recepcionista");

select * from rol;

INSERT INTO `clean_dent`.`empleado`
(`cedula`,
`primer_nombre`,
`segundo_nombre`,
`primer_apellido`,
`segundo_apellido`,
`foto`,
`telefono`,
`correo`,
`fecha_nacimiento`,
`genero`,
`id_rol`,
`estado`)
VALUES
("001-020578-1542R","Fanor","","Rivera","","./","86547689","drfanorrivera@gmail.com",STR_TO_DATE('02.05.78' ,GET_FORMAT(date,'USA')),'M',2,1);

select * from empleado;

INSERT INTO `clean_dent`.`doctor`
(`id_empleado`)
VALUES
(1);

select * from doctor;

INSERT INTO `clean_dent`.`doctor_especialidad`
(`id_doctor`,
`id_especialidad`)
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,7),
(1,8),
(1,9);

select * from especialidad;
select * from doctor_especialidad;

INSERT INTO `clean_dent`.`usuario`
(`id_empleado`,
`usuario`,
`contrasena`,
`last_session`,
`estado`)
VALUES
(1,"fanorR","123456",now(),1);

select * from usuario;








