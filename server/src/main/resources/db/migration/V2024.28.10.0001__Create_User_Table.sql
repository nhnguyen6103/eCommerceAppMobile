CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(36) NOT NULL UNIQUE PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE ,
    phone_number VARCHAR(10) UNIQUE ,
    role VARCHAR(10) NOT NULL ,
    password VARCHAR(255) NOT NULL ,
    imageURL VARCHAR(255) NOT NULL
);

INSERT INTO users(id, phone_number, username, email, role, password, imageURL)
VALUES
    ('a6045481-642b-44d1-9b3a-e802bda996b9', '0000000000' , 'ADMIN', 'admin@ad.com', 'ADMIN', '$2a$10$QgU.Q1tnV2byP02YqRw81.4grgsxMOsQCyYC0AzMWeYnF9vkbiOmK', 'src\\main\\resources\\image\\USER\\base\\base.jpeg'),
    ('111f66ca-1777-4662-bec4-dae6e97d0843', '1234567890' , 'USER1', 'user1@us.com', 'USER' , '$2a$10$TRPbc24XPjdYYO7RT4E2dOBrUBVLDi57VkekRb3xf5JjZv.eYtoAa', 'src\\main\\resources\\image\\USER\\base\\base.jpeg'),
    ('420ce691-f8de-4ecc-92d7-e2e2f9ed45af', '1512612141' , 'USER2', 'user2@us.com', 'USER' , '$2a$10$TRPbc24XPjdYYO7RT4E2dOBrUBVLDi57VkekRb3xf5JjZv.eYtoAa', 'src\\main\\resources\\image\\USER\\base\\base.jpeg'),
    ('639ce691-7381-4edc-9217-e2e2f9ed45af', '1642346234' , 'USER3', 'user3@us.com', 'USER' , '$2a$10$TRPbc24XPjdYYO7RT4E2dOBrUBVLDi57VkekRb3xf5JjZv.eYtoAa', 'src\\main\\resources\\image\\USER\\base\\base.jpeg'),
    ('812ce691-f8de-8fcc-95d7-e2e2f9ed45af', '5156135712' , 'USER4', 'user4@us.com', 'USER' , '$2a$10$TRPbc24XPjdYYO7RT4E2dOBrUBVLDi57VkekRb3xf5JjZv.eYtoAa', 'src\\main\\resources\\image\\USER\\base\\base.jpeg')