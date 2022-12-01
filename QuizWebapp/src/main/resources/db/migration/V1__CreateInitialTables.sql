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
    password varchar(100) NOT NULL ,
    id int NOT NULL AUTO_INCREMENT,
    total_score int NOT NULL ,
    PRIMARY KEY (id),
    UNIQUE (name)

);

CREATE TABLE user_role
(
    id        int         NOT NULL AUTO_INCREMENT,
    user_id   int         NOT NULL,
    role_name varchar(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (user_id, role_name),
    FOREIGN KEY (user_id) REFERENCES users (id)
);