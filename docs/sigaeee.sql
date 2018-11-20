-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 20-Nov-2018 às 05:09
-- Versão do servidor: 5.7.23
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sigaeee`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `atleta`
--

DROP TABLE IF EXISTS `atleta`;
CREATE TABLE IF NOT EXISTS `atleta` (
  `id_atleta` int(11) NOT NULL AUTO_INCREMENT,
  `peso` float NOT NULL,
  `altura` float NOT NULL,
  `data_nascimento` varchar(10) NOT NULL,
  `posicao_id` int(11) DEFAULT NULL,
  `equipe_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id_atleta`),
  KEY `fk_atleta_posicao1_idx` (`posicao_id`),
  KEY `fk_atleta_equipe1_idx` (`equipe_id`),
  KEY `fk_atleta_usuario1_idx` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `atleta`
--

INSERT INTO `atleta` (`id_atleta`, `peso`, `altura`, `data_nascimento`, `posicao_id`, `equipe_id`, `usuario_id`) VALUES
(1, 90, 1.9, '01/01/1998', NULL, 7, 1),
(3, 0, 1, '0101011', NULL, 7, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `equipe`
--

DROP TABLE IF EXISTS `equipe`;
CREATE TABLE IF NOT EXISTS `equipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_gestor` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `playbook` varchar(255) DEFAULT NULL,
  `esporte_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_gestor` (`id_gestor`),
  KEY `fk_equipe_esporte1_idx` (`esporte_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `equipe`
--

INSERT INTO `equipe` (`id`, `id_gestor`, `nome`, `logo`, `playbook`, `esporte_id`) VALUES
(7, 1, 'CBF', 'https://seeklogo.com/images/C/CBF_Confederacao_Brasileira_de_Futebol-logo-82C966FA8B-seeklogo.com.png', 'https://conteudo.cbf.com.br/cdn/201803/20180321175553_0.pdf', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `esporte`
--

DROP TABLE IF EXISTS `esporte`;
CREATE TABLE IF NOT EXISTS `esporte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `esporte`
--

INSERT INTO `esporte` (`id`, `nome`) VALUES
(1, 'Futebol'),
(2, 'Handebol'),
(3, 'Volei'),
(4, 'Basquete'),
(6, 'Futebol Americano');

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento`
--

DROP TABLE IF EXISTS `evento`;
CREATE TABLE IF NOT EXISTS `evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `data` varchar(10) NOT NULL,
  `local` varchar(45) DEFAULT NULL,
  `tipo_evento_id` int(11) DEFAULT NULL,
  `equipe_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_evento_tipo_evento1_idx` (`tipo_evento_id`),
  KEY `fk_evento_equipe1_idx` (`equipe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `evento`
--

INSERT INTO `evento` (`id`, `nome`, `descricao`, `data`, `local`, `tipo_evento_id`, `equipe_id`) VALUES
(1, 'Jogo - CBF', 'Jogo Treino reserva vs titulares', '20/09/2018', NULL, 1, 7),
(2, 'Treino - CBF', 'Jogo Treino reserva vs titulares', '18/09/2018', 'Estadio Maracana', 1, 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `gestor`
--

DROP TABLE IF EXISTS `gestor`;
CREATE TABLE IF NOT EXISTS `gestor` (
  `id_gestor` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id_gestor`),
  KEY `fk_gestor_usuario1_idx` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `gestor`
--

INSERT INTO `gestor` (`id_gestor`, `usuario_id`) VALUES
(1, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `posicao`
--

DROP TABLE IF EXISTS `posicao`;
CREATE TABLE IF NOT EXISTS `posicao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `esporte_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_posicao_esporte1_idx` (`esporte_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_evento`
--

DROP TABLE IF EXISTS `tipo_evento`;
CREATE TABLE IF NOT EXISTS `tipo_evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tipo_evento`
--

INSERT INTO `tipo_evento` (`id`, `nome`) VALUES
(1, 'Treino'),
(2, 'Jogo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `tipo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `tipo`) VALUES
(1, 'jonathan', 'j@j.com', 'ashuhsauhu', 0),
(4, 'Jonathan', 'v@v.c', 'asuh', 0),
(6, 'Vitor', 'contato@gmail.com', 'test', 1);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `atleta`
--
ALTER TABLE `atleta`
  ADD CONSTRAINT `fk_atleta_equipe1` FOREIGN KEY (`equipe_id`) REFERENCES `equipe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_atleta_posicao1` FOREIGN KEY (`posicao_id`) REFERENCES `posicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_atleta_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `fk_equipe_esporte1` FOREIGN KEY (`esporte_id`) REFERENCES `esporte` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `fk_evento_equipe1` FOREIGN KEY (`equipe_id`) REFERENCES `equipe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_evento_tipo_evento1` FOREIGN KEY (`tipo_evento_id`) REFERENCES `tipo_evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `gestor`
--
ALTER TABLE `gestor`
  ADD CONSTRAINT `fk_gestor_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `posicao`
--
ALTER TABLE `posicao`
  ADD CONSTRAINT `fk_posicao_esporte1` FOREIGN KEY (`esporte_id`) REFERENCES `esporte` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
