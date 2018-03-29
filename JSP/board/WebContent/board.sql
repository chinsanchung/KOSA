create table board (
	num number(4) primary key,
	writer varchar2(15),
	passwd varchar2(20),
	subject varchar2(50),
	email varchar2(50),
	content varchar2(1000),
	reg_date Timestamp,
	readcount number(4),
//답변기능 3가지 ref는 원글과 답변을 같은 그룹으로 묶음. re_step..원글, 답글 순서  re_level은 들여쓰기
	ref number(4),
	re_step number(4),
	re_level number(4)
	);
	
create sequence board_seq
start with 1
increment by 1
maxvalue 100000;