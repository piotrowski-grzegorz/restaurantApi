CREATE TABLE IF NOT EXISTS RESERVATION (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    GUEST_NAME VARCHAR(128) NOT NULL ,
    GUEST_SURNAME VARCHAR(128),
    GUEST_PHONENUMBER VARCHAR(128),
    RESERVATION_DATE TIMESTAMP,
    PREBOOKED_BY_CLIENT BOOLEAN NOT NULL,
    CONFIRMED_BY_HOST BOOLEAN NOT NULL,
    REJECTED_BY_HOST BOOLEAN NOT NULL,
    COMMENTS VARCHAR(128)
);