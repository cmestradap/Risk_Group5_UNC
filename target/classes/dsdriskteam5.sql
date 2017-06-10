/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  alejandro
 * Created: 5/06/2017
 */
-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2017 a las 18:31:27
-- Versión del servidor: 10.1.22-MariaDB
-- Versión de PHP: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dsd-risk`
--

-- --------------------------------------------------------
CREATE TABLE `card` (
  `id` varchar(20) NOT NULL,
  `design` varchar(20) DEFAULT NULL,
  `owner` varchar(20) NOT NULL,
  `type` varchar(20) DEFAULT NULL
  
);


CREATE TABLE `player` (
  `turn` varchar(20) NOT NULL,
  `playing` varchar(20) DEFAULT NULL,
  `color` varchar(20) NOT NULL,
  `capturestate` varchar(20) DEFAULT NULL
  `territory_amount` varchar(20) DEFAULT NULL
  `continent_amount` varchar(20) DEFAULT NULL
  `card_amount` varchar(20) DEFAULT NULL
  
);
--
-- Estructura de tabla para la tabla `continent`
--

CREATE TABLE `continent` (
  `map` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `owner` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `continent`
--

INSERT INTO `continent` (`map`, `name`, `owner`) VALUES
('Clasic', 'AMEROKI', 'NULL'),
('Clasic', 'AZIO', 'NULL'),
('Clasic', 'AFROKI', 'NULL'),
('Clasic', 'AMERPOLU', 'NULL'),
('Clasic', 'UIROPA', 'NULL'),
('Clasic', 'UISTRALIA', 'NULL');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `map`
--

CREATE TABLE `map` (
  `map` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `map`
--

INSERT INTO `map` (`map`) VALUES
('Clasic');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `session`
--

CREATE TABLE `session` (
  `id` int(20) NOT NULL,
  `state` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  `map` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `territory`
--

CREATE TABLE `territory` (
  `name` varchar(20) NOT NULL,
  `owner` varchar(20) DEFAULT NULL,
  `continent` varchar(20) NOT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `territory`
--

INSERT INTO `territory` (`name`, `owner`, `continent`, `type`) VALUES
('OEKRAINË', 'NULL', 'UIROPA', 'NULL'),
('IJSLAND', 'NULL', 'UIROPA', 'NULL'),
('SCANDINAVIË', 'NULL', 'UIROPA', 'NULL'),
('WEST-EUROPA', 'NULL', 'UIROPA', 'NULL'),
('GROOT-BRITTANIË', 'NULL', 'UIROPA', 'NULL'),
('ZUID-EUROPA', 'NULL', 'UIROPA', 'NULL'),
('NOORD-EUROPA', 'NULL', 'UIROPA', 'NULL'),
('VARENIGDE-STATEM(OOST)', 'NULL', 'AMEROKI', 'NULL'),
('VARENIGDE-STATEM(WEST)', 'NULL', 'AMEROKI', 'NULL'),
('NORTHWEST-TERRITORIES', 'NULLE', 'AMEROKI', 'NULL'),
('ALBERTA', 'NULL', 'AMEROKI', 'NULL'),
('MIDDEN-AMERIKA', 'NULL', 'AMEROKI', 'NULL'),
('ALASKA', 'NULL', 'AMEROKI', 'NULL'),
('ONTARIO', 'NULL', 'AMEROKI', 'NULL'),
('QUEBEC', 'NULL', 'AMEROKI', 'NULL'),
('GROENLAND', 'NULL', 'AMEROKI', 'NULL'),
('SIBERIË', 'NULL', 'AZIO', 'NULL'),
('IRKOETSK', 'NULL', 'AZIO', 'NULL'),
('INDIA', 'NULL', 'AZIO', 'NULL'),
('JAPON', 'NULL', 'AZIO', 'NULL'),
('JAKOETSK', 'NULL', 'AZIO', 'NULL'),
('MONGOLOË', 'NULL', 'AZIO', 'NULL'),
('CHINA', 'NULL', 'AZIO', 'NULL'),
('MIDDEN-OOSTEN', 'NULL', 'AZIO', 'NULL'),
('ZEIDOOST-AZIË', 'NULL', 'AZIO', 'NULL'),
('KAMTAJARKA', 'NULL', 'AZIO', 'NULL'),
('AFGHANISTAN', 'NULL', 'AZIO', 'NULL'),
('OERAL', 'NULL', 'AZIO', 'NULL'),
('NIEUW-GUINEA', 'NULL', 'UISTRALIA', 'NULL'),
('INDONESIË', 'NULL', 'UISTRALIA', 'NULL'),
('WEST-AUSTRALIË', 'NULL', 'UISTRALIA', 'NULL'),
('OOST-AUSTRALIË', 'NULL', 'UISTRALIA', 'NULL'),
('ZUID-AFRIKA', 'NULL', 'AFROKI', 'NULL'),
('CENTRAAL-AFRIKA', 'NULL', 'AFROKI', 'NULL'),
('OOST-AFRIKA', 'NULL', 'AFROKI', 'NULL'),
('NOORD-AFRIKA', 'NULL', 'AFROKI', 'NULL'),
('EGYPTE', 'NULL', 'AFROKI', 'NULL'),
('MADAGASCAR', 'NULL', 'AFROKI', 'NULL'),
('BRASILIË', 'NULL', 'AMERPOLU', 'NULL'),
('PERU', 'NULL', 'AMERPOLU', 'NULL'),
('VENEZUELA', 'NULL', 'AMERPOLU', 'NULL'),
('ARGENTINË', 'NULL', 'AMERPOLU', 'NULL');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `continent`
--
ALTER TABLE `continent`
  ADD PRIMARY KEY (`map`,`name`);

--
-- Indices de la tabla `map`
--
ALTER TABLE `map`
  ADD PRIMARY KEY (`map`);

--
-- Indices de la tabla `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`id`),
  ADD KEY `map` (`map`);

--
-- Indices de la tabla `territory`
--
ALTER TABLE `territory`
  ADD PRIMARY KEY (`name`,`continent`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `continent`
--
ALTER TABLE `continent`
  ADD CONSTRAINT `continent_ibfk_1` FOREIGN KEY (`map`) REFERENCES `map` (`map`);

--
-- Filtros para la tabla `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `session_ibfk_1` FOREIGN KEY (`map`) REFERENCES `map` (`map`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
