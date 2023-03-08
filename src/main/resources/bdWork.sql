-- liquibase formated sql
-- changeset sgorban:1

CREATE TABLE user_profiles
(
    id        SERIAL primary key not null,
    email     VARCHAR,
    firstName VARCHAR,
    lastName  VARCHAR,
    phone     VARCHAR
);

CREATE TABLE avatar
(
    id int8 primary key not null,
    data bytea,
    userProfile_id BIGSERIAL references user_profiles (id)
);

CREATE TABLE image
(
    id        SERIAL primary key not null,
    data      bytea,
    fileSize  BIGSERIAL,
    mediaType VARCHAR
);

CREATE TABLE ads
(
    id              SERIAL primary key not null,
    description     VARCHAR,
    price           INTEGER,
    title           VARCHAR,
    user_profile_id BIGSERIAL references user_profiles (id),
    image_id        BIGSERIAL references image (id)
);

CREATE TABLE comments
(
    id              SERIAL primary key not null,
    ads_id          BIGSERIAL,
    user_profile_id BIGSERIAL,
    created_at      TIMESTAMP,
    text            VARCHAR
);





