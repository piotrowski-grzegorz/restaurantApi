CREATE TABLE if not exists RESTAURANT
(
    id BIGINT auto_increment primary key ,
    name VARCHAR(128) NOT NULL,
    type VARCHAR(128) NOT NULL,
    OPEN_HOUR VARCHAR(6) not null,
    close_hour VARCHAR(6) NOT NULL ,
    AVG_MARK BIGINT,
    ADDRESS_ID BIGINT,
    TABLES_ID BIGINT


);

CREATE TABLE IF NOT EXISTS ADDRESS
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    street              VARCHAR(128) ,
    building_number     VARCHAR(128) ,
    apartment_number   VARCHAR(128),
    city                VARCHAR(128) ,
    postal_code         VARCHAR(128) ,
    country             VARCHAR(128),
    restaurant_id bigint,
    foreign key (restaurant_id) references RESTAURANT (id)
);

CREATE TABLE if not exists TABLES
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    ARRANGEMENT VARCHAR (128) NOT NULL,
    VISIBLE_FOR_CLIENT BOOLEAN NOT NULL,
    RESTAURANT_ID BIGINT,
    foreign key (RESTAURANT_ID) REFERENCES RESTAURANT (ID)
);

ALTER TABLE RESTAURANT add foreign key (ADDRESS_ID) references address (id);
ALTER TABLE RESTAURANT add foreign key (TABLES_ID) references TABLES (id);


