-- liquibase formated sql
-- changeset sgorban:1

CREATE TABLE user_profile
(
    id        SERIAL primary key not null,
    email     TEXT,
    firstName TEXT,
    lastName  TEXT,
    phone     TEXT

);

CREATE TABLE avatar
(
    id             TEXT primary key not null,
    data           bytea,
    user_profile_id BIGSERIAL references user_profile (id)

);

ALTER TABLE user_profile
    ADD avatar TEXT references avatar (id);
CREATE TABLE image
(
    id        SERIAL primary key not null,
    data      bytea,
    fileSize  BIGSERIAL,
    mediaType TEXT
);

CREATE TABLE ads
(
    id              SERIAL primary key not null,
    description     TEXT,
    price           INTEGER,
    title           TEXT,
    user_profile_id BIGSERIAL references user_profile (id),
    image_id        BIGSERIAL references image (id)
);

CREATE TABLE comment
(
    id              SERIAL primary key not null,
    ads_id          BIGSERIAL,
    user_profile_id BIGSERIAL,
    created_at      TIMESTAMP,
    text            TEXT
);





