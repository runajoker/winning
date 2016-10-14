
/* Drop Tables */

DROP TABLE cboard CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE seq_cboard;




/* Create Sequences */

CREATE SEQUENCE seq_cboard;



/* Create Tables */

CREATE TABLE cboard
(
	no number NOT NULL,
	pno number,
	title varchar2(100) NOT NULL,
	name varchar2(20) NOT NULL,
	password varchar2(128) NOT NULL,
	content varchar2(4000) NOT NULL,
	readcount number(5) DEFAULT 0 NOT NULL,
	regdate date DEFAULT sysdate NOT NULL,
	PRIMARY KEY (no)
);
select no, pno, title, name, content, readcount, regdate from CBOARD order by no desc


insert into cboard(no, title, name, password, content) values(seq_cboard.nextval, '1', '2', '3', '4' )
select * from cboard

select no, title, name, content, readcount, to_char(regdate,'yyyy.mm.dd') as regdate from cboard where no = 1
update cboard set readcount = readcount + 1 where no = 1