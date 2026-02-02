-- between seleciona um range de registros
 select * from users
where created_at between '2020-09-27 01:28:26'
and '2021-01-02 11:12:48' ;
-- Podemos ter uma Filtragem maior com um ou mais  between
 select * from users
where created_at between '2020-09-27 01:28:26'
and '2021-01-02 11:12:48'  
and id between 332 and 380;

-- IN seleciona elementos entre os valores enviados
 select * from users
where id in (300,305,310,320,325,330,400,500) and
first_name in ('Tanner', 'karina') ;

-- LIKE é usado em consultas para filtrar dados com base em partes de um texto
-- %   -> qualquer quantidade de caracteres
select * from users 
where first_name like '%a%';
-- _   -> exatamente um caractere
select * from users 
where first_name like '_____';


