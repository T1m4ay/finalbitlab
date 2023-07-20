INSERT INTO t_role (role)
VALUES
    ('ROLE_USER'),
    ('ROLE_ADMIN');

INSERT INTO t_users (email, full_name, password)
VALUES
    ('tero4y@gmail.com', 'Tima Daulet', '$2a$10$TybLhh7EgZR5T1bqGDrEP.CHeGq0w2OWBhXvNp5RKu2xLqz0TzmoG'),
    ('29607@gmail.com', 'Temirlan Dauletkhanov', '$2a$10$yi6eYOxZK.ZZWJEdPEvAEujXI.4XO7SOFhCFm7Z/wCpAm1SAomOo2');

INSERT INTO t_users_role (user_id, role_id)
VALUES
    (1,1),
    (2,2);

INSERT INTO t_game (author, description, name, genre, handled)
VALUES
    ('Tima Daulet', 'Dota 2 is a multiplayer online battle arena (MOBA) video game in which two teams of five players compete to destroy a large structure defended by the opposing team known as the "Ancient" whilst defending their own.', 'Dota 2', 'RPG', true),
    ('Tima Daulet', 'Counter-Strike: Global Offensive (CS:GO) is a round-based, 5v5 tactical FPS with an Attackers vs. Defenders setup and no respawns, meaning if a player is eliminated they will not respawn until the next round.', 'CS:GO', 'Shooter', false),
    ('Temirlan Dauletkhanov', 'FIFA 23 features the mens World Cup game mode and the womens World Cup game mode, replicating the 2022 FIFA World Cup and the 2023 FIFA Womens World Cup. ', 'FIFA 23', 'Sport', false),
    ('Temirlan Dauletkhanov', 'In God of War, players control Kratos, a Spartan warrior who is sent by the Greek gods to kill Ares, the god of war. As the story progresses, Kratos is revealed to be Ares'' former servant, who had been tricked into killing his own family and is haunted by terrible nightmares.', 'God of war', 'Adventure', true);

INSERT INTO t_game_genre (g_name)
VALUES
    ('RPG'),
    ('Shooter'),
    ('Sport'),
    ('Adventure');