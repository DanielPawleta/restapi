--liquibase formatted sql
--changeset root:1
CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    title VARCHAR(400) NOT NULL,
    content VARCHAR(2000) NULL,
    created timestamp(6)
);