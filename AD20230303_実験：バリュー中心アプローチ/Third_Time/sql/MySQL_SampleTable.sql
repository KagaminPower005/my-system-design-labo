CREATE DATABASE CarOwnerDb;
use carownerdb;
CREATE TABLE Car (Id int(10), Name varchar(50));
INSERT INTO Car VALUES (2,'normal_car');
INSERT INTO Car VALUES (3,'open_car');
INSERT INTO Car VALUES (4,'tractor');

CREATE TABLE CarOwner (Id int(10), Name varchar(50));
INSERT INTO CarOwner VALUES (1,'yamada taro');
INSERT INTO CarOwner VALUES (2,'tanaka jiro');
INSERT INTO CarOwner VALUES (5,'sato hanako');

CREATE TABLE CarOwner_Car_Relation (CarOwnerId int(10), CarId int(10));
INSERT INTO CarOwner_Car_Relation VALUES (1,2);
INSERT INTO CarOwner_Car_Relation VALUES (1,3);
INSERT INTO CarOwner_Car_Relation VALUES (2,4);
INSERT INTO CarOwner_Car_Relation VALUES (5,2);
INSERT INTO CarOwner_Car_Relation VALUES (5,3);
INSERT INTO CarOwner_Car_Relation VALUES (5,4);

SELECT * FROM Car;
SELECT * FROM CarOwner;
SELECT * FROM CarOwner_Car_Relation;
SELECT c.Name,a.Name FROM car a 
Join CarOwner_Car_Relation b on a.Id = b.CarId
Join CarOwner c on c.Id = b.CarOwnerId;
