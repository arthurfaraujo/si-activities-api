CREATE TABLE IF NOT EXISTS course (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) UNIQUE NOT NULL
  totalPeriods INT NOT NULL
);

INSERT INTO course (name, totalPeriods) VALUES ("Sistemas para Internet", 6);