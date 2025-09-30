
CREATE DATABASE IF NOT EXISTS levelUp;
USE levelUp;

-- Tabela de usuários
CREATE TABLE usuarios (
    registro VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    cargo VARCHAR(100),
    departamento VARCHAR(100)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Tabela de metas
CREATE TABLE metas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao TEXT,
    etapas INT,
    etapaAtual INT,
    registro_usuario VARCHAR(20),
    dataCriacao TIMESTAMP NOT NULL,
    frequencia VARCHAR(20),
    FOREIGN KEY (registro_usuario) REFERENCES usuarios(registro)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Tabela de recomendações
CREATE TABLE recomendacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao TEXT,
    urlCurso TEXT,
    etapa INT,
    id_meta INT,
    FOREIGN KEY (id_meta) REFERENCES metas(id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Exemplo de consulta
SELECT * FROM metas;



