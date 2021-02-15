drop table if exists owner;

create table owner(
    id serial primary key,
    firstname text,
    lastname text,
    phone text,
    email text
);

insert into owner (firstname, lastname, phone, email) VALUES ('adam', 'adamov', '88888','a@ya.cf');
insert into owner (firstname, lastname, phone, email) VALUES ('adam1', 'adamov1', '7777','b@ya.cf');
insert into owner (firstname, lastname, phone, email) VALUES ('adam2', 'adamov2', '666','c@ya.cf');
insert into owner (firstname, lastname, phone, email) VALUES ('adam3', 'adamov3', '5555','d@ya.cf');
insert into owner (firstname, lastname, phone, email) VALUES ('adam4', 'adamov4', '4444','e@ya.cf');