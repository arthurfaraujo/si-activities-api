CREATE TABLE
  user_subject (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL,
  subject_id INT NOT NULL,
  reference_period TEXT NOT NULL,
  CONSTRAINT fk_users_subject_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE CASCADE,
  CONSTRAINT fk_users_subject_subject_id FOREIGN KEY (subject_id) REFERENCES subject (id) ON UPDATE CASCADE,
  CONSTRAINT unq_users_subject UNIQUE (user_id, subject_id, reference_period),
  CONSTRAINT chk_reference_period_format CHECK (reference_period ~ '^\d{4}\.[12]$'),
  CONSTRAINT chk_reference_period_valid CHECK (
    SUBSTRING(
      reference_period
      FROM
        1 FOR 4
    )::INT BETWEEN EXTRACT(
      YEAR
      FROM
        CURRENT_DATE
    )::INT AND EXTRACT(
      YEAR
      FROM
        CURRENT_DATE
    )::INT + 1
  )
);

CREATE OR REPLACE FUNCTION verify_user_course () 
RETURNS TRIGGER AS $$
DECLARE
  course_id_var INT;
BEGIN
  SELECT course_id
  INTO course_id_var
  FROM users
  WHERE id = NEW.user_id;

  IF course_id_var IS NULL THEN
    RAISE EXCEPTION 'Error: can not insert/update the relationship with an user without an associated course';
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER chk_user_course 
BEFORE INSERT OR UPDATE ON user_subject 
FOR EACH ROW
EXECUTE FUNCTION verify_user_course ();

ALTER TABLE subject
DROP CONSTRAINT subject_name_key;

ALTER TABLE subject
ADD CONSTRAINT unq_subject_name_course UNIQUE (name, course_id);