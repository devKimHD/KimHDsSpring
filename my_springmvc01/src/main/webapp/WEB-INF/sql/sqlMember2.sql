create table tbl_member2(
    memberid varchar2(50) primary key,
    memberpw varchar2(50) not null,
    membername varchar2(50) not null,
    email varchar2(100),
    regdate date default sysdate,
    updatedate date default sysdate
);

select sysdate from dual;