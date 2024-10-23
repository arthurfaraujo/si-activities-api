CREATE TABLE IF NOT EXISTS course (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS period (
  id SERIAL PRIMARY KEY,
  description VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS course_period (
  course_id INT,
  period_id INT,
  PRIMARY KEY (course_id, period_id),
  FOREIGN KEY (course_id) REFERENCES course(id),
  FOREIGN KEY (period_id) REFERENCES period(id)
);