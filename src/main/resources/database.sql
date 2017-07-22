-- Product table
CREATE TABLE product (
  id          INT          NOT NULL PRIMARY KEY,
  title       VARCHAR(255) NOT NULL,
  producer    VARCHAR(255),
  price       REAL         NOT NULL,
  description VARCHAR(255)
);

-- Users table
CREATE TABLE users (
  id       INT          NOT NULL PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255)
);

-- Roles table
CREATE TABLE roles (
  id         INT NOT NULL PRIMARY KEY,
  role_title VARCHAR(255)
);

-- Table for mapping users and roles
CREATE TABLE user_role (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
);

-- Populates tables 
INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO users VALUES (1, 'ADMIN', '1234');

INSERT INTO user_role VALUES (1, 2)
