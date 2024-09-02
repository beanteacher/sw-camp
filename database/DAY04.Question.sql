CREATE TABLE MEMBER_INFO (
MEMBER_CODE INT AUTO_INCREMENT PRIMARY KEY COMMENT '회원코드',
MEMBER_NAME VARCHAR(70) NOT NULL COMMENT '회원이름',
BIRTH_DATE DATE COMMENT '생년원일',
DIVISION_CODE CHAR(2) COMMENT '구분코드', 
DETAIL_INFO VARCHAR(500) COMMENT '상세정보',
CONTACT VARCHAR(50) NOT NULL COMMENT '연락처',
TEAM_CODE INT COMMENT '소속코드',
ACTIVE_STATUS CHAR(2) DEFAULT('Y') NOT NULL COMMENT '활동상태' CHECK (ACTIVE_STATUS IN ('Y', 'N', 'H')),
FOREIGN KEY (TEAM_CODE) REFERENCES TEAM_INFO(TEAM_CODE) 
ON UPDATE CASCADE ON DELETE CASCADE
-- ON UPDATE SET NULL ON DELETE SET NULL
) COMMENT '회원정보';


CREATE TABLE TEAM_INFO (
	TEAM_CODE INT AUTO_INCREMENT PRIMARY KEY COMMENT '소속코드'
	, TEAM_NAME VARCHAR(100) NOT NULL COMMENT '소속명'
	, TEAM_DETAIL VARCHAR(500) COMMENT '소속상세정보'
	, USE_YN CHAR(2) DEFAULT('N') NOT NULL COMMENT '사용여부' CHECK (USE_YN IN ('Y', 'N')) 
) ENGINE=INNODB COMMENT '소속정보';
 

INSERT INTO TEAM_INFO 
( TEAM_NAME
, TEAM_DETAIL
, USE_YN
) VALUES 
('음악감상부'
	, '클래식 및 재즈 음악을 감상하는 사람들의 모임'
	, 'Y'),
('맛집 탐방부'
	,'맛집을 찾아다니는 사람들의 모임'	
	, DEFAULT),
('행복찾기부'
	, NULL
	, 'Y');


INSERT INTO MEMBER_INFO (
MEMBER_NAME
, BIRTH_DATE
, DIVISION_CODE
, DETAIL_INFO
, CONTACT
, TEAM_CODE
, ACTIVE_STATUS) 
VALUES 
('송가인', STR_TO_DATE('1990-01-30', '%Y-%m-%d'), 1, '안녕하세요 송가인입니다~', '010-9494-9494', 1, 'H'), 
('임영웅', STR_TO_DATE('1992-05-03', '%Y-%m-%d'), NULL, '국민아들 임영웅입니다~', 'hero@trot.com', 1, DEFAULT),
('태진아', NULL, NULL, NULL, '(1급 기밀)', 3, DEFAULT);
