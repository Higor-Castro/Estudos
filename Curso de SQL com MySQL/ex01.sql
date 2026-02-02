create database curso_sql;
-- Seleciona o banco de dados que será usado
use curso_sql;

-- Cria a tabela de usuários
create table users(
    id int auto_increment primary key,       -- Identificador único do usuário
    first_name varchar(20) not null,          -- Primeiro nome (obrigatório)
    last_name varchar(20),                    -- Sobrenome (opcional)
    email varchar(40) unique,                 -- Email único para cada usuário
    passeord_hash varchar(90) unique          -- Hash da senha (não pode repetir)
);

-- Modificar a quantidade do varchar do email
alter table users modify email varchar(100);

-- Data e hora de criação do usuário
alter table users  
add created_at datetime default now() not null;

-- Data e hora da última atualização do usuário
alter table users 
add updata_at datetime default now() 
on update now() not null;

-- Cria a tabela de cargos/perfis (roles)
create table roles(
    id int auto_increment primary key,        -- Identificador da role
    name varchar(50) not null                 -- Nome da role (ex: ADMIN, USER)
);

-- Tabela de relacionamento entre usuários e roles (muitos para muitos)
create table users_roles(
    user_id int not null,                     -- ID do usuário
    role_id int not null,                     -- ID da role
    primary key(user_id, role_id),            -- Chave primária composta
    foreign key (user_id) references users(id)
        on delete cascade on update cascade,  -- Remove/atualiza junto com o usuário
    foreign key (role_id) references roles(id)
        on delete cascade on update cascade   -- Remove/atualiza junto com a role
);

-- Data e hora de criação do vínculo usuário/role
alter table users_roles 
add created_at datetime default now() not null;

-- Data e hora da última atualização do vínculo usuário/role
alter table users_roles 
add update_at datetime default now() 
on update now() not null;

-- Cria a tabela de perfis do usuário
create table profales(
    id int auto_increment primary key,        -- Identificador do perfil
    bio text,                                 -- Biografia do usuário
    description text,                         -- Descrição adicional
    user_id int unique,                              -- Usuário dono do perfil
    foreign key (user_id) references users(id)
        on delete cascade on update cascade   -- Apaga o perfil se o usuário for removido
);
