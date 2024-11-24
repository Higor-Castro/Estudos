# criando um banco de dados
 create database universidade;

# mensionando o banco principal para uso
use universidade;

#criando a tabela aluno

create table aluno(
	`idAluno` int not null,
    `nome` varchar (45),
    `telefone` varchar (45),
    `genero` varchar(45),
    `data_nascimento` date,
    primary key (`idAluno`)
);

create table turma (
`idTruma` int not null,
`nome` varchar (45),
`fk_aluno` int,
);
