-- Criação da tabela tb_perfil
CREATE TABLE tb_perfil (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    profile_pic_url VARCHAR(255),
    description TEXT,
    tipo_perfil VARCHAR(255) NOT NULL
);
