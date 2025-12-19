create table directors (
                           id bigserial primary key,
                           full_name varchar(255) not null
);

create table genres (
                        id bigserial primary key,
                        name varchar(100) not null unique
);

create table movies (
                        id bigserial primary key,
                        title varchar(255) not null,
                        director_id bigint not null references directors(id)
);

create table movie_genres (
                              movie_id bigint not null references movies(id),
                              genre_id bigint not null references genres(id),
                              primary key (movie_id, genre_id)
);


insert into directors(full_name) values ('Christopher Nolan'), ('Denis Villeneuve');
insert into genres(name) values ('Sci-Fi'), ('Drama'), ('Action');