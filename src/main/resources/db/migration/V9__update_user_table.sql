ALTER TABLE users
ADD COLUMN IF NOT EXISTS
course_id INT;

ALTER TABLE users
ADD COLUMN IF NOT EXISTS
period INT;

ALTER TABLE users
ADD CONSTRAINT fk_user_course
FOREIGN KEY (course_id)
REFERENCES course(id);

CREATE OR REPLACE FUNCTION verify_user_period_integrity()
RETURNS TRIGGER AS $$
DECLARE
  max_period INT;
BEGIN
  IF NEW.course_id IS NOT NULL THEN
    SELECT periods_number 
    INTO max_period
    FROM course 
    WHERE id = NEW.course_id;
    
    IF NEW.period IS NULL THEN
      RAISE EXCEPTION 'Error: can not insert/update user with an associated course without period';
    END IF;

    IF NEW.period > max_period THEN 
      RAISE EXCEPTION 'Error: period number is greater than the number of periods from the associated course';
    END IF;

    IF NEW.period < 1 THEN 
      RAISE EXCEPTION 'Error: period number can not be less than one';
    END IF;
  ELSE
    IF NEW.period IS NOT NULL THEN
      RAISE EXCEPTION 'Error: can not insert/update period in a user without an associated course';
    END IF;
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER chk_user_period_integrity
BEFORE INSERT OR UPDATE ON users
FOR EACH ROW
EXECUTE FUNCTION verify_user_period_integrity();
