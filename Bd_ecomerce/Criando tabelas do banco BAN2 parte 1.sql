CREATE TABLE Usuarios (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    cpf VARCHAR(11) UNIQUE NOT NULL,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(50),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_nascimento DATE,
    id_contato UUID,
    genero VARCHAR(10),
    status VARCHAR(20),
    tipo VARCHAR(20),
    FOREIGN KEY (id_contato) REFERENCES Contatos(id)
);

CREATE TABLE Enderecos (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    cep VARCHAR(8),
    estado VARCHAR(2),
    cidade VARCHAR(100),
    bairro VARCHAR(100),
    rua VARCHAR(150),
    numero VARCHAR(10),
    complemento VARCHAR(100)
);


CREATE TABLE Contatos (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    email VARCHAR(150) UNIQUE NOT NULL,
    telefones VARCHAR(20),
    id_endereco UUID,
    FOREIGN KEY (id_endereco) REFERENCES Enderecos(id)
);

CREATE TABLE Logins (
    id_usuario UUID PRIMARY KEY,
    senha VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);

CREATE TABLE Compras (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    id_usuario UUID NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    parcelas INTEGER,
    valor_parcela DECIMAL(10, 2),
    valor_total DECIMAL(10, 2),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);


CREATE TABLE Categorias (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nome VARCHAR(100),
    rotulo VARCHAR(100)
);

CREATE TABLE SubCategorias (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nome VARCHAR(100),
    rotulo VARCHAR(100)
);
CREATE TABLE Marcas (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nome VARCHAR(100)
);

CREATE TABLE ClassificacaoProdutos (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    id_categoria UUID,
    id_subCategoria UUID,
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id),
    FOREIGN KEY (id_subCategoria) REFERENCES SubCategorias(id)
);

CREATE TABLE ItensCompra (
    id_compra UUID,
    id_produto UUID,
    quantidade INTEGER,
    valor_unitario DECIMAL(10, 2),
    valor_total DECIMAL(10, 2),
    PRIMARY KEY (id_compra, id_produto),
    FOREIGN KEY (id_compra) REFERENCES Compras(id),
    FOREIGN KEY (id_produto) REFERENCES Produtos(id)
);


CREATE TABLE Fornecedores (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    id_endereco UUID,
    nome VARCHAR(150),
    FOREIGN KEY (id_endereco) REFERENCES Enderecos(id)
);


CREATE TABLE Produtos (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nome VARCHAR(150) NOT NULL,
    id_classificacao_produto UUID,
    id_marca UUID,
    id_fornecedor UUID,
    valor DECIMAL(10, 2),
    quantidade_estoque INTEGER,
    FOREIGN KEY (id_classificacao_produto) REFERENCES ClassificacaoProdutos(id),
    FOREIGN KEY (id_marca) REFERENCES Marcas(id),
    FOREIGN KEY (id_fornecedor) REFERENCES Fornecedores(id)
);
CREATE TABLE Pedidos (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    id_fornecedor UUID,
    id_produto UUID,
    quantidade_estoque_atual INTEGER,
    quantidade INTEGER,
    FOREIGN KEY (id_fornecedor) REFERENCES Fornecedores(id),
    FOREIGN KEY (id_produto) REFERENCES Produtos(id)
);


CREATE TABLE ItensPedido (
    id_pedido UUID,
    id_produto UUID,
    quantidade INTEGER,
    valor_unitario DECIMAL(10, 2),
    valor_total DECIMAL(10, 2),
    PRIMARY KEY (id_pedido, id_produto),
    FOREIGN KEY (id_pedido) REFERENCES Pedidos(id),
    FOREIGN KEY (id_produto) REFERENCES Produtos(id)
);


CREATE TYPE tipo_pagamento_enum AS ENUM ('contas a pagar', 'contas a receber');

CREATE TABLE Pagamentos (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    id_usuario UUID,
    valor NUMERIC(10, 2),
    metodo_pagamento VARCHAR(50),
    data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status_pagamento VARCHAR(20),
    transacao_id UUID,
    tipo_pagamento tipo_pagamento_enum,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);

CREATE TABLE PagamentoCompra (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    id_compra UUID,
    id_pagamento UUID,
    FOREIGN KEY (id_compra) REFERENCES Compras(id),
    FOREIGN KEY (id_pagamento) REFERENCES Pagamentos(id)
);


-- Alterar nomes das tabelas
-- Renomear tabelas para PascalCase
ALTER TABLE public.enderecos RENAME TO "Endereco";
ALTER TABLE public.contatos RENAME TO "Contato";
ALTER TABLE public.usuarios RENAME TO "Usuario";
ALTER TABLE public.logins RENAME TO "Login";
ALTER TABLE public.itempedido RENAME TO "ItemPedido";
ALTER TABLE public.itenscompra RENAME TO "ItemCompra";

ALTER TABLE public.compras RENAME TO "Compras";

select tabelas.tablename from pg_catalog.pg_tables as tabelas where schemaname = 'public'

-- DROP SCHEMA public;
CREATE SCHEMA public AUTHORIZATION pg_database_owner;

COMMENT ON SCHEMA public IS 'standard public schema';


-- Permissions

GRANT ALL ON SCHEMA public TO pg_database_owner;
GRANT USAGE ON SCHEMA public TO public;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";