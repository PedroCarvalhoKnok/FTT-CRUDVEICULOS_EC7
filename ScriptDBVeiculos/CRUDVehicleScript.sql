CREATE DATABASE vehiclen1

USE vehiclen1

CREATE TABLE Veiculo (
    IdVeiculo int NOT NULL AUTO_INCREMENT,    
    Marca varchar(40) not null,   
    Modelo  varchar(40) not null,
    Chassi   varchar(40) not null,
    Placa varchar(12), 
    DataFabricacao date,
    Preco decimal(10,2),
    Cor varchar(20) null,  
    Condicao varchar(30),
    PRIMARY KEY (IdVeiculo)
)


CREATE TABLE Marca (
    IdMarca int NOT NULL AUTO_INCREMENT,    
    DescricaoMarca varchar(50),
    PRIMARY KEY (IdMarca)
)