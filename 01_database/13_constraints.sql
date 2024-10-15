-- 13. constraints (제약조건)
-- : 테이블에 데이터가 입력되거나 수정될 때의 규칙
-- 데이터베이스 무결성 보장

CREATE TABLE user_notnull (
	user_no INT NOT NULL,	
	user_id VARCHAR(255) NOT NULL,
	user_pwd VARCHAR(255) NOT NULL,
	user_name VARCHAR(255) NOT NULL,
	gender VARCHAR(3),
	phone VARCHAR(255) NOT NULL,
	email VARCHAR(255)
) ENGINE=INNODB;

SELECT * FROM user_notnull;

INSERT INTO USER_notnull VALUES(
	1,
	'user01',
	'pass01',
	'홍길동',
	'남',
	'01000000001',
	'hong123@gmail.com'
);

INSERT INTO USER_notnull VALUES(
	2,
	'user02',
	'pass02',
	'고길동',
	NULL,
	'01000000002',
	null
);

-- (2) unique 제약 조건 : 중복 값 허가하지 않음

CREATE TABLE user_unique (
	user_no INT NOT NULL UNIQUE,	
	user_id VARCHAR(255) NOT NULL,
	user_pwd VARCHAR(255) NOT NULL,
	user_name VARCHAR(255) NOT NULL,
	gender VARCHAR(3),
	phone VARCHAR(255) NOT NULL,
	email VARCHAR(255),
	UNIQUE(phone)
) ENGINE=INNODB;

DESC user_unique;


INSERT INTO USER_unique VALUES(
	1,
	'user01',
	'pass01',
	'홍길동',
	'남',
	'01000000001',
	'hong123@gmail.com'
);

INSERT INTO USER_unique VALUES(
	3,
	'user01',
	'pass01',
	'홍길동',
	'남',
	'01000000003',
	'hong123@gmail.com'
);

COMMIT;

-- (3) primary key : 테이블의 식별자 역할 (한 행을 구분)
-- not null + unique
-- 한 테이블 당 하나만 설정 가능

CREATE TABLE user_primarykey (
	user_no INT PRIMARY KEY,	
	user_id VARCHAR(255) NOT NULL,
	user_pwd VARCHAR(255) NOT NULL,
	user_name VARCHAR(255) NOT NULL,
	gender VARCHAR(3),
	phone VARCHAR(255) NOT NULL,
	email VARCHAR(255)
) ENGINE=INNODB;

DESC user_unique;


INSERT INTO user_primarykey VALUES(
	1,
	'user01',
	'pass01',
	'홍길동',
	'남',
	'01000000001',
	'hong123@gmail.com'
);

-- (4) Foreign Key : 참조 제약 조건(참조 무결성 위배하지 않도록)
-- 참조 대상 테이블
CREATE TABLE user_grade (
	grade_code INT NOT NULL UNIQUE,
	grade_name VARCHAR(255) NOT NULL
	);
	
	INSERT INTO user_grade VALUES(10, '일반회원'), (20, '우수회원'), (30, '특별회원');
	SELECT * FROM USER_GRADE;
	
-- FK 적용할 테이블

CREATE TABLE user_foreignkey1 (
	user_no INT PRIMARY KEY,	
	user_id VARCHAR(255) NOT NULL,
	user_pwd VARCHAR(255) NOT NULL,
	user_name VARCHAR(255) NOT NULL,
	gender VARCHAR(3),
	phone VARCHAR(255) NOT NULL,
	email VARCHAR(255),
	grade_code INT,
	FOREIGN KEY(grade_code) REFERENCES user_grade(grade_code)
) ENGINE=INNODB;

-- insert 테스트 (fk 제약 조건 적용)
INSERT INTO user_foreignkey1 VALUES(
	3,
	'user01',
	'pass01',
	'홍길동',
	'남',
	'01000000001',
	'hong123@gmail.com',
	NULL -- null 값은 입력 가능, 다루어지지 않는 값은 입력 불가
);

-- fk 적용 시 삭제를 설정
DROP TABLE user_foreignkey1;

COMMIT;
CREATE TABLE user_foreignkey2 (
	user_no INT PRIMARY KEY,	
	user_id VARCHAR(255) NOT NULL,
	user_pwd VARCHAR(255) NOT NULL,
	user_name VARCHAR(255) NOT NULL,
	gender VARCHAR(3),
	phone VARCHAR(255) NOT NULL,
	email VARCHAR(255),
	grade_code INT,
	FOREIGN KEY(grade_code) REFERENCES user_grade(grade_code)
	ON UPDATE SET NULL ON DELETE SET NULL
	-- ON UPDATE SET CASCADE ON DELETE SET CASCADE
	-- UPDATE 시 변경 된 값으로 참조 값도 변경하고 
	-- DELETE 시 참조 값이 있는 행도 삭제
) ENGINE=INNODB;


-- insert 테스트 (fk 제약 조건 적용)
INSERT INTO user_foreignkey2 VALUES(
	1,
	'user01',
	'pass01',
	'홍길동',
	'남',
	'01000000001',
	'hong123@gmail.com',
	10 -- null 값은 입력 가능, 다루어지지 않는 값은 입력 불가
);

INSERT INTO user_foreignkey2 VALUES(
	2,
	'user01',
	'pass01',
	'홍길동',
	'남',
	'01000000001',
	'hong123@gmail.com',
	20 -- null 값은 입력 가능, 다루어지지 않는 값은 입력 불가
);

SELECT * FROM user_foreignkey2;

-- 참조 대상 테이블 user_grade 수정
UPDATE user_grade SET grade_code = NULL
WHERE grade_code = 10;

DELETE FROM user_grade 
WHERE grade_code= 20;

ROLLBACK;

-- (5) CHECK 제약 조건 :

CREATE TABLE user_check (
USER_NO INT AUTO_INCREMENT PRIMARY KEY
	,USER_NAME VARCHAR(255) NOT NULL
	, GENDER VARCHAR(3) CHECK (GENDER IN ('남','여'))
	, AGE INT CHECK(AGE >= 19)
	);
	
-- INSERT TEST (정상 수행)
INSERT INTO USER_CHECK VALUES(
	1
	,'홍길동'
	, '남'
	, 19
);

-- INSERT TEST (CHECK 제약조건 위반)
INSERT INTO USER_CHECK VALUES(2, '고길동', '여', 11);


-- (6) DEFAULT : 컬럼에 NULL 대신 기본 값 적용 가능
CREATE TABLE TBL_COUNTRY (
	COUNTRY_CODE INT AUTO_INCREMENT PRIMARY KEY,
	COUNTRY_NAME VARCHAR(255) DEFAULT '한국',
	POPULATION VARCHAR(255) DEFAULT '0명', 
	ADD_DAY DATE DEFAULT (CURRENT_DATE),
	ADD_TIME DATETIME DEFAULT(CURRENT_TIME)
);

INSERT INTO TBL_COUNTRY (COUNTRY_NAME, POPULATION, ADD_DAY, ADD_TIME) VALUES (NULL, DEFAULT, DEFAULT ,DEFAULT);

SELECT * FROM TBL_COUNTRY;
INSERT INTO TBL_COUNTRY (COUNTRY_CODE) VALUES (3);