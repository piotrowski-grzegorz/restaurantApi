CREATE TABLE if not exists RESTAURANT
(
    id BIGINT auto_increment primary key ,
    name VARCHAR(128) NOT NULL,
    type VARCHAR(128) NOT NULL,
    OPEN_HOUR VARCHAR(6) not null,
    close_hour VARCHAR(6) NOT NULL ,
    address_id bigint,
    foreign key (address_id) references ADDRESS (id)

);

