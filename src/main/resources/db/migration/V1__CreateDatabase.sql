CREATE TABLE IF NOT EXISTS user
(
    id         BIGINT(19) AUTO_INCREMENT PRIMARY KEY,
    password   VARCHAR(128),
    username  VARCHAR(150),
    first_name VARCHAR(30),
    last_name  VARCHAR(150),
    email      VARCHAR(254),
    role       ENUM ('ADMIN','USER') DEFAULT 'USER',
    created_at   DATETIME,
    updated_at   DATETIME
);

INSERT INTO user(password, username, first_name, last_name, email, role)
VALUES ('123123', 'admin', 'admin', 'admin', 'admin@gmail.com', 'ADMIN');