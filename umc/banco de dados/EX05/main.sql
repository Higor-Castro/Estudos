CREATE DATABASE gerenciador_tarefas;
 
USE gerenciador_tarefas ;

CREATE TABLE IF NOT EXISTS tarefa (
  `id_tarefa` INT AUTO_INCREMENT,
  `Funcao` VARCHAR(50),
  `carga_horaria` VARCHAR(5),
  `setor` VARCHAR(100),
  PRIMARY KEY (`id_tarefa`)
);
 
CREATE TABLE IF NOT EXISTS setor (
  `id_setor` INT AUTO_INCREMENT PRIMARY KEY,
  `predio` VARCHAR(50),
  `funcao` VARCHAR(50)
);
 
CREATE TABLE IF NOT EXISTS funcionario (
  `id_funcionario` INT AUTO_INCREMENT PRIMARY KEY,
  `nome` VARCHAR(50),
  `setor` VARCHAR(30),
  `idade` INT
);
 
CREATE TABLE IF NOT EXISTS distribuicao (
  `id_distribuicao` INT AUTO_INCREMENT PRIMARY KEY,
  `id_tarefa` INT,
  `id_funcionario` INT,
  CONSTRAINT fk_tarefa FOREIGN KEY (`id_tarefa`) REFERENCES tarefa(`id_tarefa`),
  CONSTRAINT fk_funcionario FOREIGN KEY (`id_funcionario`) REFERENCES funcionario(`id_funcionario`)
);
 
CREATE TABLE IF NOT EXISTS cronograma (
  `id_cronograma` INT AUTO_INCREMENT PRIMARY KEY,
  `id_tarefa` INT,
  `horario` TIME,
  `data_inicio` DATE,
  `data_termino` DATE,
  CONSTRAINT fk_tarefa_cronograma FOREIGN KEY (`id_tarefa`) REFERENCES tarefa(`id_tarefa`)
);


