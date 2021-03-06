-- PUBLIC.PRODUCT definition

-- Drop table

DROP TABLE PUBLIC.PRODUCT;

CREATE TABLE PUBLIC.PRODUCT (
	ID BIGINT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(100) NOT NULL,
	CODE VARCHAR(20) NOT NULL,
	VALUE DOUBLE DEFAULT 0.00 NOT NULL,
	`TYPE` VARCHAR(100) NOT NULL,
	IMAGE BINARY,
	CONSTRAINT PRODUCT_PK PRIMARY KEY (ID)
);

INSERT INTO PUBLIC."PRODUCT" (NAME, CODE, VALUE, TYPE) VALUES('Maçã', 123, 6.51, '2');
INSERT INTO PUBLIC."PRODUCT" (NAME, CODE, VALUE, TYPE) VALUES('Banana', 456, 4.99, '2');
INSERT INTO PUBLIC."PRODUCT" (NAME, CODE, VALUE, TYPE) VALUES('Uva', 789, 7.99, '2');
INSERT INTO PUBLIC."PRODUCT" (NAME, CODE, VALUE, TYPE) VALUES('Laranja', 101, 4.59, '2');
INSERT INTO PUBLIC."PRODUCT" (NAME, CODE, VALUE, TYPE) VALUES('Manga', 112, 6.79, '2');