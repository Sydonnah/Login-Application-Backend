CREATE TABLE user(
    id int not null auto_increment primary key,
    username varchar(50),
    password varchar(50),
    created_at timestamp
);

