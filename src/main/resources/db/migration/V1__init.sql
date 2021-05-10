create table categories (id bigserial primary key, title varchar(255));
insert into categories (title) values ('Food');

create table products (id bigserial primary key, title varchar(255), price int, category_id bigint references categories (id));
insert into products (title, price, category_id) values
('Bread', 25, 1),
('Milk', 80, 1),
('Cheese', 325, 1);

