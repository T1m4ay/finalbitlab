CREATE TABLE t_role (
                        id SERIAL PRIMARY KEY,
                        role VARCHAR(255)
);

CREATE TABLE t_users (
                         id SERIAL PRIMARY KEY ,
                         email VARCHAR(255),
                         full_name VARCHAR(255),
                         password VARCHAR(255)
);

CREATE TABLE t_users_role (
                               user_id SERIAL,
                               role_id SERIAL,
                               FOREIGN KEY (user_id) REFERENCES t_users (id),
                               FOREIGN KEY (role_id) REFERENCES t_role (id)
);

CREATE TABLE t_game (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255),
                        description TEXT,
                        handled BOOLEAN,
                        author VARCHAR(255),
                        genre VARCHAR(255)
);

CREATE TABLE t_game_genre (
                              id SERIAL PRIMARY KEY,
                              g_name VARCHAR(255)
);

ALTER TABLE t_users_role
    ADD CONSTRAINT fk_t_users_role_t_users
        FOREIGN KEY (user_id)
            REFERENCES t_users (id);

ALTER TABLE t_users_role
    ADD CONSTRAINT fk_t_users_role_t_role
        FOREIGN KEY (role_id)
            REFERENCES t_role (id);