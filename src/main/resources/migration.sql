DROP TABLE IF EXISTS event_player;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS player;

CREATE TABLE player (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE event (
   id INTEGER NOT NULL PRIMARY KEY,
   winner INTEGER NOT NULL,
   FOREIGN KEY (winner) REFERENCES player(id)
);

CREATE TABLE event_player (
    event_id INTEGER NOT NULL,
    player_id INTEGER NOT NULL,
    hand VARCHAR(255) NOT NULL,
    PRIMARY KEY (event_id, player_id),
    FOREIGN KEY (event_id) REFERENCES event(id),
    FOREIGN KEY (player_id) REFERENCES player(id)
);

INSERT INTO player (id, name) VALUES (1, 'ed');
INSERT INTO player (id, name) VALUES (2, 'dan');
INSERT INTO player (id, name) VALUES (3, 'mon');
INSERT INTO player (id, name) VALUES (4, 'jm');
INSERT INTO player (id, name) VALUES (5, 'kai');
INSERT INTO player (id, name) VALUES (6, 'kent');
INSERT INTO player (id, name) VALUES (7, 'vin');
INSERT INTO player (id, name) VALUES (8, 'liam');

INSERT INTO event (id, winner) VALUES (1, 1);
INSERT INTO event (id, winner) VALUES (2, 2);
INSERT INTO event (id, winner) VALUES (3, 3);
INSERT INTO event (id, winner) VALUES (4, 1);

INSERT INTO event_player (event_id, player_id, hand) VALUES (1, 1, 'rock');
INSERT INTO event_player (event_id, player_id, hand) VALUES (1, 2, 'scissors');
INSERT INTO event_player (event_id, player_id, hand) VALUES (1, 3, 'rock');
INSERT INTO event_player (event_id, player_id, hand) VALUES (1, 4, 'scissors');
INSERT INTO event_player (event_id, player_id, hand) VALUES (1, 5, 'rock');
INSERT INTO event_player (event_id, player_id, hand) VALUES (2, 1, 'scissors');
INSERT INTO event_player (event_id, player_id, hand) VALUES (2, 2, 'rock');
INSERT INTO event_player (event_id, player_id, hand) VALUES (2, 3, 'scissors');

