create table tbl_board2(
bno number primary key,
title varchar2(100) not null,
content varchar2(4000),
writer varchar2(50) not null,
regdate date default sysdate,
viewcnt number default 0
);

create sequence seq_board2_bno;

--전체 삭제
truncate table tbl_board2;
-- 시퀀스 새로 만들기
drop SEQUENCE seq_board2_bno;
create SEQUENCE seq_board2_bno;

select count(*) from tbl_board2;

select * from   (select rownum rnum, a.* from
        (select * from tbl_board2
        order by bno desc) a)
where rnum between 1 and 10;

--업데이트 그룹넘

update tbl_board2 set  re_group=bno;