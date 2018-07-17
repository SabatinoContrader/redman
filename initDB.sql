drop database contrader2;
create database contrader2;
create table contrader2.users (username varchar(50), password varchar(50));
insert into contrader2.users (username, password) values ('pippo', 'paperino');
insert into contrader2.users (username, password) values ('ciccio', 'bello');
create table contrader2.gomme (model varchar(50), manufacturer varchar(50), price float);
insert into contrader2.gomme (model, manufacturer, price) values ('Trelleborg-B50', 'Trelleborg', 321.13);
insert into contrader2.gomme (model, manufacturer, price) values ('SuperG-876 ', 'Super Gomme', 213.176);


