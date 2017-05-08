DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios(id INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(256), email VARCHAR(256), telefone VARCHAR(64), sexo VARCHAR(1));

INSERT INTO usuarios (nome, email, telefone, sexo) VALUES ('Fulano de Tal', 'fdetal@fulano.com','+55 11 95555-5555','M');
INSERT INTO usuarios (nome, email, telefone, sexo) VALUES ('Beltrano o Tal', 'botal@beltrano.com','+55 11 96666-6666','M');
