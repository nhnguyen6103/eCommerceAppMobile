CREATE TABLE IF NOT EXISTS products (
    id VARCHAR(36) NOT NULL UNIQUE PRIMARY KEY,
    category_id VARCHAR(36) NOT NULL ,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    image_URL VARCHAR(255),
    description VARCHAR(255),
    price DOUBLE(10,2) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE  CASCADE
);

INSERT INTO products(id, category_id, name, quantity, image_URL, description, price)
VALUES
    ('04bff57d-1521-4bd1-8f37-444cf5cc7219' ,'5b28f651-a11a-48f4-a401-000ef2308aff'  ,'SAMSUNG S21 ULTRA'  ,'10','src\\main\\resources\\image\\PRODUCT\\base\\base.jpeg'   ,'This is a samsung s21 ultra'   ,'123'),
    ('35a2976c-5e94-4d65-99bf-0c0012d0a8aa' ,'760a40c0-5104-4537-b804-35d11d1eb3fa'  ,'IPHONE 6'           ,'10','src\\main\\resources\\image\\PRODUCT\\base\\base.jpeg'   ,'This is an iphone 6'              ,'123' ),
    ('793fcd4f-ba00-46ec-ae54-75fbea9d8fdc' ,'caf53449-c871-4fd1-874f-cf50b4335909'  ,'REDMI NOTE 10'      ,'10','src\\main\\resources\\image\\PRODUCT\\base\\base.jpeg'   ,'This is a xiaomi redmi note 10','123' ),
    ('04bff57d-1521-4bd1-8f37-179sb18sh19x' ,'5b28f651-a11a-48f4-a401-8ejd8e03nd93'  ,'OPPO FIND N3'       ,'10','src\\main\\resources\\image\\PRODUCT\\base\\base.jpeg'   ,'This is an oppo find n3'   ,'456'),
    ('35a2976c-5e94-4d65-99bf-8ac8hsd8ahc1' ,'760a40c0-5104-4537-b804-6ad8v8a693hx'  ,'ASUS ROG PHONE 7'   ,'10','src\\main\\resources\\image\\PRODUCT\\base\\base.jpeg'   ,'This is an asus rog phone 7'    ,'456' )





