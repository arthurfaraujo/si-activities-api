CREATE TABLE IF NOT EXISTS role (
  id SERIAL PRIMARY KEY,
  description TEXT UNIQUE NOT NULL 
);

INSERT INTO role values (default, 'user'), (default, 'admin');

CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  nickname TEXT UNIQUE NOT NULL,
  email TEXT UNIQUE NOT NULL,
  password TEXT NOT NULL
);

