create table tbl_comment2(
cno number primary key,
bno number REFERENCES tbl_board2(bno) ,
content varchar2(200) not null,
user_id varchar2(50) REFERENCES tbl_member2(memberid) not null,
regdate date default sysdate
);

create SEQUENCE seq_comment2_cno;