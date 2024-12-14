CREATE TABLE tb_contrato (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Identificador único do contrato
    conteudo TEXT,                         -- Conteúdo detalhado do contrato
    clausulas_especificas TEXT,            -- Cláusulas específicas do contrato
    data_inicio_analise DATE,              -- Data de início da análise do contrato
    data_criacao DATE,                     -- Data de criação do contrato
    data_inicio DATE,                      -- Data de início do contrato
    data_termino DATE,                     -- Data de término do contrato
    status VARCHAR(50),                    -- Status do contrato (usar enum)
    contratante_id BIGINT,                 -- Referência ao contratante
    prestador_id BIGINT,                   -- Referência ao prestador
    assinatura_prestador VARCHAR(255),     -- Assinatura do prestador
    assinatura_contratante VARCHAR(255),   -- Assinatura do contratante
    valor DECIMAL(10, 2),                  -- Valor do contrato
    foi_formalizado BOOLEAN,               -- Flag indicando se o contrato foi formalizado
    entrou_em_analise BOOLEAN,            -- Flag indicando se entrou em análise
    FOREIGN KEY (contratante_id) REFERENCES tb_contratante(id), -- Relacionamento com Contratante
    FOREIGN KEY (prestador_id) REFERENCES tb_prestador(id)      -- Relacionamento com Prestador
);