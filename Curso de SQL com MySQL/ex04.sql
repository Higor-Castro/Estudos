-- Where filtra Registros
-- = < <= > >= <> !=
select  * from users 
where id >= 3;

-- Pode usar o and e or para deixa a consulta mais precisa
-- AND
select  * from users 
where created_at = '2026-01-23 18:33:08'
and first_name = 'Higor';

-- OR
select  * from users 
where created_at >= '2026-01-23 18:33:12'
or first_name = 'João';


