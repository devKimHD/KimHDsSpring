create table tbl_point2(
    pid number primary key,
    userid varchar2(50) references tbl_member2(memberid),
    point number default 0,
    pcode number references tbl_point2_code(pcode),
    pointdate date default sysdate
);

create table tbl_point2_code(
    pcode number primary key,
    pdesc varchar2(100) not null
);

create sequence seq_point2_pid;

truncate table tbl_message2;

insert into tbl_point2_code(pcode,pdesc)
values (1001, '쪽지 보내기');

insert into tbl_point2_code(pcode,pdesc)
values (1002, '쪽지 읽기');

commit;