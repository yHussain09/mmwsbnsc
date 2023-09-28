INSERT INTO user_entity (id, name, birthdate) values (10001, 'Yasir', current_date);
INSERT INTO user_entity (id, name, birthdate) values (10002, 'Farhan', current_date);
INSERT INTO user_entity (id, name, birthdate) values (10003, 'Daud', current_date);

INSERT INTO post (id, description, user_id) values (20001, 'Post description for Yasir', 10001);
INSERT INTO post (id, description, user_id) values (20002, 'Post 2 description for Yasir', 10001);
INSERT INTO post (id, description, user_id) values (20003, 'Post description for Farhan', 10002);
INSERT INTO post (id, description, user_id) values (20004, 'Post 2 description for Farhan', 10002);
INSERT INTO post (id, description, user_id) values (20005, 'Post description for Daud', 10003);
INSERT INTO post (id, description, user_id) values (20006, 'Post 2 description for Daud', 10003);