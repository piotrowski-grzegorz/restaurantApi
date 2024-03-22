CREATE TABLE IF NOT EXISTS RATING
(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY ,
    NAME VARCHAR(128),
    SURNAME VARCHAR(128),
    MARK BIGINT,
    REVIEW VARCHAR(128),
    restaurant_id bigint,
    foreign key (restaurant_id) references RESTAURANT (id)
);