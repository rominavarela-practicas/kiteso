DELIMITER //

DROP PROCEDURE IF EXISTS INSERT_CARRERA;
//

CREATE PROCEDURE INSERT_CARRERA(IN nombreCarrera VARCHAR(45),IN depaCarreras VARCHAR(45))
BEGIN

INSERT INTO Carrera (nombre_Carrera,depa_Carreras) VALUES (nombreCarrera,depaCarreras);

END
//



DROP PROCEDURE IF EXISTS GET_CARRERA;
//

CREATE PROCEDURE GET_CARRERA(IN id_Carreras INT)
BEGIN

SELECT * FROM Carrera WHERE idCarreras = id_Carreras;

END
//

DELIMITER ;