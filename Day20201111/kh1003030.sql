CREATE TABLE kh5(
     NAME variable(100),
     ADDRESS VARCHAR(500),
     ROOM VARCHAR(100)
     )

     INSERT INTO kh5(NAME,ADDRESS,ROOM) VALUES ('KH정보교육원당산지원','서울특별시영등포구당산','501호')
     insert into kh5(NAME,ADDRESS,ROOM) VALUES ('KH정보교육원강남지원','서울특별시강남구강남','502호')
     insert into kh5(NAME,ADDRESS,ROOM) VALUES ('KH정보교육원종로지원','서울특별시종로구종로','503호')
     SELECT NAME,ADDRESS,ROOM FROM kh5 
     DROP TABLE kh5 
     