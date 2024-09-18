INSERT INTO subject (name)
SELECT DISTINCT subject
FROM activity
WHERE subject NOT IN (SELECT name FROM subject);

ALTER TABLE activity ADD COLUMN subject_id INT;

UPDATE activity a
SET subject_id = s.id
FROM subject s
WHERE a.subject = s.name;

ALTER TABLE activity DROP COLUMN subject;