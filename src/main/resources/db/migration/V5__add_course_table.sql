CREATE TABLE IF NOT EXISTS course (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) UNIQUE NOT NULL,
  periods_number INT NOT NULL
);

INSERT INTO course (name, periods_number) VALUES ('Sistemas para Internet', 6);