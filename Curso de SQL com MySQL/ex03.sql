-- Seleciona todas colunas
select * from users;

-- seleciona colunas escolhidas
select id, email from users;

-- selecionar dando nome diferentes 
select u.email uEmail, -- Nomeando email de maneira diferente 
u.id, u.first_name
from users as u; -- Nomeando users para u