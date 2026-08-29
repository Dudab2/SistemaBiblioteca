CREATE TABLE IF NOT EXISTS usuarios (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL, 
    email VARCHAR(150) NOT NULL
    );


CREATE TABLE IF NOT EXISTS emprestimos (
    id INT PRIMARY KEY,
    id_livro INT NOT NULL,
    id_usuario INT NOT NULL,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,

    FOREIGN KEY (id_livro) REFERENCES livros(id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

SELECT * FROM livros;

ALTER TABLE livros MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;

ALTER TABLE usuarios
MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;

ALTER TABLE emprestimos
MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;

DESCRIBE usuarios;

DESCRIBE emprestimos;

SELECT * FROM usuarios;