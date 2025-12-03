-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2025-11-28 08:06:35.365
-- tables
-- Table: album
CREATE TABLE album
(
    id           serial       NOT NULL,
    user_id      int          NOT NULL,
    name         varchar(255) NOT NULL,
    description  varchar(500) NULL,
    created_date date         NOT NULL,
    status       varchar(3)   NOT NULL,
    cover_image  bytea        NOT NULL,
    CONSTRAINT album_pk PRIMARY KEY (id)
);
-- Table: album_image
CREATE TABLE album_image
(
    id                serial       NOT NULL,
    album_id          int          NOT NULL,
    image_data        bytea        NOT NULL,
    photographer_name varchar(255) NULL,
    description       varchar(255) NULL,
    CONSTRAINT album_image_pk PRIMARY KEY (id)
);
-- Table: county
CREATE TABLE county
(
    id         serial        NOT NULL,
    name       varchar(255)  NOT NULL,
    zoom_level int           NULL,
    lng        decimal(9, 6) NULL,
    lat        decimal(9, 6) NULL,
    CONSTRAINT county_pk PRIMARY KEY (id)
);
-- Table: favorite_location
CREATE TABLE favorite_location
(
    id          serial NOT NULL,
    user_id     int    NOT NULL,
    location_id int    NOT NULL,
    CONSTRAINT user_favorite_location_pk PRIMARY KEY (id)
);
-- Table: location
CREATE TABLE location
(
    id               serial        NOT NULL,
    user_id          int           NOT NULL,
    location_type_id int           NOT NULL,
    county_id        int           NOT NULL,
    name             varchar(255)  NOT NULL,
    address          varchar(255)  NULL,
    lng              decimal(9, 6) NOT NULL,
    lat              decimal(9, 6) NOT NULL,
    description      varchar(1000) NULL,
    status           varchar(3)    NOT NULL,
    average_rating   decimal(2, 1) NOT NULL,
    created_at       timestamp     NOT NULL,
    CONSTRAINT location_pk PRIMARY KEY (id)
);
-- Table: location_image
CREATE TABLE location_image
(
    id          serial NOT NULL,
    location_id int    NOT NULL,
    image_data  bytea  NOT NULL,
    CONSTRAINT location_image_pk PRIMARY KEY (id)
);
-- Table: location_rating
CREATE TABLE location_rating
(
    id          serial    NOT NULL,
    user_id     int       NOT NULL,
    location_id int       NOT NULL,
    rating      int       NOT NULL,
    created_at  timestamp NOT NULL,
    CONSTRAINT location_rating_pk PRIMARY KEY (id)
);
-- Table: location_tag
CREATE TABLE location_tag
(
    id          serial NOT NULL,
    location_id int    NOT NULL,
    tag_id      int    NOT NULL,
    CONSTRAINT location_tag_pk PRIMARY KEY (id)
);
-- Table: location_type
CREATE TABLE location_type
(
    id         serial       NOT NULL,
    name       varchar(255) NOT NULL,
    color_code varchar(10)  NOT NULL,
    CONSTRAINT location_type_pk PRIMARY KEY (id)
);
-- Table: role
CREATE TABLE role
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (id)
);
-- Table: tag
CREATE TABLE tag
(
    id   serial      NOT NULL,
    name varchar(20) NOT NULL,
    CONSTRAINT tag_pk PRIMARY KEY (id)
);
-- Table: user
CREATE TABLE "user"
(
    id       serial       NOT NULL,
    role_id  int          NOT NULL,
    username     varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    email    varchar(255) NOT NULL,
    status   varchar(3)   NOT NULL,
    CONSTRAINT user_account_pk PRIMARY KEY (id)
);
-- Table: user_location
CREATE TABLE user_location
(
    id          serial NOT NULL,
    user_id     int    NOT NULL,
    location_id int    NOT NULL,
    CONSTRAINT user_location_pk PRIMARY KEY (id)
);
-- foreign keys
-- Reference: album_image_album (table: album_image)
ALTER TABLE album_image
    ADD CONSTRAINT album_image_album
        FOREIGN KEY (album_id)
            REFERENCES album (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: album_user (table: album)
ALTER TABLE album
    ADD CONSTRAINT album_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: location_county_fk (table: location)
ALTER TABLE location
    ADD CONSTRAINT location_county_fk
        FOREIGN KEY (county_id)
            REFERENCES county (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: location_image_location (table: location_image)
ALTER TABLE location_image
    ADD CONSTRAINT location_image_location
        FOREIGN KEY (location_id)
            REFERENCES location (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: location_location_type (table: location)
ALTER TABLE location
    ADD CONSTRAINT location_location_type
        FOREIGN KEY (location_type_id)
            REFERENCES location_type (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: location_rating_location_fk (table: location_rating)
ALTER TABLE location_rating
    ADD CONSTRAINT location_rating_location_fk
        FOREIGN KEY (location_id)
            REFERENCES location (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: location_rating_user (table: location_rating)
ALTER TABLE location_rating
    ADD CONSTRAINT location_rating_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: location_tag_location_fk (table: location_tag)
ALTER TABLE location_tag
    ADD CONSTRAINT location_tag_location_fk
        FOREIGN KEY (location_id)
            REFERENCES location (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: location_tag_tag_fk (table: location_tag)
ALTER TABLE location_tag
    ADD CONSTRAINT location_tag_tag_fk
        FOREIGN KEY (tag_id)
            REFERENCES tag (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: location_user_fk (table: location)
ALTER TABLE location
    ADD CONSTRAINT location_user_fk
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: user_account_role_fk (table: user)
ALTER TABLE "user"
    ADD CONSTRAINT user_account_role_fk
        FOREIGN KEY (role_id)
            REFERENCES role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: user_fav_location_fk (table: favorite_location)
ALTER TABLE favorite_location
    ADD CONSTRAINT user_fav_location_fk
        FOREIGN KEY (location_id)
            REFERENCES location (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: user_fav_user_fk (table: favorite_location)
ALTER TABLE favorite_location
    ADD CONSTRAINT user_fav_user_fk
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: user_location_location_fk (table: user_location)
ALTER TABLE user_location
    ADD CONSTRAINT user_location_location_fk
        FOREIGN KEY (location_id)
            REFERENCES location (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: user_location_user_fk (table: user_location)
ALTER TABLE user_location
    ADD CONSTRAINT user_location_user_fk
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;