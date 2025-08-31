# Henrique dos Santos Ferreira
# Higor de Castro Venâncio da Silva 

CREATE DATABASE ESCOLA;

USE ESCOLA;

CREATE TABLE IF NOT EXISTS Disciplina ( 
    `idDISCIPLINA` INT AUTO_INCREMENT, 
    `nome` VARCHAR(35), 
    `curso` VARCHAR(15), 
    `professor` VARCHAR(100), 
    `horario` VARCHAR(20), 
    PRIMARY KEY (`idDISCIPLINA`)
);

CREATE TABLE IF NOT EXISTS Alunos ( 
    `id_RA` INT PRIMARY KEY, 
    `nome` VARCHAR(255) NOT NULL, 
    `data_nascimento` DATE, 
    `matricula` VARCHAR(20) UNIQUE, 
    `curso` VARCHAR(255), 
    `periodo` INT
);

CREATE TABLE IF NOT EXISTS NotasAlunos ( 
    `id_NOTA` INT PRIMARY KEY,
    `aluno_id` INT, 
    `disciplina_id` INT, 
    `nota` DECIMAL(10), 
    `data_avaliacao` DATE, 
    CONSTRAINT fk_aluno FOREIGN KEY (`aluno_id`) REFERENCES Alunos(`id_RA`), 
    CONSTRAINT fk_disciplina FOREIGN KEY (`disciplina_id`) REFERENCES Disciplina(`idDISCIPLINA`)
);Henrique dos Santos Ferreira
# Higor de Castro Venâncio da Silva 

CREATE DATABASE fabrica_costura;

USE fabrica_costura;

CREATE TABLE IF NOT EXISTS setor ( 
    `id_setor` INT primary key, 
    `descricao` VARCHAR(50)  
);

CREATE TABLE IF NOT EXISTS funcionario ( 
    `id_funcionario` INT PRIMARY KEY, 
    `funcao` VARCHAR(55) NOT NULL, 
    `nome` varchar(60) not null, 
    `genero` VARCHAR(20), 
    `data_nasc` date, 
    `id_setor` int,
    constraint fk_setor foreign key (`id_setor`) references setor(`id_setor`)
);

CREATE TABLE IF NOT EXISTS pagamento ( 
    `id_funcionario` int,
    `agenda` varchar(60), 
    `numero_conta` INT, 
    `id_pagamento` int primary key, 
    `data` DATE, 
    `valor` int,
    `banco` varchar (80),
    CONSTRAINT fk_funcionario FOREIGN KEY (`id_funcionario`) REFERENCES funcionario(`id_funcionario`) 
);