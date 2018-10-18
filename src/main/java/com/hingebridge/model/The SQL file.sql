/*create table users
(
    id int unsigned not null auto_increment primary key,
    username varchar(255) unique not null,
    password varchar(255) not null,
    firstname varchar(255) not null,
    enabled bit not null
);

create table roles
(
    id int unsigned not null auto_increment primary key,
    rolename varchar(15) unique not null
);

create table users_roles
(
    id int unsigned not null auto_increment primary key,
    users_id int unsigned not null,
    roles_id int unsigned not null,
    foreign key fk_users (users_id) references users(id),
    foreign key fk_roles (roles_id) references roles(id)
);*/