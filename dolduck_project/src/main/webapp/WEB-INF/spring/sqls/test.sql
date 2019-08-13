
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
	MEMBER_ENABLED INTEGER DEFAULT 1,
	MEMBER_ROLE VARCHAR2(15) DEFAULT 'ROLE_USER' NOT NULL,
	MEMBER_VOTE NUMBER NOT NULL,
	CONSTRAINT CON_MEMBER_ID UNIQUE(MEMBER_ID)
);

SELECT * FROM MEMBER;

-- 컬럼 값 변경
ALTER TABLE MEMBER MODIFY(MEMBER_ROLE VARCHAR2(15));


delete from member where member_id='admin';

UPDATE MEMBER SET MEMBER_ROLE='ROLE_ADMIN' WHERE MEMBER_ID='한지수';

UPDATE MEMBER SET MEMBER_ROLE='ROLE_ARTIST' WHERE MEMBER_ID='한지수';

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

