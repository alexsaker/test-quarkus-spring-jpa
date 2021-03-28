CREATE TABLE fruit(
   id SERIAL PRIMARY KEY,
   name VARCHAR NOT null,
   color VARCHAR not null
);
INSERT INTO fruit(name, color) VALUES ('Cherry', 'Red');
INSERT INTO fruit(name, color) VALUES ('Apple', 'Red');
INSERT INTO fruit(name, color) VALUES ('Banana', 'Yellow');
INSERT INTO fruit(name, color) VALUES ('Avocado', 'Green');
INSERT INTO fruit(name, color) VALUES ('Strawberry', 'Red');