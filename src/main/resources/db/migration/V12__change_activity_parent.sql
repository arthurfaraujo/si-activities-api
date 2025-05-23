ALTER TABLE activity
DROP CONSTRAINT fk_course;

ALTER TABLE activity
DROP COLUMN subject_id;

ALTER TABLE activity
ADD COLUMN class_id INT NOT NULL;

ALTER TABLE activity 
ADD CONSTRAINT fk_activity_class
FOREIGN KEY (class_id) REFERENCES class (id);
