DELIMITER //

DROP PROCEDURE IF EXISTS GET_USER;
//

CREATE PROCEDURE GET_USER(IN email VARCHAR(45))
BEGIN

DECLARE idAlumno INT;
DECLARE idCarrera INT;

SELECT * FROM Alumno WHERE correo_Alumno = email;
SELECT idAlumno FROM Alumno WHERE correo_Alumno = email INTO idAlumno;
SELECT Carrera_idCarreras FROM Alumno_Carrera WHERE Alumno_idAlumno = idAlumno INTO idCarrera;
SELECT nombre_Carrera FROM Carrera WHERE idCarreras = idCarrera;

END
//



DROP PROCEDURE IF EXISTS INSERT_USER;
//

CREATE PROCEDURE INSERT_USER(IN nombre VARCHAR(45),IN apellido VARCHAR(45),IN correo VARCHAR(45),IN sexo BIT(1),IN Carrera VARCHAR(45))
BEGIN

DECLARE idCarrera INT;
DECLARE idAlumno INT;

INSERT INTO Alumno (nombre_Alumno, apellido_Alumno, correo_Alumno,sexo_Alumno,activo_Alumno)SELECT nombre, apellido, correo,sexo,1 FROM Alumno WHERE NOT EXISTS ( SELECT * FROM Alumno WHERE correo_Alumno = correo);
SELECT idCarreras FROM Carrera WHERE nombre_Carrera = Carrera INTO idCarrera;
SELECT idAlumno FROM Alumno WHERE correo_Alumno = correo INTO idAlumno;
INSERT INTO Alumno_Carrera (Alumno_idAlumno,Carrera_idCarreras) VALUES (idAlumno,idCarrera);

END
//



DROP PROCEDURE IF EXISTS UNSUBSCRIBE_USER;
//

CREATE PROCEDURE UNSUBSCRIBE_USER(IN idUsuario INT)
BEGIN

UPDATE Alumno SET activo_Alumno = 0 WHERE idAlumno = idUsuario;

END
//



DROP PROCEDURE IF EXISTS UPDATE_USER;
//

CREATE PROCEDURE UPDATE_USER(IN idUsuario INT, IN nombre VARCHAR(45),IN apellido VARCHAR(45),IN correo VARCHAR(45),IN sexo BIT(1))

BEGIN

UPDATE Alumno SET nombre_Alumno=nombre,apellido_Alumno = apellido, correo_Alumno = correo, sexo_Alumno = sexo WHERE idAlumno = idUsuario;

END
//

DELIMITER ;
