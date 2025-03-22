BEGIN TRANSACTION;

INSERT INTO seller (id, name, description)
VALUES ('4a45da41-a4c3-49a1-9c81-bb0381ef0c57', 'Садовое наслаждение', 'Магазин с акцентом на экологичность и натуральность');

INSERT INTO seller (id, name, description)
VALUES ('eb42de06-a1d1-4058-a2ce-d9af9636245f', 'Фруктовый рай', 'Популярный магазин с широким выбором продуктов');

INSERT INTO seller (id, name, description)
VALUES ('90f1dc43-c28a-4ad6-b801-64e37210ae1f', 'Свежий урожай', 'Магазин, ориентированный на быструю доставку и качество');


INSERT INTO customer (id, name, description)
VALUES ('4027f597-66c9-4eb1-a600-c24cb4f9b963', 'Эко-кафе', 'Кафе с фруктовыми салатами');


INSERT INTO product (id, name, description, current_price)
VALUES ('02d4e764-340c-4822-87bb-5d8be1a80d2e', 'Лимонка', 'Груша с желтоватой кожицей и кремовой мякотью', 50);

INSERT INTO product (id, name, description, current_price)
VALUES ('c8e2b639-f610-4fab-8cb4-ec3c2bdc346d', 'Северянка', 'Сорт с плотной мякотью и сладко-кислым вкусом', 60);

INSERT INTO product (id, name, description, current_price)
VALUES ('df13b6c3-7114-49f1-85cc-c50b29c49d18', 'Конференция', 'Классическая груша с грубой кожицей и сладкой, сочной мякотью', 70);

INSERT INTO product (id, name, description, current_price)
VALUES ('816a2c94-6f7a-446b-92e5-1f69650f8b56', 'Бартлетт', 'Сладкая груша с мягкой мякотью', 80);

INSERT INTO product (id, name, description, current_price)
VALUES ('9438fdb0-b89b-4e91-8f03-901b6923044b', 'Голден Делишес', 'Яблоки с золотистой кожицей и сладким, слегка кисловатым вкусом', 40);

INSERT INTO product (id, name, description, current_price)
VALUES ('7b53e763-03cf-4009-82cf-13c60ed93cf2', 'Грэнни Смит', 'Зеленые яблоки с кисловатым вкусом', 65);

INSERT INTO product (id, name, description, current_price)
VALUES ('f2182cf4-5d38-4489-8b2f-f465917759e4', 'Ред Делишес', 'Яблоки с красной кожицей и сладким, сочным вкусом', 90);

INSERT INTO product (id, name, description, current_price)
VALUES ('e2327a80-ddb6-402e-9251-50af8dd1ab5a', 'Фуджи', 'Яблоки с розоватой кожицей и сладко-кислым вкусом', 100);

COMMIT;