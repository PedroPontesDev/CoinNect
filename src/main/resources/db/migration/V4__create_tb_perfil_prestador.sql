-- Criação da tabela tb_perfil_prestador (subclasse de Perfil)
CREATE TABLE tb_perfil_prestador (
    id BIGINT PRIMARY KEY,                     -- A chave primária é a mesma da tabela tb_perfil
    biografia TEXT,                            -- Coluna biografia
    servicos_prestados VARCHAR(255),        -- Coluna servicos_prestado (campo enum convertido para string)
    CONSTRAINT fk_perfil_prestador FOREIGN KEY (id) REFERENCES tb_perfil(id)  -- Chave estrangeira referenciando tb_perfil
);
