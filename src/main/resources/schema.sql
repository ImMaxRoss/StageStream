-- Create schema (replace `your_database_name` with desired database name)
CREATE DATABASE IF NOT EXISTS stagestreamDB;
USE stagestreamDB;


-- Create table: users
CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    mobile_number VARCHAR(10) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    role VARCHAR(255) NOT NULL DEFAULT 'USER',
    password VARCHAR(255),
    PRIMARY KEY (user_id)
);

-- Create table: addresses
CREATE TABLE addresses (
    address_id BIGINT AUTO_INCREMENT NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    zipcode VARCHAR(255) NOT NULL,
    PRIMARY KEY (address_id)
);

-- Create user_address bridge table
CREATE TABLE user_address (
    user_id BIGINT NOT NULL,
    address_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, address_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);

-- Create table: carts
CREATE TABLE carts (
    cart_id BIGINT AUTO_INCREMENT NOT NULL,
    user_id BIGINT,
    total_price DOUBLE DEFAULT 0.0,
    PRIMARY KEY (cart_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE SET NULL
);


-- Create table: products
CREATE TABLE products (
    product_id BIGINT AUTO_INCREMENT NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    quantity INT,
    price DOUBLE,
    discount DOUBLE,
    special_price DOUBLE,
    category VARCHAR(255),
    PRIMARY KEY (product_id),
);

-- Create table: payments
CREATE TABLE payments (
    payment_id BIGINT AUTO_INCREMENT NOT NULL,
    payment_method VARCHAR(255) NOT NULL,
    PRIMARY KEY (payment_id)
);

-- Create table: orders
CREATE TABLE orders (
    order_id BIGINT AUTO_INCREMENT NOT NULL,
    email VARCHAR(255) NOT NULL,
    order_date DATE,
    payment_id BIGINT,
    total_amount DOUBLE,
    order_status VARCHAR(255),
    PRIMARY KEY (order_id),
    FOREIGN KEY (payment_id) REFERENCES payments(payment_id) ON DELETE SET NULL
);

-- Create table: order_items
CREATE TABLE order_items (
    order_item_id BIGINT AUTO_INCREMENT NOT NULL,
    product_id BIGINT,
    order_id BIGINT,
    quantity INT,
    discount DOUBLE,
    ordered_product_price DOUBLE,
    PRIMARY KEY (order_item_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE SET NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE
);

-- Create table: cart_items
CREATE TABLE cart_items (
    cart_item_id BIGINT AUTO_INCREMENT NOT NULL,
    cart_id BIGINT,
    product_id BIGINT,
    quantity INT,
    discount DOUBLE,
    product_price DOUBLE,
    PRIMARY KEY (cart_item_id),
    FOREIGN KEY (cart_id) REFERENCES carts(cart_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE SET NULL
);