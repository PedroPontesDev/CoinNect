CREATE TABLE tb_perfil (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Coluna id
    profile_pic_url VARCHAR(255),          -- Coluna profilePicUrl
    description VARCHAR(255),              -- Coluna description
    TIPO_PERFIL VARCHAR(50),               -- Coluna de discriminação
    CONSTRAINT chk_tipo_perfil CHECK (TIPO_PERFIL IN ('TIPO_PRESTADOR', 'TIPO_CONTRATANTE')) -- Exemplo de valores possíveis para a discriminação
);
