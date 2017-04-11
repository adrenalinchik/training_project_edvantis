CREATE TABLE OWNER (ID BIGINT(11) PRIMARY KEY AUTO_INCREMENT, FIRSTNAME VARCHAR (255), LASTNAME VARCHAR (255), GENDER VARCHAR (255), DOB DATE);
CREATE TABLE VEHICLE (ID BIGINT(11) PRIMARY KEY AUTO_INCREMENT, OWNER_ID INT (11), TYPE VARCHAR (255), NUMBER VARCHAR (255), MODEL VARCHAR (255));
CREATE TABLE GARAGE (ID BIGINT(11) PRIMARY KEY AUTO_INCREMENT, PARKING_ID INT (11), TYPE VARCHAR (10), SQUARE FLOAT);
CREATE TABLE PARKING (ID BIGINT(11) PRIMARY KEY AUTO_INCREMENT, MANAGER_ID INT (11), ADDRESS VARCHAR (255), FREE_GARAGES INT(11));
CREATE TABLE RESERVATION (ID BIGINT(11) PRIMARY KEY AUTO_INCREMENT,BEGIN DATETIME, END DATETIME, GARAGE_ID BIGINT(20), OWNER_ID BIGINT(20), PARKING_ID BIGINT(20));