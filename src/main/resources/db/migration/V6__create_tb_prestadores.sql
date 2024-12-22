CREATE TABLE tb_prestador (
    id BIGINT PRIMARY KEY, -- Deve ser a mesma chave primária de tb_usuario
    cpf VARCHAR(20) NOT NULL,
    avaliacao DECIMAL(3,2),
    total_avaliacoes BIGINT DEFAULT 0 NOT NULL,
    CONSTRAINT fk_prestador_usuario FOREIGN KEY (id) REFERENCES tb_usuarios(id),
    CONSTRAINT uq_prestador_cpf UNIQUE (cpf)
);