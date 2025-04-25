CREATE OR REPLACE FUNCTION verify_period_integrity()
RETURNS trigger AS $$
DECLARE
  max_period INT;
BEGIN
  SELECT periods_number 
  INTO max_period
  FROM course 
  WHERE id = NEW.course_id;

  IF NEW.period > max_period THEN 
    RAISE EXCEPTION 'Error: period number is greater than the number of periods from the associated course';
  END IF;

  IF NEW.period < 1 THEN 
    RAISE EXCEPTION 'Error: period number can not be less than one';
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER chk_period_integrity_ins 
BEFORE INSERT OR UPDATE ON subject
FOR EACH ROW
EXECUTE FUNCTION verify_period_integrity();
