--liquibase formatted sql
--changeset root:1
CREATE TABLE comment (
    id SERIAL PRIMARY KEY,
    post_id BIGINT NOT NULL,
    content VARCHAR(2000) NULL,
    created timestamp(6)
);

ALTER TABLE comment
    ADD CONSTRAINT comment_post_id
    FOREIGN KEY (post_id) REFERENCES post(id)
