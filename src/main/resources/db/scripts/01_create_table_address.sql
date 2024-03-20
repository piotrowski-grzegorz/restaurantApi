CREATE TABLE IF NOT EXISTS address
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    street              VARCHAR(128) NOT NULL,
    building_number     VARCHAR(128) NOT NULL,
    apartment_number   VARCHAR(128),
    city                VARCHAR(128) NOT NULL,
    postal_code         VARCHAR(128) NOT NULL,
    country             VARCHAR(128) NOT NULL

)