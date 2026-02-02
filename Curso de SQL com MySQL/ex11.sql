-- Lista todos os registros da tabela profales
SELECT * FROM profales;

-- JOIN é usado para combinar dados de duas ou mais tabelas relacionadas
-- Ele permite buscar informações que estão separadas em tabelas diferentes
-- utilizando uma chave em comum (ex: users.id = profales.user_id)

-- Consulta usando ligação pelo WHERE (forma antiga)
-- Junta users com profales usando o id do usuário
SELECT 
    u.id AS uid,        -- id do usuário
    p.id AS pid,        -- id do perfil
    p.bio,              -- biografia do perfil
    u.first_name        -- nome do usuário
FROM users AS u, profales AS p
WHERE u.id = p.user_id;

-- Consulta usando INNER JOIN (forma correta e recomendada)
-- INNER JOIN retorna apenas os registros que possuem correspondência
-- entre as tabelas users e profales
SELECT 
    u.id AS uid,
    p.id AS pid,
    p.bio,
    u.first_name
FROM users AS u
INNER JOIN profales p 
    ON u.id = p.user_id;

-- INNER JOIN com filtro, ordenação e limite
-- Busca usuários cujo nome termina com "a"
-- Ordena do Z para o A
-- Limita o resultado a 10 registros
SELECT 
    u.id AS uid,
    p.id AS pid,
    p.bio,
    u.first_name
FROM users AS u
INNER JOIN profales p 
    ON u.id = p.user_id
WHERE u.first_name LIKE '%a'
ORDER BY u.first_name DESC
LIMIT 10;
