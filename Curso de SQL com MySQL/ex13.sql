-- Adiciona a coluna salary na tabela users
-- DECIMAL(15,2) permite armazenar valores monetários com 2 casas decimais
ALTER TABLE users 
ADD salary DECIMAL(15,2);

-- RAND() gera um número aleatório entre 0 e 1
-- ROUND() arredonda o valor para a quantidade de casas decimais informada
-- Neste caso, RAND() * 10000 cria salários aleatórios de 0 até 10.000
-- ROUND(..., 2) garante que o valor tenha apenas 2 casas decimais
UPDATE users 
SET salary = ROUND(RAND() * 10000, 2)
WHERE id > 0;

-- Lista todos os usuários com seus salários
SELECT * FROM users;
