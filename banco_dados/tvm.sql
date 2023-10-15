CREATE DATABASE tvm;
USE tvm;

CREATE TABLE Cliente (
idCliente INTEGER(10) PRIMARY KEY  AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
cpf VARCHAR(11) NOT NULL,
dataNasc DATETIME NOT NULL,
telefone VARCHAR(20) NOT NULL
);

CREATE TABLE Passagem (
idPassagem INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
ciaAerea VARCHAR(20) NOT NULL,
origem VARCHAR(20) NOT NULL,
destino VARCHAR(20) NOT NULL,
valor DECIMAL(10,2) NOT NULL
);

CREATE TABLE Compra (
idPassagem INTEGER(10),
idCompra INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
formaPgto VARCHAR(20),
idCliente INTEGER(10),
valorTotal DECIMAL(10,2),
FOREIGN KEY(idCliente) REFERENCES Cliente (idCliente),
FOREIGN KEY(idPassagem) REFERENCES Passagem (idPassagem)
);

select * from Cliente;
select * from Passagem;
select * from Compra;
