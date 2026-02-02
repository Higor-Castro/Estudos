-- DELETE apaga os registros da tabela
delete from users where id = '60';

-- AVISO: use SELECT para garantir que está 
-- apagando os valores corretos da tabela
select * from users where id between 50 and 61; 