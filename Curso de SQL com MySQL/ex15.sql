select 
-- Tabela Users
u.id as uID, u.first_name,
-- Tabela Profales
p.id as pID,p.bio,
-- Tabela Users_roles
ur.user_id as urID,
-- Tabela Roles
r.name
from users as u
left join profales as p on u.id = p.user_id
inner join users_roles as ur on u.id = ur.user_id
inner join roles as r on ur.role_id = r.id
order by uid asc
;