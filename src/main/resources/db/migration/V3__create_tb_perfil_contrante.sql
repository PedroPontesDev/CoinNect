-- Criação da tabela tb_perfil_contratante (subclasse de Perfil)
CREATE TABLE tb_perfil_contratante (
    id BIGINT PRIMARY KEY,                     -- A chave primária é a mesma da tabela tb_perfil
    biografia TEXT,                            -- Coluna biografia
    servicos_em_interesse VARCHAR(255),        -- Coluna servicosEmInteresse (campo enum convertido para string)
    CONSTRAINT fk_perfil_contratante FOREIGN KEY (id) REFERENCES tb_perfil(id)  -- Chave estrangeira referenciando tb_perfil
);
