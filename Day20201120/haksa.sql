

select * from manager
CREATE TABLE manager
(
   no                    NUMBER(3)  NOT NULL ,
   age                   NUMBER(3)  NULL ,
   irum                  VARCHAR2(100)  NULL ,
   part                  VARCHAR2(100)  NULL 
);


DROP TABLE stdent
DROP SEQUENCE student_no
create unique index XPK�л� ON student
(no asc);


CREATE UNIQUE INDEX XPK������ ON manager
(no  ASC);



ALTER TABLE manager
   ADD CONSTRAINT  XPK������ PRIMARY KEY (no);


select * from professor
CREATE TABLE professor
(
   no                    NUMBER(3)  NOT NULL ,
   age                   NUMBER(3)  NULL ,
   irum                 VARCHAR2(100)  NULL ,
   subject               VARCHAR2(100)  NULL 
);



CREATE UNIQUE INDEX XPK���� ON professor
(no  ASC);



ALTER TABLE professor
   ADD CONSTRAINT  XPK���� PRIMARY KEY (no);

select * from student
create sequence student_no
CREATE TABLE student
(
   no                    NUMBER(3)  NOT NULL ,
   age                   NUMBER(3)  NULL ,
   irum                  VARCHAR2(200)  NULL ,
   hakbun                NUMBER(3)  NULL 
);



CREATE UNIQUE INDEX XPK�л� ON student
(no  ASC);



ALTER TABLE student
   ADD CONSTRAINT  XPK�л� PRIMARY KEY (no);


  select s.no as ��ȣ,s.age as ����,s.irum as �̸�,s.hakbun as �й�,p.age as ��������,p.irum as �����̸�,p.subject as ����,m.age as �����ڳ���,m.irum as �������̸�,m.part as �μ� from (student s left join professor p on s.no=p.no) left join manager m on s.no=m.no ORDER BY ��ȣ ASC;