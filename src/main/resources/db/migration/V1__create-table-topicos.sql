CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(200) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    autor VARCHAR(100),
    status BOOLEAN,
    curso VARCHAR(100)
);