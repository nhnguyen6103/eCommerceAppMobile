CREATE TABLE IF NOT EXISTS orders (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    user_id VARCHAR(36) NOT NULL,
    total_amount DOUBLE NOT NULL,
    status VARCHAR(255) NOT NULL,
    shipping_address VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL ,
    updated_at TIMESTAMP,
    payment_method VARCHAR(255),
    shipping_method VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO orders (id, user_id, total_amount, status, shipping_address, created_at, updated_at, payment_method, shipping_method)
VALUES
    ('420ce691-f8de-4ecc-78fc-e2e2f9ed45af','420ce691-f8de-4ecc-92d7-e2e2f9ed45af','123','complete','123 abc street def city', '2024-11-01 13:45:30', '2024-11-04 13:45:30', 'COD', 'JAVA SHIPPING')