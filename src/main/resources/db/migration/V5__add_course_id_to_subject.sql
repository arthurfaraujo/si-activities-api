ALTER TABLE subject
ADD COLUMN course_id INT NOT NULL,
ADD CONSTRAINT fk_course
FOREIGN KEY (course_id)
REFERENCES course(id);

ALTER TABLE subject ADD COLUMN period INT NOT NULL;

UPDATE subject s
SET s.course_id = c.id, s.period = 1
FROM course c
WHERE c.name = "Sistemas para Internet";


