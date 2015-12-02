SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

​

-- -----------------------------------------------------

-- Schema Diseno_Software

-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `Diseno_Software` ;

​

-- -----------------------------------------------------

-- Schema Diseno_Software

-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `Diseno_Software` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE `Diseno_Software` ;

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Carrera`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Carrera` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Carrera` (

  `idCarreras` INT NOT NULL AUTO_INCREMENT,

  `nombre_Carrera` VARCHAR(45) NOT NULL,

  `depa_Carreras` VARCHAR(45) NULL,

  PRIMARY KEY (`idCarreras`) )

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Alumno`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Alumno` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Alumno` (

  `idAlumno` INT NOT NULL AUTO_INCREMENT,

  `nombre_Alumno` VARCHAR(45) NOT NULL,

  `apellido_Alumno` VARCHAR(45) NOT NULL,

  `correo_Alumno` VARCHAR(45) NOT NULL,

  `sexo_Alumno` BIT(1) NULL,

  `activo_Alumno` TINYINT(1) NOT NULL,

  PRIMARY KEY (`idAlumno`) )

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Alumno_Carrera`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Alumno_Carrera` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Alumno_Carrera` (

  `Alumno_idAlumno` INT NOT NULL,

  `Carrera_idCarreras` INT NOT NULL,

  PRIMARY KEY (`Alumno_idAlumno`, `Carrera_idCarreras`),

  INDEX `fk_Alumno_has_Carrera_Carrera1_idx` (`Carrera_idCarreras` ASC),

  INDEX `fk_Alumno_has_Carrera_Alumno_idx` (`Alumno_idAlumno` ASC),

  CONSTRAINT `fk_Alumno_has_Carrera_Alumno`

    FOREIGN KEY (`Alumno_idAlumno`)

    REFERENCES `Diseno_Software`.`Alumno` (`idAlumno`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Alumno_has_Carrera_Carrera1`

    FOREIGN KEY (`Carrera_idCarreras`)

    REFERENCES `Diseno_Software`.`Carrera` (`idCarreras`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Salon`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Salon` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Salon` (

  `idSalon` INT NOT NULL AUTO_INCREMENT,

  `nombre_Salon` VARCHAR(45) NOT NULL,

  PRIMARY KEY (`idSalon`) )

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Edificio`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Edificio` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Edificio` (

  `idEdificio` INT NOT NULL AUTO_INCREMENT,

  `nombre_Edificio` VARCHAR(45) NOT NULL,

  PRIMARY KEY (`idEdificio`) )

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Maestro`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Maestro` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Maestro` (

  `idMaestro` INT NOT NULL AUTO_INCREMENT,

  `nombre_Maestro` VARCHAR(45) NOT NULL,

  `apellido_Maestro` VARCHAR(45) NOT NULL,

  `correo_Maestro` VARCHAR(45) NOT NULL,

  `cubiculo_Maestro` VARCHAR(45) NOT NULL,

  `descripcion_Maestro` VARCHAR(300) NOT NULL,

  PRIMARY KEY (`idMaestro`) )

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Dia_de_semana`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Dia_de_semana` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Dia_de_semana` (

  `idDia` INT NOT NULL AUTO_INCREMENT,

  `nombre_Dia_de_semana` VARCHAR(45) NOT NULL,

  PRIMARY KEY (`idDia`) )

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Table7-9`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Table7-9` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Table7-9` (

  `idTable7-9` INT NOT NULL AUTO_INCREMENT,

  `Alumno_idAlumno` INT NOT NULL,

  `Salon_idSalon` INT NOT NULL,

  `Edificio_idEdificio` INT NOT NULL,

  `Maestro_idMaestro` INT NOT NULL,

  `Dia_de_semana_idDia` INT NOT NULL,

  PRIMARY KEY (`idTable7-9`, `Alumno_idAlumno`, `Salon_idSalon`, `Edificio_idEdificio`, `Maestro_idMaestro`, `Dia_de_semana_idDia`)  COMMENT '',

  INDEX `fk_Table7-9_Alumno1_idx` (`Alumno_idAlumno` ASC),

  INDEX `fk_Table7-9_Salon1_idx` (`Salon_idSalon` ASC) ,

  INDEX `fk_Table7-9_Edificio1_idx` (`Edificio_idEdificio` ASC) ,

  INDEX `fk_Table7-9_Maestro1_idx` (`Maestro_idMaestro` ASC) ,

  INDEX `fk_Table7-9_Dia_de_semana1_idx` (`Dia_de_semana_idDia` ASC) ,

  CONSTRAINT `fk_Table7-9_Alumno1`

    FOREIGN KEY (`Alumno_idAlumno`)

    REFERENCES `Diseno_Software`.`Alumno` (`idAlumno`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table7-9_Salon1`

    FOREIGN KEY (`Salon_idSalon`)

    REFERENCES `Diseno_Software`.`Salon` (`idSalon`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table7-9_Edificio1`

    FOREIGN KEY (`Edificio_idEdificio`)

    REFERENCES `Diseno_Software`.`Edificio` (`idEdificio`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table7-9_Maestro1`

    FOREIGN KEY (`Maestro_idMaestro`)

    REFERENCES `Diseno_Software`.`Maestro` (`idMaestro`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table7-9_Dia_de_semana1`

    FOREIGN KEY (`Dia_de_semana_idDia`)

    REFERENCES `Diseno_Software`.`Dia_de_semana` (`idDia`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Table9-11`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Table9-11` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Table9-11` (

  `idTable9-11` INT NOT NULL AUTO_INCREMENT ,

  `Alumno_idAlumno` INT NOT NULL ,

  `Salon_idSalon` INT NOT NULL ,

  `Edificio_idEdificio` INT NOT NULL,

  `Maestro_idMaestro` INT NOT NULL ,

  `Dia_de_semana_idDia` INT NOT NULL ,

  PRIMARY KEY (`idTable9-11`, `Alumno_idAlumno`, `Salon_idSalon`, `Edificio_idEdificio`, `Maestro_idMaestro`, `Dia_de_semana_idDia`)  COMMENT '',

  INDEX `fk_Table9-11_Alumno1_idx` (`Alumno_idAlumno` ASC),

  INDEX `fk_Table9-11_Salon1_idx` (`Salon_idSalon` ASC) ,

  INDEX `fk_Table9-11_Edificio1_idx` (`Edificio_idEdificio` ASC),

  INDEX `fk_Table9-11_Maestro1_idx` (`Maestro_idMaestro` ASC) ,

  INDEX `fk_Table9-11_Dia_de_semana1_idx` (`Dia_de_semana_idDia` ASC) ,

  CONSTRAINT `fk_Table9-11_Alumno1`

    FOREIGN KEY (`Alumno_idAlumno`)

    REFERENCES `Diseno_Software`.`Alumno` (`idAlumno`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table9-11_Salon1`

    FOREIGN KEY (`Salon_idSalon`)

    REFERENCES `Diseno_Software`.`Salon` (`idSalon`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table9-11_Edificio1`

    FOREIGN KEY (`Edificio_idEdificio`)

    REFERENCES `Diseno_Software`.`Edificio` (`idEdificio`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table9-11_Maestro1`

    FOREIGN KEY (`Maestro_idMaestro`)

    REFERENCES `Diseno_Software`.`Maestro` (`idMaestro`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table9-11_Dia_de_semana1`

    FOREIGN KEY (`Dia_de_semana_idDia`)

    REFERENCES `Diseno_Software`.`Dia_de_semana` (`idDia`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Table11-1`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Table11-1` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Table11-1` (

  `idTable11-1` INT NOT NULL AUTO_INCREMENT,

  `Alumno_idAlumno` INT NOT NULL ,

  `Salon_idSalon` INT NOT NULL ,

  `Edificio_idEdificio` INT NOT NULL ,

  `Maestro_idMaestro` INT NOT NULL ,

  `Dia_de_semana_idDia` INT NOT NULL,

  PRIMARY KEY (`idTable11-1`, `Alumno_idAlumno`, `Salon_idSalon`, `Edificio_idEdificio`, `Maestro_idMaestro`, `Dia_de_semana_idDia`)  COMMENT '',

  INDEX `fk_Table11-1_Alumno1_idx` (`Alumno_idAlumno` ASC) ,

  INDEX `fk_Table11-1_Salon1_idx` (`Salon_idSalon` ASC)  ,

  INDEX `fk_Table11-1_Edificio1_idx` (`Edificio_idEdificio` ASC) ,

  INDEX `fk_Table11-1_Maestro1_idx` (`Maestro_idMaestro` ASC),

  INDEX `fk_Table11-1_Dia_de_semana1_idx` (`Dia_de_semana_idDia` ASC) ,

  CONSTRAINT `fk_Table11-1_Alumno1`

    FOREIGN KEY (`Alumno_idAlumno`)

    REFERENCES `Diseno_Software`.`Alumno` (`idAlumno`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table11-1_Salon1`

    FOREIGN KEY (`Salon_idSalon`)

    REFERENCES `Diseno_Software`.`Salon` (`idSalon`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table11-1_Edificio1`

    FOREIGN KEY (`Edificio_idEdificio`)

    REFERENCES `Diseno_Software`.`Edificio` (`idEdificio`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table11-1_Maestro1`

    FOREIGN KEY (`Maestro_idMaestro`)

    REFERENCES `Diseno_Software`.`Maestro` (`idMaestro`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table11-1_Dia_de_semana1`

    FOREIGN KEY (`Dia_de_semana_idDia`)

    REFERENCES `Diseno_Software`.`Dia_de_semana` (`idDia`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Table1-3`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Table1-3` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Table1-3` (

  `idTable1-3` INT NOT NULL AUTO_INCREMENT,

  `Alumno_idAlumno` INT NOT NULL,

  `Salon_idSalon` INT NOT NULL,

  `Edificio_idEdificio` INT NOT NULL,

  `Maestro_idMaestro` INT NOT NULL,

  `Dia_de_semana_idDia` INT NOT NULL,

  PRIMARY KEY (`idTable1-3`, `Alumno_idAlumno`, `Salon_idSalon`, `Edificio_idEdificio`, `Maestro_idMaestro`, `Dia_de_semana_idDia`)  COMMENT '',

  INDEX `fk_Table1-3_Alumno1_idx` (`Alumno_idAlumno` ASC),

  INDEX `fk_Table1-3_Salon1_idx` (`Salon_idSalon` ASC),

  INDEX `fk_Table1-3_Edificio1_idx` (`Edificio_idEdificio` ASC),

  INDEX `fk_Table1-3_Maestro1_idx` (`Maestro_idMaestro` ASC),

  INDEX `fk_Table1-3_Dia_de_semana1_idx` (`Dia_de_semana_idDia` ASC),

  CONSTRAINT `fk_Table1-3_Alumno1`

    FOREIGN KEY (`Alumno_idAlumno`)

    REFERENCES `Diseno_Software`.`Alumno` (`idAlumno`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table1-3_Salon1`

    FOREIGN KEY (`Salon_idSalon`)

    REFERENCES `Diseno_Software`.`Salon` (`idSalon`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table1-3_Edificio1`

    FOREIGN KEY (`Edificio_idEdificio`)

    REFERENCES `Diseno_Software`.`Edificio` (`idEdificio`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table1-3_Maestro1`

    FOREIGN KEY (`Maestro_idMaestro`)

    REFERENCES `Diseno_Software`.`Maestro` (`idMaestro`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table1-3_Dia_de_semana1`

    FOREIGN KEY (`Dia_de_semana_idDia`)

    REFERENCES `Diseno_Software`.`Dia_de_semana` (`idDia`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Table4-6`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Table4-6` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Table4-6` (

  `idTable4-6` INT NOT NULL AUTO_INCREMENT,

  `Alumno_idAlumno` INT NOT NULL,

  `Salon_idSalon` INT NOT NULL,

  `Edificio_idEdificio` INT NOT NULL,

  `Maestro_idMaestro` INT NOT NULL,

  `Dia_de_semana_idDia` INT NOT NULL ,

  PRIMARY KEY (`idTable4-6`, `Alumno_idAlumno`, `Salon_idSalon`, `Edificio_idEdificio`, `Maestro_idMaestro`, `Dia_de_semana_idDia`)  COMMENT '',

  INDEX `fk_Table4-6_Alumno1_idx` (`Alumno_idAlumno` ASC) ,

  INDEX `fk_Table4-6_Salon1_idx` (`Salon_idSalon` ASC),

  INDEX `fk_Table4-6_Edificio1_idx` (`Edificio_idEdificio` ASC),

  INDEX `fk_Table4-6_Maestro1_idx` (`Maestro_idMaestro` ASC) ,

  INDEX `fk_Table4-6_Dia_de_semana1_idx` (`Dia_de_semana_idDia` ASC),

  CONSTRAINT `fk_Table4-6_Alumno1`

    FOREIGN KEY (`Alumno_idAlumno`)

    REFERENCES `Diseno_Software`.`Alumno` (`idAlumno`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table4-6_Salon1`

    FOREIGN KEY (`Salon_idSalon`)

    REFERENCES `Diseno_Software`.`Salon` (`idSalon`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table4-6_Edificio1`

    FOREIGN KEY (`Edificio_idEdificio`)

    REFERENCES `Diseno_Software`.`Edificio` (`idEdificio`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table4-6_Maestro1`

    FOREIGN KEY (`Maestro_idMaestro`)

    REFERENCES `Diseno_Software`.`Maestro` (`idMaestro`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table4-6_Dia_de_semana1`

    FOREIGN KEY (`Dia_de_semana_idDia`)

    REFERENCES `Diseno_Software`.`Dia_de_semana` (`idDia`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Table6-8`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Table6-8` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Table6-8` (

  `idTable6-8` INT NOT NULL AUTO_INCREMENT,

  `Alumno_idAlumno` INT NOT NULL,

  `Salon_idSalon` INT NOT NULL ,

  `Edificio_idEdificio` INT NOT NULL ,

  `Maestro_idMaestro` INT NOT NULL ,

  `Dia_de_semana_idDia` INT NOT NULL ,

  PRIMARY KEY (`idTable6-8`, `Alumno_idAlumno`, `Salon_idSalon`, `Edificio_idEdificio`, `Maestro_idMaestro`, `Dia_de_semana_idDia`)  COMMENT '',

  INDEX `fk_Table6-8_Alumno1_idx` (`Alumno_idAlumno` ASC) ,

  INDEX `fk_Table6-8_Salon1_idx` (`Salon_idSalon` ASC)  ,

  INDEX `fk_Table6-8_Edificio1_idx` (`Edificio_idEdificio` ASC) ,

  INDEX `fk_Table6-8_Maestro1_idx` (`Maestro_idMaestro` ASC) ,

  INDEX `fk_Table6-8_Dia_de_semana1_idx` (`Dia_de_semana_idDia` ASC)  ,

  CONSTRAINT `fk_Table6-8_Alumno1`

    FOREIGN KEY (`Alumno_idAlumno`)

    REFERENCES `Diseno_Software`.`Alumno` (`idAlumno`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table6-8_Salon1`

    FOREIGN KEY (`Salon_idSalon`)

    REFERENCES `Diseno_Software`.`Salon` (`idSalon`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table6-8_Edificio1`

    FOREIGN KEY (`Edificio_idEdificio`)

    REFERENCES `Diseno_Software`.`Edificio` (`idEdificio`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table6-8_Maestro1`

    FOREIGN KEY (`Maestro_idMaestro`)

    REFERENCES `Diseno_Software`.`Maestro` (`idMaestro`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table6-8_Dia_de_semana1`

    FOREIGN KEY (`Dia_de_semana_idDia`)

    REFERENCES `Diseno_Software`.`Dia_de_semana` (`idDia`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;

​

​

-- -----------------------------------------------------

-- Table `Diseno_Software`.`Table8-10`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `Diseno_Software`.`Table8-10` ;

​

CREATE TABLE IF NOT EXISTS `Diseno_Software`.`Table8-10` (

  `idTable8-10` INT NOT NULL AUTO_INCREMENT ,

  `Alumno_idAlumno` INT NOT NULL ,

  `Salon_idSalon` INT NOT NULL ,

  `Edificio_idEdificio` INT NOT NULL ,

  `Maestro_idMaestro` INT NOT NULL ,

  `Dia_de_semana_idDia` INT NOT NULL ,

  PRIMARY KEY (`idTable8-10`, `Alumno_idAlumno`, `Salon_idSalon`, `Edificio_idEdificio`, `Maestro_idMaestro`, `Dia_de_semana_idDia`)  COMMENT '',

  INDEX `fk_Table8-10_Alumno1_idx` (`Alumno_idAlumno` ASC) ,

  INDEX `fk_Table8-10_Salon1_idx` (`Salon_idSalon` ASC),

  INDEX `fk_Table8-10_Edificio1_idx` (`Edificio_idEdificio` ASC) ,

  INDEX `fk_Table8-10_Maestro1_idx` (`Maestro_idMaestro` ASC)  ,

  INDEX `fk_Table8-10_Dia_de_semana1_idx` (`Dia_de_semana_idDia` ASC)  ,

  CONSTRAINT `fk_Table8-10_Alumno1`

    FOREIGN KEY (`Alumno_idAlumno`)

    REFERENCES `Diseno_Software`.`Alumno` (`idAlumno`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table8-10_Salon1`

    FOREIGN KEY (`Salon_idSalon`)

    REFERENCES `Diseno_Software`.`Salon` (`idSalon`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table8-10_Edificio1`

    FOREIGN KEY (`Edificio_idEdificio`)

    REFERENCES `Diseno_Software`.`Edificio` (`idEdificio`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table8-10_Maestro1`

    FOREIGN KEY (`Maestro_idMaestro`)

    REFERENCES `Diseno_Software`.`Maestro` (`idMaestro`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Table8-10_Dia_de_semana1`

    FOREIGN KEY (`Dia_de_semana_idDia`)

    REFERENCES `Diseno_Software`.`Dia_de_semana` (`idDia`)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;

​

​

SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
