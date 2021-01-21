create table member(

id varchar(12) primary key,
pw varchar(8),
addr varchar(100),
tel varchar(11)

)

insert into member(id,pw,addr,tel) values ('id','pw','addr','tel')

drop table member

select id,pw,addr,tel from member
