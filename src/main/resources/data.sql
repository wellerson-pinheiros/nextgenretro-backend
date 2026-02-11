
INSERT INTO tb_usuarios (name, email, password, url_img) VALUES
('Wellerson', 'wellerson@gmail.com', '12345678', ''),
('João Silva', 'joao.silva@example.com', 'password123', 'http://example.com/img1.jpg'),
('Maria Oliveira', 'maria.oliveira@example.com', '1234abcd', 'http://example.com/img2.jpg'),
('Carlos Souza', 'carlos.souza@example.com', 'qwerty123', 'http://example.com/img3.jpg');

-- Inserção de dados na tabela tb_categoria
INSERT INTO tb_categoria (nome_categoria)
VALUES
    ('Ação'),
    ('Aventura'),
    ('RPG'),
    ('Simulação'),
    ('Estratégia');

-- Inserção de dados na tabela tb_console
INSERT INTO tb_console (name, description, fabricante, img_url, price, ano_lancamento, modelo)
VALUES
    ('Console X', 'Console de última geração', 'Fabricante X', 'http://example.com/img1.jpg', 499.99, '2025-11-15', 'Modelo X1'),
    ('Console Y', 'Console com recursos exclusivos', 'Fabricante Y', 'http://example.com/img2.jpg', 399.99, '2024-10-12', 'Modelo Y2');

-- Inserção de dados na tabela tb_controles
INSERT INTO tb_controles (name, description, fabricante, img_url, price, cor, original_replica, tipo_conexao)
VALUES
    ('Controle X', 'Controle sem fio com alta precisão', 'Fabricante A', 'http://example.com/img3.jpg', 49.99, 'Preto', 'Original', 'Bluetooth'),
    ('Controle Y', 'Controle com vibração e luz LED', 'Fabricante B', 'http://example.com/img4.jpg', 59.99, 'Branco', 'Replica', 'USB');

-- Inserção de dados na tabela tb_genero_jogos
INSERT INTO tb_genero_jogos (nome, descricao)
VALUES
    ('Ação', 'Jogos com foco em combate e ação dinâmica'),
    ('Aventura', 'Jogos de exploração e resolução de puzzles'),
    ('RPG', 'Jogos de interpretação de personagens e mundos fictícios'),
    ('Simulação', 'Jogos que simulam aspectos da vida real'),
    ('Estratégia', 'Jogos focados em planejamento e tomada de decisões');

-- Inserção de dados na tabela tb_jogos
INSERT INTO tb_jogos (name, description, fabricante, img_url, price, facha_etaria, plataforma, categoria_id)
VALUES
    ('Jogo Ação 1', 'Jogo de ação com muitas aventuras', 'Fabricante A', 'http://example.com/jogo1.jpg', 59.99, '18+', 'PlayStation 5', 1),
    ('Jogo Aventura 2', 'Jogo de aventura com gráficos realistas', 'Fabricante B', 'http://example.com/jogo2.jpg', 49.99, '12+', 'Xbox Series X', 2);

-- Inserção de dados na tabela tb_memory_card
INSERT INTO tb_memory_card (name, description, fabricante, img_url, price, capacidade)
VALUES
    ('Memory Card X', 'Cartão de memória para console X', 'Fabricante C', 'http://example.com/memcard1.jpg', 39.99, '512GB'),
    ('Memory Card Y', 'Cartão de memória para console Y', 'Fabricante D', 'http://example.com/memcard2.jpg', 29.99, '256GB');

-- Inserção de dados na tabela tb_usuarios
INSERT INTO tb_usuarios (email, name, password, url_img)
VALUES
    ('usuario1@example.com', 'Usuário 1', 'senha123', 'http://example.com/user1.jpg'),
    ('usuario2@example.com', 'Usuário 2', 'senha456', 'http://example.com/user2.jpg');


    INSERT INTO tb_intermediaria_jogo_genero (jogo_id, genero_id)
    VALUES
    (1, 1),  -- "Jogo Ação 1" é de "Ação"
    (2, 2);  -- "Jogo Aventura 2" é de "Aventura"
