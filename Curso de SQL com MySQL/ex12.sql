-- Remove registros da tabela profales
-- Apaga os perfis com id entre 49 e 51
DELETE FROM profales 
WHERE id BETWEEN 49 AND 51;

-- LEFT JOIN
-- Retorna TODOS os usuários
-- Mesmo os que NÃO possuem perfil
SELECT 
    u.id AS uid,        -- id do usuário
    p.id AS pid,        -- id do perfil (pode ser NULL)
    p.bio,              -- bio do perfil (pode ser NULL)
    u.first_name        -- nome do usuário
FROM users AS u
LEFT JOIN profales p 
    ON u.id = p.user_id;

-- RIGHT JOIN
-- Retorna TODOS os perfis
-- Mesmo os que NÃO possuem usuário correspondente
SELECT 
    u.id AS uid,        -- id do usuário (pode ser NULL)
    p.id AS pid,        -- id do perfil
    p.bio,              -- bio do perfil
    u.first_name        -- nome do usuário (pode ser NULL)
FROM users AS u
RIGHT JOIN profales p 
    ON u.id = p.user_id;
