CREATE TABLE IF NOT EXISTS carts (
    id VARCHAR(36) NOT NULL UNIQUE PRIMARY KEY,
    user_id VARCHAR(36) NOT NULL UNIQUE ,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO carts (id, user_id)
VALUES
    ('420ce691-cd71-4ecc-92d7-e2e2f9ed45af','a6045481-642b-44d1-9b3a-e802bda996b9'),    -- ADMIN
    ('a6045481-648d-44d1-9b3a-e802bda996b9','111f66ca-1777-4662-bec4-dae6e97d0843'),    -- USER1
    ('111f66ca-1777-4662-aed9-dae6e97d0843','420ce691-f8de-4ecc-92d7-e2e2f9ed45af')     -- USER2

