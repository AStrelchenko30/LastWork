-- liquibase formated sql
-- changeset sgorban:1

CREATE TABLE user_profiles
(
    id        SERIAL primary key not null,
    email     TEXT,
    firstName TEXT,
    lastName  TEXT,
    phone     TEXT
);

CREATE TABLE avatar
(
    id             SERIAL primary key not null,
    data           bytea,
    userProfile_id BIGSERIAL references user_profiles (id),
    avatar_id      BIGSERIAL references avatar (id)
);

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
    user_profile_id BIGSERIAL references user_profiles (id),
    image_id        BIGSERIAL references image (id)
);

CREATE TABLE comments
(
    id              SERIAL primary key not null,
    ads_id          BIGSERIAL,
    user_profile_id BIGSERIAL,
    created_at      TIMESTAMP,
    text            TEXT
);





