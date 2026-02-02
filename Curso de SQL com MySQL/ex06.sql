-- Order by serve para ordena 
-- ASC por ordem crescente
select id,first_name,email umail
from users where id between 300 and 350
order by id asc;

-- desc por ordem Decresente 
select id,first_name,email umail
from users where id between 300 and 350
order by id desc;

-- ambos juntos 
select id,first_name,email umail
from users where id between 300 and 350
order by first_name desc , id asc;

