-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema catalogodeherois
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema catalogodeherois
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `catalogodeherois` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `catalogodeherois` ;

-- -----------------------------------------------------
-- Table `catalogodeherois`.`heroi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalogodeherois`.`heroi` (
  `id_heroi` INT NOT NULL,
  `descricao` VARCHAR(50) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_heroi`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `catalogodeherois`.`poder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalogodeherois`.`poder` (
  `id_heroi` INT NOT NULL,
  `poder` VARCHAR(45) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
