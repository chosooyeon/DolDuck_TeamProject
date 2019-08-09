
/*-------------------------------------		회원 테이	-----------------------------------------*/
-- 회원테이블 MEMBER
-- 회원번호용 시퀀스 MEMBERSEQ
-- 컬럼 : 회원번호, 회원아이디, 회원비밀번호, 회원이름, 회원연락처
-- 회원주소, 회원이메일 회원가입일, 회원활동여부, 회원등급, 투표권갯수

DROP TABLE MEMBER;
DROP SEQUENCE MEMBERSEQ;

CREATE SEQUENCE MEMBERSEQ;
CREATE TABLE MEMBER(
	MEMBER_SEQ NUMBER PRIMARY KEY,
	MEMBER_ID VARCHAR2(1000) NOT NULL,
	MEMBER_PW VARCHAR2(1000) NOT NULL,
	MEMBER_NAME VARCHAR2(1000) NOT NULL,
	MEMBER_PHONE VARCHAR2(100) NOT NULL,
	MEMBER_ADDR VARCHAR2(4000) NOT NULL,
	MEMBER_EMAIL VARCHAR2(1000) NOT NULL,
	MEMBER_REGDATE DATE NOT NULL,
	MEMBER_HEART NUMBER NOT NULL,
	MEMBER_ENABLED NUMBER(1) DEFAULT 1,
	MEMBER_ROLE VARCHAR2(10) DEFAULT 'ROLE_USER' NOT NULL,
	MEMBER_VOTE NUMBER NOT NULL,
	CONSTRAINT CON_MEMBER_ID UNIQUE(MEMBER_ID)
);

SELECT * FROM MEMBER;

INSERT INTO MEMBER VALUES(MEMBERSEQ.NEXTVAL, 'admin','admin1234','관리자','010-0000-0000','서울시 중랑구','1whtndus@naver.com',SYSDATE, 0, 1,'ADMIN',0);

drop table member;
SELECT * FROM MEMBER;



select member_heart, member_vote from member where member_id = 'lotus526'

--하트구매
update member set member_heart = 1000, member_vote = 0 where member_id = 'lotus526'

update member set member_vote = 
(select member_vote from member where member_id = 'lotus526') + 5
where member_id = 'lotus526'


--투표권 구매 
update member 
set member_vote = ((select member_vote from member where member_id = 'lotus526') + 10),
member_heart = ((select member_heart from member where member_id = 'lotus526') - 250)
where member_id = 'lotus526'

