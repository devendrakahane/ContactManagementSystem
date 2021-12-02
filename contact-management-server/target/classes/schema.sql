CREATE TABLE IF NOT EXISTS contact  (
    id INT NOT NULL PRIMARY KEY auto_increment,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    phone_number VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255),
    status Boolean
);