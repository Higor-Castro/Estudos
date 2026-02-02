-- Insere roles (permissões) na tabela roles
INSERT INTO roles (name)
VALUES
('POST'), ('PUT'), ('DELETE'), ('GET');

-- Gera um SELECT para testar
-- Para cada usuário, escolhe uma role aleatória
SELECT 
    id,
    (SELECT id FROM roles ORDER BY RAND() LIMIT 1) AS role_aleatoria
FROM users;

-- Insere na tabela users_roles
-- Associa cada usuário a uma role escolhida aleatoriamente
INSERT INTO users_roles (user_id, role_id)
SELECT 
    id,
    (SELECT id FROM roles ORDER BY RAND() LIMIT 1)
FROM users;

-- Mostra todos os relacionamentos entre usuários e roles
SELECT * FROM users_roles;
