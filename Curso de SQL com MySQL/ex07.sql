-- Limit limita a quantidade de valores
-- Offset desloca o cursos para exibir os resultados 
select id,first_name,email umail
from users where id between 300 and 350
order by first_name desc , id asc limit 1 offset 3;


select id,first_name,email umail
from users where id between 300 and 350
order by first_name desc , id asc limit  1,3;
						-- primeio offset, segundo limit
