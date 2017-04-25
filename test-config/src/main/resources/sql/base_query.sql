CREATE DATABASE full_stack_test;

CREATE TABLE user(
	id bigint PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(200),
    phone VARCHAR(200),
    gender VARCHAR(1)
);

INSERT INTO user VALUES(1,'Daniel Kanczuk','danielsussa@gmail.com','986877728','H');
INSERT INTO user VALUES(2,'Marilia Melo','cmmarilia@gmail.com','789588544','M');


SELECT * FROM user;