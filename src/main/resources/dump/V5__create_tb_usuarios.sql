CREATE TABLE tb_usuarios {
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    primeiro_nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    endereco_id BIGINT,  -- Chave estrangeira para a tabela 'tb_endereco' 
    perfil_id BIGINT,    -- Chave estrangeira para a tabela 'tb_perfil'
    tipo_usuario VARCHAR(50) NOT NULL,  -- Para indicar o tipo de usuário (ex: TIPO_PRESTADOR, TIPO_CONTRATANTE)
    CONSTRAINT fk_endereco FOREIGN KEY (endereco_id) REFERENCES tb_enderecos(id);   -- Relacionamento com Endereco
    CONSTRAINT fk_perfil_id FOREIGN KEY (perfil_id) REFERENCES tb_perfil(id); --Releacionamento com perfil
   	CONSTRAINT tipo_usuario_check CHECK (tipo_usuario IN ('TIPO_PRESTADOR', 'GARCOM', 'TIPO_CONTRATANTE')),  -- Tipos de usuário
	
}