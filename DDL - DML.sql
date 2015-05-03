/*
Untuk Menghapus Seluruh Tabel
DROP TABLE log_jadwal;
DROP TABLE jadwal;
DROP TABLE member;
DROP TABLE lapangan;
*/


CREATE TABLE member(
	id_member INT NOT NULL AUTO_INCREMENT,
	isAktif BOOLEAN,
	nama VARCHAR(255),
	umur INT,
	username VARCHAR(255),
	password VARCHAR(255),
	PRIMARY KEY(id_member),
	UNIQUE KEY (username)
);

CREATE TABLE lapangan(
	id_lapangan INT NOT NULL AUTO_INCREMENT,
	isVinyl BOOLEAN,
	lebar FLOAT,
	panjang FLOAT,
	PRIMARY KEY (id_lapangan)
);

CREATE TABLE jadwal (
	id_jadwal INT NOT NULL AUTO_INCREMENT,
	hari INT,
	shift INT,
	PRIMARY KEY (id_jadwal)
);

CREATE TABLE jadwal_lapangan(
	id_lapangan INT,
	id_jadwal INT,
	id_member INT,
	isDP BOOLEAN,
	FOREIGN KEY (id_lapangan) REFERENCES lapangan (id_lapangan) ON DELETE CASCADE,
	FOREIGN KEY (id_jadwal) REFERENCES jadwal (id_jadwal) ON DELETE CASCADE,
	FOREIGN KEY (id_member) REFERENCES member (id_member) ON DELETE CASCADE
);

INSERT INTO jadwal VALUES (NULL, 0, 0, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 1, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 2, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 3, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 4, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 5, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 6, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 7, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 8, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 9, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 10, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 11, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 12, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 13, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 14, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 15, FALSE);
INSERT INTO jadwal VALUES (NULL, 0, 16, FALSE);


INSERT INTO jadwal VALUES (NULL, 1, 0, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 1, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 2, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 3, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 4, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 5, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 6, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 7, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 8, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 9, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 10, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 11, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 12, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 13, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 14, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 15, FALSE);
INSERT INTO jadwal VALUES (NULL, 1, 16, FALSE);


INSERT INTO jadwal VALUES (NULL, 2, 0, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 1, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 2, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 3, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 4, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 5, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 6, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 7, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 8, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 9, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 10, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 11, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 12, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 13, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 14, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 15, FALSE);
INSERT INTO jadwal VALUES (NULL, 2, 16, FALSE);


INSERT INTO jadwal VALUES (NULL, 3, 0, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 1, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 2, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 3, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 4, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 5, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 6, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 7, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 8, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 9, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 10, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 11, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 12, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 13, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 14, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 15, FALSE);
INSERT INTO jadwal VALUES (NULL, 3, 16, FALSE);


INSERT INTO jadwal VALUES (NULL, 4, 0, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 1, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 2, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 3, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 4, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 5, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 6, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 7, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 8, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 9, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 10, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 11, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 12, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 13, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 14, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 15, FALSE);
INSERT INTO jadwal VALUES (NULL, 4, 16, FALSE);


INSERT INTO jadwal VALUES (NULL, 6, 0, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 1, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 2, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 3, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 4, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 5, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 6, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 7, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 8, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 9, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 10, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 11, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 12, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 13, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 14, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 15, FALSE);
INSERT INTO jadwal VALUES (NULL, 5, 16, FALSE);


INSERT INTO jadwal VALUES (NULL, 6, 0, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 1, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 2, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 3, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 4, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 5, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 6, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 7, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 8, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 9, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 10, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 11, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 12, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 13, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 14, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 15, FALSE);
INSERT INTO jadwal VALUES (NULL, 6, 16, FALSE);