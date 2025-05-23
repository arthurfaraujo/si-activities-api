CREATE TABLE user_class (
  user_id INT NOT NULL,
  class_id INT NOT NULL,
  CONSTRAINT fk_user_class_user_id FOREIGN KEY (user_id) REFERENCES users (id) 
    ON UPDATE CASCADE,
  CONSTRAINT fk_user_class_class_id FOREIGN KEY (class_id) REFERENCES class (id)
    ON UPDATE CASCADE,
  CONSTRAINT pk_user_class PRIMARY KEY (user_id, class_id)
);

CREATE FUNCTION is_reference_period_valid()
RETURNS TRIGGER AS $$
DECLARE
  ref_period TEXT;
  ref_year INT;
  ref_semester INT;
  curr_year INT := EXTRACT(YEAR FROM CURRENT_DATE)::INT;
  curr_semester INT := CASE WHEN EXTRACT(MONTH FROM CURRENT_DATE)::INT > 6 THEN 2 ELSE 1 END;
  curr_month INT := EXTRACT(MONTH FROM CURRENT_DATE)::INT;
BEGIN
  SELECT reference_period
  INTO ref_period
  FROM class
  WHERE id = NEW.class_id;

  ref_year := SUBSTRING(ref_period FROM 1 FOR 4)::INT;
  ref_semester := SUBSTRING(ref_period FROM 6 FOR 1)::INT;

  IF ref_year = curr_year THEN
    IF ref_semester = curr_semester THEN
      RETURN NEW;
    END IF;

    IF ref_semester > curr_semester AND curr_month = 6 THEN
      RETURN NEW;
    END IF;
  ELSIF ref_year = (curr_year + 1) AND ref_semester = 1 AND curr_month = 12 THEN
    RETURN NEW;
  END IF;

  RAISE EXCEPTION 'Error: trying to enroll on invalid class';
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER chk_reference_period_valid
BEFORE INSERT OR UPDATE ON user_class
FOR EACH ROW
EXECUTE FUNCTION is_reference_period_valid();

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
    RAISE EXCEPTION 'Error: can not insert/update the table user_class with an user without an associated course';
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER chk_has_user_course 
BEFORE INSERT OR UPDATE ON user_class 
FOR EACH ROW
EXECUTE FUNCTION verify_user_course ();
