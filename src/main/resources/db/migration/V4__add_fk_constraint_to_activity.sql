ALTER TABLE activity
ADD CONSTRAINT fk_course
FOREIGN KEY (subject_id)
REFERENCES subject(id);