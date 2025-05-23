CREATE TABLE class (
  id SERIAL PRIMARY KEY,
  subject_id INT NOT NULL,
  reference_period TEXT NOT NULL,
  CONSTRAINT fk_class_subject FOREIGN KEY (subject_id) REFERENCES subject (id) ON UPDATE CASCADE,
  CONSTRAINT chk_reference_period_format CHECK (reference_period ~ '^\d{4}\.[12]$'),
  CONSTRAINT unq_class_subject_period_group UNIQUE (subject_id, reference_period)
);

ALTER TABLE subject
DROP CONSTRAINT subject_name_key;

ALTER TABLE subject
ADD CONSTRAINT unq_subject_name_course UNIQUE (name, course_id);