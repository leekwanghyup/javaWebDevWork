-- 스키마 생성
create schema studydb;
use studydb;

-- 테이블 작성 
create table members(
	mno integer not null, -- 회원 일련번호 
	email varchar(40) not null, -- 이메일
    pwd varchar(100) not null,  -- 비밀번호
    mname varchar(50) not null, -- 이름
    cre_date datetime not null, -- 가입일
    mod_date datetime not null	-- 마지막 비밀번호변경일
); 
-- 기본키 추가 
alter table members add constraint pk_members primary key(mno);

-- EMAIL 컬럼 유니크로 지정
create unique index uix_members on members(email asc);

-- 회원일련 번호 자동증가 
alter table members modify column mno integer not null auto_increment;

-- 테스트 데이터 준비 
insert into members(email,pwd,mname,cre_date,mod_date)
values('s1@test.com','1111','홍길동',now(),now());

insert into members(email,pwd,mname,cre_date,mod_date)
values('s2@test.com','1111','임꺽정',now(),now());

insert into members(email,pwd,mname,cre_date,mod_date)
values('s3@test.com','1111','일지매',now(),now());

insert into members(email,pwd,mname,cre_date,mod_date)
values('s4@test.com','1111','이몽룡',now(),now());

insert into members(email,pwd,mname,cre_date,mod_date)
values('s5@test.com','1111','성춘향',now(),now());

select * from members;