DROP TABLE IF EXISTS ITEM;

CREATE TABLE ITEM
(
    id integer AUTO_INCREMENT NOT NULL,
    name varchar(255) NOT NULL,
    price integer,
    quantity integer,
    PRIMARY KEY(id)
);