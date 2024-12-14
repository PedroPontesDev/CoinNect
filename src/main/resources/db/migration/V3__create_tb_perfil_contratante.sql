-- Criação da tabela tb_perfil_contratante
CREATE TABLE tb_perfil_contratante (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    perfil_id BIGINT,
    biografia TEXT,
    servicos_em_interesse VARCHAR(255),
    CONSTRAINT fk_perfil_contratante FOREIGN KEY (perfil_id) REFERENCES tb_perfil(id) /* A coluna perfil_id define uma chave estrangeira que referencia a coluna id da tabela tb_perfil */

