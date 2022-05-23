create table tbl_message2(
    mid number primary key,
    sender varchar2(50) references tbl_member(userid),
    receiver varchar2(50) references tbl_member(userid),
    message varchar2(500) not null,
    senddate date default sysdate,
    opendate date 
);

create sequence seq_message2_mid;
-- add point
alter table tbl_member2
add m_point number default 0;