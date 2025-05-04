# ANTES DE RODAR O SOFTWARE
# DEVE-SE CRIAR ESSE BANCO

CREATE DATABASE IF NOT EXISTS sistema_de_contabilidade;
USE sistema_de_contabilidade;

-- Tabela Cliente
CREATE TABLE IF NOT EXISTS Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    estado VARCHAR(2) NOT NULL
);

-- Tabela Fornecedor
CREATE TABLE IF NOT EXISTS Fornecedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) UNIQUE NOT NULL,
    estado VARCHAR(2) NOT NULL
);

-- Tabela Produto
CREATE TABLE IF NOT EXISTS Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco VARCHAR(100),
    pagamento VARCHAR(100) 
);


-- Tabela de Vendas 
CREATE TABLE Venda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_Fornecedor INT,
    id_Cliente INT,
    id_Produto INT,
    preco VARCHAR(20),
    pagamento VARCHAR(50),
    FOREIGN KEY (id_Fornecedor) REFERENCES Fornecedor(id),
    FOREIGN KEY (id_Cliente) REFERENCES Cliente(id),
    FOREIGN KEY (id_Produto) REFERENCES Produto(id)
);

-- Tabela de Compras 
CREATE TABLE Compra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_Cliente INT,
    id_Produto INT,
    preco VARCHAR(20),
    pagamento VARCHAR(50),
    FOREIGN KEY (id_Cliente) REFERENCES Cliente(id),
    FOREIGN KEY (id_Produto) REFERENCES Produto(id)
);
