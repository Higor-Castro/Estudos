-- insert select
-- insere valores em uma tabela usando outra

 insert into profales (bio,description,user_id) select 
 concat('Bio de ', first_name), -- concat serve para concatenar string com dados e dentre outros
 concat('Description de', ' ', first_name),
 id from users;
 
 select * from profales; 

 
