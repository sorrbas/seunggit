drop table emp

create table emp(

emp_id VARCHAR2(5) primary key,
ename VARCHAR2(100),
salary NUMBER(5),
depart VARCHAR2(50)



)

insert into emp(emp_id,ename,salary,depart) values('kh001','정보교육',400,'개발부')

select * from EMP