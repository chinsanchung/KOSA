create table users (
    id varchar2(30),
    password varchar2(30),
    name varchar2(20),
    role varchar2(30)
);

insert into users values ('admin', '1234', '홍길동', 'Admin');

commit;


create table sboard (
    seq number,
    title varchar2(30),
    writer varchar2(20),
    content varchar2(300),
    regdate date,
    cnt number
);