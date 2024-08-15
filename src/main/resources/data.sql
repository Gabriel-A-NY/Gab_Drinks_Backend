INSERT INTO drink (product_id, product_name, price, description, image_link)
VALUES (1, 'coke', 1.99, 'beverage', 'https://m.media-amazon.com/images/I/71booHxo0YL._SL1500_.jpg'),
       (2, 'pepsi', 1.99, 'refreshment', 'https://m.media-amazon.com/images/I/51btQudC3YL._SL1198_.jpg'),
       (3, 'sprite', 1.99, 'beverage',
        'https://www.coca-cola.com/content/dam/onexp/au/en/brands/sprite/new/03-08-2024/sprite.png'),
       (4, 'fanta', 1.99, 'beverage',
        'https://www.coca-cola.com/content/dam/onexp/gb/en/brands/fanta/Product-Information-fanta-orange.jpg'),
       (5, 'water', 1.99, 'beverage',
        'https://media.post.rvohealth.io/wp-content/uploads/2020/08/11178-Different_types_of_water_thumbnail-732x549-1-732x549.jpg'),
       (6, 'juice', 1.99, 'beverage',
        'https://target.scene7.com/is/image/Target/GUEST_2b7f75ea-fbb8-4767-8b1f-6bb809bfe214'),
       (7, 'milk', 1.99, 'beverage',
        'https://i5.walmartimages.com/seo/Great-Value-Milk-Whole-Vitamin-D-Gallon-Plastic-Jug_6a7b09b4-f51d-4bea-a01c-85767f1b481a.86876244397d83ce6cdedb030abe6e4a.jpeg'),
       (8, 'coffee', 1.99, 'beverage',
        'https://www.puffco.com/cdn/shop/products/Cupsy_Front_Facing.png?v=1680818865&width=600'),
       (9, 'tea', 1.99, 'beverage',
        'https://media.post.rvohealth.io/wp-content/uploads/2022/01/hot-tea-steaming-steeping-732-549-feature-thumb-732x549.jpg'),
       (10, 'hot chocolate', 1.99, 'beverage',
        'https://www.vindulge.com/wp-content/uploads/2021/12/Smoked-Hot-Chocolate.jpg');

INSERT INTO role(role_id, role_name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO authority (authority_id, authority_name)
VALUES (1, 'GET'),
       (2, 'POST'),
       (3, 'PUT'),
       (4, 'DELETE');

INSERT INTO role_authority (id_authority, id_role)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (1, 2);

INSERT INTO users (user_id, user_password, id_role, first_name, last_name, phone_number, email)
VALUES (1, 'ADMIN', 1, 'ADMIN', 'ADMIN', '0762626399', 'admin@admin.com'),
       (2, 'USER', 2, 'USER', 'USER', '123456789', 'user@user.com');