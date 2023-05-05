USE db1;

-- API-Users Table
DROP TABLE IF EXISTS api_user;
CREATE TABLE api_user (ID bigint (20), password varchar(255), token varchar(255), user_name VARCHAR(255));
INSERT INTO api_user VALUES(1, 'lfpw', 'lftoken', 'lfun');
INSERT INTO api_user VALUES(2, 'bhpw', 'bhtoken', 'bhun');
SELECT * FROM api_user; 

-- Students table
DROP TABLE IF EXISTS student;
CREATE TABLE student (ID bigint (20), first_name varchar(255), last_name varchar(255), address VARCHAR(255));
INSERT INTO student VALUES(1, 'Leo', 'Manchester', '1111 Address Way');
INSERT INTO student VALUES(2, 'Brian', 'Hillsley', '2222 Square Circle');
SELECT * FROM student; 

-- Courses Table TODO
DROP TABLE IF EXISTS course;
CREATE TABLE course (ID bigint (20), number bigint(20), title varchar(255));
INSERT INTO course VALUES(1, 101, 'Intro to Physics');
INSERT INTO course VALUES(2, 202, 'Intro to Physics II: Electromagnetism');
SELECT * FROM course; 

-- Registrars Table TODO
DROP TABLE IF EXISTS registrar;
CREATE TABLE registrar (ID bigint(20), course_number bigint(20), student_id varchar(255));
INSERT INTO registrar VALUES(1, 101, 1);
INSERT INTO registrar VALUES(2, 101, 2);
INSERT INTO registrar VALUES(3, 102, 1);
INSERT INTO registrar VALUES(4, 202, 2);
SELECT * FROM registrar;

