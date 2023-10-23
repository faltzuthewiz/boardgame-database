SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS board_game;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS language;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE category
(category_id BIGINT NOT NULL AUTO_INCREMENT
, category_name VARCHAR(30) NOT NULL
, PRIMARY KEY (category_id)
);

INSERT INTO category(category_name)
VALUES ("Board game")
, ("Card game")
, ("Dice game")
, ("Other");

CREATE TABLE genre
(genre_id BIGINT NOT NULL AUTO_INCREMENT
, genre_name VARCHAR(30) NOT NULL
, PRIMARY KEY (genre_id)
);


INSERT INTO genre(genre_name)
VALUES("City building")
, ("Educational")
, ("Negotiation")
, ("Economic")
, ("Family")
, ("Wargame")
, ("Expansion")
, ("Party")
, ("Hand management")
, ("Auction");

CREATE TABLE language
(language_id BIGINT NOT NULL AUTO_INCREMENT
, language_name VARCHAR(30) NOT NULL
, PRIMARY KEY (language_id)
);

INSERT INTO language(language_name)
VALUES ("English")
, ("Finnish");

CREATE TABLE board_game
(id BIGINT NOT NULL AUTO_INCREMENT
, title VARCHAR(100) NOT NULL
, description VARCHAR(1000) NOT NULL
, min_player BIGINT NOT NULL
, max_player BIGINT NOT NULL
, min_age BIGINT NOT NULL
, est_duration BIGINT
, category_id BIGINT
, genre_id BIGINT
, language_id BIGINT
, PRIMARY KEY (id)
, FOREIGN KEY (category_id) REFERENCES category
(category_id)
, FOREIGN KEY (genre_id) REFERENCES genre
(genre_id)
, FOREIGN KEY (language_id) REFERENCES language
(language_id)
);

INSERT INTO board_game (title, description, min_player, max_player, min_age, est_duration, category_id, genre_id, language_id)
VALUES("Machi Koro - 5th anniversary edition", "Welcome to the city of Machi Koro!
This beloved game from Japan has sold over 300,000 copies - and the city is celebrating with some fancy upgrades. Big chunky dice, shiny new plastic coins, and other fun flair make being mayor better than ever!", 2, 4, 10, 30, 1, 1, 1)
, ("#Koulutusleikkaus", "Peli petetyistä lupauksista ja leikatuista unelmista! KOULUTUSLEIKKAUS on peli koulutusleikkauksista ja niiden vaikutuksista. Kukin pelaaja pelaa koulutuksen järjestäjää, joka yrittää saada oppilaitoksensa aina varhaiskasvatuksesta yliopistoon asti selviämään parhaalla mahdollisella tavalla hallituksen tekemistä leikkauksista. Tässä pelissä ei ole voittajia, ainoastaan pienempiä tai suurempia häviäjiä. Koeta tehdä parhaasi koulutuksen pelastamiseksi!", 2, 6, 15, null, 2, 2, 2)
, ("Patchwork - Tilkkutäkki", "Niin monta upeaa kankaanpalaa ja nahkapaikkaa vain lojumassa joutilaina - on aika tehdä niistä upea tilkkutyö! Työn tekeminen vaatii kuitenkin aikaa ja vaivaa ja hyvän varaston nappeja. Pelin voittaa se, joka valitsee parhaat tilkut ja tekee niistä upeimman tilkkutäkin.", 2, 0, 8, 30, 1, 4, 2)
, ("High Society", "At the turn of the century it's time to live large. As the quintessential bon vivant you must spare no expense following the latest thend and surrounding yourself with the fineries of life that you justly deserve. Assert your status, impress your peers, and avoid scandal at every turn. In Reiner Knizia's classic auction game, players must bid against each other for life's luxuries, while avoiding going bankrupt in the process. High Society features 16 stunning Art Nouveau -inspired illustrations by Medusa Dollmaker.", 3, 5, 14, 20, 2, 10, 1)
, ("BANG! The dice game", "In the Wild West, the eternal battle between the Law and the Outlaws keeps heating up. Suddenly, a rain of arrows darken the sky: it's an Indian attack! Are you bold enough to keep up with the Indians? Do you have the courage to challenge your fate? Can you expose and defeat the ruthless gunmen around you? All the excitement of BANG!, now with dice!", 3, 8, 8, 15, 3, 8, 1);

CREATE TABLE app_user
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
, username VARCHAR(255) NOT NULL
, password VARCHAR(255) NOT NULL
, role VARCHAR(255) NOT NULL
);

INSERT INTO app_user (username, password, role)
VALUES("user", "$2y$10$PpYQ9hZdL6qP3F9SgEAHSuE3SwBgApfcEBACzfH1.yAuzm4ZL5ZDO", "USER"),
("admin", "$2a$12$FMWhm6JJqcVM2KN2hSQv8O631QOXcj3LmTpSWNHb7naMWISmWhpsK", "ADMIN");


SELECT * FROM category;
SELECT * FROM genre;
SELECT * FROM language;
SELECT * FROM board_game;
SELECT * FROM app_user;



