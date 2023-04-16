CREATE TABLE todo
(
    id   SERIAL PRIMARY KEY,
    user VARCHAR(255) NOT NULL,
    date TIMESTAMP    NOT NULL,
    done BOOLEAN      NOT NULL,
    text TEXT         NOT NULL
);
