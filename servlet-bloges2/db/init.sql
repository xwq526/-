drop database if exists chong_blog;
create database chong_blog character set utf8mb4;

use chong_blog;
drop table if exists user;
create table user(
    id int primary key auto_increment,
    username varchar(20) not null unique comment '用户账号',
    password varchar(20) not null,
    nickname varchar(20),
    birthday date,
    phone_number varchar(11),
    email varchar(20),
    head varchar(50)
);
drop table if exists article;
create table article(
    id int primary key auto_increment,
    title varchar(50) not null,
    content mediumtext not null,
    user_id int,
    cretate_time timestamp default now(),
    view_count int default 0,
    foreign key (user_id) references user(id)
);

insert into user(username,password) values('a','1');
insert into user(username,password) values('b','2');
insert into user(username,password) values('c','3');
insert into user(username,password) values('d','4');


insert into article(title, content, user_id) values ('马师傅耗子尾汁','内容1',1);
insert into article(title, content, user_id) values ('拜登养老','内容2',1);
insert into article(title, content, user_id) values ('不讲武德','内容3',2);
insert into article(title, content, user_id) values ('澳大利亚不讲武德','内容4',2);
insert into article(title, content, user_id) values ('昨天停电了','内容5',3);


select id, username, password, nickname, birthday, phone_number, email, head
        from user
    where username = 'a';

select id, title, content, user_id, cretate_time, view_count from article where user_id = 1;
