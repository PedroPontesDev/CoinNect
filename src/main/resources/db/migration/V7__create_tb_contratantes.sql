CREATE TABLE tb_contratante (
    id BIGINT PRIMARY KEY, -- Deve ser a mesma chave primária de tb_usuario
    cpf VARCHAR(20),
    cnpj VARCHAR(20),
    avaliacao DECIMAL(3,2),
    total_avaliacoes BIGINT DEFAULT 0 NOT NULL,
    CONSTRAINT fk_contratante_usuario FOREIGN KEY (id) REFERENCES tb_usuarios(id),
    CONSTRAINT uq_contratante_cnpj UNIQUE (cnpj),
    CONSTRAINT uq_contratante_cpf UNIQUE (cpf)
);