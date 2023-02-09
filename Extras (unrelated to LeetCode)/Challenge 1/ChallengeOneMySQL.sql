DROP DATABASE bookdb;
CREATE SCHEMA bookdb;
USE bookdb;

CREATE TABLE publisher_info(
publisher_id int NOT NULL AUTO_INCREMENT,
first_name VARCHAR(100) NOT NULL, /*Did not make first_name or last_name unique because of the off chance there are two publishers with the same name*/
last_name VARCHAR(100) NOT NULL,
PRIMARY KEY(publisher_id)
);

CREATE TABLE author_info(
author_id int NOT NULL AUTO_INCREMENT,
first_name VARCHAR(100) NOT NULL, /*Did not make first_name or last_name unique because of the off chance there are two authors with the same name*/
last_name VARCHAR(100) NOT NULL,
PRIMARY KEY(author_id)
);

CREATE TABLE book_info(
book_id int NOT NULL AUTO_INCREMENT,
title VARCHAR(255) NOT NULL UNIQUE,
publication_date DATE NOT NULL,
publisher_id int NOT NULL,
PRIMARY KEY(book_id),
FOREIGN KEY(publisher_id) REFERENCES publisher_info(publisher_id)
);

CREATE TABLE book_authors(
book_id int NOT NULL,
author_id int NOT NULL,
FOREIGN KEY(book_id) REFERENCES book_info(book_id),
FOREIGN KEY(author_id) REFERENCES author_info(author_id)
);


/*////////////////////Inserting mock data////////////////////*/

INSERT INTO publisher_info(first_name,last_name)
VALUES('Andrew','Facada');
INSERT INTO publisher_info(first_name,last_name)
VALUES('Tina','Smith');
INSERT INTO publisher_info(first_name,last_name)
VALUES('Greg','Baker');

INSERT INTO author_info(first_name,last_name)
VALUES('Albert','Cruiz');
INSERT INTO author_info(first_name,last_name)
VALUES('Max','Woodward');
INSERT INTO author_info(first_name,last_name)
VALUES('Ben','Bernstein');
INSERT INTO author_info(first_name,last_name)
VALUES('Kelly','Barello');

INSERT INTO book_info(title,publication_date,publisher_id)
VALUES('The Lost City','1985-09-10',2);
INSERT INTO book_info(title,publication_date,publisher_id)
VALUES('The 8th Kind','1995-10-24',1);
INSERT INTO book_info(title,publication_date,publisher_id)
VALUES('The Deep Sea','1990-04-25',2);
INSERT INTO book_info(title,publication_date,publisher_id)
VALUES('The Bright City','2020-01-21',3);
INSERT INTO book_info(title,publication_date,publisher_id)
VALUES('The 24th of October','2005-03-05',1);
INSERT INTO book_info(title,publication_date,publisher_id)
VALUES('Water of Life','2017-02-15',3);

INSERT INTO book_authors(book_id,author_id)
VALUES(1,1);
INSERT INTO book_authors(book_id,author_id)
VALUES(2,2);
INSERT INTO book_authors(book_id,author_id)
VALUES(2,3);
INSERT INTO book_authors(book_id,author_id)
VALUES(3,2);
INSERT INTO book_authors(book_id,author_id)
VALUES(4,4);
INSERT INTO book_authors(book_id,author_id)
VALUES(5,2);
INSERT INTO book_authors(book_id,author_id)
VALUES(5,3);
INSERT INTO book_authors(book_id,author_id)
VALUES(5,4);
INSERT INTO book_authors(book_id,author_id)
VALUES(6,3);


/*////////////////////MySQL Coding Challenge Tests////////////////////*/

/*Returns all books with Woodward as an author*/
SELECT bi.title
FROM book_info bi
JOIN book_authors ba ON(bi.book_id = ba.book_id)
JOIN author_info ai ON(ba.author_id = ai.author_id)
WHERE ai.last_name = 'Woodward';

/*Return all books whose authors include Woodward and/or Bernstein.*/
SELECT bi.title
FROM book_info bi
JOIN book_authors ba ON(bi.book_id = ba.book_id)
JOIN author_info ai ON(ba.author_id = ai.author_id)
WHERE ai.last_name = 'Woodward' OR ai.last_name = 'Bernstein'
GROUP BY bi.title;

/*Return all books whose authors include both Woodward and Bernstein.*/
SELECT bi.title
FROM book_info bi
JOIN book_authors ba ON(bi.book_id = ba.book_id)
JOIN author_info ai ON(ba.author_id = ai.author_id)
GROUP BY ba.book_id
HAVING COUNT(CASE WHEN ai.last_name = 'Woodward' THEN ba.book_id ELSE NULL END) AND 
COUNT(CASE WHEN ai.last_name = 'Bernstein' THEN ba.book_id ELSE NULL END);

/*Return all books whose authors are Woodward and Bernstein (and no other authors) 
(This is the only sub-question that gave me an issue in all of CodeChallenges-2022-db.nb. 
I am trying to have it return books if their authors are ONLY Woodward and Bernstein.
I believe lines 122-124 do this, but I am still getting a book that has an extra author.).*/
SELECT bi.title
FROM book_info bi
JOIN book_authors ba ON(bi.book_id = ba.book_id)
JOIN author_info ai ON(ba.author_id = ai.author_id)
GROUP BY bi.book_id
HAVING COUNT(CASE WHEN  ba.author_id > 1 < 4 THEN bi.title ELSE NULL END) AND
COUNT(CASE WHEN  ai.last_name = 'Woodward' THEN bi.title ELSE NULL END) AND
COUNT(CASE WHEN  ai.last_name = 'Bernstein' THEN bi.title ELSE NULL END);