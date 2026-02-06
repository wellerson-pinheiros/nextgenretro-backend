INSERT INTO tb_usuarios (name, email, password, url_img) VALUES
('Wellerson', 'wellerson@gmail.com', '12345678', ''),
('João Silva', 'joao.silva@example.com', 'password123', 'http://example.com/img1.jpg'),
('Maria Oliveira', 'maria.oliveira@example.com', '1234abcd', 'http://example.com/img2.jpg'),
('Carlos Souza', 'carlos.souza@example.com', 'qwerty123', 'http://example.com/img3.jpg');

INSERT INTO tb_genero_jogos (nome) VALUES ('Aventura');
INSERT INTO tb_genero_jogos (nome) VALUES ('Terror');
INSERT INTO tb_genero_jogos (nome) VALUES ('Ação');
INSERT INTO tb_genero_jogos (nome) VALUES ('RPG');

INSERT INTO tb_jogos (id, name, description, price, img_url, plataforma, facha_etaria)
VALUES
(1, 'Super Mario Bros', 'Um jogo clássico de plataforma', 59.99, 'mario.jpg', 'Nintendo', 'Livre'),
(2, 'Resident Evil', 'Jogo de terror e sobrevivência', 89.99, 're.jpg', 'PlayStation', '18+'),
(3, 'Street Fighter', 'Jogo de luta', 49.99, 'sf.jpg', 'Arcade', '12+');


INSERT INTO tb_intermediaria_jogo_genero (jogo_id, genero_id)
VALUES (1, 1), -- 'The Last of Us' com 'Aventura'
       (1, 3); -- 'The Last of Us' com 'Ação'

INSERT INTO tb_intermediaria_jogo_genero (jogo_id, genero_id)
VALUES (2, 2); -- 'Resident Evil 2' com 'Terror'

INSERT INTO tb_intermediaria_jogo_genero (jogo_id, genero_id)
VALUES (3, 1), -- 'God of War' com 'Aventura'
       (3, 3); -- 'God of War' com 'Ação'