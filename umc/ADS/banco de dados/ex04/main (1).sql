# Henrique dos santos ferreira
# Higor castro venâncio da silva
CREATE TABLE cliente (
  cod_cli INT,
  nome VARCHAR(50),
  cpf VARCHAR(17),
  rua VARCHAR(50),
  num VARCHAR(5),
  bairro VARCHAR(50),
  cidade VARCHAR(50),
  uf VARCHAR(2),
  cep VARCHAR(9),
  PRIMARY KEY (cod_cli)
);

INSERT INTO cliente (cod_cli, nome, cpf, rua, num, bairro, cidade, uf, cep) 
VALUES 
(1, 'GILBERTO', '12345678901', 'AV. Astronautas', '1333', 'Cidade Jardim', 'S.J Dos Campos', 'SP', '12227-220');
INSERT INTO cliente (cod_cli, nome, cpf, rua, num, bairro, cidade, uf, cep) 
VALUES
(2, 'EDUARDO', '12345678902', 'AV. X', '1456', 'Vila', 'Rio de Janeiro', 'RJ', '35000000');
# Foi alterado a chave primaria, pois não pode ter duas chaves com o mesmo valor


INSERT INTO cliente VALUES
(3, 'Bruno', '12345678903', 'Rua Albino Sartori', '95', 'V.S.J', 'Ouro Preto', 'MG', '35400-000');
INSERT INTO cliente (cod_cli,nome,cpf,rua) VALUES  (4,'RICARDO','12345678903','Rua Ceci');
INSERT INTO cliente (cod_cli,nome,cpf) VALUES  (5,'ANTONIO','12345678903');
# Foi alterado as chaves primaria e acrencetamos o (cod_cli,nome,cpf,rua),(cod_cli  "Foi colocado a chave primaria",nome,cpf) 



DELETE FROM cliente  WHERE cod_cli > 0;
DELETE FROM cliente  WHERE nome='bruno';
DELETE FROM cliente;
# Não existe chave primaria menor que 0, maior que 0.

UPDATE cliente SET nome='JOÃO' WHERE cod_cli = 1;
UPDATE cliente SET nome='JOÃO' WHERE nome = 'BRUNO';
#Foi alterado o valor 0 da chave primaria para 1, pois não existe chave primaria no valor 0
