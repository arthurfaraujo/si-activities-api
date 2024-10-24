ALTER TABLE subject
ADD COLUMN course_id INT,
ADD CONSTRAINT fk_course
FOREIGN KEY (course_id)
REFERENCES course(id),
ADD COLUMN period INT;

UPDATE subject
SET course_id = c.id, period = 1
FROM course c
WHERE c.name = 'Sistemas para Internet';

ALTER TABLE subject
ALTER COLUMN course_id SET NOT NULL,
ALTER COLUMN period SET NOT NULL;

