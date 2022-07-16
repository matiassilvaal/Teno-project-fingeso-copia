-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-07-2022 a las 04:43:15
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbfingeso`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denounces`
--

CREATE TABLE `denounces` (
  `id` int(11) NOT NULL,
  `iddenunciante` int(11) NOT NULL,
  `iddenounced` int(11) NOT NULL,
  `idfiscal` int(11) NOT NULL,
  `description` text NOT NULL,
  `security` text DEFAULT NULL,
  `state` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `denounces`
--

INSERT INTO `denounces` (`id`, `iddenunciante`, `iddenounced`, `idfiscal`, `description`, `security`, `state`) VALUES
(0, 0, 4, 2, 'me sentí menospreciado por mi genero en su clase', NULL, 'en curso'),
(1, 4, 5, 2, 'me sentí menospreciado por mi genero en su clase', '', 'finalizado'),
(2, 5, 3, 2, 'me aparto del grupo de trabajo y su excusa era que por mi raza era flojo y poco trabajador', 'pido que se le cambie de seccion', 'en curso'),
(3, 0, 5, 1, 'recibí una agresión física solo por haber dado mi opinión sobre un tema', 'quiero que le prohíban acercarse a mi ', 'finalizado'),
(4, 3, 5, -1, 'esta entrando al baño de estudiantes de su genero opuesto', '', 'ingresado'),
(5, 4, 0, 1, 'dijo que las mujeres no deberíamos estudiar ingeniería ', 'que no pueda seguir dando clases', 'en curso'),
(6, 5, 0, 2, 'me pregunto en que nivel estaba de manera burlona en medio de una prueba', '', 'finalizado'),
(7, 0, 3, 1, 'se burlo de un asistente del aseo, denigrándola por su trabajo', '', 'finalizado'),
(8, 5, 4, 2, 'estaba agarrando partes intimas a los alumnos sin su consentimiento', '', 'finalizado'),
(9, 5, 3, 1, 'estaba sacando fotos en los baños de mujeres', '', 'en curso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `correo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='representa toda la información relacionada a un usuario';

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `correo`) VALUES
(0, 'alex.pacheco@usach.cl'),
(1, 'catalina.olivares@usach.cl'),
(2, 'matias.silva@usach.cl'),
(3, 'francisco.salfate.ga@usach.cl'),
(4, 'andres.ijurra@usach.cl');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `denounces`
--
ALTER TABLE `denounces`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD UNIQUE KEY `mail` (`correo`) USING HASH,
  ADD KEY `id` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
