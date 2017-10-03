INSERT INTO usuario(login,senha,nome) VALUES ('jhon','123', 'jhonatan');
INSERT INTO usuario(login,senha,nome) VALUES ('camila','123', 'camila');
INSERT INTO usuario(login,senha,nome) VALUES ('usuario','123', 'usuario');

INSERT INTO papel VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USER');

INSERT INTO usuario_papel VALUES ('jhon', 1);
INSERT INTO usuario_papel VALUES ('jhon', 2);
INSERT INTO usuario_papel VALUES ('camila', 1);
INSERT INTO usuario_papel VALUES ('camila', 2);
INSERT INTO usuario_papel VALUES ('usuario', 2);

