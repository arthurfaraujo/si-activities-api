CREATE TABLE activity (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  description VARCHAR(300),
  subject VARCHAR(150) NOT NULL,
  start_date DATE,
  end_date DATE
);