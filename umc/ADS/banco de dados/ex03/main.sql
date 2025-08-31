# Henrique dos Santos Ferreira
# Higor de Castro Venâncio da Silva

CREATE DATABASE fabrica_costura;

USE fabrica_costura;

CREATE TABLE IF NOT EXISTS setor (
    `id_setor` INT AUTO_INCREMENT PRIMARY KEY,
    `descricao` VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS funcionario (
    `id_funcionario` INT AUTO_INCREMENT PRIMARY KEY,
    `funcao` VARCHAR(55) NOT NULL,
    `nome` VARCHAR(60) NOT NULL,
    `genero` VARCHAR(20),
    `data_nasc` DATE,
    `setor_id` INT, 
    CONSTRAINT fk_setor FOREIGN KEY (`setor_id`) REFERENCES setor(`id_setor`)
);

CREATE TABLE IF NOT EXISTS pagamento (
    `funcionario_id` INT,
    `agenda` VARCHAR(60),
    `numero_conta` INT,
    `id_pagamento` INT AUTO_INCREMENT PRIMARY KEY,
    `data` DATE,
    `valor` DECIMAL(10,2),
    `banco` VARCHAR(80),
    CONSTRAINT fk_funcionario FOREIGN KEY (`funcionario_id`) REFERENCES funcionario(`id_funcionario`)
);

CREATE TABLE IF NOT EXISTS roupa (
    `id_roupa` INT AUTO_INCREMENT PRIMARY KEY,
    `descricao` VARCHAR(50),
    `preco` DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS item_pagamento (
    `pagamento_id` INT,
    `roupa_id` INT,
    `valor_total` DECIMAL(10,2),
    `comisao` DECIMAL(10,2),
    CONSTRAINT fk_pagamento FOREIGN KEY (`pagamento_id`) REFERENCES pagamento (`id_pagamento`),
    CONSTRAINT fk_roupa FOREIGN KEY (`roupa_id`) REFERENCES roupa (`id_roupa`)
);

CREATE TABLE IF NOT EXISTS tipo_costura (
    `id_tipo_costura` INT AUTO_INCREMENT PRIMARY KEY,
    `tipo` VARCHAR(55),
    `tipo_agulha` VARCHAR(60),
    `tipo_linha` VARCHAR(60)
);

CREATE TABLE IF NOT EXISTS maquinario (
    `id_maquina` INT AUTO_INCREMENT PRIMARY KEY,
    `tipo` VARCHAR(55),
    `status` VARCHAR(60),
    `tipo_costura_id` INT,
    `data` DATE,
    CONSTRAINT fk_tipo_costura FOREIGN KEY (`tipo_costura_id`) REFERENCES tipo_costura (`id_tipo_costura`)
);

CREATE TABLE IF NOT EXISTS producao (
    `id_funcionario_costureira` INT,
    `maquina_id` INT,
    `roupa_id` INT,
    `data_hora` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `status` VARCHAR(60),
    `id_funcionario_supervisora` INT,
    CONSTRAINT fk_funcionario_costureira FOREIGN KEY (`id_funcionario_costureira`) REFERENCES funcionario (`id_funcionario`),
    CONSTRAINT fk_maquina FOREIGN KEY (`maquina_id`) REFERENCES maquinario (`id_maquina`),
    CONSTRAINT fk_roupa_producao FOREIGN KEY (`roupa_id`) REFERENCES roupa (`id_roupa`),
    CONSTRAINT fk_funcionario_supervisora_producao FOREIGN KEY (`id_funcionario_supervisora`) REFERENCES funcionario (`id_funcionario`)
);

INSERT INTO setor (`descricao`) VALUES ('Setor de Produção');
INSERT INTO setor (`descricao`) VALUES ('Setor de Vendas');

INSERT INTO funcionario (`funcao`, `nome`, `genero`, `data_nasc`, `setor_id`) VALUES ('Costureira', 'Maria Silva', 'Feminino', '1990-01-15', 1);
INSERT INTO funcionario (`funcao`, `nome`, `genero`, `data_nasc`, `setor_id`) VALUES ('Vendedor', 'João Santos', 'Masculino', '1985-05-20', 2);

INSERT INTO roupa (`descricao`, `preco`) VALUES ('Camisa', 29.99);
INSERT INTO roupa (`descricao`, `preco`) VALUES ('Calça', 39.99);

INSERT INTO tipo_costura (`tipo`, `tipo_agulha`, `tipo_linha`) VALUES ('Costura Reta', 'Agulha Comum', 'Linha Comum');
INSERT INTO tipo_costura (`tipo`, `tipo_agulha`, `tipo_linha`) VALUES ('Costura Overlock', 'Agulha Overlock', 'Linha Overlock');

INSERT INTO maquinario (`tipo`, `status`, `tipo_costura_id`, `data`) VALUES ('Máquina de Costura', 'Ativo', 1, '2023-01-01');
INSERT INTO maquinario (`tipo`, `status`, `tipo_costura_id`, `data`) VALUES ('Overlock', 'Inativo', 2, '2023-02-01');

INSERT INTO pagamento (`funcionario_id`, `agenda`, `numero_conta`, `data`, `valor`, `banco`) VALUES (1, 'Mensal', 12345, '2023-01-31', 1500.00, 'Banco A');
INSERT INTO pagamento (`funcionario_id`, `agenda`, `numero_conta`, `data`, `valor`, `banco`) VALUES (2, 'Semanal', 67890, '2023-02-15', 800.00, 'Banco B');

INSERT INTO item_pagamento (`pagamento_id`, `roupa_id`, `valor_total`, `comisao`) VALUES (1, 1, 29.99, 5.00);
INSERT INTO item_pagamento (`pagamento_id`, `roupa_id`, `valor_total`, `comisao`) VALUES (2, 2, 39.99, 7.00);


INSERT INTO producao (`id_funcionario_costureira`, `maquina_id`, `roupa_id`, `status`, `id_funcionario_supervisora`) VALUES (1, 1, 1, 'Concluído', 2);
INSERT INTO producao (`id_funcionario_costureira`, `maquina_id`, `roupa_id`, `status`, `id_funcionario_supervisora`) VALUES (1, 2, 2, 'Em Progresso', 2);


SELECT * FROM setor;
SELECT * FROM funcionario;
SELECT * FROM roupa;
SELECT * FROM tipo_costura;
SELECT * FROM maquinario;
SELECT * FROM pagamento;
SELECT * FROM item_pagamento;
SELECT * FROM producao;