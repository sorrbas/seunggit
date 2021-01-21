create table book(
    no number(2) primary key,
    name varchar(100),
    gender varchar(100),
    birth number(6),
    address varchar(100),
    insta varchar(100),
    culsuk number(38)
)

create sequence book_no
insert into book(no,name,gender,birth,address,insta,culsuk) values (book_no.nextval,'이름','성별',0,'주소','insta',0)
select no,name,gender,birth,address,insta,culsuk from book

drop table book