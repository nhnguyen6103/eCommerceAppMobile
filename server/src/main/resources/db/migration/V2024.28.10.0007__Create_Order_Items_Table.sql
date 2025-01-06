CREATE TABLE IF NOT EXISTS order_items (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    order_id VARCHAR(36) NOT NULL,
    product_id VARCHAR(36) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE  CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO order_items (id, order_id, product_id, quantity, price)
VALUES
    ('420df789-f8de-4ecc-78fc-e2e2f9ed45af', '420ce691-f8de-4ecc-78fc-e2e2f9ed45af', '04bff57d-1521-4bd1-8f37-444cf5cc7219', '1', '123')