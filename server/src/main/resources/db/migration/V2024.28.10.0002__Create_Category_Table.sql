CREATE TABLE IF NOT EXISTS categories (
    id VARCHAR(36) NOT NULL UNIQUE PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

INSERT INTO categories (id, name, description)
VALUES
    ('5b28f651-a11a-48f4-a401-000ef2308aff','SAMSUNG'   ,'This is a samsung phone'),
    ('760a40c0-5104-4537-b804-35d11d1eb3fa','APPLE'     ,'This is an iphone'),
    ('caf53449-c871-4fd1-874f-cf50b4335909','XIAOMI'    ,'This is a xiaomi phone'),
    ('5b28f651-a11a-48f4-a401-8ejd8e03nd93','OPPO'      ,'This is an oppo phone'),
    ('760a40c0-5104-4537-b804-6ad8v8a693hx','ASUS'      ,'This is an asus phone'),
    ('caf53449-c871-4fd1-874f-19d0q4jd04jw','HUAWEI'    ,'This is a huawei phone')