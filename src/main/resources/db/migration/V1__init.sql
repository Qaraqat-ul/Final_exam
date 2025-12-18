CREATE TABLE cinemas (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    address VARCHAR(250) NOT NULL,
    city VARCHAR(100) NOT NULL
);

CREATE TABLE genres (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(80) NOT NULL UNIQUE
);

CREATE TABLE movies (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    release_date DATE,
    description VARCHAR(1000),
    duration_minutes INT
);

CREATE TABLE movie_genres (
    movie_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY (movie_id, genre_id),
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE
);
