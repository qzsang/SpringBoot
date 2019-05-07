
drop table if exists city;

create table city (id int primary key auto_increment, name varchar(255), state varchar(255), country varchar(255));

insert into city (name, state, country) values ('San Francisco', 'CA', 'US');

insert into city (name, state, country) values ('San Francissdco', 'CAdsd', 'UddS');
insert into city (name, state, country) values ('San Francissdco', 'aaa', 'UddS');