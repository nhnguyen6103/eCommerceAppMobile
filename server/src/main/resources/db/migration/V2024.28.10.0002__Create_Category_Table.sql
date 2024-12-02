CREATE TABLE IF NOT EXISTS categories (
    id VARCHAR(36) NOT NULL UNIQUE PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

INSERT INTO categories (id, name, description)
VALUES
    ('5b28f651-a11a-48f4-a401-000ef2308aff','SAMSUNG'   ,'This is a samsung phone'),
    ('760a40c0-5104-4537-b804-35d11d1eb3fa','APPLE'     ,'This is a iphone'),
    ('caf53449-c871-4fd1-874f-cf50b4335909','XIAOMI'    ,'This is a xiaomi phone')