-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-06-2017 a las 23:30:26
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cotxox`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conductor`
--

CREATE TABLE `conductor` (
  `user` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `foto` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `libre` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `conductor`
--

INSERT INTO `conductor` (`user`, `password`, `nombre`, `apellidos`, `foto`, `libre`) VALUES
('Michi25', 'MK1234567890_mk', 'Michi', 'Kurokami', '../../img/conductores/Michi25/', 1),
('Mikechi150', 'MT1234567890_mk', 'Mike', 'Tanpopo', '../../img/conductores/Mikechi1', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nickname` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidos` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `foto` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nickname`, `password`, `nombre`, `apellidos`, `email`, `telefono`, `foto`) VALUES
('miau100', 'miaumiau', 'Mike', 'mimo', 'miau@miau.mi', '123456789', ':)'),
('miau101', 'miaumiau', 'mimi', 'mimo', 'miau@miau.mi', '123456789', ':)');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `conductor`
--
ALTER TABLE `conductor`
  ADD PRIMARY KEY (`user`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nickname`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
