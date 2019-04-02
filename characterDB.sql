create database if not exists characters;

use characters;

drop table if exists characters;

create table characters (
	id int(10) not null auto_increment,
    first_name varchar(30) not null,
    last_name varchar(30),
    primary key(id)
);