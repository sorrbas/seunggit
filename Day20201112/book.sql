create table book (

 no number (3) primary key,
 name varchar2 (100),
 gender varchar2 (100),
 birth number (6),
 address varchar2(100),
 insta varchar2(100),
 culsuk number (3)
 
)

create sequence book_no
insert into book(no,name,gender,birth,address,insta,culsuk) values (book_no.nextval,'name','gender',0,'address','insta',0)
select no,name,gender,birth,address,insta,culsuk from book

drop table book

update book set name = '이송기' where name = '이승기'