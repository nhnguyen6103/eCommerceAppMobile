CREATE TABLE IF NOT EXISTS cart_items (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    cart_id VARCHAR(36) NOT NULL,
    product_id VARCHAR(36) NOT NULL ,
    quantity INT NOT NULL DEFAULT 1,
    FOREIGN KEY (cart_id) REFERENCES carts(id) ON DELETE  CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE  CASCADE
);

INSERT INTO cart_items (id, cart_id, product_id, quantity)
VALUES
    ('04bff57d-1521-6d8f-8f37-444cf5cc7219','a6045481-648d-44d1-9b3a-e802bda996b9','35a2976c-5e94-4d65-99bf-0c0012d0a8aa',1),
    ('04bff57d-1521-4bd1-7dc6-444cf5cc7219','a6045481-648d-44d1-9b3a-e802bda996b9','793fcd4f-ba00-46ec-ae54-75fbea9d8fdc',2)
