create table users (
  "id"       SERIAL PRIMARY KEY,
  "name" VARCHAR NOT NULL,
  "surname" VARCHAR NOT NULL,
  "birth_date" VARCHAR NOT NULL,
  "address" VARCHAR NOT NULL);