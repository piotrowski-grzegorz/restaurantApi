CREATE TABLE IF NOT EXISTS address
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    street              VARCHAR(128) NOT NULL,
    building_number     VARCHAR(128) NOT NULL,
    apartment_number   VARCHAR(128),
    city                VARCHAR(128) NOT NULL,
    postal_code         VARCHAR(128) NOT NULL,
    country             VARCHAR(128) NOT NULL,
    restaurant_id bigint

);
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

ALTER TABLE address ADD CONSTRAINT address FOREIGN KEY (restaurant_id) REFERENCES RESTAURANT(ID);

