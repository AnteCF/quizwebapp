CREATE TABLE quizzes
(
    name varchar(20) NOT NULL,
    questions JSON DEFAULT NULL,
    creator_id int,
    rating float,
    description varchar(40),
    possible_answers JSON DEFAULT NULL,
    correct_answers JSON DEFAULT NULL,
    PRIMARY KEY(name)
);

CREATE TABLE users
(
    name varchar(20) NOT NULL,
    role varchar(5) NOT NULL,
    password varchar(50) NOT NULL ,
    id int NOT NULL AUTO_INCREMENT,
    total_score int NOT NULL ,
    PRIMARY KEY (Id)
);