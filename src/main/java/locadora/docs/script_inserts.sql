INSERT INTO usuario(login,senha,nome) VALUES ('jhon','123', 'jhonatan');
INSERT INTO usuario(login,senha,nome) VALUES ('camila','123', 'camila');
INSERT INTO usuario(login,senha,nome) VALUES ('usuario','123', 'usuario');

INSERT INTO papel VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USER');

INSERT INTO usuario_papel VALUES ('jhon', 1);
INSERT INTO usuario_papel VALUES ('jhon', 2);
INSERT INTO usuario_papel VALUES ('camila', 1);
INSERT INTO usuario_papel VALUES ('camila', 2);
INSERT INTO usuario_papel VALUES ('usuario', 2);

INSERT INTO veiculo VALUES
(1, 'ABC123','Mod1','FIAT','Verde','2010',true,true,200.00,null),
(2, 'BCA627','Mod2','Renault','Prata','2010',true,true, 550.00,null),
(3, 'CBA456','Mod3','Honda','Preto','2010',true,true, 300.00,null);

