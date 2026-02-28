CREATE TABLE alunos
(
    id BIGINT NOT NULL auto_increment,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    logradouro    VARCHAR(100) NOT NULL,
    numero        VARCHAR(10),
    complemento   VARCHAR(50),
    bairro        VARCHAR(100) NOT NULL,
    cidade        VARCHAR(100) NOT NULL,
    uf            VARCHAR(2)   NOT NULL,
    cep           VARCHAR(8)   NOT NULL,
    especialidade VARCHAR(20) NOT NULL,
    ativo TINYINT NOT NULL,

    PRIMARY KEY (id)
);

