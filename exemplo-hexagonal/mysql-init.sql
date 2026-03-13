CREATE DATABASE IF NOT EXISTS teste;
USE teste;

CREATE TABLE IF NOT EXISTS Heroi (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    forca INT NOT NULL,
    arma VARCHAR(100) NOT NULL,
    tem_capa BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Heroi (nome, forca, arma, tem_capa)
VALUES
    ('Superman', 100, 'Forca fisica', true),
    ('Batman', 85, 'Batarang', true),
    ('Mulher-Maravilha', 95, 'Laco da Verdade', false),
    ('Thor', 98, 'Mjolnir', true),
    ('Homem-Aranha', 80, 'Lancador de teia', false),
    ('Hulk', 120, 'Punhos', false);
