/*** CRIAÇÃO DO BANCO DE DADOS ***/
DROP DATABASE  IF EXISTS db_zeroesjobs;
CREATE DATABASE db_zeroesjobs;
USE db_zeroesjobs;

/*** CRIAÇÃO DAS TABELAS ***/
CREATE TABLE usuario_tipo (
  usuario_tipo_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  usuario_tipo_nome varchar(255) DEFAULT NULL
) ENGINE=InnoDB;

INSERT INTO usuario_tipo VALUES (1,'Recrutador'),(2,'Candidato');

CREATE TABLE usuario (
  usuario_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email varchar(255) UNIQUE DEFAULT NULL,
  ativo bit(1) DEFAULT NULL,
  senha varchar(255) DEFAULT NULL,
  data_cadastro datetime(6) DEFAULT NULL,
  usuario_tipo_id int DEFAULT NULL,
  FOREIGN KEY (usuario_tipo_id) REFERENCES usuario_tipo (usuario_tipo_id)
) ENGINE=InnoDB;

CREATE TABLE empresa (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  logo varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE vaga_localidade (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cidade varchar(255) DEFAULT NULL,
  estado varchar(255) DEFAULT NULL,
  pais varchar(255) DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE vaga (
  vaga_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  descricao varchar(10000) DEFAULT NULL,
  titulo_vaga varchar(255) DEFAULT NULL,
  tipo_vaga varchar(255) DEFAULT NULL,
  data_publicada datetime(6) DEFAULT NULL,
  remota varchar(255) DEFAULT NULL,
  salario varchar(255) DEFAULT NULL,
  empresa_id int DEFAULT NULL,
  vaga_localidade_id int DEFAULT NULL,
  anunciante_id int DEFAULT NULL,
  FOREIGN KEY (vaga_localidade_id) REFERENCES vaga_localidade (id),
  FOREIGN KEY (anunciante_id) REFERENCES usuario (usuario_id),
  FOREIGN KEY (empresa_id) REFERENCES empresa (id)
) ENGINE=InnoDB;

CREATE TABLE candidato (
  usuario_conta_id int NOT NULL PRIMARY KEY,
  cidade varchar(255) DEFAULT NULL,
  estado varchar(255) DEFAULT NULL,
  pais varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  cpf varchar(255) DEFAULT NULL,
  sobrenome varchar(255) DEFAULT NULL,
  foto_perfil varchar(255) DEFAULT NULL,
  curriculo varchar(255) DEFAULT NULL,
  tipo_trabalho varchar(255) DEFAULT NULL,
  FOREIGN KEY (usuario_conta_id) REFERENCES usuario (usuario_id)
) ENGINE=InnoDB;

CREATE TABLE recrutador (
  usuario_conta_id int NOT NULL PRIMARY KEY,
  cidade varchar(255) DEFAULT NULL,
  estado varchar(255) DEFAULT NULL,
  pais varchar(255) DEFAULT NULL,
  empresa varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  sobrenome varchar(255) DEFAULT NULL,
  foto_perfil varchar(64) DEFAULT NULL,
  FOREIGN KEY (usuario_conta_id) REFERENCES usuario (usuario_id)
) ENGINE=InnoDB;

CREATE TABLE candidato_salvo (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  vaga int DEFAULT NULL UNIQUE,
  usuario_id int DEFAULT NULL UNIQUE,
  FOREIGN KEY (usuario_id) REFERENCES candidato (usuario_conta_id),
  FOREIGN KEY (vaga) REFERENCES vaga (vaga_id)
) ENGINE=InnoDB;

CREATE TABLE candidato_aplicacao (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  data_aplicacao datetime(6) DEFAULT NULL,
  carta_recomendacao varchar(255) DEFAULT NULL,
  vaga int DEFAULT NULL UNIQUE,
  usuario_id int DEFAULT NULL UNIQUE,
  FOREIGN KEY (vaga) REFERENCES vaga (vaga_id),
  FOREIGN KEY (usuario_id) REFERENCES candidato (usuario_conta_id)
) ENGINE=InnoDB;

CREATE TABLE competencias (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nivel_experiencia varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  anos_experiencia varchar(255) DEFAULT NULL,
  candidato int DEFAULT NULL,
  FOREIGN KEY (candidato) REFERENCES candidato (usuario_conta_id)
) ENGINE=InnoDB;